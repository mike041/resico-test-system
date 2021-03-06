package cn.resico.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("interface_group")
public class InterfaceGroup {
    private Integer id;
    private String name;
    private String description;
}
