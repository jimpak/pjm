package com.example.sb02.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;

import javax.swing.text.html.parser.Entity;

@org.springframework.context.annotation.Configuration
public class RootConfig {
    @Bean
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper;
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager em){
        return new JPAQueryFactory(em);
    }
}
