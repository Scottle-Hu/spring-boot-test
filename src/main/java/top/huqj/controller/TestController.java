package top.huqj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huqj
 */
@RestController
@EnableAutoConfiguration
@PropertySource("classpath:test.properties")
@RequestMapping("/test")
public class TestController {

    @Value("${test.word}")
    private String word;

    @Value("${test.random}")
    private int random;

    @Value("${db.name}")
    private String dbName;

    @RequestMapping("/")
    public String index() {
        //测试使用自定义的配置文件test.properties
        return word;
    }

    @RequestMapping("/random")
    public String random() {
        return "随机数：" + random;
    }

    @RequestMapping("/db")
    public String dbName() {
        //测试通过spring.profiles.active来控制环境切换（也就是配置文件属性的切换）
        return "db name:" + dbName;
    }

}
