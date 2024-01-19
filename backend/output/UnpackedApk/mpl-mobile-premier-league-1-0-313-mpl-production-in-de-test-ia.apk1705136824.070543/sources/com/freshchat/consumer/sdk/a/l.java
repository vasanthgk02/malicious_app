package com.freshchat.consumer.sdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.CalendarDay.PartOfDay;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.k.m;
import com.freshchat.consumer.sdk.ui.NonScrollableGridView;
import com.freshchat.consumer.sdk.ui.f;
import java.util.Collection;
import java.util.List;

public class l extends Adapter<ViewHolder> implements f {
    public final List<b> oC;
    public final int oD = R.layout.freshchat_calendar_day_header;
    public int oE;
    public final com.freshchat.consumer.sdk.a.i.a ox;

    public static class a extends b {
        public static final Creator<a> CREATOR = new n();
        public final String oF;

        public a(Parcel parcel) {
            super(parcel);
            this.oF = parcel.readString();
        }

        public a(String str) {
            super(0);
            this.oF = str;
        }

        public int describeContents() {
            return 0;
        }

        public String hw() {
            return this.oF;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.b(parcel);
            parcel.writeString(this.oF);
        }
    }

    public static abstract class b implements Parcelable {
        public final int oG;

        public b(int i) {
            this.oG = i;
        }

        public b(Parcel parcel) {
            this.oG = parcel.readInt();
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.oG);
        }

        public int hx() {
            return this.oG;
        }
    }

    public static class c extends b {
        public static final Creator<c> CREATOR = new o();
        public final PartOfDay oH;
        public final List<TimeSlot> oI;

        public c(Parcel parcel) {
            super(parcel);
            this.oH = PartOfDay.values()[parcel.readInt()];
            this.oI = parcel.createTypedArrayList(TimeSlot.CREATOR);
        }

        public c(PartOfDay partOfDay, List<TimeSlot> list) {
            super(1);
            this.oH = partOfDay;
            this.oI = list;
        }

        public int describeContents() {
            return 0;
        }

        public PartOfDay hy() {
            return this.oH;
        }

        public List<TimeSlot> hz() {
            return this.oI;
        }

        public void writeToParcel(Parcel parcel, int i) {
            b(parcel);
            parcel.writeInt(this.oH.ordinal());
            parcel.writeTypedList(this.oI);
        }
    }

    public class d extends ViewHolder {
        public final TextView oJ;

        public d(View view) {
            super(view);
            this.oJ = (TextView) view;
        }

        /* access modifiers changed from: private */
        public void a(m mVar) {
            this.oJ.setText(mVar.ib());
        }
    }

    public class e extends ViewHolder {
        public final NonScrollableGridView oL;
        public final TextView oM;

        public e(View view) {
            super(view);
            this.oM = (TextView) view.findViewById(R.id.freshchat_calendar_part_of_day_header);
            this.oL = (NonScrollableGridView) view.findViewById(R.id.freshchat_calendar_timeslots_grid_view);
        }

        /* access modifiers changed from: private */
        public void a(m mVar) {
            this.oM.setText(mVar.ic());
            this.oL.setNumColumns(l.this.oE);
            this.oL.setAdapter(new i(mVar.id(), l.this.ox));
        }
    }

    public l(List<b> list, com.freshchat.consumer.sdk.a.i.a aVar) {
        this.ox = aVar;
        this.oC = list;
    }

    private b L(int i) {
        if (k.isEmpty(this.oC)) {
            return null;
        }
        return this.oC.get(i);
    }

    public void K(int i) {
        this.oE = i;
    }

    public int M(int i) {
        while (i > 0) {
            if (O(i)) {
                return i;
            }
            i--;
        }
        return 0;
    }

    public int N(int i) {
        return this.oD;
    }

    public boolean O(int i) {
        b bVar = this.oC.get(i);
        return bVar != null && bVar.hx() == 0;
    }

    public void c(View view, int i) {
        b L = L(i);
        if (L != null) {
            m mVar = new m(view.getContext());
            mVar.a(L);
            ((TextView) view).setText(mVar.ib());
        }
    }

    public int getItemCount() {
        return k.b((Collection<?>) this.oC);
    }

    public int getItemViewType(int i) {
        b bVar = this.oC.get(i);
        if (bVar != null) {
            return bVar.hx();
        }
        return 1;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        try {
            b L = L(i);
            if (L != null) {
                m mVar = new m(viewHolder.itemView.getContext());
                mVar.a(L);
                if (viewHolder instanceof d) {
                    ((d) viewHolder).a(mVar);
                } else if (viewHolder instanceof e) {
                    ((e) viewHolder).a(mVar);
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? new d(LayoutInflater.from(viewGroup.getContext()).inflate(this.oD, viewGroup, false)) : new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.freshchat_calendar_part_of_day_item, viewGroup, false));
    }
}
