package com.braintreepayments.cardform.utils;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.cardform.R$dimen;
import com.braintreepayments.cardform.R$layout;
import java.util.ArrayList;
import java.util.List;

public class ExpirationDateItemAdapter extends ArrayAdapter<String> {
    public List<Integer> mDisabledPositions = new ArrayList();
    public OnItemClickListener mOnItemClickListener;
    public ShapeDrawable mSelectedItemBackground;
    public int mSelectedPosition = -1;
    public ExpirationDateDialogTheme mTheme;

    public ExpirationDateItemAdapter(Context context, ExpirationDateDialogTheme expirationDateDialogTheme, List<String> list) {
        super(context, R$layout.bt_expiration_date_item, list);
        this.mTheme = expirationDateDialogTheme;
        float dimension = context.getResources().getDimension(R$dimen.bt_expiration_date_item_selected_background_radius);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dimension, dimension, dimension, dimension, dimension, dimension, dimension, dimension}, null, null));
        this.mSelectedItemBackground = shapeDrawable;
        shapeDrawable.getPaint().setColor(this.mTheme.getSelectedItemBackground());
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getView(i, view, viewGroup);
        textView.setEnabled(true);
        if (this.mSelectedPosition == i) {
            textView.setBackgroundDrawable(this.mSelectedItemBackground);
            textView.setTextColor(this.mTheme.getItemInvertedTextColor());
        } else {
            textView.setBackgroundResource(17170445);
            if (this.mDisabledPositions.contains(Integer.valueOf(i))) {
                textView.setTextColor(this.mTheme.getItemDisabledTextColor());
                textView.setEnabled(false);
            } else {
                textView.setTextColor(this.mTheme.getItemTextColor());
            }
        }
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ExpirationDateItemAdapter expirationDateItemAdapter = ExpirationDateItemAdapter.this;
                expirationDateItemAdapter.mSelectedPosition = i;
                expirationDateItemAdapter.notifyDataSetChanged();
                k.vibrate(ExpirationDateItemAdapter.this.getContext(), 10);
                OnItemClickListener onItemClickListener = ExpirationDateItemAdapter.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    int i = i;
                    onItemClickListener.onItemClick(null, view, i, (long) i);
                }
            }
        });
        return textView;
    }
}
