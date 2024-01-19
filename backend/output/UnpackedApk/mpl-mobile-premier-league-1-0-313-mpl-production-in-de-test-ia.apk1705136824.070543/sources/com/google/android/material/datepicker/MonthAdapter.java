package com.google.android.material.datepicker;

import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

public class MonthAdapter extends BaseAdapter {
    public static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final DateSelector<?> dateSelector;
    public final Month month;
    public Collection<Long> previouslySelectedDates;

    public MonthAdapter(Month month2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2) {
        this.month = month2;
        this.dateSelector = dateSelector2;
        this.calendarConstraints = calendarConstraints2;
        this.previouslySelectedDates = dateSelector2.getSelectedDays();
    }

    public int dayToPosition(int i) {
        return firstPositionInMonth() + (i - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    public int getCount() {
        return firstPositionInMonth() + this.month.daysInMonth;
    }

    public long getItemId(int i) {
        return (long) (i / this.month.daysInWeek);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            r8 = this;
            android.content.Context r0 = r11.getContext()
            com.google.android.material.datepicker.CalendarStyle r1 = r8.calendarStyle
            if (r1 != 0) goto L_0x000f
            com.google.android.material.datepicker.CalendarStyle r1 = new com.google.android.material.datepicker.CalendarStyle
            r1.<init>(r0)
            r8.calendarStyle = r1
        L_0x000f:
            r0 = r10
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r10 != 0) goto L_0x0026
            android.content.Context r10 = r11.getContext()
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r10)
            int r0 = com.google.android.material.R$layout.mtrl_calendar_day
            android.view.View r10 = r10.inflate(r0, r11, r1)
            r0 = r10
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0026:
            int r10 = r8.firstPositionInMonth()
            int r10 = r9 - r10
            if (r10 < 0) goto L_0x00df
            com.google.android.material.datepicker.Month r11 = r8.month
            int r2 = r11.daysInMonth
            if (r10 < r2) goto L_0x0036
            goto L_0x00df
        L_0x0036:
            r2 = 1
            int r10 = r10 + r2
            r0.setTag(r11)
            android.content.res.Resources r11 = r0.getResources()
            android.content.res.Configuration r11 = r11.getConfiguration()
            java.util.Locale r11 = r11.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r11 = java.lang.String.format(r11, r4, r3)
            r0.setText(r11)
            com.google.android.material.datepicker.Month r11 = r8.month
            java.util.Calendar r11 = r11.firstOfMonth
            java.util.Calendar r11 = com.google.android.material.datepicker.UtcDates.getDayCopy(r11)
            r3 = 5
            r11.set(r3, r10)
            long r10 = r11.getTimeInMillis()
            com.google.android.material.datepicker.Month r4 = r8.month
            int r4 = r4.year
            java.util.Calendar r5 = com.google.android.material.datepicker.UtcDates.getTodayCalendar()
            r5.set(r3, r2)
            java.util.Calendar r5 = com.google.android.material.datepicker.UtcDates.getDayCopy(r5)
            r6 = 2
            r5.get(r6)
            int r6 = r5.get(r2)
            r7 = 7
            r5.getMaximum(r7)
            r5.getActualMaximum(r3)
            r5.getTimeInMillis()
            r3 = 24
            if (r4 != r6) goto L_0x00b2
            java.util.Locale r4 = java.util.Locale.getDefault()
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r3) goto L_0x00a1
            android.icu.text.DateFormat r3 = com.google.android.material.datepicker.UtcDates.getAbbrMonthWeekdayDayFormat(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r10)
            java.lang.String r10 = r3.format(r4)
            goto L_0x00ae
        L_0x00a1:
            java.text.DateFormat r3 = com.google.android.material.datepicker.UtcDates.getFullFormat(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r10)
            java.lang.String r10 = r3.format(r4)
        L_0x00ae:
            r0.setContentDescription(r10)
            goto L_0x00d8
        L_0x00b2:
            java.util.Locale r4 = java.util.Locale.getDefault()
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r3) goto L_0x00c8
            android.icu.text.DateFormat r3 = com.google.android.material.datepicker.UtcDates.getYearAbbrMonthWeekdayDayFormat(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r10)
            java.lang.String r10 = r3.format(r4)
            goto L_0x00d5
        L_0x00c8:
            java.text.DateFormat r3 = com.google.android.material.datepicker.UtcDates.getFullFormat(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r10)
            java.lang.String r10 = r3.format(r4)
        L_0x00d5:
            r0.setContentDescription(r10)
        L_0x00d8:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L_0x00e7
        L_0x00df:
            r10 = 8
            r0.setVisibility(r10)
            r0.setEnabled(r1)
        L_0x00e7:
            java.lang.Long r9 = r8.getItem(r9)
            if (r9 != 0) goto L_0x00ee
            goto L_0x00f5
        L_0x00ee:
            long r9 = r9.longValue()
            r8.updateSelectedState(r0, r9)
        L_0x00f5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public boolean hasStableIds() {
        return true;
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public final void updateSelectedState(TextView textView, long j) {
        CalendarItemStyle calendarItemStyle;
        if (textView != null) {
            boolean z = false;
            if (this.calendarConstraints.validator.isValid(j)) {
                textView.setEnabled(true);
                Iterator<Long> it = this.dateSelector.getSelectedDays().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (UtcDates.canonicalYearMonthDay(j) == UtcDates.canonicalYearMonthDay(it.next().longValue())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    calendarItemStyle = this.calendarStyle.selectedDay;
                } else if (UtcDates.getTodayCalendar().getTimeInMillis() == j) {
                    calendarItemStyle = this.calendarStyle.todayDay;
                } else {
                    calendarItemStyle = this.calendarStyle.day;
                }
            } else {
                textView.setEnabled(false);
                calendarItemStyle = this.calendarStyle.invalidDay;
            }
            calendarItemStyle.styleItem(textView);
        }
    }

    public final void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (Month.create(j).equals(this.month)) {
            Calendar dayCopy = UtcDates.getDayCopy(this.month.firstOfMonth);
            dayCopy.setTimeInMillis(j);
            updateSelectedState((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().dayToPosition(dayCopy.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    public Long getItem(int i) {
        if (i < this.month.daysFromStartOfWeekToFirstOfMonth() || i > lastPositionInMonth()) {
            return null;
        }
        Month month2 = this.month;
        Calendar dayCopy = UtcDates.getDayCopy(month2.firstOfMonth);
        dayCopy.set(5, (i - month2.daysFromStartOfWeekToFirstOfMonth()) + 1);
        return Long.valueOf(dayCopy.getTimeInMillis());
    }
}
