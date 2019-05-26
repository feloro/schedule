package com.feloro.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class AppProperties {

    private static String calendarLink;

    public static String getCalendarLink() {
        return calendarLink;
    }

    @Value(value = "${google.calendar.link}")
    public void setCalendarLink(String calendarLink) {
        AppProperties.calendarLink = calendarLink;
    }
}
