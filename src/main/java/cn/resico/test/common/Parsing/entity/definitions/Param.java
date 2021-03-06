package cn.resico.test.common.Parsing.entity.definitions;

import lombok.Data;

@Data
public class Param {
    String description;
    ParamType type;
    String format;
    String $ref;
    String originalRef;
}
