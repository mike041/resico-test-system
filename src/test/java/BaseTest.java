import cn.resico.test.common.request.Request;
import org.apache.log4j.Logger;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends AbstractTestNGSpringContextTests {
    Logger log = Logger.getLogger(this.getClass());
    @BeforeSuite
    public void setup() {
        log.info("------------------判断是否需要登录---------------");

       /* if (!this.isTokenEffective()) {
            new Request().login();
        }*/



        log.info("------------------开始执行测试---------------");
    }

    @AfterSuite
    public void tearDown() {
        log.info("关闭server");
        log.info("-------------结束测试，并关闭退出driver及自动化 server-------------");
    }
}
