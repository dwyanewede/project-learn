package com.learn.demo.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @ClassName: JUnitAndMktioTest
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/13 19:01
 * @Version: 1.0
 */
@SpringJUnitConfig(classes = {UserController.class, MockRemoteUserServiceBean.class})
public class JUnitAndMktioTest {

    @Autowired
    private UserController userController;

    @Test
    public void findAll() {
        List<User> users = userController.findAll();
        System.out.println(users.toString());
    }

    /*@Configuration
    public static class MockRemoteUserService {

        @Bean
        public RemoteUserService getRemoteUserService() {

            RemoteUserService remoteUserService = mock(RemoteUserService.class);
            ArrayList<User> list = new ArrayList<>();
            User user = new User();
            user.setId(1L);
            user.setName("尚先生");
            list.add(user);
            when(remoteUserService.findAll()).thenReturn(list);
            return remoteUserService;
        }
    }*/
}
