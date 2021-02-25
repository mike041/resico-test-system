package cn.resico.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condition {
    String name;
    String requestType;
    Integer groupId;
}
