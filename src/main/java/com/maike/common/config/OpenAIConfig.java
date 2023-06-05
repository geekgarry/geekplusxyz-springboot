/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 2/18/23 20:29
 * description: 做什么的？
 */
package com.maike.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {
    @Value("${openai.api.key}")
    private String apiKey;

//    @Bean
//    public OpenAI getOpenAIClient() {
//        return new OpenAI(apiKey);
//    }
}
