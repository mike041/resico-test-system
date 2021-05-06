package cn.resico.test.vo.gitStatistics;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitQuery {


    @ApiModelProperty("工程ids")
    private List<Integer> projectIds;
    @ApiModelProperty("统计人")
    private List<String> users;
    @ApiModelProperty("统计开始时间")
    private String start;
    @ApiModelProperty("统计结束时间")
    private String end;
}
