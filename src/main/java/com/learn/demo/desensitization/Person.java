package com.learn.demo.desensitization;

/**
 * @ClassName: Person
 * @Description: Person实体类
 * @Author: 尚先生
 * @CreateDate: 2019/1/24 17:50
 * @Version: 1.0
 */
public class Person {

    private String custName;

    private int idNo;

    private String certNo;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "custName='" + custName + '\'' +
                ", idNo=" + idNo +
                ", certNo='" + certNo + '\'' +
                '}';
    }
}
