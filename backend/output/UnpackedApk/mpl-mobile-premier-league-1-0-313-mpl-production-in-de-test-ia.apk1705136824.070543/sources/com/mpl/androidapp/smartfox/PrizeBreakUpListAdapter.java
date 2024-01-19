package com.mpl.androidapp.smartfox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.MLogger;
import java.util.ArrayList;
import java.util.List;

public class PrizeBreakUpListAdapter extends Adapter<PrizeBreakUpViewHolder> {
    public static final String TAG = "PlayerListAdapter";
    public int lastPosition = -1;
    public final Context mContext;
    public List<Double> mPrizeList;

    public static class PrizeBreakUpViewHolder extends ViewHolder {
        public final TextView mRankAmount;
        public final TextView mRankPosition;

        public PrizeBreakUpViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            this.mRankPosition = (TextView) linearLayout.findViewById(R.id.rankPosition);
            this.mRankAmount = (TextView) linearLayout.findViewById(R.id.rankAmount);
        }
    }

    public PrizeBreakUpListAdapter(Context context, List<Double> list) {
        this.mPrizeList = list;
        this.mContext = context;
    }

    private Double getAmount(int i) {
        List<Double> list = this.mPrizeList;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.mPrizeList.get(i);
    }

    public void addPlayer(Double d2) {
        this.mPrizeList.add(d2);
        notifyDataSetChanged();
    }

    public boolean containsItem(Double d2) {
        return this.mPrizeList.contains(d2);
    }

    public int getItemCount() {
        List<Double> list = this.mPrizeList;
        int size = list != null ? list.size() : 0;
        MLogger.d("PlayerListAdapter", "getItemCount: ", Integer.valueOf(size));
        return size;
    }

    public void removePlayer(Double d2) {
        this.mPrizeList.remove(d2);
        notifyDataSetChanged();
    }

    public void swapItems(ArrayList<Double> arrayList) {
        this.mPrizeList = arrayList;
        MLogger.d("PlayerListAdapter", "swapItems: ", Integer.valueOf(arrayList.size()));
        notifyDataSetChanged();
    }

    public void onBindViewHolder(PrizeBreakUpViewHolder prizeBreakUpViewHolder, int i) {
        Double amount = getAmount(i);
        if (amount != null) {
            TextView textView = prizeBreakUpViewHolder.mRankAmount;
            textView.setText("" + amount);
            TextView textView2 = prizeBreakUpViewHolder.mRankPosition;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Rank ");
            outline73.append(i + 2);
            textView2.setText(outline73.toString());
        }
    }

    public PrizeBreakUpViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PrizeBreakUpViewHolder((LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rank_amount_layout, viewGroup, false));
    }
}
