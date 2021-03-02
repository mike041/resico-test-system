package cn.resico.test.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.net.httpserver.Headers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interface {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    @TableField("request_type")
    private String requestType;
    @TableField("protocol_type")
    private String protocolType;
    private String data;
    private String url;
    private List<Headers> headers;
    private int status;
    @TableField("group_id")
    private int groupId;
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private Date createdAt;
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;
}
