package cn.resico.test.pojo;

import com.sun.net.httpserver.Headers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interface {
    private int id;
    private String name;
    private String requestType;
    private String protocolType;
    private String data;
    private String url;
    private List<Param> paramList;
    private List<Headers> headers;
    private int status;
    private Long groupId;
}
