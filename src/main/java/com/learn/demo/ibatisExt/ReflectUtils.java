package com.learn.demo.ibatisExt;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/**
 * @ClassName: ReflectUtils
 * @Description: 反射设置自定义处理器
 * @Author: 尚先生
 * @CreateDate: 2019/4/3 19:38
 * @Version: 1.0
 */
public class ReflectUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

    /**
     * 执行 set方法
     * @param target
     * @param name
     * @param type
     * @param value
     */
    public static void setFieldValue(Object target, String name, Class type,
                                     Object value) {
        if (target == null || name == null || StringUtils.isEmpty(name) || StringUtils.isEmpty(name)
        || (value != null && !type.isAssignableFrom(value.getClass()))){

            logger.error("设置自定义处理器异常，原因是存在参数值为空");
            return;
        }
        Class clazz = target.getClass();
        try {
            Field field = clazz.getDeclaredField(name);
            if (!Modifier.isPublic(field.getModifiers())) {
                // 设置属性可获取
                field.setAccessible(true);
            }
            field.set(target, value);
        } catch (Exception e) {
            logger.error("设置自定义处理器异常，异常信息：" ,new Object[]{e});
        }
    }
}