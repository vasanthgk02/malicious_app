package com.freshchat.consumer.sdk.a.a;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.service.Status;

public class b extends ViewHolder {
    public final TextView qV;

    public b(View view) {
        super(view);
        this.qV = (TextView) view;
    }

    public void a(Status status, e eVar) {
        TextView textView;
        int i;
        if (status == Status.NO_INTERNET) {
            textView = this.qV;
            i = R.string.freshchat_pagination_no_internet_with_retry;
        } else {
            textView = this.qV;
            i = R.string.freshchat_pagination_error_with_retry;
        }
        textView.setText(i);
        this.qV.setOnClickListener(new c(this, eVar));
    }
}
