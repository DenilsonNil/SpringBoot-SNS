package br.com.kualit.springbootsns.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Log4j2
public class SnsClientConfiguration {

    @Value("${amazon.config.accessKey}")
    private String ACCESS_KEY;

    @Value("${amazon.config.secretKey}")
    private String SECRET_KEY;

    @Value("${amazon.config.region}")
    private String REGION;

    @Primary
    @Bean
    public AmazonSNSClient getSNSClient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                    .withRegion(REGION)
                    .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
                .build();
    }
}
