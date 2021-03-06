package cn.resico.test.common.Parsing.entity.definitions;

public enum ParamType {
    string("srting"),
    number("number"),
    Boolean("boolean"),
    integer("integer");

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    ParamType(String type) {
        this.type = type;
    }

    String type;

}
