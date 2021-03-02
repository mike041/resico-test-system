package cn.resico.test.entity;

import com.sun.net.httpserver.Headers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceHistory {
    private int id;
    private int interface_history_id;
    private String name;
    private String requestType;
    private String protocolType;
    private String data;
    private String url;
    private List<Headers> headers;
    private int status;
    private int groupId;
}
