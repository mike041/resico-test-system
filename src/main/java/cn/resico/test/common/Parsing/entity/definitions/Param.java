package cn.resico.test.common.Parsing.entity.definitions;

import lombok.Data;

@Data
public class Param {
    String description;
    String format;
    String in;
    String name;
    String type;
    String items;
    boolean required;
    String schema;
}
