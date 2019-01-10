package com.learn.demo.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @ClassName: Java2XML
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/5 11:23
 * @Version: 1.0
 */
public class Java2XML {

    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(User.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");//编码格式

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化生成的xml串  

        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）  

        User user = new User();

        marshaller.marshal(user, System.out);

    }  

 

} 