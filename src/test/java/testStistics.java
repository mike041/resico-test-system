
import cn.resico.test.entity.gitStatistics.StatisticsUser;
import cn.resico.test.mapper.gitStatistics.StatisticsUserMapper;
import cn.resico.test.service.gitStatistics.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
@Slf4j
public class testStistics extends AbstractTestNGSpringContextTests {

    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private StatisticsUserMapper statisticsUserMapper;


    @Test
    public void test() throws Exception {
        String start = "20210101";
        String end = "20210331";
        statisticsService.queryResult(start, end);
    }

    @Test
    public void testUser() throws Exception {
        String start = "20210101";
        String end = "20210331";
        statisticsService.queryResult("eugene", start, end);
    }

    /**
     * 将用户写入数据库
     * @throws GitLabApiException
     */

    @Test
    public void test2() throws GitLabApiException {
       GitLabApi  gitLabApi = new GitLabApi("http://gitlab.ustax.tech/", "ar-mE1pshASQ-AJZmeYH");
        for (User user : gitLabApi.getUserApi().getUsers()) {
            StatisticsUser statisticsUser = StatisticsUser.builder()
                    .username(user.getUsername())
                    .name(user.getName())
                    .line(0)
                    .additions(0)
                    .deletions(0)
                    .codeNumber(0)
                    .bugNumber(0)
                    .commitTimes(0)
                    .build();
            statisticsUserMapper.insert(statisticsUser);
        }
    }
}
