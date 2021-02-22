package cn.resico.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
