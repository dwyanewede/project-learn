package com.learn.demo.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @ClassName: XML2Java
 * @Description: User实体
 * @Author: 尚先生
 * @CreateDate: 2018/12/5 11:23
 * @Version: 1.0
 */
public class XML2Java {

    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(User.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        File file = new File("D:\\MyWorkSpace\\gupao-project\\demo-tomcat\\src\\main\\resources\\user.xml");

        User user = (User)unmarshaller.unmarshal(file);

        System.out.println(user.id);

        System.out.println(user.name);

        System.out.println(user.age);

    }  

} 