package com.apress.prospring4.ch4;


import com.apress.prospring4.ch4.xml.classes.SimpleBean;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppContextStart {
    private static final Logger LOGGER = Logger.getLogger(SpringAppContextStart.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("xml-bean-application-context.xml");

        LOGGER.info(getBean("simpleBean1",context).toString());
        LOGGER.info(getBean("simpleBean2",context).toString());
        LOGGER.info(getBean("simpleBean3",context).toString());
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
