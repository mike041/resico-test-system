package cn.resico.test.service.gitStatistics.impl;

import cn.resico.test.entity.gitStatistics.StatisticsUser;
import cn.resico.test.mapper.gitStatistics.StatisticsUserMapper;
import cn.resico.test.service.gitStatistics.StatisticsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Commit;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("statisticsServiceImpl")
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    StatisticsUserMapper statisticsUserMapper;

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
    static Map<String, String> userAndEmialMap = new HashMap();

    @Override
    public List<StatisticsUser> statistic(String start, String end) {
        return statisticsUserMapper.selectList(null);
    }

    public void queryResult(String start, String end) throws ParseException, UnirestException, IOException, GitLabApiException {
        if (start.equals("") && end.equals("")) {
            return;
        }
        gitLabApi = new GitLabApi("http://gitlab.ustax.tech/", token);
        setUserAndEmialMap();

        List<StatisticsUser> users = statisticsUserMapper.selectList(null);

        build(users, start, end);
        for (StatisticsUser u : users) {
            u.setBugNumber(getBug(u.getUsername(), start, end));
            int codeNumber = (u.getCodeNumber() == 0)
                    ? 1
                    : u.getCodeNumber();
            u.setBugRatio((float) u.getBugNumber() / ((float) codeNumber / 1000F));
            statisticsUserMapper.updateById(u);
        }
    }

    /**
     * 更新userName的统计
     *
     * @param userName
     * @param start
     * @param end
     * @throws ParseException
     * @throws UnirestException
     * @throws IOException
     * @throws GitLabApiException
     */

    @Override
    public void queryResult(String userName, String start, String end) throws ParseException, UnirestException, IOException, GitLabApiException {
        if (start.equals("") && end.equals("")) {
            return;
        }
        gitLabApi = new GitLabApi("http://gitlab.ustax.tech/", token);
        setUserAndEmialMap();

        QueryWrapper queryWrapper = new QueryWrapper<StatisticsUser>();
        queryWrapper.eq("username", userName);
        List<StatisticsUser> users = statisticsUserMapper.selectList(queryWrapper);

        build(users, start, end);
        for (StatisticsUser u : users) {
            u.setBugNumber(getBug(u.getUsername(), start, end));
            int codeNumber = (u.getCodeNumber() == 0)
                    ? 1
                    : u.getCodeNumber();
            u.setBugRatio((float) u.getBugNumber() / ((float) codeNumber / 1000F));
            statisticsUserMapper.updateById(u);
        }
    }
  
    private void build(List<StatisticsUser> users, String start, String end) throws GitLabApiException, ParseException, IOException {
        List<Integer> projectIds = getAllProjectIds();
        /*List<Integer> projectIds =Arrays.asList(new Integer[]{38});*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (Integer projectId : projectIds) {
            List<Commit> commits = gitLabApi.getCommitsApi().getCommits(projectId, "master", sdf.parse(start), sdf.parse(end));
            if (null == commits) {
                continue;
            }
            for (Commit commit : commits) {
                commit = gitLabApi.getCommitsApi().getCommit(projectId, commit.getId());

                String userName = userAndEmialMap.get(commit.getAuthorEmail());
                for (StatisticsUser user : users) {
                    if (user.getUsername().equals(userName)) {
                        Integer additions = commit.getStats().getAdditions();
                        Integer deletions = commit.getStats().getDeletions();
                        Integer line = commit.getStats().getTotal();
                        user.setLine(user.getLine() + line);
                        user.setAdditions(user.getAdditions() + additions);
                        user.setDeletions(user.getDeletions() + deletions);
                        user.setCodeNumber(user.getCodeNumber() + additions - deletions);
                        user.setCommitTimes(user.getCommitTimes() + 1);
                        break;
                    }
                }
            }
            log.info("完成" + projectId);
        }
        log.info("查询结束");
    }

    private int getBug(String user, String start, String end) throws UnirestException, ParseException {
        log.info("查询{}的bug数量", user);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        String jql = "issuetype in (线上故障, 线下Bug) AND created >= %s AND created <= %s AND 处理人 in (%s)";
        String format = String.format(jql, sdf1.format(sdf.parse(start)), sdf1.format(sdf.parse(end)), user);
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

    private void setUserAndEmialMap() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\User.properties"));
        String str;
        HashSet<String> username = new HashSet<>();
        while ((str = reader.readLine()) != null) {
            if (username.contains(str.split("=")[1])) {
                continue;
            }
            userAndEmialMap.put(str.split("=")[0], str.split("=")[1]);
        }
    }

    private List<Integer> getAllProjectIds() throws GitLabApiException {
        List<Project> PROJECTS = gitLabApi.getProjectApi().getProjects();
        List<Integer> projectIds = new ArrayList<>();
        for (Project project : PROJECTS) {
            projectIds.add(project.getId());
        }
        return projectIds;
    }


    /*获取所有未映射的邮件*/
    @Test
    public void test2() throws Exception {
        Map<String, String> userNotInConfig = new HashMap();
        gitLabApi = new GitLabApi("http://gitlab.ustax.tech/", token);
        setUserAndEmialMap();
        List<Project> projects = gitLabApi.getProjectApi().getProjects();
        for (Project project : projects) {
            List<Commit> commits = gitLabApi.getCommitsApi().getCommits(project.getId());
            if (null == commits || commits.isEmpty()) {
                continue;
            }
            for (Commit commit : commits) {
                if (!userAndEmialMap.containsKey(commit.getAuthorEmail())) {
                    if (userNotInConfig.containsKey(commit.getAuthorEmail()))
                        continue;
                    System.out.println(commit.getAuthorEmail() + ":" + commit.getAuthorName());
                    userNotInConfig.put(commit.getAuthorEmail(), commit.getAuthorName());
                }
            }
        }
        System.out.println(userNotInConfig);
    }

    public Commit getCommit(Object projectIdOrPath, String sha) throws GitLabApiException {
        gitLabApi = new GitLabApi("http://gitlab.ustax.tech/", token);
        Commit c = gitLabApi.getCommitsApi().getCommit(projectIdOrPath, sha);
        System.out.println(c);
        return c;
    }

    @Test
    public void Test() throws GitLabApiException {
        getCommit(38, "0015d95c");
    }

}
