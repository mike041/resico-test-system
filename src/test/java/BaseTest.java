import cn.resico.test.common.utils.PropertiesUtils;
import cn.resico.test.common.utils.FunctionUtil;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
@Slf4j
public class BaseTest extends AbstractTestNGSpringContextTests {

    /**
     * 公共参数数据池（全局可用）
     */
    public static Map<String, String> variables = new HashMap<>();
    protected static String host = PropertiesUtils.getProperties("host");

    /**
     * 替换符，如果数据中包含“${}”则会被替换成公共参数中存储的数据
     */
    protected Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");


    /**
     * 截取自定义方法正则表达式：__xxx(ooo)
     */
    protected Pattern funPattern = Pattern.compile("__(\\w*?)\\((([\\w\\\\\\/:\\.\\$]*,?)*)\\)");

    String Authorization;


    public static void setVariables(Map<String, String> map) {
        variables.putAll(map);
    }


    protected String buildParam(String param) {
        getCommonParam(param);
        getFunctionParam(param);
        return param;
    }


    /**
     * 替换${}的数据
     *
     * @param param
     * @return
     */
    protected String getCommonParam(String param) {
        if (StringUtils.isEmpty(param)) {
            return "";
        }
        Matcher m = replaceParamPattern.matcher(param);
        while (m.find()) {
            String replaceKey = m.group(1);
            String value = getVariables(replaceKey);
            Assert.assertNotNull(value, String.format("格式化参数失败，公共参数中找不到%s。", replaceKey));
            param = param.replace(m.group(), value);
        }

        return param;
    }

    /**
     * 替换_()的数据
     *
     * @param param
     * @return
     */
    protected String getFunctionParam(String param) {
        Matcher m = funPattern.matcher(param);
        while (m.find()) {
            String funcName = m.group(1);
            String args = m.group(2);
            String value;
            // bodyfile属于特殊情况，不进行匹配，在post请求的时候进行处理
            if (FunctionUtil.isFunction(funcName)
                    && !funcName.equals("bodyfile")) {
                // 属于函数助手，调用那个函数助手获取。
                try {
                    value = FunctionUtil.getValue(funcName, args.split(","));
                    // 解析对应的函数失败
                    Assert.assertNotNull(value,
                            String.format("解析函数失败：%s。", funcName));
                    param = param.replaceFirst(m.group(), value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        return param;
    }

    /**
     * 获取公共数据池中的数据
     *
     * @param key 公共数据的key
     * @return 对应的value
     */
    protected String getVariables(String key) {
        if ("" == key || !variables.containsKey(key)) {
            return null;
        }
        return variables.get(key);
    }

    protected void savePreParam(String preParam) {
        // 通过';'分隔，将参数加入公共参数map中
        if (StringUtils.isEmpty(preParam)) {
            return;
        }
        String[] preParamArr = preParam.split(";");
        String key, value;
        for (String prepar : preParamArr) {
            if (StringUtils.isEmpty(prepar)) {
                continue;
            }
            key = prepar.split("=")[0];
            value = prepar.split("=")[1];
            variables.put(key, value);
        }
    }


    @BeforeSuite
    public void setup() throws UnirestException {
        this.defaultLogin();
        this.setDefaultHeader();
        log.info("------------------开始执行测试---------------");
    }

    @AfterSuite
    public void tearDown() {
        /*Runtime run = Runtime.getRuntime();
        try {
            run.exec(" cmd.exe /c  allure serve allure-results");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        log.info("关闭server");
        log.info("-------------结束测试，并关闭退出driver及自动化 server-------------");
    }

    public void setDefaultHeader() {
        Unirest.setDefaultHeader("Accept", "application/json, text/plain, */*");
        Unirest.setDefaultHeader("content-type", "application/json;charset=UTF-8");
        Unirest.setDefaultHeader("Authorization", Authorization);
    }

    public void defaultLogin() throws UnirestException {
        String username = PropertiesUtils.getProperties("login.test.username");
        String password = PropertiesUtils.getProperties("login.test.password");
        String body = "{\"loginType\":1,\"platformNo\":1,\"clientId\":\"resico\",\"clientSecret\":\"resico888\",\"username\":\"%s\",\"password\":\"%s\"}";
        body = String.format(body, username, password);
        Authorization = Unirest.post(host+"auth/login").body(body).asJson().getBody().getObject().getJSONObject("data").get("accessToken").toString();
    }


}
