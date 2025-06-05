package net.javaguides.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaguidesTopic(){
        return TopicBuilder.name("kafka_producer_topic")
                .build();
    }

    @Bean
    public NewTopic javaguidesJspnTopic(){
        return TopicBuilder.name("kafka_producer_json_topic")
                .build();
    }
}
