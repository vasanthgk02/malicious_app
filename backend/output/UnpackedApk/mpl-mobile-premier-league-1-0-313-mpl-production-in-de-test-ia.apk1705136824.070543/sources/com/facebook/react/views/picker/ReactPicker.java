package com.facebook.react.views.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatSpinner;
import com.facebook.react.views.picker.ReactPickerManager.PickerEventEmitter;
import com.facebook.react.views.picker.events.PickerItemSelectEvent;
import java.util.List;

public class ReactPicker extends AppCompatSpinner {
    public final OnItemSelectedListener mItemSelectedListener = new OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            OnSelectListener onSelectListener = ReactPicker.this.mOnSelectListener;
            if (onSelectListener != null) {
                PickerEventEmitter pickerEventEmitter = (PickerEventEmitter) onSelectListener;
                pickerEventEmitter.mEventDispatcher.dispatchEvent(new PickerItemSelectEvent(pickerEventEmitter.mReactPicker.getId(), i));
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
            OnSelectListener onSelectListener = ReactPicker.this.mOnSelectListener;
            if (onSelectListener != null) {
                PickerEventEmitter pickerEventEmitter = (PickerEventEmitter) onSelectListener;
                pickerEventEmitter.mEventDispatcher.dispatchEvent(new PickerItemSelectEvent(pickerEventEmitter.mReactPicker.getId(), -1));
            }
        }
    };
    public List<ReactPickerItem> mItems;
    public int mMode = 0;
    public OnSelectListener mOnSelectListener;
    public Integer mStagedBackgroundColor;
    public List<ReactPickerItem> mStagedItems;
    public Integer mStagedPrimaryTextColor;
    public Integer mStagedSelection;
    public final Runnable measureAndLayout = new Runnable() {
        public void run() {
            ReactPicker reactPicker = ReactPicker.this;
            reactPicker.measure(MeasureSpec.makeMeasureSpec(reactPicker.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(ReactPicker.this.getHeight(), 1073741824));
            ReactPicker reactPicker2 = ReactPicker.this;
            reactPicker2.layout(reactPicker2.getLeft(), ReactPicker.this.getTop(), ReactPicker.this.getRight(), ReactPicker.this.getBottom());
        }
    };

    public interface OnSelectListener {
    }

    public ReactPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getMode() {
        return this.mMode;
    }

    public OnSelectListener getOnSelectListener() {
        return this.mOnSelectListener;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getOnItemSelectedListener() == null) {
            setOnItemSelectedListener(this.mItemSelectedListener);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    public void setImmediateSelection(int i) {
        if (i != getSelectedItemPosition()) {
            setOnItemSelectedListener(null);
            setSelection(i, false);
            setOnItemSelectedListener(this.mItemSelectedListener);
        }
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.mOnSelectListener = onSelectListener;
    }

    public void setStagedBackgroundColor(Integer num) {
        this.mStagedBackgroundColor = num;
    }

    public void setStagedItems(List<ReactPickerItem> list) {
        this.mStagedItems = list;
    }

    public void setStagedPrimaryTextColor(Integer num) {
        this.mStagedPrimaryTextColor = num;
    }

    public void setStagedSelection(int i) {
        this.mStagedSelection = Integer.valueOf(i);
    }

    public ReactPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ReactPicker(Context context, int i) {
        super(context, null, R$attr.spinnerStyle, i);
        this.mMode = i;
    }
}
