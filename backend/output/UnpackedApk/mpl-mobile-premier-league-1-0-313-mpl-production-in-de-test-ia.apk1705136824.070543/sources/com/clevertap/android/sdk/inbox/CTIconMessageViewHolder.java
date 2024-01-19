package com.clevertap.android.sdk.inbox;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.clevertap.android.sdk.R$id;

public class CTIconMessageViewHolder extends CTInboxBaseMessageViewHolder {
    public final RelativeLayout clickLayout;
    public final Button cta1;
    public final Button cta2;
    public final Button cta3;
    public final LinearLayout ctaLinearLayout;
    public final ImageView iconImage;
    public final TextView message;
    public final ImageView readDot;
    public final TextView timestamp;
    public final TextView title;

    public CTIconMessageViewHolder(View view) {
        super(view);
        view.setTag(this);
        this.title = (TextView) view.findViewById(R$id.messageTitle);
        this.message = (TextView) view.findViewById(R$id.messageText);
        this.mediaImage = (ImageView) view.findViewById(R$id.media_image);
        this.iconImage = (ImageView) view.findViewById(R$id.image_icon);
        this.readDot = (ImageView) view.findViewById(R$id.read_circle);
        this.timestamp = (TextView) view.findViewById(R$id.timestamp);
        this.cta1 = (Button) view.findViewById(R$id.cta_button_1);
        this.cta2 = (Button) view.findViewById(R$id.cta_button_2);
        this.cta3 = (Button) view.findViewById(R$id.cta_button_3);
        this.frameLayout = (FrameLayout) view.findViewById(R$id.icon_message_frame_layout);
        this.squareImage = (ImageView) view.findViewById(R$id.square_media_image);
        this.clickLayout = (RelativeLayout) view.findViewById(R$id.click_relative_layout);
        this.ctaLinearLayout = (LinearLayout) view.findViewById(R$id.cta_linear_layout);
        this.progressBarFrameLayout = (FrameLayout) view.findViewById(R$id.icon_progress_frame_layout);
        this.mediaLayout = (RelativeLayout) view.findViewById(R$id.media_layout);
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: type inference failed for: r18v4 */
    /* JADX WARNING: type inference failed for: r18v5 */
    /* JADX WARNING: type inference failed for: r18v6 */
    /* JADX WARNING: type inference failed for: r2v151, types: [com.clevertap.android.sdk.inbox.CTInboxButtonClickListener] */
    /* JADX WARNING: type inference failed for: r18v7 */
    /* JADX WARNING: type inference failed for: r2v152, types: [android.view.View$OnClickListener] */
    /* JADX WARNING: type inference failed for: r18v8 */
    /* JADX WARNING: type inference failed for: r18v9 */
    /* JADX WARNING: type inference failed for: r18v10 */
    /* JADX WARNING: type inference failed for: r18v11 */
    /* JADX WARNING: type inference failed for: r18v12 */
    /* JADX WARNING: type inference failed for: r18v13 */
    /* JADX WARNING: type inference failed for: r18v14 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:104|105|106|107|108|130|(0)(0)|137|138|139|(0)(0)|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:97|98|99|100|101|130|(0)(0)|137|138|139|(0)(0)|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:113|114|115|116|117) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:141|142|143|144|145) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:56|57|58|59|60) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:63|64|65|66|67) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:73|(1:75)(1:76)|77|78|79|80) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x052b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x0597 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:116:0x060c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:144:0x072b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0351 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x03bb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0440 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r18v4
      assigns: []
      uses: []
      mth insns count: 663
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x06a3  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x06b2  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x06f0 A[Catch:{ NoClassDefFoundError -> 0x074c }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0744 A[Catch:{ NoClassDefFoundError -> 0x074c }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0751  */
    /* JADX WARNING: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x02e0 A[Catch:{ NoClassDefFoundError -> 0x0695 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x02ef A[Catch:{ NoClassDefFoundError -> 0x0695 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x04dc A[Catch:{ NoClassDefFoundError -> 0x0696 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:107:0x0597=Splitter:B:107:0x0597, B:100:0x052b=Splitter:B:100:0x052b, B:116:0x060c=Splitter:B:116:0x060c} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:79:0x0440=Splitter:B:79:0x0440, B:59:0x0351=Splitter:B:59:0x0351, B:66:0x03bb=Splitter:B:66:0x03bb} */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configureWithMessage(com.clevertap.android.sdk.inbox.CTInboxMessage r21, com.clevertap.android.sdk.inbox.CTInboxListViewFragment r22, int r23) {
        /*
            r20 = this;
            r1 = r20
            r9 = r21
            java.lang.String r10 = "l"
            java.lang.String r11 = "CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info"
            java.lang.String r12 = "CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info"
            java.lang.String r13 = "ct_image"
            super.configureWithMessage(r21, r22, r23)
            com.clevertap.android.sdk.inbox.CTInboxListViewFragment r14 = r20.getParent()
            java.util.ArrayList<com.clevertap.android.sdk.inbox.CTInboxMessageContent> r0 = r9.inboxMessageContents
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            r15 = r0
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r15 = (com.clevertap.android.sdk.inbox.CTInboxMessageContent) r15
            android.widget.TextView r0 = r1.title
            java.lang.String r3 = r15.title
            r0.setText(r3)
            android.widget.TextView r0 = r1.title
            java.lang.String r3 = r15.titleColor
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setTextColor(r3)
            android.widget.TextView r0 = r1.message
            java.lang.String r3 = r15.message
            r0.setText(r3)
            android.widget.TextView r0 = r1.message
            java.lang.String r3 = r15.messageColor
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setTextColor(r3)
            android.widget.RelativeLayout r0 = r1.clickLayout
            java.lang.String r3 = r9.bgColor
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setBackgroundColor(r3)
            long r3 = r9.date
            java.lang.String r0 = r1.calculateDisplayTimestamp(r3)
            android.widget.TextView r3 = r1.timestamp
            r3.setText(r0)
            android.widget.TextView r0 = r1.timestamp
            java.lang.String r3 = r15.titleColor
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setTextColor(r3)
            boolean r0 = r9.isRead
            r3 = 8
            if (r0 == 0) goto L_0x006e
            android.widget.ImageView r0 = r1.readDot
            r0.setVisibility(r3)
            goto L_0x0073
        L_0x006e:
            android.widget.ImageView r0 = r1.readDot
            r0.setVisibility(r2)
        L_0x0073:
            android.widget.FrameLayout r0 = r1.frameLayout
            r0.setVisibility(r3)
            org.json.JSONArray r0 = r15.links
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L_0x029e
            android.widget.LinearLayout r5 = r1.ctaLinearLayout
            r5.setVisibility(r2)
            int r5 = r0.length()
            if (r5 == r4) goto L_0x0230
            if (r5 == r3) goto L_0x018d
            r6 = 3
            if (r5 == r6) goto L_0x0094
        L_0x008e:
            r16 = r11
            r18 = r12
            goto L_0x02a9
        L_0x0094:
            org.json.JSONObject r6 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r5 = r1.cta1     // Catch:{ JSONException -> 0x0189 }
            r5.setVisibility(r2)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r5 = r1.cta1     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r7 = r15.getLinkText(r6)     // Catch:{ JSONException -> 0x0189 }
            r5.setText(r7)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r5 = r1.cta1     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r7 = r15.getLinkColor(r6)     // Catch:{ JSONException -> 0x0189 }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ JSONException -> 0x0189 }
            r5.setTextColor(r7)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r5 = r1.cta1     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r7 = r15.getLinkBGColor(r6)     // Catch:{ JSONException -> 0x0189 }
            int r7 = android.graphics.Color.parseColor(r7)     // Catch:{ JSONException -> 0x0189 }
            r5.setBackgroundColor(r7)     // Catch:{ JSONException -> 0x0189 }
            org.json.JSONObject r8 = r0.getJSONObject(r4)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r4 = r1.cta2     // Catch:{ JSONException -> 0x0189 }
            r4.setVisibility(r2)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r4 = r1.cta2     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r5 = r15.getLinkText(r8)     // Catch:{ JSONException -> 0x0189 }
            r4.setText(r5)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r4 = r1.cta2     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r5 = r15.getLinkColor(r8)     // Catch:{ JSONException -> 0x0189 }
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ JSONException -> 0x0189 }
            r4.setTextColor(r5)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r4 = r1.cta2     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r5 = r15.getLinkBGColor(r8)     // Catch:{ JSONException -> 0x0189 }
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ JSONException -> 0x0189 }
            r4.setBackgroundColor(r5)     // Catch:{ JSONException -> 0x0189 }
            org.json.JSONObject r0 = r0.getJSONObject(r3)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r3 = r1.cta3     // Catch:{ JSONException -> 0x0189 }
            r3.setVisibility(r2)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r3 = r15.getLinkText(r0)     // Catch:{ JSONException -> 0x0189 }
            r2.setText(r3)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r3 = r15.getLinkColor(r0)     // Catch:{ JSONException -> 0x0189 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0189 }
            r2.setTextColor(r3)     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r3 = r15.getLinkBGColor(r0)     // Catch:{ JSONException -> 0x0189 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0189 }
            r2.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x0189 }
            if (r14 == 0) goto L_0x008e
            android.widget.Button r7 = r1.cta1     // Catch:{ JSONException -> 0x0189 }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r5 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x0189 }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x0189 }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x0189 }
            java.lang.String r16 = r2.toString()     // Catch:{ JSONException -> 0x0189 }
            r17 = 0
            r2 = r5
            r3 = r23
            r4 = r21
            r18 = r5
            r5 = r16
            r16 = r11
            r11 = r7
            r7 = r14
            r19 = r8
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x0184 }
            r2 = r18
            r11.setOnClickListener(r2)     // Catch:{ JSONException -> 0x0184 }
            android.widget.Button r11 = r1.cta2     // Catch:{ JSONException -> 0x0184 }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r8 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x0184 }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x0184 }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x0184 }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x0184 }
            r17 = 0
            r2 = r8
            r3 = r23
            r4 = r21
            r6 = r19
            r7 = r14
            r18 = r12
            r12 = r8
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x0288 }
            r11.setOnClickListener(r12)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r11 = r1.cta3     // Catch:{ JSONException -> 0x0288 }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r12 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x0288 }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x0288 }
            r8 = 0
            r2 = r12
            r3 = r23
            r4 = r21
            r6 = r0
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x0288 }
            r11.setOnClickListener(r12)     // Catch:{ JSONException -> 0x0288 }
            goto L_0x02a9
        L_0x0184:
            r0 = move-exception
        L_0x0185:
            r18 = r12
            goto L_0x0289
        L_0x0189:
            r0 = move-exception
            r16 = r11
            goto L_0x0185
        L_0x018d:
            r16 = r11
            r18 = r12
            r2 = 0
            org.json.JSONObject r6 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r3 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            r3.setVisibility(r2)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r3 = r15.getLinkText(r6)     // Catch:{ JSONException -> 0x0288 }
            r2.setText(r3)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r3 = r15.getLinkColor(r6)     // Catch:{ JSONException -> 0x0288 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0288 }
            r2.setTextColor(r3)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r3 = r15.getLinkBGColor(r6)     // Catch:{ JSONException -> 0x0288 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0288 }
            r2.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x0288 }
            r2 = 1
            org.json.JSONObject r0 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x0288 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r3 = r15.getLinkText(r0)     // Catch:{ JSONException -> 0x0288 }
            r2.setText(r3)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r3 = r15.getLinkColor(r0)     // Catch:{ JSONException -> 0x0288 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0288 }
            r2.setTextColor(r3)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r3 = r15.getLinkBGColor(r0)     // Catch:{ JSONException -> 0x0288 }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x0288 }
            r2.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r3 = r1.cta2     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r4 = r1.cta3     // Catch:{ JSONException -> 0x0288 }
            r1.hideOneButton(r2, r3, r4)     // Catch:{ JSONException -> 0x0288 }
            if (r14 == 0) goto L_0x02a9
            android.widget.Button r11 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r12 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x0288 }
            r8 = 0
            r2 = r12
            r3 = r23
            r4 = r21
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x0288 }
            r11.setOnClickListener(r12)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r11 = r1.cta2     // Catch:{ JSONException -> 0x0288 }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r12 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x0288 }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x0288 }
            r8 = 0
            r2 = r12
            r3 = r23
            r4 = r21
            r6 = r0
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x0288 }
            r11.setOnClickListener(r12)     // Catch:{ JSONException -> 0x0288 }
            goto L_0x02a9
        L_0x0230:
            r16 = r11
            r18 = r12
            r2 = 0
            org.json.JSONObject r6 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            r0.setVisibility(r2)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r2 = r15.getLinkText(r6)     // Catch:{ JSONException -> 0x0288 }
            r0.setText(r2)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r2 = r15.getLinkColor(r6)     // Catch:{ JSONException -> 0x0288 }
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ JSONException -> 0x0288 }
            r0.setTextColor(r2)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r2 = r15.getLinkBGColor(r6)     // Catch:{ JSONException -> 0x0288 }
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ JSONException -> 0x0288 }
            r0.setBackgroundColor(r2)     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r3 = r1.cta3     // Catch:{ JSONException -> 0x0288 }
            r1.hideTwoButtons(r0, r2, r3)     // Catch:{ JSONException -> 0x0288 }
            if (r14 == 0) goto L_0x02a9
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r11 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x0288 }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x0288 }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x0288 }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x0288 }
            r8 = 0
            r2 = r11
            r3 = r23
            r4 = r21
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x0288 }
            r0.setOnClickListener(r11)     // Catch:{ JSONException -> 0x0288 }
            goto L_0x02a9
        L_0x0288:
            r0 = move-exception
        L_0x0289:
            java.lang.String r2 = "Error parsing CTA JSON - "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r0 = r0.getLocalizedMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.clevertap.android.sdk.Logger.d(r0)
            goto L_0x02a9
        L_0x029e:
            r16 = r11
            r18 = r12
            android.widget.LinearLayout r0 = r1.ctaLinearLayout
            r2 = 8
            r0.setVisibility(r2)
        L_0x02a9:
            r0 = 8
            android.widget.ImageView r2 = r1.mediaImage
            r2.setVisibility(r0)
            android.widget.ImageView r2 = r1.mediaImage
            java.lang.String r3 = r9.bgColor
            int r3 = android.graphics.Color.parseColor(r3)
            r2.setBackgroundColor(r3)
            android.widget.ImageView r2 = r1.squareImage
            r2.setVisibility(r0)
            android.widget.ImageView r2 = r1.squareImage
            java.lang.String r3 = r9.bgColor
            int r3 = android.graphics.Color.parseColor(r3)
            r2.setBackgroundColor(r3)
            android.widget.RelativeLayout r2 = r1.mediaLayout
            r2.setVisibility(r0)
            android.widget.FrameLayout r2 = r1.progressBarFrameLayout
            r2.setVisibility(r0)
            java.lang.String r0 = r9.orientation     // Catch:{ NoClassDefFoundError -> 0x0695 }
            int r2 = r0.hashCode()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r3 = 108(0x6c, float:1.51E-43)
            r4 = -1
            if (r2 == r3) goto L_0x02ef
            r3 = 112(0x70, float:1.57E-43)
            if (r2 == r3) goto L_0x02e5
            goto L_0x02f7
        L_0x02e5:
            java.lang.String r2 = "p"
            boolean r0 = r0.equals(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            if (r0 == 0) goto L_0x02f7
            r0 = 1
            goto L_0x02f8
        L_0x02ef:
            boolean r0 = r0.equals(r10)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            if (r0 == 0) goto L_0x02f7
            r0 = 0
            goto L_0x02f8
        L_0x02f7:
            r0 = -1
        L_0x02f8:
            java.lang.String r2 = "ct_audio"
            java.lang.String r3 = "ct_video_1"
            if (r0 == 0) goto L_0x04dc
            r5 = 1
            if (r0 == r5) goto L_0x0303
            goto L_0x03d7
        L_0x0303:
            boolean r0 = r15.mediaIsImage()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            if (r0 == 0) goto L_0x036a
            android.widget.RelativeLayout r0 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.setScaleType(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x0351 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x0351 }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoSuchMethodError -> 0x0351 }
            java.lang.String r2 = r15.media     // Catch:{ NoSuchMethodError -> 0x0351 }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoSuchMethodError -> 0x0351 }
            com.bumptech.glide.request.RequestOptions r2 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x0351 }
            r2.<init>()     // Catch:{ NoSuchMethodError -> 0x0351 }
            android.content.Context r3 = r1.context     // Catch:{ NoSuchMethodError -> 0x0351 }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r13)     // Catch:{ NoSuchMethodError -> 0x0351 }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder(r3)     // Catch:{ NoSuchMethodError -> 0x0351 }
            com.bumptech.glide.request.RequestOptions r2 = (com.bumptech.glide.request.RequestOptions) r2     // Catch:{ NoSuchMethodError -> 0x0351 }
            android.content.Context r3 = r1.context     // Catch:{ NoSuchMethodError -> 0x0351 }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r13)     // Catch:{ NoSuchMethodError -> 0x0351 }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.error(r3)     // Catch:{ NoSuchMethodError -> 0x0351 }
            com.bumptech.glide.RequestBuilder r0 = r0.apply(r2)     // Catch:{ NoSuchMethodError -> 0x0351 }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x0351 }
            r0.into(r2)     // Catch:{ NoSuchMethodError -> 0x0351 }
            goto L_0x03d7
        L_0x0351:
            com.clevertap.android.sdk.Logger.d(r18)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            java.lang.String r2 = r15.media     // Catch:{ NoClassDefFoundError -> 0x0695 }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.into(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            goto L_0x03d7
        L_0x036a:
            boolean r0 = r15.mediaIsGIF()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            if (r0 == 0) goto L_0x03da
            android.widget.RelativeLayout r0 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.setScaleType(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x03bb }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x03bb }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoSuchMethodError -> 0x03bb }
            com.bumptech.glide.RequestBuilder r0 = r0.asGif()     // Catch:{ NoSuchMethodError -> 0x03bb }
            java.lang.String r2 = r15.media     // Catch:{ NoSuchMethodError -> 0x03bb }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoSuchMethodError -> 0x03bb }
            com.bumptech.glide.request.RequestOptions r2 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x03bb }
            r2.<init>()     // Catch:{ NoSuchMethodError -> 0x03bb }
            android.content.Context r3 = r1.context     // Catch:{ NoSuchMethodError -> 0x03bb }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r13)     // Catch:{ NoSuchMethodError -> 0x03bb }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder(r3)     // Catch:{ NoSuchMethodError -> 0x03bb }
            com.bumptech.glide.request.RequestOptions r2 = (com.bumptech.glide.request.RequestOptions) r2     // Catch:{ NoSuchMethodError -> 0x03bb }
            android.content.Context r3 = r1.context     // Catch:{ NoSuchMethodError -> 0x03bb }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r13)     // Catch:{ NoSuchMethodError -> 0x03bb }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.error(r3)     // Catch:{ NoSuchMethodError -> 0x03bb }
            com.bumptech.glide.RequestBuilder r0 = r0.apply(r2)     // Catch:{ NoSuchMethodError -> 0x03bb }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x03bb }
            r0.into(r2)     // Catch:{ NoSuchMethodError -> 0x03bb }
            goto L_0x03d7
        L_0x03bb:
            com.clevertap.android.sdk.Logger.d(r18)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            com.bumptech.glide.RequestBuilder r0 = r0.asGif()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            java.lang.String r2 = r15.media     // Catch:{ NoClassDefFoundError -> 0x0695 }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.into(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
        L_0x03d7:
            r0 = 2
            goto L_0x0699
        L_0x03da:
            boolean r0 = r15.mediaIsVideo()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            if (r0 == 0) goto L_0x049c
            android.widget.RelativeLayout r0 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            java.lang.String r0 = r15.posterUrl     // Catch:{ NoClassDefFoundError -> 0x0695 }
            boolean r0 = r0.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            if (r0 != 0) goto L_0x0456
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            int r0 = com.clevertap.android.sdk.inbox.CTInboxActivity.orientation     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r2 = 2
            if (r0 != r2) goto L_0x0401
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.setScaleType(r4)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            goto L_0x0408
        L_0x0401:
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.setScaleType(r4)     // Catch:{ NoClassDefFoundError -> 0x0695 }
        L_0x0408:
            com.clevertap.android.sdk.Logger.d(r18)     // Catch:{ NoSuchMethodError -> 0x0440 }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x0440 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x0440 }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoSuchMethodError -> 0x0440 }
            java.lang.String r4 = r15.posterUrl     // Catch:{ NoSuchMethodError -> 0x0440 }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r4)     // Catch:{ NoSuchMethodError -> 0x0440 }
            com.bumptech.glide.request.RequestOptions r4 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x0440 }
            r4.<init>()     // Catch:{ NoSuchMethodError -> 0x0440 }
            android.content.Context r5 = r1.context     // Catch:{ NoSuchMethodError -> 0x0440 }
            int r5 = com.clevertap.android.sdk.Utils.getThumbnailImage(r5, r3)     // Catch:{ NoSuchMethodError -> 0x0440 }
            com.bumptech.glide.request.BaseRequestOptions r4 = r4.placeholder(r5)     // Catch:{ NoSuchMethodError -> 0x0440 }
            com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4     // Catch:{ NoSuchMethodError -> 0x0440 }
            android.content.Context r5 = r1.context     // Catch:{ NoSuchMethodError -> 0x0440 }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r5, r3)     // Catch:{ NoSuchMethodError -> 0x0440 }
            com.bumptech.glide.request.BaseRequestOptions r3 = r4.error(r3)     // Catch:{ NoSuchMethodError -> 0x0440 }
            com.bumptech.glide.RequestBuilder r0 = r0.apply(r3)     // Catch:{ NoSuchMethodError -> 0x0440 }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x0440 }
            r0.into(r3)     // Catch:{ NoSuchMethodError -> 0x0440 }
            goto L_0x03d7
        L_0x0440:
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x0695 }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            java.lang.String r3 = r15.posterUrl     // Catch:{ NoClassDefFoundError -> 0x0695 }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r3)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0695 }
            r0.into(r3)     // Catch:{ NoClassDefFoundError -> 0x0695 }
            goto L_0x03d7
        L_0x0456:
            r0 = 2
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r5 = 0
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            int r2 = com.clevertap.android.sdk.inbox.CTInboxActivity.orientation     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r2 != r0) goto L_0x046e
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setScaleType(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            goto L_0x0475
        L_0x046e:
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setScaleType(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
        L_0x0475:
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r5 = 0
            r2.setBackgroundColor(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r2 = r1.context     // Catch:{ NoClassDefFoundError -> 0x0696 }
            int r2 = com.clevertap.android.sdk.Utils.getThumbnailImage(r2, r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r2 == r4) goto L_0x0699
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestBuilder r2 = r3.load(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            goto L_0x0699
        L_0x049c:
            r0 = 2
            boolean r3 = r15.mediaIsAudio()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r3 == 0) goto L_0x0699
            android.widget.RelativeLayout r3 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r5 = 0
            r3.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r3.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r3.setScaleType(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r5 = 0
            r3.setBackgroundColor(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r3 = r1.context     // Catch:{ NoClassDefFoundError -> 0x0696 }
            int r2 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r2 == r4) goto L_0x0699
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestBuilder r2 = r3.load(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            goto L_0x0699
        L_0x04dc:
            r0 = 2
            boolean r5 = r15.mediaIsImage()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r5 == 0) goto L_0x0545
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x052b }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoSuchMethodError -> 0x052b }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoSuchMethodError -> 0x052b }
            java.lang.String r3 = r15.media     // Catch:{ NoSuchMethodError -> 0x052b }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoSuchMethodError -> 0x052b }
            com.bumptech.glide.request.RequestOptions r3 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x052b }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x052b }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x052b }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r13)     // Catch:{ NoSuchMethodError -> 0x052b }
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.placeholder(r4)     // Catch:{ NoSuchMethodError -> 0x052b }
            com.bumptech.glide.request.RequestOptions r3 = (com.bumptech.glide.request.RequestOptions) r3     // Catch:{ NoSuchMethodError -> 0x052b }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x052b }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r13)     // Catch:{ NoSuchMethodError -> 0x052b }
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.error(r4)     // Catch:{ NoSuchMethodError -> 0x052b }
            com.bumptech.glide.RequestBuilder r2 = r2.apply(r3)     // Catch:{ NoSuchMethodError -> 0x052b }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x052b }
            r2.into(r3)     // Catch:{ NoSuchMethodError -> 0x052b }
            goto L_0x0699
        L_0x052b:
            com.clevertap.android.sdk.Logger.d(r18)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            java.lang.String r3 = r15.media     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            goto L_0x0699
        L_0x0545:
            boolean r5 = r15.mediaIsGIF()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r5 == 0) goto L_0x05b5
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x0597 }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoSuchMethodError -> 0x0597 }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoSuchMethodError -> 0x0597 }
            com.bumptech.glide.RequestBuilder r2 = r2.asGif()     // Catch:{ NoSuchMethodError -> 0x0597 }
            java.lang.String r3 = r15.media     // Catch:{ NoSuchMethodError -> 0x0597 }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoSuchMethodError -> 0x0597 }
            com.bumptech.glide.request.RequestOptions r3 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x0597 }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x0597 }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x0597 }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r13)     // Catch:{ NoSuchMethodError -> 0x0597 }
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.placeholder(r4)     // Catch:{ NoSuchMethodError -> 0x0597 }
            com.bumptech.glide.request.RequestOptions r3 = (com.bumptech.glide.request.RequestOptions) r3     // Catch:{ NoSuchMethodError -> 0x0597 }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x0597 }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r13)     // Catch:{ NoSuchMethodError -> 0x0597 }
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.error(r4)     // Catch:{ NoSuchMethodError -> 0x0597 }
            com.bumptech.glide.RequestBuilder r2 = r2.apply(r3)     // Catch:{ NoSuchMethodError -> 0x0597 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x0597 }
            r2.into(r3)     // Catch:{ NoSuchMethodError -> 0x0597 }
            goto L_0x0699
        L_0x0597:
            com.clevertap.android.sdk.Logger.d(r18)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestBuilder r2 = r2.asGif()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            java.lang.String r3 = r15.media     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            goto L_0x0699
        L_0x05b5:
            boolean r5 = r15.mediaIsVideo()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r5 == 0) goto L_0x0657
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r5 = 0
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            java.lang.String r2 = r15.posterUrl     // Catch:{ NoClassDefFoundError -> 0x0696 }
            boolean r2 = r2.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r2 != 0) goto L_0x0625
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r4 = 0
            r2.setVisibility(r4)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setScaleType(r4)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x060c }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoSuchMethodError -> 0x060c }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoSuchMethodError -> 0x060c }
            java.lang.String r4 = r15.posterUrl     // Catch:{ NoSuchMethodError -> 0x060c }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r4)     // Catch:{ NoSuchMethodError -> 0x060c }
            com.bumptech.glide.request.RequestOptions r4 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x060c }
            r4.<init>()     // Catch:{ NoSuchMethodError -> 0x060c }
            android.content.Context r5 = r1.context     // Catch:{ NoSuchMethodError -> 0x060c }
            int r5 = com.clevertap.android.sdk.Utils.getThumbnailImage(r5, r3)     // Catch:{ NoSuchMethodError -> 0x060c }
            com.bumptech.glide.request.BaseRequestOptions r4 = r4.placeholder(r5)     // Catch:{ NoSuchMethodError -> 0x060c }
            com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4     // Catch:{ NoSuchMethodError -> 0x060c }
            android.content.Context r5 = r1.context     // Catch:{ NoSuchMethodError -> 0x060c }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r5, r3)     // Catch:{ NoSuchMethodError -> 0x060c }
            com.bumptech.glide.request.BaseRequestOptions r3 = r4.error(r3)     // Catch:{ NoSuchMethodError -> 0x060c }
            com.bumptech.glide.RequestBuilder r2 = r2.apply(r3)     // Catch:{ NoSuchMethodError -> 0x060c }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x060c }
            r2.into(r3)     // Catch:{ NoSuchMethodError -> 0x060c }
            goto L_0x0699
        L_0x060c:
            com.clevertap.android.sdk.Logger.d(r18)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            java.lang.String r3 = r15.posterUrl     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            goto L_0x0699
        L_0x0625:
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r5 = 0
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.setScaleType(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r2 = r1.context     // Catch:{ NoClassDefFoundError -> 0x0696 }
            int r2 = com.clevertap.android.sdk.Utils.getThumbnailImage(r2, r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r2 == r4) goto L_0x0699
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestBuilder r2 = r3.load(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            goto L_0x0699
        L_0x0657:
            boolean r3 = r15.mediaIsAudio()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r3 == 0) goto L_0x0699
            android.widget.RelativeLayout r3 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r5 = 0
            r3.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r3.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r3.setScaleType(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r5 = 0
            r3.setBackgroundColor(r5)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r3 = r1.context     // Catch:{ NoClassDefFoundError -> 0x0696 }
            int r2 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            if (r2 == r4) goto L_0x0699
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            com.bumptech.glide.RequestBuilder r2 = r3.load(r2)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x0696 }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x0696 }
            goto L_0x0699
        L_0x0695:
            r0 = 2
        L_0x0696:
            com.clevertap.android.sdk.Logger.d(r16)
        L_0x0699:
            android.content.Context r2 = r1.context
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.clevertap.android.sdk.inbox.CTInboxActivity.orientation
            if (r3 != r0) goto L_0x06b2
            android.util.DisplayMetrics r3 = r2.getDisplayMetrics()
            int r3 = r3.heightPixels
            int r3 = r3 / r0
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            int r2 = r2 / r0
            goto L_0x06cd
        L_0x06b2:
            android.util.DisplayMetrics r0 = r2.getDisplayMetrics()
            int r3 = r0.widthPixels
            java.lang.String r0 = r9.orientation
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x06cc
            float r0 = (float) r3
            r2 = 1058013184(0x3f100000, float:0.5625)
            float r0 = r0 * r2
            int r0 = java.lang.Math.round(r0)
            r2 = r3
            r3 = r0
            goto L_0x06cd
        L_0x06cc:
            r2 = r3
        L_0x06cd:
            android.widget.FrameLayout r0 = r1.progressBarFrameLayout
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r4.<init>(r2, r3)
            r0.setLayoutParams(r4)
            com.clevertap.android.sdk.inbox.CTIconMessageViewHolder$1 r0 = new com.clevertap.android.sdk.inbox.CTIconMessageViewHolder$1
            r3 = r23
            r0.<init>(r3)
            android.os.Handler r2 = new android.os.Handler
            r2.<init>()
            r4 = 2000(0x7d0, double:9.88E-321)
            r2.postDelayed(r0, r4)
            java.lang.String r0 = r15.icon     // Catch:{ NoClassDefFoundError -> 0x074c }
            boolean r0 = r0.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x074c }
            if (r0 != 0) goto L_0x0744
            android.widget.ImageView r0 = r1.iconImage     // Catch:{ NoClassDefFoundError -> 0x074c }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x074c }
            android.widget.ImageView r0 = r1.iconImage     // Catch:{ NoSuchMethodError -> 0x072b }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x072b }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoSuchMethodError -> 0x072b }
            java.lang.String r2 = r15.icon     // Catch:{ NoSuchMethodError -> 0x072b }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoSuchMethodError -> 0x072b }
            com.bumptech.glide.request.RequestOptions r2 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x072b }
            r2.<init>()     // Catch:{ NoSuchMethodError -> 0x072b }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x072b }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r13)     // Catch:{ NoSuchMethodError -> 0x072b }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder(r4)     // Catch:{ NoSuchMethodError -> 0x072b }
            com.bumptech.glide.request.RequestOptions r2 = (com.bumptech.glide.request.RequestOptions) r2     // Catch:{ NoSuchMethodError -> 0x072b }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x072b }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r13)     // Catch:{ NoSuchMethodError -> 0x072b }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.error(r4)     // Catch:{ NoSuchMethodError -> 0x072b }
            com.bumptech.glide.RequestBuilder r0 = r0.apply(r2)     // Catch:{ NoSuchMethodError -> 0x072b }
            android.widget.ImageView r2 = r1.iconImage     // Catch:{ NoSuchMethodError -> 0x072b }
            r0.into(r2)     // Catch:{ NoSuchMethodError -> 0x072b }
            goto L_0x074f
        L_0x072b:
            com.clevertap.android.sdk.Logger.d(r18)     // Catch:{ NoClassDefFoundError -> 0x074c }
            android.widget.ImageView r0 = r1.iconImage     // Catch:{ NoClassDefFoundError -> 0x074c }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x074c }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoClassDefFoundError -> 0x074c }
            java.lang.String r2 = r15.icon     // Catch:{ NoClassDefFoundError -> 0x074c }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoClassDefFoundError -> 0x074c }
            android.widget.ImageView r2 = r1.iconImage     // Catch:{ NoClassDefFoundError -> 0x074c }
            r0.into(r2)     // Catch:{ NoClassDefFoundError -> 0x074c }
            goto L_0x074f
        L_0x0744:
            android.widget.ImageView r0 = r1.iconImage     // Catch:{ NoClassDefFoundError -> 0x074c }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x074c }
            goto L_0x074f
        L_0x074c:
            com.clevertap.android.sdk.Logger.d(r16)
        L_0x074f:
            if (r14 == 0) goto L_0x0764
            android.widget.RelativeLayout r0 = r1.clickLayout
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r10 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener
            r5 = 0
            r6 = 0
            r8 = 1
            r2 = r10
            r3 = r23
            r4 = r21
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.setOnClickListener(r10)
        L_0x0764:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.CTIconMessageViewHolder.configureWithMessage(com.clevertap.android.sdk.inbox.CTInboxMessage, com.clevertap.android.sdk.inbox.CTInboxListViewFragment, int):void");
    }
}
