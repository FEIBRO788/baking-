package cn.tedu.baking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BakingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BakingApplication.class, args);
    }

}
