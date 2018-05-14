package com.apress.prospring4.ch4.xml.classes;


import org.apache.log4j.Logger;

import java.security.MessageDigest;

public class MessageDigester {
    private static final Logger LOGGER = Logger.getLogger(MessageDigester.class);

    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg){
        LOGGER.info("Using digest1 ");
        digest(msg,digest1);

        LOGGER.info("Using digest2 ");
        digest(msg,digest2);

    }

    private void digest(String msg,MessageDigest digest){
        LOGGER.info("Using algorithm - "+digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        LOGGER.info(out+"\n");
    }
}
