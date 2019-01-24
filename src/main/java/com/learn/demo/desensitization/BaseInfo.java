package com.learn.demo.desensitization;

import java.io.Serializable;

/**
 * @ClassName: BaseInfo
 * @Description: 日志过滤字段基类
 * @Author: 尚先生
 * @CreateDate: 2019/1/24 17:38
 * @Version: 1.0
 */
public class BaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @DesensitizedAnnotation(type = TypeEnum.PERSON_NAME)
    private String custName;

    @DesensitizedAnnotation(type = TypeEnum.PERSON_CERT_NO)
    private String certNo;


}
