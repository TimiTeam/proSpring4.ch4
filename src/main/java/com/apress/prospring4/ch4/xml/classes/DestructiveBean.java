package com.apress.prospring4.ch4.xml.classes;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import java.io.File;
import java.io.FileNotFoundException;

public class DestructiveBean implements InitializingBean{
    private static final Logger LOGGER = Logger.getLogger(DestructiveBean.class);

    private String filePath;
    private File file;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void afterPropertiesSet() throws Exception
    // This method is from the InitializingBean interface.
    // And it is called after initialization and before creating
    {
        LOGGER.info("Initialization method by implements InitializingBean \n ------- ");
        if(filePath == null){
            LOGGER.info("ERROR: NO FILE PATH");
            throw new IllegalArgumentException("You must specify  the 'filePath' property of "
                    +DestructiveBean.class.getName());
        }
        this.file = new File(filePath);
        try {
            file.createNewFile();
        }catch (FileNotFoundException e){
            e.getMessage();
        }
        LOGGER.info("Is exist file: "+file.exists());
    }

    public void destroy() // In the destroy method, you can free up memory
     {
        LOGGER.info("Start destroy method \n *-------*");
        if(!file.delete()){
            LOGGER.info("ERROR: failed to delete file");
        }
        LOGGER.info("Is exist file: "+file.exists());
    }

    @Override
    public String toString() {
        return "DestructiveBean{" +
                "filePath='" + filePath + '\'' +
                ", file=" + file +
                '}';
    }
}
