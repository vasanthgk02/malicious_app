package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView;
import com.clevertap.android.sdk.customviews.VerticalSpaceItemDecoration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONObject;

public class CTInboxListViewFragment extends Fragment {
    public CleverTapInstanceConfig config;
    public boolean firstTime = true;
    public boolean haveVideoPlayerSupport = Utils.haveVideoPlayerSupport;
    public CTInboxMessageAdapter inboxMessageAdapter;
    public ArrayList<CTInboxMessage> inboxMessages = new ArrayList<>();
    public LinearLayout linearLayout;
    public WeakReference<InboxListener> listenerWeakReference;
    public MediaPlayerRecyclerView mediaRecyclerView;
    public RecyclerView recyclerView;
    public CTInboxStyleConfig styleConfig;
    public int tabPosition;

    public interface InboxListener {
        void messageDidClick(Context context, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap, boolean z);

        void messageDidShow(Context context, CTInboxMessage cTInboxMessage, Bundle bundle);
    }

    public void didClick(Bundle bundle, int i, HashMap<String, String> hashMap, boolean z) {
        InboxListener inboxListener;
        try {
            inboxListener = (InboxListener) this.listenerWeakReference.get();
        } catch (Throwable unused) {
            inboxListener = null;
        }
        InboxListener inboxListener2 = inboxListener;
        if (inboxListener2 == null) {
            Logger.v("InboxListener is null for messages");
        }
        if (inboxListener2 != null) {
            inboxListener2.messageDidClick(getActivity().getBaseContext(), this.inboxMessages.get(i), bundle, hashMap, z);
        }
    }

    public void didShow(Bundle bundle, int i) {
        InboxListener inboxListener;
        try {
            inboxListener = (InboxListener) this.listenerWeakReference.get();
        } catch (Throwable unused) {
            inboxListener = null;
        }
        if (inboxListener == null) {
            Logger.v("InboxListener is null for messages");
        }
        if (inboxListener != null) {
            Logger.v("CTInboxListViewFragment:didShow() called with: data = [" + null + "], position = [" + i + CMapParser.MARK_END_OF_ARRAY);
            inboxListener.messageDidShow(getActivity().getBaseContext(), this.inboxMessages.get(i), null);
        }
    }

    public void fireUrlThroughIntent(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str.replace("\n", "").replace("\r", "")));
            if (getActivity() != null) {
                Utils.setPackageNameFromResolveInfoList(getActivity(), intent);
            }
            startActivity(intent);
        } catch (Throwable unused) {
        }
    }

    public void handleClick(int i, String str, JSONObject jSONObject, HashMap<String, String> hashMap, boolean z) {
        try {
            Bundle bundle = new Bundle();
            JSONObject wzrkParams = this.inboxMessages.get(i).getWzrkParams();
            Iterator<String> keys = wzrkParams.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("wzrk_")) {
                    bundle.putString(next, wzrkParams.getString(next));
                }
            }
            if (str != null && !str.isEmpty()) {
                bundle.putString("wzrk_c2a", str);
            }
            didClick(bundle, i, hashMap, z);
            boolean z2 = hashMap != null && !hashMap.isEmpty();
            if (jSONObject != null) {
                if (!z2) {
                    if (!this.inboxMessages.get(i).inboxMessageContents.get(0).getLinktype(jSONObject).equalsIgnoreCase("copy")) {
                        String linkUrl = this.inboxMessages.get(i).inboxMessageContents.get(0).getLinkUrl(jSONObject);
                        if (linkUrl != null) {
                            fireUrlThroughIntent(linkUrl);
                        }
                    }
                }
                return;
            }
            String str2 = this.inboxMessages.get(i).inboxMessageContents.get(0).actionUrl;
            if (str2 != null) {
                fireUrlThroughIntent(str2);
            }
        } catch (Throwable th) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error handling notification button click: ");
            outline73.append(th.getCause());
            Logger.d(outline73.toString());
        }
    }

    public void handleViewPagerClick(int i, int i2, boolean z) {
        try {
            Bundle bundle = new Bundle();
            JSONObject wzrkParams = this.inboxMessages.get(i).getWzrkParams();
            Iterator<String> keys = wzrkParams.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("wzrk_")) {
                    bundle.putString(next, wzrkParams.getString(next));
                }
            }
            didClick(bundle, i, null, z);
            fireUrlThroughIntent(this.inboxMessages.get(i).inboxMessageContents.get(i2).actionUrl);
        } catch (Throwable th) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error handling notification button click: ");
            outline73.append(th.getCause());
            Logger.d(outline73.toString());
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.config = (CleverTapInstanceConfig) arguments.getParcelable("config");
            this.styleConfig = (CTInboxStyleConfig) arguments.getParcelable("styleConfig");
            this.tabPosition = arguments.getInt("position", -1);
            updateInboxMessages();
            if (context instanceof CTInboxActivity) {
                this.listenerWeakReference = new WeakReference<>((InboxListener) getActivity());
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.inbox_list_view, viewGroup, false);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R$id.list_view_linear_layout);
        this.linearLayout = linearLayout2;
        linearLayout2.setBackgroundColor(Color.parseColor(this.styleConfig.getInboxBackgroundColor()));
        TextView textView = (TextView) inflate.findViewById(R$id.list_view_no_message_view);
        if (this.inboxMessages.size() <= 0) {
            textView.setVisibility(0);
            textView.setText(this.styleConfig.getNoMessageViewText());
            textView.setTextColor(Color.parseColor(this.styleConfig.getNoMessageViewTextColor()));
            return inflate;
        }
        textView.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.inboxMessageAdapter = new CTInboxMessageAdapter(this.inboxMessages, this);
        if (this.haveVideoPlayerSupport) {
            MediaPlayerRecyclerView mediaPlayerRecyclerView = new MediaPlayerRecyclerView(getActivity());
            this.mediaRecyclerView = mediaPlayerRecyclerView;
            this.mediaRecyclerView = mediaPlayerRecyclerView;
            mediaPlayerRecyclerView.setVisibility(0);
            this.mediaRecyclerView.setLayoutManager(linearLayoutManager);
            this.mediaRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(18));
            this.mediaRecyclerView.setItemAnimator(new DefaultItemAnimator());
            this.mediaRecyclerView.setAdapter(this.inboxMessageAdapter);
            this.inboxMessageAdapter.notifyDataSetChanged();
            this.linearLayout.addView(this.mediaRecyclerView);
            if (this.firstTime) {
                if (this.tabPosition <= 0) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            CTInboxListViewFragment.this.mediaRecyclerView.playVideo();
                        }
                    }, 1000);
                    this.firstTime = false;
                }
            }
        } else {
            RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R$id.list_view_recycler_view);
            this.recyclerView = recyclerView2;
            recyclerView2.setVisibility(0);
            this.recyclerView.setLayoutManager(linearLayoutManager);
            this.recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(18));
            this.recyclerView.setItemAnimator(new DefaultItemAnimator());
            this.recyclerView.setAdapter(this.inboxMessageAdapter);
            this.inboxMessageAdapter.notifyDataSetChanged();
        }
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        MediaPlayerRecyclerView mediaPlayerRecyclerView = this.mediaRecyclerView;
        if (mediaPlayerRecyclerView != null) {
            mediaPlayerRecyclerView.release();
        }
    }

    public void onPause() {
        super.onPause();
        MediaPlayerRecyclerView mediaPlayerRecyclerView = this.mediaRecyclerView;
        if (mediaPlayerRecyclerView != null) {
            mediaPlayerRecyclerView.onPausePlayer();
        }
    }

    public void onResume() {
        super.onResume();
        MediaPlayerRecyclerView mediaPlayerRecyclerView = this.mediaRecyclerView;
        if (mediaPlayerRecyclerView != null && mediaPlayerRecyclerView.videoSurfaceView == null) {
            mediaPlayerRecyclerView.initialize(mediaPlayerRecyclerView.appContext);
            mediaPlayerRecyclerView.playVideo();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MediaPlayerRecyclerView mediaPlayerRecyclerView = this.mediaRecyclerView;
        if (!(mediaPlayerRecyclerView == null || mediaPlayerRecyclerView.getLayoutManager() == null)) {
            bundle.putParcelable("recyclerLayoutState", this.mediaRecyclerView.getLayoutManager().onSaveInstanceState());
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null && recyclerView2.getLayoutManager() != null) {
            bundle.putParcelable("recyclerLayoutState", this.recyclerView.getLayoutManager().onSaveInstanceState());
        }
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("recyclerLayoutState");
            MediaPlayerRecyclerView mediaPlayerRecyclerView = this.mediaRecyclerView;
            if (!(mediaPlayerRecyclerView == null || mediaPlayerRecyclerView.getLayoutManager() == null)) {
                this.mediaRecyclerView.getLayoutManager().onRestoreInstanceState(parcelable);
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null && recyclerView2.getLayoutManager() != null) {
                this.recyclerView.getLayoutManager().onRestoreInstanceState(parcelable);
            }
        }
    }

    public void updateAdapterContent() {
        updateInboxMessages();
        CTInboxMessageAdapter cTInboxMessageAdapter = this.inboxMessageAdapter;
        if (cTInboxMessageAdapter != null) {
            ArrayList<CTInboxMessage> arrayList = this.inboxMessages;
            if (!(arrayList == null || this.config == null)) {
                synchronized (cTInboxMessageAdapter) {
                    cTInboxMessageAdapter.inboxMessages.clear();
                    cTInboxMessageAdapter.inboxMessages.addAll(arrayList);
                    cTInboxMessageAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public final void updateInboxMessages() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("filter", null);
            CleverTapAPI instanceWithConfig = CleverTapAPI.instanceWithConfig(getActivity(), this.config);
            if (instanceWithConfig != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("CTInboxListViewFragment:onAttach() called with: tabPosition = [");
                outline73.append(this.tabPosition);
                outline73.append("], filter = [");
                outline73.append(string);
                outline73.append(CMapParser.MARK_END_OF_ARRAY);
                Logger.v(outline73.toString());
                ArrayList<CTInboxMessage> allInboxMessages = instanceWithConfig.getAllInboxMessages();
                if (string != null) {
                    ArrayList<CTInboxMessage> arrayList = new ArrayList<>();
                    Iterator<CTInboxMessage> it = allInboxMessages.iterator();
                    while (it.hasNext()) {
                        CTInboxMessage next = it.next();
                        List<String> list = next.tags;
                        if (list != null && list.size() > 0) {
                            for (String equalsIgnoreCase : next.tags) {
                                if (equalsIgnoreCase.equalsIgnoreCase(string)) {
                                    arrayList.add(next);
                                }
                            }
                        }
                    }
                    allInboxMessages = arrayList;
                }
                this.inboxMessages = allInboxMessages;
            }
        }
    }
}
