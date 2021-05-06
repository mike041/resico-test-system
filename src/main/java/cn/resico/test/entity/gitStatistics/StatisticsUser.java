package cn.resico.test.entity.gitStatistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@TableName("statistics_user")
public class StatisticsUser {
    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String username;
    @TableField("user_group")
    private String userGroup;// 1.前端 java php 其他
    private int line;
    private int additions;
    private int deletions;
    @TableField("commit_times")
    private int commitTimes;
    @TableField("bug_number")
    private int bugNumber;
    @TableField("code_number")
    private int codeNumber;
    @TableField("bug_ratio")
    private float bugRatio;
}
