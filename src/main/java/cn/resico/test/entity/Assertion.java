package cn.resico.test.entity;

import cn.resico.test.common.utils.JsonUtils;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jayway.jsonpath.JsonPath;
import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

@Data
public class Assertion {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "testcase_detail_id")
    private Integer testcaseDetailId;
    @TableField("verification_type")
    private Integer verificationType;
    @TableField("jsonPath")
    private String jsonPath;
    @TableField("expect")
    private String expect;

    public void judge(Response response) {
        Object actulResult;
        Object expectResult;
        switch (verificationType) {
            case 1:
                actulResult = response.getResult();
                expectResult = expect;
                break;
            case 2:
                actulResult = JsonUtils.getJsonKey(null, response.getResult());
                expectResult = JsonUtils.getJsonKey(null, expect);
                break;
            case 3:
                actulResult = response.getCode();
                expectResult = expect;
                break;
            case 4:
                actulResult = JsonPath.read(response.getResult(), jsonPath);
                expectResult = JsonPath.read(expect, jsonPath);
                break;
            default:
                actulResult = response.getCode();
                expectResult = 10000;
                break;
        }
        Assert.assertEquals(actulResult, expectResult, "实际结果：" +"\n"+ actulResult + "预期结果：" + expectResult);
    }

    @Test
    public void testJudge() {
        Assertion assertion = new Assertion();
        assertion.setTestcaseDetailId(1);
        assertion.setVerificationType(4);
        assertion.setJsonPath("$.data");
        assertion.setExpect("{\n" +
                "    \"code\": 10000,\n" +
                "    \"succeed\": true,\n" +
                "    \"msg\": \"成功\",\n" +
                "    \"data\": \"-1988806.74\",\n" +
                "    \"error\": null\n" +
                "}");


        Response reponse = Response.builder()
                .status(200)
                .code("10000")
                .data("-1988806.74")
                .error(null)
                .msg("成功")
                .succeed(true)
                .result("{\n" +
                        "    \"code\": 10000,\n" +
                        "    \"succeed\": true,\n" +
                        "    \"msg\": \"成功\",\n" +
                        "    \"data\": \"-1988806.74\",\n" +
                        "    \"error\": null\n" +
                        "}")
                .build();
        assertion.judge(reponse);
    }
}
