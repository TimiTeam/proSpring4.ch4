package com.apress.prospring4.ch4.xml.classes;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import java.security.MessageDigest;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>,
// Implements FactoryBean for get another way inject dependency
        InitializingBean {


    private String algorithmName = "MD5";
    private MessageDigest messageDigest; // This is abstract class for generate a message digest
    //or hash of user password

    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);// This is realization of abstract class
        //MessageDigest, we transfer algorithm of creating the digest in the interface method InitializingBean
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
