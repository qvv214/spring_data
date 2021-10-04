package ru.digitalleague.spring_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.digitalleague.spring_data.config.ApplicationConfiguration;

@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

}
