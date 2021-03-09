import cn.resico.test.common.Parsing.ParsingSwagger;
import cn.resico.test.common.request.Request;

import cn.resico.test.entity.Interface;
import cn.resico.test.mapper.InterfaceGroupMapper;
import cn.resico.test.mapper.InterfaceMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Before;
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
    private JsonNode definitions;
    private JsonNode paths;
    private JsonNode tags;

    @Autowired
    InterfaceMapper interfaceMapper;
    @Autowired
    InterfaceGroupMapper interfaceGroupMapper;

    @Before
    public void setUp() {
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


    @Test
    public void test() throws IOException {
        ParsingSwagger parsingSwagger = new ParsingSwagger();
        Iterator<Map.Entry<String, JsonNode>> interfaceNodes = parsingSwagger.paths.fields();

        while (interfaceNodes.hasNext()) {
            Interface i = new Interface();

            Map.Entry<String, JsonNode> interfaceNodesEntry = interfaceNodes.next();
            JsonNode interfaceNode = interfaceNodesEntry.getValue();

            i.setName(interfaceNode.iterator().next().get("summary").asText());
            i.setUrl(interfaceNodesEntry.getKey());

            i.setRequestType(parsingSwagger.getRequestType(interfaceNode));
            i.setProtocolType("http");
            i.setStatus(1);

            JsonNode requestTypeNode = interfaceNode.elements().next();
            i.setGroupId(parsingSwagger.setGroup(requestTypeNode, interfaceGroupMapper).getId());

            JsonNode parameterNode = requestTypeNode.get("parameters");

            String s = objectMapper.writeValueAsString(parsingSwagger.getParams(parameterNode));
            i.setData(s);
            interfaceMapper.insert(i);
        }
    }

}
