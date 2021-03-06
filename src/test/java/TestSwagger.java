import cn.resico.test.common.request.Request;

import cn.resico.test.entity.Interface;
import cn.resico.test.mapper.InterfaceGroupMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
public class TestSwagger {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static JsonNode definitions;
    @Autowired
    private InterfaceGroupMapper interfaceGroupMapper;

    @Test
    public void test() throws IOException {
        String swaggerData = getSwaggerData();

        /*JsonNode tags = objectMapper.readTree(swaggerData).get("tags");*/
        JsonNode paths = objectMapper.readTree(swaggerData).get("paths");
        definitions = objectMapper.readTree(swaggerData).get("definitions");

        /*获取接口分组*/
       /* JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, InterfaceGroup.class);
        ArrayList<InterfaceGroup> groups = objectMapper.readValue(tags.toString(), type);
        for (InterfaceGroup group : groups
        ) {
            interfaceGroupMapper.insert(group);
        }*/

        Iterator<Map.Entry<String, JsonNode>> fields = paths.fields();
        while (fields.hasNext()) {
            Interface i = new Interface();
            Map.Entry<String, JsonNode> next = fields.next();

            i.setRequestType(next.getKey());
            JsonNode value = next.getValue();
            String originalRef = value.get("parameters").get(0).get("schema").get("originalRef").toString();

        }

    }



    public String setParameters(Iterator<Map.Entry<String, JsonNode>> parameters) {
        while (parameters.hasNext()) {
            HashMap<String, Object> map = new HashMap<>();

            Map.Entry<String, JsonNode> parameter = parameters.next();
            if (parameter.getKey().equals("schema")) {
                String ref = parameter.getValue().get("originalRef").toString();
            }
            map.put(parameter.getKey(), parameter.getValue());
        }
        return null;
    }

    public HashMap<String, Object> getRef(String ref, JsonNode definitions) {
        HashMap<String, Object> map = new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fields = definitions.get(ref).fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> value = fields.next();
            if (null != value.getValue().get("originalRef")) {
                map.put(value.getKey(), getRef(value.getValue().get("originalRef").toString(), definitions));
            }
            map.put(value.getKey(), value.getValue());
        }
        return map;
    }

    public String getSwaggerData() {
        String cookie = "experimentation_subject_id=eyJfcmFpbHMiOnsibWVzc2FnZSI6IkltUmpaR00zWkRrd0xUTTNZVEV0TkdVMk5TMDRNek0yTFdFeVpEWTJPVGN6TmpNME1TST0iLCJleHAiOm51bGwsInB1ciI6ImNvb2tpZS5leHBlcmltZW50YXRpb25fc3ViamVjdF9pZCJ9fQ%3D%3D--5c8e69e9e17f55a9d47fb5ec454fa7fef88c1834; UM_distinctid=176d0a3aeda695-06ec6be9b76342-c791039-144000-176d0a3aedbb33; auth.test=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50SWQiOiIxMzI4NTE5Mzk0NDkxOTY5NTM4IiwicGxhdGZvcm1ObyI6MSwiY2xpZW50SWQiOiJyZXNpY28iLCJleHAiOjE2MTQ4MzQ4MzUsInVzZXJJZCI6IjEzMjg1MTkzOTM5Mzk0NjQxOTMiLCJqdGkiOiJkM2FiYmU2Zi1mMmI5LTQ0ZTctYmJmYy1jNGM5ZmI3YjUxZDgifQ.xLDHvCe7n-5H_TfC7u4vKEnOnvjTaDaQABpuRua1H0A";
        String url = "http://api.test.ustax.tech/finance/v2/api-docs";
        Request request = new Request();
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"));
        headers.add(new BasicHeader("Accept", "application/json,*/*"));
        headers.add(new BasicHeader("Connection", "keep-alive"));
        headers.add(new BasicHeader("Accept-Encoding", "gzip, deflate"));
        headers.add(new BasicHeader("Host", "api.test.ustax.tech"));
        headers.add(new BasicHeader("Referer", "http://api.test.ustax.tech/finance/swagger-ui.html"));
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Safari/537.36"));
        headers.add(new BasicHeader("Cookie", cookie));
        return request.getWithoutParam(url, headers);
    }
}
