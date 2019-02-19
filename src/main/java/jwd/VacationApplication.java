package jwd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class VacationApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VacationApplication.class, args);
    }
}