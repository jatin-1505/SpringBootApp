package com.jatin.taskmanager.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Configuration
public class DynamoDbConfig {

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient() {
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.EU_NORTH_1)
                .build();

        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(client)
                .build();
    }
}