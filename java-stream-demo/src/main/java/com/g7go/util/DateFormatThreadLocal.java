package com.g7go.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lwc
 */
public class DateFormatThreadLocal {

    private static final ThreadLocal<DateFormat> DF = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static Date convert(String source) throws ParseException {
        return DF.get().parse(source);
    }

}