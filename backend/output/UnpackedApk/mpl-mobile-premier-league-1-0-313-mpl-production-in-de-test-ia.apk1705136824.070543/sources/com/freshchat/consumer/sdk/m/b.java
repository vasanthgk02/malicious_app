package com.freshchat.consumer.sdk.m;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.i.a;
import com.freshchat.consumer.sdk.a.l;
import com.freshchat.consumer.sdk.ui.e;
import java.util.List;

public abstract class b extends a {
    public RecyclerView dR;
    public l oU;
    public int orientation;
    public a ox = new c(this);

    private void hF() {
        l lVar = this.oU;
        if (lVar != null) {
            lVar.K(hG());
            this.oU.notifyDataSetChanged();
        }
    }

    private int hG() {
        return getResources().getInteger(this.orientation == 1 ? R.integer.freshchat_calendar_timeslot_items_portrait : R.integer.freshchat_calendar_timeslot_items_landscape);
    }

    public void G(List<com.freshchat.consumer.sdk.a.l.b> list) {
        if (getContext() != null) {
            l lVar = new l(list, this.ox);
            this.oU = lVar;
            e eVar = new e(lVar);
            this.oU.K(hG());
            this.dR.addItemDecoration(eVar);
            this.dR.setLayoutManager(new LinearLayoutManager(getContext()));
            this.dR.setAdapter(this.oU);
        }
    }

    public abstract int getCalendarType();

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.orientation = configuration.orientation;
        hF();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.orientation = hD();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dR = (RecyclerView) view.findViewById(R.id.freshchat_all_timeslots_recycler_view);
    }
}
