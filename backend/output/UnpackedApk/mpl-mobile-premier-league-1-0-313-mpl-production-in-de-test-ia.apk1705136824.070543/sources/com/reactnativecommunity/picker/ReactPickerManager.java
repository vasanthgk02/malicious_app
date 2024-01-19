package com.reactnativecommunity.picker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.app.NotificationCompatJellybean;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativecommunity.picker.ReactPicker.OnSelectListener;

public abstract class ReactPickerManager extends SimpleViewManager<ReactPicker> {

    public static class PickerEventEmitter implements OnSelectListener {
        public final EventDispatcher mEventDispatcher;
        public final ReactPicker mReactPicker;

        public PickerEventEmitter(ReactPicker reactPicker, EventDispatcher eventDispatcher) {
            this.mReactPicker = reactPicker;
            this.mEventDispatcher = eventDispatcher;
        }
    }

    public static class ReactPickerAdapter extends BaseAdapter {
        public final LayoutInflater mInflater;
        public ReadableArray mItems;
        public Integer mPrimaryTextColor;

        public ReactPickerAdapter(Context context, ReadableArray readableArray) {
            this.mItems = readableArray;
            Object systemService = context.getSystemService("layout_inflater");
            ImageOriginUtils.assertNotNull(systemService);
            this.mInflater = (LayoutInflater) systemService;
        }

        public int getCount() {
            ReadableArray readableArray = this.mItems;
            if (readableArray == null) {
                return 0;
            }
            return readableArray.size();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getView(i, view, viewGroup, true);
        }

        public Object getItem(int i) {
            ReadableArray readableArray = this.mItems;
            if (readableArray == null) {
                return null;
            }
            return readableArray.getMap(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup, boolean z) {
            ReadableMap readableMap;
            ReadableArray readableArray = this.mItems;
            if (readableArray == null) {
                readableMap = null;
            } else {
                readableMap = readableArray.getMap(i);
            }
            if (view == null) {
                view = this.mInflater.inflate(z ? 17367049 : 17367048, viewGroup, false);
            }
            TextView textView = (TextView) view;
            textView.setText(readableMap.getString(NotificationCompatJellybean.KEY_LABEL));
            if (!z) {
                Integer num = this.mPrimaryTextColor;
                if (num != null) {
                    textView.setTextColor(num.intValue());
                    return view;
                }
            }
            if (readableMap.hasKey("color") && !readableMap.isNull("color")) {
                textView.setTextColor(readableMap.getInt("color"));
            }
            return view;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getView(i, view, viewGroup, false);
        }
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactPicker reactPicker, Integer num) {
        reactPicker.setPrimaryColor(num);
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter != null) {
            reactPickerAdapter.mPrimaryTextColor = num;
            reactPickerAdapter.notifyDataSetChanged();
        }
    }

    @ReactProp(name = "dropdownIconColor")
    public void setDropdownIconColor(ReactPicker reactPicker, String str) {
        reactPicker.getBackground().setColorFilter(Color.parseColor(str), Mode.SRC_ATOP);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactPicker reactPicker, boolean z) {
        reactPicker.setEnabled(z);
    }

    @ReactProp(name = "items")
    public void setItems(ReactPicker reactPicker, ReadableArray readableArray) {
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter == null) {
            ReactPickerAdapter reactPickerAdapter2 = new ReactPickerAdapter(reactPicker.getContext(), readableArray);
            reactPickerAdapter2.mPrimaryTextColor = reactPicker.getPrimaryColor();
            reactPickerAdapter2.notifyDataSetChanged();
            reactPicker.setAdapter((SpinnerAdapter) reactPickerAdapter2);
            return;
        }
        reactPickerAdapter.mItems = readableArray;
        reactPickerAdapter.notifyDataSetChanged();
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
        reactPicker.updateStagedSelection();
    }
}
