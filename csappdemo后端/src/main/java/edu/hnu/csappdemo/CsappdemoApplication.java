package edu.hnu.csappdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "edu.hnu.csappdemo.dao")
@SpringBootApplication
public class CsappdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsappdemoApplication.class, args);
    }

}
