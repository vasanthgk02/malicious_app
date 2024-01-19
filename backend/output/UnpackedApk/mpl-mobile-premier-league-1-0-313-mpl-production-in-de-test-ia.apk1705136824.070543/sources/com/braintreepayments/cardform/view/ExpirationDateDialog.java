package com.braintreepayments.cardform.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.cardform.R$id;
import com.braintreepayments.cardform.R$layout;
import com.braintreepayments.cardform.R$style;
import com.braintreepayments.cardform.utils.ExpirationDateDialogTheme;
import com.braintreepayments.cardform.utils.ExpirationDateItemAdapter;
import com.paynimo.android.payment.util.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class ExpirationDateDialog extends Dialog implements OnShowListener {
    public static final List<String> MONTHS = Arrays.asList(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", Constant.BANKCODE_ICICI, "11", "12"});
    public final int CURRENT_MONTH = (Calendar.getInstance().get(2) + 1);
    public final int CURRENT_YEAR = Calendar.getInstance().get(1);
    public int mAnimationDelay;
    public ExpirationDateEditText mEditText;
    public boolean mHasSelectedMonth;
    public boolean mHasSelectedYear;
    public int mSelectedMonth = -1;
    public int mSelectedYear = -1;
    public ExpirationDateDialogTheme mTheme;
    public GridView mYearGridView;
    public final List<String> mYears = new ArrayList();

    public ExpirationDateDialog(Context context, int i) {
        super(context, i);
    }

    public static void access$200(ExpirationDateDialog expirationDateDialog) {
        String str;
        String str2;
        int i = expirationDateDialog.mSelectedMonth;
        if (i == -1) {
            str = "  ";
        } else {
            str = MONTHS.get(i);
        }
        if (expirationDateDialog.mSelectedYear == -1) {
            str2 = GeneratedOutlineSupport.outline50(str, "    ");
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append(expirationDateDialog.mYears.get(expirationDateDialog.mSelectedYear));
            str2 = outline73.toString();
        }
        expirationDateDialog.mEditText.setText(str2);
        if (expirationDateDialog.mHasSelectedMonth && expirationDateDialog.mHasSelectedYear) {
            final View focusNextView = expirationDateDialog.mEditText.focusNextView();
            if (focusNextView != null) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        ((InputMethodManager) ExpirationDateDialog.this.getContext().getSystemService("input_method")).showSoftInput(focusNextView, 0);
                    }
                }, (long) expirationDateDialog.mAnimationDelay);
            }
        }
    }

    public static ExpirationDateDialog create(Activity activity, ExpirationDateEditText expirationDateEditText) {
        ExpirationDateDialog expirationDateDialog;
        ExpirationDateDialogTheme detectTheme = ExpirationDateDialogTheme.detectTheme(activity);
        if (detectTheme == ExpirationDateDialogTheme.LIGHT) {
            expirationDateDialog = new ExpirationDateDialog(activity, R$style.bt_expiration_date_dialog_light);
        } else {
            expirationDateDialog = new ExpirationDateDialog(activity, R$style.bt_expiration_date_dialog_dark);
        }
        expirationDateDialog.setOwnerActivity(activity);
        expirationDateDialog.mTheme = detectTheme;
        expirationDateDialog.mEditText = expirationDateEditText;
        return expirationDateDialog;
    }

    public final View findViewAt(ViewGroup viewGroup, int i, int i2) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof ViewGroup) {
                View findViewAt = findViewAt((ViewGroup) childAt, i, i2);
                if (findViewAt != null && findViewAt.isShown()) {
                    return findViewAt;
                }
            } else {
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                if (new Rect(iArr[0], iArr[1], childAt.getWidth() + iArr[0], childAt.getHeight() + iArr[1]).contains(i, i2)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.bt_expiration_date_sheet);
        this.mAnimationDelay = getContext().getResources().getInteger(17694720);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setOnShowListener(this);
        for (int i = 0; i < 20; i++) {
            this.mYears.add(Integer.toString(this.CURRENT_YEAR + i));
        }
        final ExpirationDateItemAdapter expirationDateItemAdapter = new ExpirationDateItemAdapter(getContext(), this.mTheme, MONTHS);
        final ExpirationDateItemAdapter expirationDateItemAdapter2 = new ExpirationDateItemAdapter(getContext(), this.mTheme, this.mYears);
        ((GridView) findViewById(R$id.bt_expiration_month_grid_view)).setAdapter(expirationDateItemAdapter);
        expirationDateItemAdapter.mOnItemClickListener = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ExpirationDateDialog expirationDateDialog = ExpirationDateDialog.this;
                expirationDateDialog.mHasSelectedMonth = true;
                expirationDateDialog.mSelectedMonth = i;
                ExpirationDateDialog.access$200(expirationDateDialog);
                if (Integer.parseInt(ExpirationDateDialog.MONTHS.get(i)) < ExpirationDateDialog.this.CURRENT_MONTH) {
                    ExpirationDateItemAdapter expirationDateItemAdapter = expirationDateItemAdapter2;
                    expirationDateItemAdapter.mDisabledPositions = Collections.singletonList(Integer.valueOf(0));
                    expirationDateItemAdapter.notifyDataSetChanged();
                    return;
                }
                ExpirationDateItemAdapter expirationDateItemAdapter2 = expirationDateItemAdapter2;
                expirationDateItemAdapter2.mDisabledPositions = new ArrayList();
                expirationDateItemAdapter2.notifyDataSetChanged();
            }
        };
        GridView gridView = (GridView) findViewById(R$id.bt_expiration_year_grid_view);
        this.mYearGridView = gridView;
        gridView.setAdapter(expirationDateItemAdapter2);
        expirationDateItemAdapter2.mOnItemClickListener = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ExpirationDateDialog expirationDateDialog = ExpirationDateDialog.this;
                expirationDateDialog.mHasSelectedYear = true;
                expirationDateDialog.mSelectedYear = i;
                ExpirationDateDialog.access$200(expirationDateDialog);
                if (Integer.parseInt(ExpirationDateDialog.this.mYears.get(i)) == ExpirationDateDialog.this.CURRENT_YEAR) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < ExpirationDateDialog.MONTHS.size(); i2++) {
                        if (Integer.parseInt(ExpirationDateDialog.MONTHS.get(i2)) < ExpirationDateDialog.this.CURRENT_MONTH) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    ExpirationDateItemAdapter expirationDateItemAdapter = expirationDateItemAdapter;
                    expirationDateItemAdapter.mDisabledPositions = arrayList;
                    expirationDateItemAdapter.notifyDataSetChanged();
                    return;
                }
                ExpirationDateItemAdapter expirationDateItemAdapter2 = expirationDateItemAdapter;
                expirationDateItemAdapter2.mDisabledPositions = new ArrayList();
                expirationDateItemAdapter2.notifyDataSetChanged();
            }
        };
        int indexOf = MONTHS.indexOf(this.mEditText.getMonth());
        this.mSelectedMonth = indexOf;
        if (indexOf >= 0) {
            expirationDateItemAdapter.mSelectedPosition = indexOf;
            expirationDateItemAdapter.notifyDataSetChanged();
        }
        int indexOf2 = this.mYears.indexOf(this.mEditText.getYear());
        this.mSelectedYear = indexOf2;
        if (indexOf2 >= 0) {
            expirationDateItemAdapter2.mSelectedPosition = indexOf2;
            expirationDateItemAdapter2.notifyDataSetChanged();
        }
    }

    public void onShow(DialogInterface dialogInterface) {
        int i = this.mSelectedYear;
        if (i > 0) {
            this.mYearGridView.smoothScrollToPosition(i);
        }
        this.mHasSelectedMonth = false;
        this.mHasSelectedYear = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int scaledWindowTouchSlop = ViewConfiguration.get(getContext()).getScaledWindowTouchSlop();
            View decorView = getWindow().getDecorView();
            int i = -scaledWindowTouchSlop;
            if ((x < i || y < i || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop) && getWindow().peekDecorView() != null) {
                z = true;
                if (isShowing() || !z) {
                    return false;
                }
                View rootView = getOwnerActivity().getWindow().getDecorView().getRootView();
                final View findViewAt = rootView instanceof ViewGroup ? findViewAt((ViewGroup) rootView, (int) motionEvent.getRawX(), (int) motionEvent.getRawY()) : null;
                if (findViewAt != null && findViewAt != this.mEditText) {
                    dismiss();
                    if (findViewAt instanceof EditText) {
                        findViewAt.requestFocus();
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                ((InputMethodManager) ExpirationDateDialog.this.getContext().getSystemService("input_method")).showSoftInput(findViewAt, 0);
                            }
                        }, (long) this.mAnimationDelay);
                    } else if (findViewAt instanceof Button) {
                        findViewAt.callOnClick();
                    }
                } else if (findViewAt == null) {
                    dismiss();
                }
                return true;
            }
        }
        z = false;
        if (isShowing()) {
        }
        return false;
    }

    public void show() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Activity ownerActivity = ExpirationDateDialog.this.getOwnerActivity();
                if (ExpirationDateDialog.this.mEditText.isFocused() && ownerActivity != null && !ownerActivity.isFinishing()) {
                    ExpirationDateDialog.super.show();
                }
            }
        }, (long) this.mAnimationDelay);
    }
}
