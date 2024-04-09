package com.assgn3.polynomial.res;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static final DateFormat errorDateFormat = new SimpleDateFormat("HH:mm:ss");

    public Logger() {
    }

    public static void info(String infoMessage) {
        System.out.printf("-- INFO -- [%s][%s]: %s%n\n", errorDateFormat.format(new Date()), Thread.currentThread().getStackTrace()[2].getMethodName(), infoMessage);
    }

    public static void error(String errorMessage) {
        System.out.printf("-- ERROR -- [%s][%s]: %s%n\n", errorDateFormat.format(new Date()), Thread.currentThread().getStackTrace()[2].getMethodName(), errorMessage);
    }
}
