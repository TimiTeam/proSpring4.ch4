package com.apress.prospring4.ch4;


import com.apress.prospring4.ch4.xml.classes.DestructiveBean;
import com.apress.prospring4.ch4.xml.classes.MessageDigester;
import com.apress.prospring4.ch4.xml.classes.SimpleBean;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class SpringAppContextStart {
    private static final Logger LOGGER = Logger.getLogger(SpringAppContextStart.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("xml-bean-application-context.xml");

        GenericXmlApplicationContext genericCont = new
                GenericXmlApplicationContext("xml-bean-application-context.xml");

//        LOGGER.info(getBean("simpleBean1",context).toString());
//        LOGGER.info(getBean("simpleBean2",context).toString());
//        LOGGER.info(getBean("simpleBean3",context).toString());

//        genericCont.registerShutdownHook();
//        DestructiveBean bean = genericCont.getBean("destructiveBean",DestructiveBean.class);
//        LOGGER.info(bean.toString()+"\n and bean ID: "+bean.getBeanName());
//        genericCont.close(); // This method for called all destroyed methods

        MessageDigester digester = context.getBean("digester",MessageDigester.class);
        digester.digest("My name is Timur");


        Resource resource1 = context.getResource("classpath:text.txt");
        displayInfo(resource1);
        resource1 = context.getResource("http://www.google.com");
        displayInfo(resource1);
    }


    private static void displayInfo(Resource resource){
        try {
            LOGGER.info("\n"+resource.getClass()+"\n"+
            resource.getURL().getContent()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static SimpleBean getBean(String beanName, ApplicationContext context){
        try {
            SimpleBean bean = context.getBean(beanName,SimpleBean.class);
            return bean;
        }catch (IllegalArgumentException e){
            e.getMessage();
            return null;
        }
    }
}
