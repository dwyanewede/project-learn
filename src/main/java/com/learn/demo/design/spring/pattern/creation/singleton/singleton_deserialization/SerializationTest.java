package com.learn.demo.design.spring.pattern.creation.singleton.singleton_deserialization;

import java.io.*;

public class SerializationTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        DemoSingleton instanceOne = DemoSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        
        // 从文件反序列化到对象
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        DemoSingleton instanceTwo = (DemoSingleton) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
        
    }

}
