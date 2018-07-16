import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huqj.controller.TestController;
import top.huqj.model.Student;

/**
 * hello spring boot
 *
 * @author huqj
 */
@RestController
@EnableAutoConfiguration
@EnableConfigurationProperties({Student.class})
public class Example {

    /**
     * 使用注解注入配置文件的属性
     */
    @Value("${application.name}")
    private String testName;

    @Autowired
    private Student student;

    @RequestMapping("/")
    public String home() {
        return "Hello SpringBoot!" + testName;
    }

    @RequestMapping("/student")
    public Student student() {
        //返回bean对象，@RestController自动转换为json输出
        return student;
    }

    public static void main(String[] args) {
        //启动多个controller
        Class[] classes = new Class[]{Example.class, TestController.class};
        SpringApplication.run(classes, args);
    }

}
