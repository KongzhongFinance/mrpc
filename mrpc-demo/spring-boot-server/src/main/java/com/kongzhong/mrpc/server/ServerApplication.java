package com.kongzhong.mrpc.server;

import com.kongzhong.mrpc.client.Referers;
import com.kongzhong.mrpc.demo.service.OtherService;
import com.kongzhong.mrpc.trace.interceptor.ClientTraceInterceptor;
import com.kongzhong.mrpc.trace.interceptor.ServerTraceInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author biezhi
 *         2017/5/15
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.kongzhong.mrpc.server.service")
public class ServerApplication {

    @Bean
    public Referers referers(){
        return new Referers().add(OtherService.class);
    }

    @Bean
    public ServerTraceInterceptor serverTraceInterceptor(){
        return new ServerTraceInterceptor();
    }

    @Bean
    public ClientTraceInterceptor clientTraceInterceptor() {
        return new ClientTraceInterceptor();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
