package cn.resico.test.vo.gitStatistics;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GitQuery {
    @ApiModelProperty("工程ids")
    private List<Integer> projectIds;
    @ApiModelProperty("统计人")
    private List<String> users;
    @ApiModelProperty("统计开始时间")
    private Date start;
    @ApiModelProperty("统计结束时间")
    private Date end;
}
