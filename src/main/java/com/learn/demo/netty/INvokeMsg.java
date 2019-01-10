package com.learn.demo.netty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @ClassName: INvokeMsg
 * @Description: RPC调用代理对象封装类
 * @Author: 尚先生
 * @CreateDate: 2019/1/10 9:09
 * @Version: 1.0
 */
public class INvokeMsg implements Serializable {

    private String className;
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] args;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }


    @Override
    public String toString() {
        return "INvokeMsg{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", paramTypes=" + paramTypes +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
