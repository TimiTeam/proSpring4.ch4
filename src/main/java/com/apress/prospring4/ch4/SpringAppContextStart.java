package com.apress.prospring4.ch4;


import com.apress.prospring4.ch4.xml.classes.DestructiveBean;
import com.apress.prospring4.ch4.xml.classes.SimpleBean;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringAppContextStart {
    private static final Logger LOGGER = Logger.getLogger(SpringAppContextStart.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("xml-bean-application-context.xml");

        GenericXmlApplicationContext genericCont = new
                GenericXmlApplicationContext("xml-bean-application-context.xml");

//        LOGGER.info(getBean("simpleBean1",context).toString());
//        LOGGER.info(getBean("simpleBean2",context).toString());
//        LOGGER.info(getBean("simpleBean3",context).toString());

        genericCont.registerShutdownHook();
        DestructiveBean bean = genericCont.getBean("destructiveBean",DestructiveBean.class);
        LOGGER.info(bean.toString()+"\n and bean ID: "+bean.getBeanName());
//        genericCont.close(); // This method for called all destroyed methods

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
