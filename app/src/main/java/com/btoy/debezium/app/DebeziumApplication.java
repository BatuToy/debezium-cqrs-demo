package com.btoy.debezium.app;

import com.btoy.debezium.shared.annotations.DaoAdapter;
import com.btoy.debezium.shared.annotations.Publisher;
import com.btoy.debezium.shared.annotations.QueryHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = {"com.btoy.debezium"})
@EnableJpaRepositories(basePackages = {"com.btoy.debezium.persistence"})
@EntityScan(basePackages = {"com.btoy.debezium.persistence"})
@EnableElasticsearchRepositories(basePackages = {"com.btoy.debezium.elastic"})
@ComponentScan(
        basePackages = "com.btoy.debezium",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,
                        value = {DaoAdapter.class,
                                QueryHandler.class,
                                Publisher.class,
                                Component.class}
                )})
public class DebeziumApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebeziumApplication.class, args);
    }
}
