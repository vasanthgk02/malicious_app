package com.clevertap.android.sdk.inbox;

import android.view.View.OnClickListener;
import androidx.viewpager.widget.ViewPager;
import org.json.JSONObject;

public class CTInboxButtonClickListener implements OnClickListener {
    public JSONObject buttonObject;
    public final String buttonText;
    public final CTInboxListViewFragment fragment;
    public final CTInboxMessage inboxMessage;
    public boolean isBodyClick;
    public final int position;
    public ViewPager viewPager;

    public CTInboxButtonClickListener(int i, CTInboxMessage cTInboxMessage, String str, JSONObject jSONObject, CTInboxListViewFragment cTInboxListViewFragment, boolean z) {
        this.position = i;
        this.inboxMessage = cTInboxMessage;
        this.buttonText = str;
        this.fragment = cTInboxListViewFragment;
        this.buttonObject = jSONObject;
        this.isBodyClick = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010d, code lost:
        if (r6.isEmpty() == false) goto L_0x011d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r15) {
        /*
            r14 = this;
            androidx.viewpager.widget.ViewPager r15 = r14.viewPager
            if (r15 == 0) goto L_0x0015
            com.clevertap.android.sdk.inbox.CTInboxListViewFragment r0 = r14.fragment
            if (r0 == 0) goto L_0x0131
            int r1 = r14.position
            int r15 = r15.getCurrentItem()
            boolean r2 = r14.isBodyClick
            r0.handleViewPagerClick(r1, r15, r2)
            goto L_0x0131
        L_0x0015:
            java.lang.String r15 = r14.buttonText
            if (r15 == 0) goto L_0x0123
            org.json.JSONObject r15 = r14.buttonObject
            if (r15 == 0) goto L_0x0123
            com.clevertap.android.sdk.inbox.CTInboxListViewFragment r15 = r14.fragment
            if (r15 == 0) goto L_0x0131
            com.clevertap.android.sdk.inbox.CTInboxMessage r15 = r14.inboxMessage
            java.util.ArrayList<com.clevertap.android.sdk.inbox.CTInboxMessageContent> r15 = r15.inboxMessageContents
            r0 = 0
            java.lang.Object r15 = r15.get(r0)
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r15 = (com.clevertap.android.sdk.inbox.CTInboxMessageContent) r15
            org.json.JSONObject r1 = r14.buttonObject
            java.lang.String r15 = r15.getLinktype(r1)
            java.lang.String r1 = "copy"
            boolean r15 = r15.equalsIgnoreCase(r1)
            r1 = 0
            if (r15 == 0) goto L_0x00a1
            com.clevertap.android.sdk.inbox.CTInboxListViewFragment r15 = r14.fragment
            androidx.fragment.app.FragmentActivity r15 = r15.getActivity()
            if (r15 == 0) goto L_0x00a1
            com.clevertap.android.sdk.inbox.CTInboxListViewFragment r15 = r14.fragment
            androidx.fragment.app.FragmentActivity r15 = r15.getActivity()
            java.lang.String r2 = "clipboard"
            java.lang.Object r2 = r15.getSystemService(r2)
            android.content.ClipboardManager r2 = (android.content.ClipboardManager) r2
            java.lang.String r3 = r14.buttonText
            com.clevertap.android.sdk.inbox.CTInboxMessage r4 = r14.inboxMessage
            java.util.ArrayList<com.clevertap.android.sdk.inbox.CTInboxMessageContent> r4 = r4.inboxMessageContents
            java.lang.Object r4 = r4.get(r0)
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r4 = (com.clevertap.android.sdk.inbox.CTInboxMessageContent) r4
            org.json.JSONObject r5 = r14.buttonObject
            if (r4 == 0) goto L_0x00a0
            java.lang.String r4 = "text"
            java.lang.String r6 = "copyText"
            if (r5 != 0) goto L_0x0068
            goto L_0x008b
        L_0x0068:
            boolean r7 = r5.has(r6)     // Catch:{ JSONException -> 0x0081 }
            if (r7 == 0) goto L_0x0073
            org.json.JSONObject r5 = r5.getJSONObject(r6)     // Catch:{ JSONException -> 0x0081 }
            goto L_0x0074
        L_0x0073:
            r5 = r1
        L_0x0074:
            if (r5 == 0) goto L_0x008b
            boolean r6 = r5.has(r4)     // Catch:{ JSONException -> 0x0081 }
            if (r6 == 0) goto L_0x008b
            java.lang.String r4 = r5.getString(r4)     // Catch:{ JSONException -> 0x0081 }
            goto L_0x008d
        L_0x0081:
            r4 = move-exception
            java.lang.String r5 = "Unable to get Link Text with JSON - "
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            com.android.tools.r8.GeneratedOutlineSupport.outline105(r4, r5)
        L_0x008b:
            java.lang.String r4 = ""
        L_0x008d:
            android.content.ClipData r3 = android.content.ClipData.newPlainText(r3, r4)
            if (r2 == 0) goto L_0x00a1
            r2.setPrimaryClip(r3)
            java.lang.String r2 = "Text Copied to Clipboard"
            android.widget.Toast r15 = android.widget.Toast.makeText(r15, r2, r0)
            r15.show()
            goto L_0x00a1
        L_0x00a0:
            throw r1
        L_0x00a1:
            com.clevertap.android.sdk.inbox.CTInboxListViewFragment r2 = r14.fragment
            int r3 = r14.position
            java.lang.String r4 = r14.buttonText
            org.json.JSONObject r5 = r14.buttonObject
            com.clevertap.android.sdk.inbox.CTInboxMessage r15 = r14.inboxMessage
            if (r15 == 0) goto L_0x011c
            java.util.ArrayList<com.clevertap.android.sdk.inbox.CTInboxMessageContent> r6 = r15.inboxMessageContents
            if (r6 == 0) goto L_0x011c
            java.lang.Object r6 = r6.get(r0)
            if (r6 == 0) goto L_0x011c
            java.util.ArrayList<com.clevertap.android.sdk.inbox.CTInboxMessageContent> r6 = r15.inboxMessageContents
            java.lang.Object r6 = r6.get(r0)
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r6 = (com.clevertap.android.sdk.inbox.CTInboxMessageContent) r6
            org.json.JSONObject r7 = r14.buttonObject
            java.lang.String r6 = r6.getLinktype(r7)
            java.lang.String r7 = "kv"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x011c
            java.util.ArrayList<com.clevertap.android.sdk.inbox.CTInboxMessageContent> r15 = r15.inboxMessageContents
            java.lang.Object r15 = r15.get(r0)
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r15 = (com.clevertap.android.sdk.inbox.CTInboxMessageContent) r15
            org.json.JSONObject r0 = r14.buttonObject
            if (r15 == 0) goto L_0x011b
            if (r0 == 0) goto L_0x011c
            boolean r15 = r0.has(r7)
            if (r15 != 0) goto L_0x00e2
            goto L_0x011c
        L_0x00e2:
            org.json.JSONObject r15 = r0.getJSONObject(r7)     // Catch:{ JSONException -> 0x0110 }
            java.util.Iterator r0 = r15.keys()     // Catch:{ JSONException -> 0x0110 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ JSONException -> 0x0110 }
            r6.<init>()     // Catch:{ JSONException -> 0x0110 }
        L_0x00ef:
            boolean r7 = r0.hasNext()     // Catch:{ JSONException -> 0x0110 }
            if (r7 == 0) goto L_0x0109
            java.lang.Object r7 = r0.next()     // Catch:{ JSONException -> 0x0110 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ JSONException -> 0x0110 }
            java.lang.String r8 = r15.getString(r7)     // Catch:{ JSONException -> 0x0110 }
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0110 }
            if (r9 != 0) goto L_0x00ef
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0110 }
            goto L_0x00ef
        L_0x0109:
            boolean r15 = r6.isEmpty()     // Catch:{ JSONException -> 0x0110 }
            if (r15 != 0) goto L_0x011c
            goto L_0x011d
        L_0x0110:
            r15 = move-exception
            java.lang.String r0 = "Unable to get Link Key Value with JSON - "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            com.android.tools.r8.GeneratedOutlineSupport.outline105(r15, r0)
            goto L_0x011c
        L_0x011b:
            throw r1
        L_0x011c:
            r6 = r1
        L_0x011d:
            boolean r7 = r14.isBodyClick
            r2.handleClick(r3, r4, r5, r6, r7)
            goto L_0x0131
        L_0x0123:
            com.clevertap.android.sdk.inbox.CTInboxListViewFragment r8 = r14.fragment
            if (r8 == 0) goto L_0x0131
            int r9 = r14.position
            r10 = 0
            r11 = 0
            r12 = 0
            boolean r13 = r14.isBodyClick
            r8.handleClick(r9, r10, r11, r12, r13)
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.CTInboxButtonClickListener.onClick(android.view.View):void");
    }

    public CTInboxButtonClickListener(int i, CTInboxMessage cTInboxMessage, String str, CTInboxListViewFragment cTInboxListViewFragment, ViewPager viewPager2, boolean z) {
        this.position = i;
        this.inboxMessage = cTInboxMessage;
        this.buttonText = null;
        this.fragment = cTInboxListViewFragment;
        this.viewPager = viewPager2;
        this.isBodyClick = z;
    }
}
