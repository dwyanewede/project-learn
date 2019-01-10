package com.learn.demo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class MockRemoteUserServiceBean {

    @Bean
    public RemoteUserService getRemoteUserService() {
        RemoteUserService remoteUserService = mock(RemoteUserService.class);
//        User user = new User();
//        user.setId(1L);
//        user.setName("尚先生");
//        Mockito.when(remoteUserService.findAll()).thenReturn(Arrays.asList(user));
        return remoteUserService;
    }
}