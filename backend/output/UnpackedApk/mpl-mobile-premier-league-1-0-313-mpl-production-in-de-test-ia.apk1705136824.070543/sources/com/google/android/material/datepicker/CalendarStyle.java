package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

public final class CalendarStyle {
    public final CalendarItemStyle day;
    public final CalendarItemStyle invalidDay;
    public final Paint rangeFill;
    public final CalendarItemStyle selectedDay;
    public final CalendarItemStyle selectedYear;
    public final CalendarItemStyle todayDay;
    public final CalendarItemStyle todayYear;
    public final CalendarItemStyle year;

    public CalendarStyle(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ImageOriginUtils.resolveOrThrow(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.day = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.invalidDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.selectedDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.todayDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateList = ImageOriginUtils.getColorStateList(context, obtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.year = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.selectedYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.todayYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.rangeFill = paint;
        paint.setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
