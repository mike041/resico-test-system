package cn.resico.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceWithParams {
    private Integer id;
    private Integer interface_id;
    private Integer verification_type;
    private String verification_context;
    private String interface_instance_result;
    private String data;
}
