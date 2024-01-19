package com.mpl.androidapp.react;

import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.CountryUtils;
import java.util.ArrayList;

public class UpdateListAdapter extends Adapter<ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    public final boolean isDefaultData;
    public final Typeface mRobotoBoldFont = Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Bold.ttf");
    public final Typeface mRobotoRegularFont = Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Regular.ttf");
    public final ArrayList<UpdateItem> mUpdateItems;

    public class UpdateViewHolder extends ViewHolder {
        public final SimpleDraweeView mUpdateItemIcon;
        public final TextView mUpdateItemText;

        public UpdateViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            this.mUpdateItemIcon = (SimpleDraweeView) linearLayout.findViewById(R.id.update_icon);
            this.mUpdateItemText = (TextView) linearLayout.findViewById(R.id.update_text);
        }
    }

    public class VHHeader extends ViewHolder {
        public final TextView tvMessage;
        public final TextView tvStatus;

        public VHHeader(LinearLayout linearLayout) {
            super(linearLayout);
            this.tvStatus = (TextView) linearLayout.findViewById(R.id.tv_status);
            this.tvMessage = (TextView) linearLayout.findViewById(R.id.tv_message);
        }
    }

    public UpdateListAdapter(ArrayList<UpdateItem> arrayList, boolean z) {
        Fresco.initialize(MPLApplication.getInstance(), null, null);
        this.mUpdateItems = arrayList;
        this.isDefaultData = z;
    }

    public int getItemCount() {
        ArrayList<UpdateItem> arrayList = this.mUpdateItems;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String str;
        if (viewHolder instanceof VHHeader) {
            VHHeader vHHeader = (VHHeader) viewHolder;
            vHHeader.tvStatus.setTypeface(this.mRobotoBoldFont);
            vHHeader.tvMessage.setTypeface(this.mRobotoRegularFont);
            try {
                str = CountryUtils.getCountryCodeInNormalPref();
            } catch (Exception unused) {
                str = "";
            }
            if (TextUtils.isEmpty(str) || !"ID".equalsIgnoreCase(str)) {
                TextView textView = vHHeader.tvStatus;
                textView.setText(textView.getContext().getResources().getString(R.string.update_ready_install));
                TextView textView2 = vHHeader.tvMessage;
                textView2.setText(textView2.getContext().getResources().getString(R.string.what_s_new));
                return;
            }
            TextView textView3 = vHHeader.tvStatus;
            textView3.setText(textView3.getContext().getResources().getString(R.string.update_ready_install_id));
            TextView textView4 = vHHeader.tvMessage;
            textView4.setText(textView4.getContext().getResources().getString(R.string.what_s_new_id));
            return;
        }
        UpdateViewHolder updateViewHolder = (UpdateViewHolder) viewHolder;
        if (this.isDefaultData) {
            int i2 = i - 1;
            updateViewHolder.mUpdateItemIcon.setImageResource(CommonUtils.defaultReleaseNoteIcon.get(i2).intValue());
            updateViewHolder.mUpdateItemText.setTypeface(this.mRobotoRegularFont);
            updateViewHolder.mUpdateItemText.setText(CommonUtils.defaultReleaseNoteText.get(i2));
            return;
        }
        ArrayList<UpdateItem> arrayList = this.mUpdateItems;
        if (arrayList == null || arrayList.get(i) == null || TextUtils.isEmpty(this.mUpdateItems.get(i).getUpdateImageUrl())) {
            updateViewHolder.mUpdateItemIcon.setBackgroundResource(R.drawable.update_note_placeholder);
        } else {
            updateViewHolder.mUpdateItemIcon.setImageURI(Uri.parse(this.mUpdateItems.get(i).getUpdateImageUrl()));
        }
        ArrayList<UpdateItem> arrayList2 = this.mUpdateItems;
        if (arrayList2 == null || arrayList2.get(i) == null || TextUtils.isEmpty(this.mUpdateItems.get(i).getUpdateDesc())) {
            updateViewHolder.mUpdateItemText.setText(R.string.improvements_to_app_and_game_performance);
        } else {
            updateViewHolder.mUpdateItemText.setText(this.mUpdateItems.get(i).getUpdateDesc());
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new VHHeader((LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.update_list_header, viewGroup, false));
        }
        return new UpdateViewHolder((LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.update_list_item, viewGroup, false));
    }

    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
    }
}
