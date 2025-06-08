package com.skillsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.skillsync.entity")
public class SkillsyncBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkillsyncBackendApplication.class, args);
    }
}
