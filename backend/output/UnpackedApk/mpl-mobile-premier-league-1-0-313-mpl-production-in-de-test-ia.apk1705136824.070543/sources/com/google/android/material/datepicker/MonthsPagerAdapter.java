package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar.AnonymousClass3;
import com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener;
import java.util.Iterator;

public class MonthsPagerAdapter extends Adapter<ViewHolder> {
    public final CalendarConstraints calendarConstraints;
    public final Context context;
    public final DateSelector<?> dateSelector;
    public final int itemHeight;
    public final OnDayClickListener onDayClickListener;

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final MaterialCalendarGridView monthGrid;
        public final TextView monthTitle;

        public ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.monthTitle = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (!z) {
                this.monthTitle.setVisibility(8);
            }
        }
    }

    public MonthsPagerAdapter(Context context2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2, OnDayClickListener onDayClickListener2) {
        Month month = calendarConstraints2.start;
        Month month2 = calendarConstraints2.end;
        Month month3 = calendarConstraints2.openAt;
        if (month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (month3.compareTo(month2) <= 0) {
            int dayHeight = MaterialCalendar.getDayHeight(context2) * MonthAdapter.MAXIMUM_WEEKS;
            int dimensionPixelSize = MaterialDatePicker.isFullscreen(context2) ? context2.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) : 0;
            this.context = context2;
            this.itemHeight = dayHeight + dimensionPixelSize;
            this.calendarConstraints = calendarConstraints2;
            this.dateSelector = dateSelector2;
            this.onDayClickListener = onDayClickListener2;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public int getItemCount() {
        return this.calendarConstraints.monthSpan;
    }

    public long getItemId(int i) {
        return this.calendarConstraints.start.monthsLater(i).firstOfMonth.getTimeInMillis();
    }

    public Month getPageMonth(int i) {
        return this.calendarConstraints.start.monthsLater(i);
    }

    public int getPosition(Month month) {
        return this.calendarConstraints.start.monthsUntil(month);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Month monthsLater = this.calendarConstraints.start.monthsLater(i);
        viewHolder2.monthTitle.setText(monthsLater.getLongName(viewHolder2.itemView.getContext()));
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.monthGrid.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthsLater.equals(materialCalendarGridView.getAdapter().month)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            MonthAdapter adapter = materialCalendarGridView.getAdapter();
            for (Long longValue : adapter.previouslySelectedDates) {
                adapter.updateSelectedStateForDate(materialCalendarGridView, longValue.longValue());
            }
            DateSelector<?> dateSelector2 = adapter.dateSelector;
            if (dateSelector2 != null) {
                for (Long longValue2 : dateSelector2.getSelectedDays()) {
                    adapter.updateSelectedStateForDate(materialCalendarGridView, longValue2.longValue());
                }
                adapter.previouslySelectedDates = adapter.dateSelector.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MonthAdapter adapter = materialCalendarGridView.getAdapter();
                if (i >= adapter.firstPositionInMonth() && i <= adapter.lastPositionInMonth()) {
                    OnDayClickListener onDayClickListener = MonthsPagerAdapter.this.onDayClickListener;
                    long longValue = materialCalendarGridView.getAdapter().getItem(i).longValue();
                    AnonymousClass3 r1 = (AnonymousClass3) onDayClickListener;
                    if (MaterialCalendar.this.calendarConstraints.validator.isValid(longValue)) {
                        MaterialCalendar.this.dateSelector.select(longValue);
                        Iterator it = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                        while (it.hasNext()) {
                            ((OnSelectionChangedListener) it.next()).onSelectionChanged(MaterialCalendar.this.dateSelector.getSelection());
                        }
                        MaterialCalendar.this.recyclerView.getAdapter().notifyDataSetChanged();
                        RecyclerView recyclerView = MaterialCalendar.this.yearSelector;
                        if (recyclerView != null) {
                            recyclerView.getAdapter().notifyDataSetChanged();
                        }
                    }
                }
            }
        });
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new LayoutParams(-1, this.itemHeight));
        return new ViewHolder(linearLayout, true);
    }
}
