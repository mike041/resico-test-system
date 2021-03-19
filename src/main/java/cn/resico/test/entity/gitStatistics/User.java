package cn.resico.test.entity.gitStatistics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int line;
    private int additions;
    private int deletions;
    private int commitTimes;
    private int bugNumber;
    private float bugRatioOfThousand;

}
