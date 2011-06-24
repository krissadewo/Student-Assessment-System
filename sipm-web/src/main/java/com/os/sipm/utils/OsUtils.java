/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kris
 */
public class OsUtils {

    /**
     * @param date
     * @return string format for date dd-mm-yyyy
     */
    public static String formatThis(Date date) {
        Format df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(date);
    }

    /**
     * @param param1
     * @param param2
     * @return merge String using StringBuilder
     */
    public static String mergeThis(String param1, String param2) {
        return new StringBuilder().append(param1).append(" ").append(param2).toString();
    }

    /**
     * @param param1
     * @return merge String using StringBuilder
     */
    public static String mergeThis(String param1) {
        return new StringBuilder().append(param1).toString();
    }
}
