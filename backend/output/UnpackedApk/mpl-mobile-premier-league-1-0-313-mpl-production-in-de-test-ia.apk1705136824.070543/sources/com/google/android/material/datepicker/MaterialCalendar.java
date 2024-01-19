package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.State;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

public final class MaterialCalendar<S> extends PickerFragment<S> {
    public static final Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
    public static final Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
    public static final Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
    public static final Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";
    public CalendarConstraints calendarConstraints;
    public CalendarSelector calendarSelector;
    public CalendarStyle calendarStyle;
    public Month current;
    public DateSelector<S> dateSelector;
    public View dayFrame;
    public RecyclerView recyclerView;
    public int themeResId;
    public View yearFrame;
    public RecyclerView yearSelector;

    public enum CalendarSelector {
        DAY,
        YEAR
    }

    public interface OnDayClickListener {
    }

    public static int getDayHeight(Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    public LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt("THEME_RES_ID_KEY");
        this.dateSelector = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.current = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final int i;
        int i2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.calendarConstraints.start;
        if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            i2 = R$layout.mtrl_calendar_vertical;
            i = 1;
        } else {
            i2 = R$layout.mtrl_calendar_horizontal;
            i = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                accessibilityNodeInfoCompat.setCollectionInfo(null);
            }
        });
        gridView.setAdapter(new DaysOfWeekAdapter());
        gridView.setNumColumns(month.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        AnonymousClass2 r4 = new SmoothCalendarLayoutManager(getContext(), i, false) {
            public void calculateExtraLayoutSpace(State state, int[] iArr) {
                if (i == 0) {
                    iArr[0] = MaterialCalendar.this.recyclerView.getWidth();
                    iArr[1] = MaterialCalendar.this.recyclerView.getWidth();
                    return;
                }
                iArr[0] = MaterialCalendar.this.recyclerView.getHeight();
                iArr[1] = MaterialCalendar.this.recyclerView.getHeight();
            }
        };
        this.recyclerView.setLayoutManager(r4);
        this.recyclerView.setTag("MONTHS_VIEW_GROUP_TAG");
        final MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new OnDayClickListener() {
        });
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView2;
        if (recyclerView2 != null) {
            recyclerView2.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            this.yearSelector.addItemDecoration(new ItemDecoration() {
                public final Calendar endItem = UtcDates.getUtcCalendar();
                public final Calendar startItem = UtcDates.getUtcCalendar();

                public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
                    int i;
                    int i2;
                    if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                        YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                        for (Pair next : MaterialCalendar.this.dateSelector.getSelectedRanges()) {
                            F f2 = next.first;
                            if (!(f2 == null || next.second == null)) {
                                this.startItem.setTimeInMillis(((Long) f2).longValue());
                                this.endItem.setTimeInMillis(((Long) next.second).longValue());
                                int positionForYear = yearGridAdapter.getPositionForYear(this.startItem.get(1));
                                int positionForYear2 = yearGridAdapter.getPositionForYear(this.endItem.get(1));
                                View findViewByPosition = gridLayoutManager.findViewByPosition(positionForYear);
                                View findViewByPosition2 = gridLayoutManager.findViewByPosition(positionForYear2);
                                int i3 = gridLayoutManager.mSpanCount;
                                int i4 = positionForYear / i3;
                                int i5 = positionForYear2 / i3;
                                for (int i6 = i4; i6 <= i5; i6++) {
                                    View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.mSpanCount * i6);
                                    if (findViewByPosition3 != null) {
                                        int top = findViewByPosition3.getTop() + MaterialCalendar.this.calendarStyle.year.insets.top;
                                        int bottom = findViewByPosition3.getBottom() - MaterialCalendar.this.calendarStyle.year.insets.bottom;
                                        if (i6 == i4) {
                                            i = (findViewByPosition.getWidth() / 2) + findViewByPosition.getLeft();
                                        } else {
                                            i = 0;
                                        }
                                        if (i6 == i5) {
                                            i2 = (findViewByPosition2.getWidth() / 2) + findViewByPosition2.getLeft();
                                        } else {
                                            i2 = recyclerView.getWidth();
                                        }
                                        canvas.drawRect((float) i, (float) top, (float) i2, (float) bottom, MaterialCalendar.this.calendarStyle.rangeFill);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
        if (inflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            final MaterialButton materialButton = (MaterialButton) inflate.findViewById(R$id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    String str;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    if (MaterialCalendar.this.dayFrame.getVisibility() == 0) {
                        str = MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_year_selection);
                    } else {
                        str = MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_day_selection);
                    }
                    accessibilityNodeInfoCompat.setHintText(str);
                }
            });
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.yearFrame = inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
            this.dayFrame = inflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            setSelector(CalendarSelector.DAY);
            materialButton.setText(this.current.getLongName(inflate.getContext()));
            this.recyclerView.addOnScrollListener(new OnScrollListener() {
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    if (i == 0) {
                        recyclerView.announceForAccessibility(materialButton.getText());
                    }
                }

                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    int i3;
                    if (i < 0) {
                        i3 = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition();
                    } else {
                        i3 = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
                    }
                    MaterialCalendar.this.current = monthsPagerAdapter.getPageMonth(i3);
                    MaterialButton materialButton = materialButton;
                    MonthsPagerAdapter monthsPagerAdapter = monthsPagerAdapter;
                    materialButton.setText(monthsPagerAdapter.calendarConstraints.start.monthsLater(i3).getLongName(monthsPagerAdapter.context));
                }
            });
            materialButton.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    CalendarSelector calendarSelector = materialCalendar.calendarSelector;
                    if (calendarSelector == CalendarSelector.YEAR) {
                        materialCalendar.setSelector(CalendarSelector.DAY);
                    } else if (calendarSelector == CalendarSelector.DAY) {
                        materialCalendar.setSelector(CalendarSelector.YEAR);
                    }
                }
            });
            materialButton3.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int findFirstVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() + 1;
                    if (findFirstVisibleItemPosition < MaterialCalendar.this.recyclerView.getAdapter().getItemCount()) {
                        MaterialCalendar.this.setCurrentMonth(monthsPagerAdapter.getPageMonth(findFirstVisibleItemPosition));
                    }
                }
            });
            materialButton2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    int findLastVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition() - 1;
                    if (findLastVisibleItemPosition >= 0) {
                        MaterialCalendar.this.setCurrentMonth(monthsPagerAdapter.getPageMonth(findLastVisibleItemPosition));
                    }
                }
            });
        }
        if (!MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.getPosition(this.current));
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.themeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.current);
    }

    public final void postSmoothRecyclerViewScroll(final int i) {
        this.recyclerView.post(new Runnable() {
            public void run() {
                MaterialCalendar.this.recyclerView.smoothScrollToPosition(i);
            }
        });
    }

    public void setCurrentMonth(Month month) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int monthsUntil = monthsPagerAdapter.calendarConstraints.start.monthsUntil(month);
        int position = monthsUntil - monthsPagerAdapter.getPosition(this.current);
        boolean z = true;
        boolean z2 = Math.abs(position) > 3;
        if (position <= 0) {
            z = false;
        }
        this.current = month;
        if (z2 && z) {
            this.recyclerView.scrollToPosition(monthsUntil - 3);
            postSmoothRecyclerViewScroll(monthsUntil);
        } else if (z2) {
            this.recyclerView.scrollToPosition(monthsUntil + 3);
            postSmoothRecyclerViewScroll(monthsUntil);
        } else {
            postSmoothRecyclerViewScroll(monthsUntil);
        }
    }

    public void setSelector(CalendarSelector calendarSelector2) {
        this.calendarSelector = calendarSelector2;
        if (calendarSelector2 == CalendarSelector.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
        } else if (calendarSelector2 == CalendarSelector.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }
}
