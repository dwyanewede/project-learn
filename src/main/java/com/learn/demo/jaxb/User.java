package com.learn.demo.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: User
 * @Description: User实体
 * @Author: 尚先生
 * @CreateDate: 2018/12/5 11:23
 * @Version: 1.0
 */
@XmlRootElement
public class User {

    public String id = "001";  

    public String name = "尚先生";

    public int age = 18;

} 