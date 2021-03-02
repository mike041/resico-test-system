package cn.resico.test.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 自动通过表生成java文件
 */
public class CustomGenerator {
    public static void main(String[] args) {

        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\ideaProject\\resico-test-system\\src\\main\\java");
        gc.setFileOverride(false);
        gc.setEnableCache(false);
        gc.setActiveRecord(false);
        gc.setAuthor("zyt");
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("admin");
        dsc.setUrl("jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8&useSSL=false");
        mpg.setDataSource(dsc);


        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(new String[]{"interface","interface_group","interface_hisotry",
        "interface_with_params","testcase","testcase_group","testcase_instance",
        "testcase_interface_relation"}); // 需要生成的表
        /*strategy.setTablePrefix("library_");// 此处可以修改为您的表前缀*/
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        mpg.setStrategy(strategy);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.resico.test");
        //pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        //目录配置
        TemplateConfig tc = new TemplateConfig();
        tc.setController(null);
        tc.setService(null);
        tc.setXml(null);
        mpg.setTemplate(tc);

        //执行生成
        mpg.execute();
    }
}
