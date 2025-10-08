package com.btoy.debezium.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.btoy.debezium"})
@EnableJpaRepositories(basePackages = {"com.btoy.debezium.persistence"})
@EntityScan(basePackages = {"com.btoy.debezium.persistence"})
@EnableElasticsearchRepositories(basePackages = {"com.btoy.debezium.elastic"})
public class DebeziumApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebeziumApplication.class, args);
	}

}
