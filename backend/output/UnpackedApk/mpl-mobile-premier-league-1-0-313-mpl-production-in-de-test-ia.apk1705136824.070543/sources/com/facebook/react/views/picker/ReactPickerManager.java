package com.facebook.react.views.picker;

import android.content.res.ColorStateList;
import android.widget.SpinnerAdapter;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.picker.ReactPicker.OnSelectListener;
import java.util.ArrayList;
import java.util.List;

public abstract class ReactPickerManager extends SimpleViewManager<ReactPicker> {

    public static class PickerEventEmitter implements OnSelectListener {
        public final EventDispatcher mEventDispatcher;
        public final ReactPicker mReactPicker;

        public PickerEventEmitter(ReactPicker reactPicker, EventDispatcher eventDispatcher) {
            this.mReactPicker = reactPicker;
            this.mEventDispatcher = eventDispatcher;
        }
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactPicker reactPicker, Integer num) {
        reactPicker.setStagedPrimaryTextColor(num);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactPicker reactPicker, boolean z) {
        reactPicker.setEnabled(z);
    }

    @ReactProp(name = "items")
    public void setItems(ReactPicker reactPicker, ReadableArray readableArray) {
        ArrayList arrayList;
        if (readableArray == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(readableArray.size());
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList2.add(new ReactPickerItem(readableArray.getMap(i)));
            }
            arrayList = arrayList2;
        }
        reactPicker.setStagedItems(arrayList);
    }

    @ReactProp(name = "prompt")
    public void setPrompt(ReactPicker reactPicker, String str) {
        reactPicker.setPrompt(str);
    }

    @ReactProp(name = "selected")
    public void setSelected(ReactPicker reactPicker, int i) {
        reactPicker.setStagedSelection(i);
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, ReactPicker reactPicker) {
        reactPicker.setOnSelectListener(new PickerEventEmitter(reactPicker, ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
    }

    public void onAfterUpdateTransaction(ReactPicker reactPicker) {
        super.onAfterUpdateTransaction(reactPicker);
        reactPicker.setOnItemSelectedListener(null);
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        int selectedItemPosition = reactPicker.getSelectedItemPosition();
        List<ReactPickerItem> list = reactPicker.mStagedItems;
        if (!(list == null || list == reactPicker.mItems)) {
            reactPicker.mItems = list;
            reactPicker.mStagedItems = null;
            if (reactPickerAdapter == null) {
                reactPickerAdapter = new ReactPickerAdapter(reactPicker.getContext(), reactPicker.mItems);
                reactPicker.setAdapter((SpinnerAdapter) reactPickerAdapter);
            } else {
                reactPickerAdapter.clear();
                reactPickerAdapter.addAll(reactPicker.mItems);
                reactPickerAdapter.notifyDataSetChanged();
            }
        }
        Integer num = reactPicker.mStagedSelection;
        if (!(num == null || num.intValue() == selectedItemPosition)) {
            reactPicker.setSelection(reactPicker.mStagedSelection.intValue(), false);
            reactPicker.mStagedSelection = null;
        }
        Integer num2 = reactPicker.mStagedPrimaryTextColor;
        if (!(num2 == null || reactPickerAdapter == null || num2 == reactPickerAdapter.mPrimaryTextColor)) {
            reactPickerAdapter.mPrimaryTextColor = num2;
            reactPickerAdapter.notifyDataSetChanged();
            ViewCompat.setBackgroundTintList(reactPicker, ColorStateList.valueOf(reactPicker.mStagedPrimaryTextColor.intValue()));
            reactPicker.mStagedPrimaryTextColor = null;
        }
        Integer num3 = reactPicker.mStagedBackgroundColor;
        if (!(num3 == null || reactPickerAdapter == null || num3 == reactPickerAdapter.mBackgroundColor)) {
            reactPickerAdapter.mBackgroundColor = num3;
            reactPickerAdapter.notifyDataSetChanged();
            reactPicker.mStagedBackgroundColor = null;
        }
        reactPicker.setOnItemSelectedListener(reactPicker.mItemSelectedListener);
    }

    public void receiveCommand(ReactPicker reactPicker, String str, ReadableArray readableArray) {
        if (((str.hashCode() == -729039331 && str.equals("setNativeSelectedPosition")) ? (char) 0 : 65535) == 0 && readableArray != null) {
            reactPicker.setImmediateSelection(readableArray.getInt(0));
        }
    }
}
