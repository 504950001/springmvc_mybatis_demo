package cn.kingfeeling.config;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zemal-tan
 * @description mybatis 通过类的方式自动生成, mapper(java) mapper(xml) dao 等文件 .
 * @create 2017-07-30 23:29:29.
 */
public class MybatisGeneratorConfig {

    public void generator() throws Exception{

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指定 逆向工程配置文件
        File configFile = new File("src/main/resources/generator/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {
        try {
            MybatisGeneratorConfig mybatisGeneratorConfig = new MybatisGeneratorConfig();
            mybatisGeneratorConfig.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
