package cn.resico.test.common.Parsing;

import cn.resico.test.common.request.Request;
import cn.resico.test.entity.Interface;
import cn.resico.test.entity.InterfaceGroup;
import cn.resico.test.mapper.InterfaceGroupMapper;
import cn.resico.test.mapper.InterfaceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.*;

@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
public class ParsingSwagger {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static JsonNode definitions;
    private static JsonNode paths;

    @Autowired
    static InterfaceMapper interfaceMapper;
    @Autowired
    static InterfaceGroupMapper interfaceGroupMapper;

    public static void main(String[] args) throws IOException {
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
        String swaggerData = request.getWithoutParam(url, headers);
        paths = objectMapper.readTree(swaggerData).get("paths");
        definitions = objectMapper.readTree(swaggerData).get("definitions");
        List<Interface> interfaceList = getInterfaceList(paths);
        interfaceList.forEach(System.out::println);
    }

    public static HashMap<String, Object> getRef(String ref, JsonNode definitions) {
        HashMap<String, Object> map = new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fields = definitions.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> value = fields.next();
            if (value.getKey().equals(ref)) {
                Iterator<Map.Entry<String, JsonNode>> properties = value.getValue().get("properties").fields();
                while (properties.hasNext()) {
                    Map.Entry<String, JsonNode> property = properties.next();
                    map.put(property.getKey(), "");
                    if (null != property.getValue().get("originalRef")) {
                        String originalRef = property.getValue().get("originalRef").asText();
                        map.put(property.getKey(), getRef(originalRef, definitions));
                    }
                }
                break;
            }
        }
        return map;
    }

    public static List<Interface> getInterfaceList(JsonNode paths) {
        List<Interface> interfaceList = new ArrayList<>();
        Iterator<Map.Entry<String, JsonNode>> swaggerInterfaceList = paths.fields();

        while (swaggerInterfaceList.hasNext()) {
            Map.Entry<String, JsonNode> swaggerInterface = swaggerInterfaceList.next();
            System.out.println("------------------------" + swaggerInterface.getKey());
            Interface i = new Interface();
            JsonNode swaggerInterfaceType = swaggerInterface.getValue();

            String interfaceType = "";
            if (swaggerInterfaceType.has("post")) {
                interfaceType = "post";
            }
            if (swaggerInterfaceType.has("get")) {
                interfaceType = "get";
            }
            if (swaggerInterfaceType.has("delete")) {
                interfaceType = "delete";
            }

            if (null == swaggerInterfaceType.get(interfaceType).get("parameters")) {
                i.setData(null);
            } else {
                HashMap<String, Object> parameters = getParams(swaggerInterfaceType.get(interfaceType).get("parameters"));
                try {
                    i.setData(objectMapper.writeValueAsString(parameters));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            i.setName(swaggerInterfaceType.get(interfaceType).get("summary").asText());
            i.setUrl(swaggerInterface.getKey());
            i.setRequestType(interfaceType);
            i.setProtocolType("http");
            i.setStatus(1);

            String groupName = swaggerInterfaceType.get(interfaceType).get("tags").get(0).asText();
            QueryWrapper<InterfaceGroup> wrapper = new QueryWrapper();
            wrapper.eq("name", groupName);
            InterfaceGroup group = interfaceGroupMapper.selectOne(wrapper);
            i.setGroupId(group.getId());
            interfaceMapper.insert(i);
            interfaceList.add(i);

        }
        return interfaceList;
    }

    public static HashMap<String, Object> getParams(JsonNode params) {
        HashMap<String, Object> param = new HashMap<>();
        if (params.size() != 1) {
            // TODO: 2021/3/5
        } else if (null == params.get(0).get("schema")) {
            // TODO: 2021/3/5
        } else if (null != params.get(0).get("schema").get("items")) {
            // TODO: 2021/3/5
        } else {
            String originalRef = params.get(0).get("schema").get("originalRef").asText();
            param = getRef(originalRef, definitions);
        }
        return param;
    }
}
