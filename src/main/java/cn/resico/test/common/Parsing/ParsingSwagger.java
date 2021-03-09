package cn.resico.test.common.Parsing;

import cn.resico.test.common.request.Request;
import cn.resico.test.entity.Interface;
import cn.resico.test.entity.InterfaceGroup;
import cn.resico.test.mapper.InterfaceGroupMapper;
import cn.resico.test.mapper.InterfaceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
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
    public static ObjectMapper objectMapper = new ObjectMapper();
    public JsonNode definitions;
    public JsonNode paths;
    public JsonNode tags;

    @Autowired
    InterfaceMapper interfaceMapper;


    public ParsingSwagger() {
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

        try {
            paths = objectMapper.readTree(swaggerData).get("paths");
            definitions = objectMapper.readTree(swaggerData).get("definitions");
            tags = objectMapper.readTree(swaggerData).get("tags");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public HashMap<String, Object> getRef(String ref, JsonNode definitions) {
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

    public List<Interface> synchronizeInterface(JsonNode paths, InterfaceGroupMapper interfaceGroupMapper) throws JsonProcessingException {
        List<Interface> interfaceList = new ArrayList<>();
        Iterator<Map.Entry<String, JsonNode>> swaggerInterfaceList = paths.fields();

        while (swaggerInterfaceList.hasNext()) {
            Interface i = new Interface();

            Map.Entry<String, JsonNode> interfaceNodesEntry = swaggerInterfaceList.next();
            JsonNode interfaceNode = interfaceNodesEntry.getValue();

            i.setName(interfaceNode.iterator().next().get("summary").asText());
            i.setUrl(interfaceNodesEntry.getKey());

            i.setRequestType(this.getRequestType(interfaceNode));
            i.setProtocolType("http");
            i.setStatus(1);

            JsonNode requestTypeNode = interfaceNode.elements().next();
            i.setGroupId(this.setGroup(requestTypeNode, interfaceGroupMapper).getId());

            JsonNode parameterNode = requestTypeNode.get("parameters");

            String s = objectMapper.writeValueAsString(this.getParams(parameterNode));
            i.setData(s);
            interfaceMapper.insert(i);
        }
        return interfaceList;
    }

    public void synchronizeInterfaceGroup(JsonNode tags, InterfaceGroupMapper interfaceGroupMapper) {
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, InterfaceGroup.class);
        ArrayList<InterfaceGroup> groups = null;
        try {
            groups = objectMapper.readValue(tags.toString(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (InterfaceGroup group : groups
        ) {
            interfaceGroupMapper.insert(group);
        }

    }


    public HashMap<String, Object> getParams(JsonNode params) {
        if (null == params) {
            return null;
        }
        HashMap<String, Object> param = new HashMap<>();
        if (params.size() > 1) {
            Iterator<JsonNode> iteratorParam = params.iterator();
            while (iteratorParam.hasNext()) {
                JsonNode paramNode = iteratorParam.next();
                if (null != paramNode.get("type")) {
                    param.put(paramNode.get("name").asText(), paramNode.get("type"));
                }
            }

        } else if (null == params.get(0).get("schema")) {
            param.put(params.get(0).get("name").asText(), params.get(0).get("type"));
        } else if (null != params.get(0).get("schema").get("items")) {
            JsonNode itemsjsonNode = params.get(0).get("schema").get("items");
            String originalRef = params.get(0).get("schema").get("items").get("originalRef").asText();
            param = getRef(originalRef, definitions);
        } else {
            String originalRef = params.get(0).get("schema").get("originalRef").asText();
            param = getRef(originalRef, definitions);
        }
        return param;
    }


    public InterfaceGroup setGroup(JsonNode requestTypeNode, InterfaceGroupMapper interfaceGroupMapper) {
        String groupName = requestTypeNode.get("tags").get(0).asText();
        QueryWrapper<InterfaceGroup> wrapper = new QueryWrapper();
        wrapper.eq("name", groupName);
        return interfaceGroupMapper.selectOne(wrapper);

    }

    public String getRequestType(JsonNode interfaceNode) {
        return interfaceNode.fields().next().getKey();

    }

}
