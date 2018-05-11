package com.apress.prospring4.ch4.xml.classes;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanNameAware;

public class SimpleBean{

    private static final Logger LOGGER = Logger.getLogger(SimpleBean.class);
    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;


    public static String getDefaultName() {
        return DEFAULT_NAME;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }
    public void init() { // This method will called after initialization bean and before creating object
        LOGGER.info("Initialization method "+this.name+"\n ----- \n");
        if(name == null){
            name = DEFAULT_NAME;
            LOGGER.info("Name does not exist...Set default name. \n");
        }
        if(age == Integer.MIN_VALUE){
            LOGGER.info("You must set the age property of beans of type:"+SimpleBean.class.getName()+"\n");
            throw new IllegalArgumentException("" +
                    "You must set the age property of beans of type: "+ SimpleBean.class.getName());
        }
        LOGGER.info("**Initialization method is end** \n");
    }

    @Override
    public String toString() {
        return "SimpleBean - " +
                "name - " + name +
                ", age - " + age;
    }
}
