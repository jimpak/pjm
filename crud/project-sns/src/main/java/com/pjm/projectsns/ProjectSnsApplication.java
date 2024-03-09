package com.pjm.projectsns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ProjectSnsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSnsApplication.class, args);
    }

}
