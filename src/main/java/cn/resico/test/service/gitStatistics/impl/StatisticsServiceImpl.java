package cn.resico.test.service.gitStatistics.impl;

import cn.resico.test.entity.gitStatistics.User;
import cn.resico.test.service.gitStatistics.StatisticsService;
import cn.resico.test.vo.gitStatistics.GitQuery;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Commit;
import org.gitlab4j.api.models.Project;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("statisticsServiceImpl")
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {


    Set<String> username = new HashSet<>();
    Map<String, User> map = new HashMap<>();
    List<User> userList = new ArrayList<>();

    static Integer[] OBJECT_NUMBERS_RESICO_RD = {
            35, 134, 132, 130, 129, 126, 125, 124, 122, 118, 112, 105, 101, 91, 90, 42, 41, 40, 39, 38,//后端
            37, 20, 19, 18, 16, 15, 14, 13, 12, 11
    };//这写上你要统计的后端项目id

    static Integer[] OBJECT_NUMBERS_RESICO_FED = {
            30, 29, 140, 136, 131, 121, 117, 115, 100, 83, 80, 78, 75, 72, 67, 66, 65, 64, 63, 62,//前端
            61, 55, 52
    };//这写上你要统计的前端项目id

    static Integer[] OBJECT_NUMBERS = {
            35, 134, 132, 130, 129, 126, 125, 124, 122, 118, 112, 105, 101, 91, 90, 42, 41, 40, 39, 38,//后端
            37, 20, 19, 18, 16, 15, 14, 13, 12, 11,
            30, 29, 140, 136, 131, 121, 117, 115, 100, 83, 80, 78, 75, 72, 67, 66, 65, 64, 63, 62,//前端
            61, 55, 52
    };//这写上你要统计的所有项目id


    static String token = "ar-mE1pshASQ-AJZmeYH";
    //这写上你家gitlab地址
    static GitLabApi gitLabApi;


    @Override
    public List<User> statistic(GitQuery query) throws Exception {
        gitLabApi = new GitLabApi("http://gitlab.ustax.tech/", token);
        //获取要查询的工程
        List<Integer> projectIds = (null != query.getProjectIds())
                ? query.getProjectIds()
                : getAllProjectIds();

        List<String> users = (null != query.getUsers())
                ? query.getUsers()
                : getAllUsers();

        return query(users, projectIds, query.getStart(), query.getEnd());
    }


    public List<Integer> getAllProjectIds() throws GitLabApiException {
        List<Project> PROJECTS = gitLabApi.getProjectApi().getProjects();
        List<Integer> projectIds = new ArrayList<>();
        for (Project project : PROJECTS) {
            projectIds.add(project.getId());
        }
        return projectIds;
    }

    public List<String> getAllUsers() throws GitLabApiException {
        List<org.gitlab4j.api.models.User> ACTIVE_USERS = gitLabApi.getUserApi().getActiveUsers();
        List<String> users = new ArrayList<>();
        for (org.gitlab4j.api.models.User activeUser : ACTIVE_USERS) {
            users.add(activeUser.getUsername());
        }
        return users;
    }

    public List<User> query(List<String> users, List<Integer> projectIds, String start, String end) throws GitLabApiException, UnirestException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return query(users, projectIds, sdf.parse(start), sdf.parse(end));
    }

    public List<User> query(List<String> users, List<Integer> projectIds, Date start, Date end) throws GitLabApiException, UnirestException {

        for (Integer projectId : projectIds) {
            List<Commit> commits = gitLabApi.getCommitsApi().getCommits(projectId, "master", start, end);

            if (null != commits && commits.isEmpty()) {
                continue;
            }
            for (Commit commit : commits) {

                String userName = commit.getAuthorName();
               /* if (!users.contains(userName)) {
                    continue;
                }*/

                User user = null;
                if (!username.contains(userName)) {
                    user = User.builder()
                            .name(userName)
                            .line(0)
                            .additions(0)
                            .deletions(0)
                            .bugNumber(getBug(userName))
                            .build();
                    username.add(userName);
                    map.put(userName, user);
                    userList.add(user);
                } else {
                    user = map.get(userName);
                }
                commit = gitLabApi.getCommitsApi().getCommit(projectId, commit.getShortId());
                Integer additions = commit.getStats().getAdditions();
                Integer deletions = commit.getStats().getDeletions();
                user.setLine(user.getLine() + additions - deletions);
                user.setAdditions(user.getAdditions() + additions);
                user.setDeletions(user.getDeletions() + deletions);
                user.setCommitTimes(user.getCommitTimes() + 1);
                log.info("项目：{}，用户：{}", projectId, user);
            }
        }
        return userList;
    }

    public int getBug(String user) throws UnirestException {
        log.info("查询{}的bug数量", user);
        String jql = "issuetype in (线上故障, 线下Bug) AND created >= 2021-01-01 AND created <= 2021-03-31 AND 处理人 in (%s)";
        String format = String.format(jql, user);
        HttpResponse<JsonNode> response = Unirest.get("http://jira2.ustax.tech/rest/api/2/search")
                .basicAuth("zhouyunteng", "qaz19950401")
                .header("Accept", "application/json")
                .queryString("jql", format)
                .asJson();
        Integer bugNumber = (response.getBody().getObject().has("total")) ?
                (Integer) response.getBody().getObject().get("total")
                : 0;

        return bugNumber;
    }

    @Test
    public void bug() throws UnirestException, GitLabApiException {
        List<org.gitlab4j.api.models.User> ACTIVE_USERS = gitLabApi.getUserApi().getActiveUsers();

        for (org.gitlab4j.api.models.User active_user : ACTIVE_USERS) {
            System.out.println(getBug(active_user.getUsername()));
        }

    }

    @Test
    public void test() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date start = sdf.parse("20210101");
        Date end = sdf.parse("20210331");
        GitQuery query = new GitQuery();
        query.setStart(start);
        query.setEnd(end);

        List<User> statistic = statistic(query);

    }
}
