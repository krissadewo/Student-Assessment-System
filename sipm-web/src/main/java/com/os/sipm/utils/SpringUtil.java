/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kris
 */
public class SpringUtil {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringConfig.xml");

    public SpringUtil() {
    }

    public static Object getContext(Class classes) {
        classes = (Class) context.getBean(classes);
        return classes;
    }
}
