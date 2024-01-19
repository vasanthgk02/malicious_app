package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.MaterialCalendar.CalendarSelector;
import java.util.Calendar;
import java.util.Locale;

public class YearGridAdapter extends Adapter<ViewHolder> {
    public final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar2) {
        this.materialCalendar = materialCalendar2;
    }

    public int getItemCount() {
        return this.materialCalendar.calendarConstraints.yearSpan;
    }

    public int getPositionForYear(int i) {
        return i - this.materialCalendar.calendarConstraints.start.year;
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        final int i2 = this.materialCalendar.calendarConstraints.start.year + i;
        String string = viewHolder2.textView.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        viewHolder2.textView.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i2)}));
        viewHolder2.textView.setContentDescription(String.format(string, new Object[]{Integer.valueOf(i2)}));
        CalendarStyle calendarStyle = this.materialCalendar.calendarStyle;
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        CalendarItemStyle calendarItemStyle = todayCalendar.get(1) == i2 ? calendarStyle.todayYear : calendarStyle.year;
        for (Long longValue : this.materialCalendar.dateSelector.getSelectedDays()) {
            todayCalendar.setTimeInMillis(longValue.longValue());
            if (todayCalendar.get(1) == i2) {
                calendarItemStyle = calendarStyle.selectedYear;
            }
        }
        calendarItemStyle.styleItem(viewHolder2.textView);
        viewHolder2.textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Month create = Month.create(i2, YearGridAdapter.this.materialCalendar.current.month);
                CalendarConstraints calendarConstraints = YearGridAdapter.this.materialCalendar.calendarConstraints;
                if (create.compareTo(calendarConstraints.start) < 0) {
                    create = calendarConstraints.start;
                } else if (create.compareTo(calendarConstraints.end) > 0) {
                    create = calendarConstraints.end;
                }
                YearGridAdapter.this.materialCalendar.setCurrentMonth(create);
                YearGridAdapter.this.materialCalendar.setSelector(CalendarSelector.DAY);
            }
        });
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
