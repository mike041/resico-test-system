package cn.resico.test.entity;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import lombok.Builder;
import lombok.Data;
import org.apache.http.Header;

import java.util.List;

@Data
@Builder
public class Response {
    final static int SUCCEED_CODE = 10000;
    final static boolean SUCCEED_TRUE = true;
    final static boolean SUCCEED_FALSE = false;
    int status;
    String code;
    String error;
    String msg;
    boolean succeed;
    Object data;
    String result;
    List<Header> headerList;

    public static Response setResponse(HttpResponse<JsonNode> jsonResponse) {
        Response response = Response.builder()
                .status(jsonResponse.getStatus())
                .code(jsonResponse.getBody().getObject().getString("code"))
                .data(jsonResponse.getBody().getObject().get("data"))
                .error(jsonResponse.getBody().getObject().getString("error"))
                .msg(jsonResponse.getBody().getObject().getString("msg"))
                .succeed(jsonResponse.getBody().getObject().getBoolean("succeed"))
                .result(jsonResponse.getBody().getObject().toString())
                .build();
        return response;
    }
}
