import cn.resico.test.dto.TestcaseDetailDTO;
import cn.resico.test.entity.Assertion;
import cn.resico.test.entity.Response;
import cn.resico.test.entity.SaveResult;
import cn.resico.test.entity.Testcase;
import cn.resico.test.mapper.AssertionMapper;
import cn.resico.test.mapper.SaveResultMapper;
import cn.resico.test.service.TestcaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class TestTestcase extends BaseTest {
    @Autowired
    private TestcaseService testcaseService;

    @Autowired
    private AssertionMapper assertionMapper;
    @Autowired
    private SaveResultMapper saveResultMapper;

    @BeforeClass
    public void before() {
    }

    @AfterClass
    public void after() {
    }

    @Test(dataProvider = "testcase")
    public void test(TestcaseDetailDTO testcaseDetailDTO) throws UnirestException {
        //数据预处理 1.URL  2.body
        String url = assembleUrl(testcaseDetailDTO.getUrl());


        HttpResponse<JsonNode> JsonResponse = (testcaseDetailDTO.getRequestType().equals("post")) ?
                Unirest.post(url)
                        .body(testcaseDetailDTO.getInstanceData())
                        .asJson()
                :
                Unirest.get(url)
                        .asJson();

        Response response = Response.setResponse(JsonResponse);

        //断言
        QueryWrapper wrapper = new QueryWrapper<Assertion>();
        wrapper.eq("testcaseDetailId", testcaseDetailDTO.getId());
        List<Assertion> assertionList = assertionMapper.selectList(wrapper);
        if (null == assertionList) {
            Assert.assertEquals(response.getStatus(), 200);
        } else {
            for (Assertion assertion : assertionList) {
                assertion.judge(response);
            }
        }


        // 保存数据
        QueryWrapper queryWrapper = new QueryWrapper<SaveResult>();
        queryWrapper.eq("testcaseDetailId", testcaseDetailDTO.getId());
        List<SaveResult> saveResults = saveResultMapper.selectList(queryWrapper);
        if (null != saveResults) {
            for (SaveResult saveResult : saveResults) {
                String value = JsonPath.read(response.getResult(), saveResult.getJsonPath());
                variables.put(saveResult.getKey(), value);
            }
        }

    }


    @DataProvider(name = "testcase")
    public Iterator<Object[]> dataProvider() {
        List<Object[]> list = new ArrayList<>();
        List<Testcase> testcaseList = testcaseService.queryAll();
        for (Testcase testcase : testcaseList) {
            TestcaseDetailDTO testcaseDetailDTO = testcaseService.queryTestcaseDetail(testcase.getId());
            list.add(new Object[]{testcaseDetailDTO});
        }
        return list.iterator();
    }


    public String assembleUrl(String url) {
        String regex = "\\{([^}]*)\\}";
        String key = this.getContentInfo(regex, url);
        if (!variables.containsKey(key)) {
            log.error("前置参数" + key + "不存在");
            return url;
        }
        url = url.replaceAll(regex, variables.get(key));
        return host + url;
    }


    public String getContentInfo(String regex, String content) {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(content);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group(1) + ",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String contentInfo = getContentInfo("\\{([^}]*)\\}", "www.baidu.com/{id}/get");

    }
}
