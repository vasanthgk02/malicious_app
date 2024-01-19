package com.braintreepayments.cardform.utils;

import java.util.Calendar;

public class DateValidator {
    public static final DateValidator INSTANCE = new DateValidator(Calendar.getInstance());
    public final Calendar mCalendar;

    public DateValidator(Calendar calendar) {
        this.mCalendar = calendar;
    }
}
