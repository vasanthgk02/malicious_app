package com.clevertap.android.sdk.inbox;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.clevertap.android.sdk.R$id;

public class CTSimpleMessageViewHolder extends CTInboxBaseMessageViewHolder {
    public final Button cta1;
    public final Button cta2;
    public final Button cta3;
    public final TextView message;
    public final ImageView readDot;
    public final TextView timestamp;
    public final TextView title;

    public CTSimpleMessageViewHolder(View view) {
        super(view);
        view.setTag(this);
        this.title = (TextView) view.findViewById(R$id.messageTitle);
        this.message = (TextView) view.findViewById(R$id.messageText);
        this.timestamp = (TextView) view.findViewById(R$id.timestamp);
        this.readDot = (ImageView) view.findViewById(R$id.read_circle);
        this.cta1 = (Button) view.findViewById(R$id.cta_button_1);
        this.cta2 = (Button) view.findViewById(R$id.cta_button_2);
        this.cta3 = (Button) view.findViewById(R$id.cta_button_3);
        this.mediaImage = (ImageView) view.findViewById(R$id.media_image);
        this.relativeLayout = (RelativeLayout) view.findViewById(R$id.simple_message_relative_layout);
        this.frameLayout = (FrameLayout) view.findViewById(R$id.simple_message_frame_layout);
        this.squareImage = (ImageView) view.findViewById(R$id.square_media_image);
        this.clickLayout = (RelativeLayout) view.findViewById(R$id.click_relative_layout);
        this.ctaLinearLayout = (LinearLayout) view.findViewById(R$id.cta_linear_layout);
        this.bodyRelativeLayout = (LinearLayout) view.findViewById(R$id.body_linear_layout);
        this.progressBarFrameLayout = (FrameLayout) view.findViewById(R$id.simple_progress_frame_layout);
        this.mediaLayout = (RelativeLayout) view.findViewById(R$id.media_layout);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:102|103|104|105|106) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:45|46|47|48|49) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:52|53|54|55|56) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:62|(1:64)(1:65)|66|67|68|69) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:86|87|88|89|90|119|(0)(0)|126|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:93|94|95|96|97|119|(0)(0)|126|(0)(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x05d6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0324 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x038e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x040f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x04f6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:96:0x0562 */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x066e  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x067d  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x06b5  */
    /* JADX WARNING: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x04a7 A[Catch:{ NoClassDefFoundError -> 0x065f }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x0324=Splitter:B:48:0x0324, B:55:0x038e=Splitter:B:55:0x038e, B:68:0x040f=Splitter:B:68:0x040f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:96:0x0562=Splitter:B:96:0x0562, B:89:0x04f6=Splitter:B:89:0x04f6, B:105:0x05d6=Splitter:B:105:0x05d6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configureWithMessage(com.clevertap.android.sdk.inbox.CTInboxMessage r18, com.clevertap.android.sdk.inbox.CTInboxListViewFragment r19, int r20) {
        /*
            r17 = this;
            r1 = r17
            r9 = r18
            java.lang.String r10 = "l"
            super.configureWithMessage(r18, r19, r20)
            com.clevertap.android.sdk.inbox.CTInboxListViewFragment r11 = r17.getParent()
            java.util.ArrayList<com.clevertap.android.sdk.inbox.CTInboxMessageContent> r0 = r9.inboxMessageContents
            r12 = 0
            java.lang.Object r0 = r0.get(r12)
            r13 = r0
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r13 = (com.clevertap.android.sdk.inbox.CTInboxMessageContent) r13
            android.widget.TextView r0 = r1.title
            java.lang.String r2 = r13.title
            r0.setText(r2)
            android.widget.TextView r0 = r1.title
            java.lang.String r2 = r13.titleColor
            int r2 = android.graphics.Color.parseColor(r2)
            r0.setTextColor(r2)
            android.widget.TextView r0 = r1.message
            java.lang.String r2 = r13.message
            r0.setText(r2)
            android.widget.TextView r0 = r1.message
            java.lang.String r2 = r13.messageColor
            int r2 = android.graphics.Color.parseColor(r2)
            r0.setTextColor(r2)
            android.widget.LinearLayout r0 = r1.bodyRelativeLayout
            java.lang.String r2 = r9.bgColor
            int r2 = android.graphics.Color.parseColor(r2)
            r0.setBackgroundColor(r2)
            long r2 = r9.date
            java.lang.String r0 = r1.calculateDisplayTimestamp(r2)
            android.widget.TextView r2 = r1.timestamp
            r2.setText(r0)
            android.widget.TextView r0 = r1.timestamp
            java.lang.String r2 = r13.titleColor
            int r2 = android.graphics.Color.parseColor(r2)
            r0.setTextColor(r2)
            boolean r0 = r9.isRead
            r2 = 8
            if (r0 == 0) goto L_0x0068
            android.widget.ImageView r0 = r1.readDot
            r0.setVisibility(r2)
            goto L_0x006d
        L_0x0068:
            android.widget.ImageView r0 = r1.readDot
            r0.setVisibility(r12)
        L_0x006d:
            android.widget.FrameLayout r0 = r1.frameLayout
            r0.setVisibility(r2)
            org.json.JSONArray r0 = r13.links
            r2 = 1
            r3 = 2
            if (r0 == 0) goto L_0x0271
            android.widget.LinearLayout r4 = r1.ctaLinearLayout
            r4.setVisibility(r12)
            int r4 = r0.length()
            if (r4 == r2) goto L_0x0207
            if (r4 == r3) goto L_0x0169
            r5 = 3
            if (r4 == r5) goto L_0x008a
            goto L_0x0278
        L_0x008a:
            org.json.JSONObject r6 = r0.getJSONObject(r12)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r4 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            r4.setVisibility(r12)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r4 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r13.getLinkText(r6)     // Catch:{ JSONException -> 0x025b }
            r4.setText(r5)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r4 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r13.getLinkColor(r6)     // Catch:{ JSONException -> 0x025b }
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ JSONException -> 0x025b }
            r4.setTextColor(r5)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r4 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r13.getLinkBGColor(r6)     // Catch:{ JSONException -> 0x025b }
            int r5 = android.graphics.Color.parseColor(r5)     // Catch:{ JSONException -> 0x025b }
            r4.setBackgroundColor(r5)     // Catch:{ JSONException -> 0x025b }
            org.json.JSONObject r14 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            r2.setVisibility(r12)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            java.lang.String r4 = r13.getLinkText(r14)     // Catch:{ JSONException -> 0x025b }
            r2.setText(r4)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            java.lang.String r4 = r13.getLinkColor(r14)     // Catch:{ JSONException -> 0x025b }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x025b }
            r2.setTextColor(r4)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            java.lang.String r4 = r13.getLinkBGColor(r14)     // Catch:{ JSONException -> 0x025b }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ JSONException -> 0x025b }
            r2.setBackgroundColor(r4)     // Catch:{ JSONException -> 0x025b }
            org.json.JSONObject r0 = r0.getJSONObject(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x025b }
            r2.setVisibility(r12)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkText(r0)     // Catch:{ JSONException -> 0x025b }
            r2.setText(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkColor(r0)     // Catch:{ JSONException -> 0x025b }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x025b }
            r2.setTextColor(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkBGColor(r0)     // Catch:{ JSONException -> 0x025b }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x025b }
            r2.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x025b }
            if (r11 == 0) goto L_0x0278
            android.widget.Button r15 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r8 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x025b }
            r16 = 0
            r2 = r8
            r3 = r20
            r4 = r18
            r7 = r11
            r12 = r8
            r8 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x025b }
            r15.setOnClickListener(r12)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r12 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r15 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x025b }
            r8 = 0
            r2 = r15
            r3 = r20
            r4 = r18
            r6 = r14
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x025b }
            r12.setOnClickListener(r15)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r12 = r1.cta3     // Catch:{ JSONException -> 0x025b }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r14 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta3     // Catch:{ JSONException -> 0x025b }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x025b }
            r8 = 0
            r2 = r14
            r3 = r20
            r4 = r18
            r6 = r0
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x025b }
            r12.setOnClickListener(r14)     // Catch:{ JSONException -> 0x025b }
            goto L_0x0278
        L_0x0169:
            r2 = 0
            org.json.JSONObject r6 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r3 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            r3.setVisibility(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkText(r6)     // Catch:{ JSONException -> 0x025b }
            r2.setText(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkColor(r6)     // Catch:{ JSONException -> 0x025b }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x025b }
            r2.setTextColor(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkBGColor(r6)     // Catch:{ JSONException -> 0x025b }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x025b }
            r2.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x025b }
            r2 = 1
            org.json.JSONObject r0 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkText(r0)     // Catch:{ JSONException -> 0x025b }
            r2.setText(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkColor(r0)     // Catch:{ JSONException -> 0x025b }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x025b }
            r2.setTextColor(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            java.lang.String r3 = r13.getLinkBGColor(r0)     // Catch:{ JSONException -> 0x025b }
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ JSONException -> 0x025b }
            r2.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r3 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r4 = r1.cta3     // Catch:{ JSONException -> 0x025b }
            r1.hideOneButton(r2, r3, r4)     // Catch:{ JSONException -> 0x025b }
            if (r11 == 0) goto L_0x0278
            android.widget.Button r12 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r14 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x025b }
            r8 = 0
            r2 = r14
            r3 = r20
            r4 = r18
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x025b }
            r12.setOnClickListener(r14)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r12 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r14 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x025b }
            r8 = 0
            r2 = r14
            r3 = r20
            r4 = r18
            r6 = r0
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x025b }
            r12.setOnClickListener(r14)     // Catch:{ JSONException -> 0x025b }
            goto L_0x0278
        L_0x0207:
            r2 = 0
            org.json.JSONObject r6 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            r0.setVisibility(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r2 = r13.getLinkText(r6)     // Catch:{ JSONException -> 0x025b }
            r0.setText(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r2 = r13.getLinkColor(r6)     // Catch:{ JSONException -> 0x025b }
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ JSONException -> 0x025b }
            r0.setTextColor(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.String r2 = r13.getLinkBGColor(r6)     // Catch:{ JSONException -> 0x025b }
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ JSONException -> 0x025b }
            r0.setBackgroundColor(r2)     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta2     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r3 = r1.cta3     // Catch:{ JSONException -> 0x025b }
            r1.hideTwoButtons(r0, r2, r3)     // Catch:{ JSONException -> 0x025b }
            if (r11 == 0) goto L_0x0278
            android.widget.Button r0 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r12 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener     // Catch:{ JSONException -> 0x025b }
            android.widget.Button r2 = r1.cta1     // Catch:{ JSONException -> 0x025b }
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ JSONException -> 0x025b }
            java.lang.String r5 = r2.toString()     // Catch:{ JSONException -> 0x025b }
            r8 = 0
            r2 = r12
            r3 = r20
            r4 = r18
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x025b }
            r0.setOnClickListener(r12)     // Catch:{ JSONException -> 0x025b }
            goto L_0x0278
        L_0x025b:
            r0 = move-exception
            java.lang.String r2 = "Error parsing CTA JSON - "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r0 = r0.getLocalizedMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.clevertap.android.sdk.Logger.d(r0)
            goto L_0x0278
        L_0x0271:
            android.widget.LinearLayout r0 = r1.ctaLinearLayout
            r2 = 8
            r0.setVisibility(r2)
        L_0x0278:
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
            java.lang.String r0 = r9.orientation     // Catch:{ NoClassDefFoundError -> 0x065e }
            int r2 = r0.hashCode()     // Catch:{ NoClassDefFoundError -> 0x065e }
            r3 = 108(0x6c, float:1.51E-43)
            r4 = -1
            if (r2 == r3) goto L_0x02be
            r3 = 112(0x70, float:1.57E-43)
            if (r2 == r3) goto L_0x02b4
            goto L_0x02c6
        L_0x02b4:
            java.lang.String r2 = "p"
            boolean r0 = r0.equals(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            if (r0 == 0) goto L_0x02c6
            r0 = 1
            goto L_0x02c7
        L_0x02be:
            boolean r0 = r0.equals(r10)     // Catch:{ NoClassDefFoundError -> 0x065e }
            if (r0 == 0) goto L_0x02c6
            r0 = 0
            goto L_0x02c7
        L_0x02c6:
            r0 = -1
        L_0x02c7:
            java.lang.String r2 = "ct_audio"
            java.lang.String r3 = "ct_video_1"
            java.lang.String r5 = "CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info"
            java.lang.String r6 = "ct_image"
            if (r0 == 0) goto L_0x04a7
            r7 = 1
            if (r0 == r7) goto L_0x02d6
            goto L_0x03aa
        L_0x02d6:
            boolean r0 = r13.mediaIsImage()     // Catch:{ NoClassDefFoundError -> 0x065e }
            if (r0 == 0) goto L_0x033d
            android.widget.RelativeLayout r0 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065e }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.setScaleType(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x0324 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x0324 }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoSuchMethodError -> 0x0324 }
            java.lang.String r2 = r13.media     // Catch:{ NoSuchMethodError -> 0x0324 }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoSuchMethodError -> 0x0324 }
            com.bumptech.glide.request.RequestOptions r2 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x0324 }
            r2.<init>()     // Catch:{ NoSuchMethodError -> 0x0324 }
            android.content.Context r3 = r1.context     // Catch:{ NoSuchMethodError -> 0x0324 }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r6)     // Catch:{ NoSuchMethodError -> 0x0324 }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder(r3)     // Catch:{ NoSuchMethodError -> 0x0324 }
            com.bumptech.glide.request.RequestOptions r2 = (com.bumptech.glide.request.RequestOptions) r2     // Catch:{ NoSuchMethodError -> 0x0324 }
            android.content.Context r3 = r1.context     // Catch:{ NoSuchMethodError -> 0x0324 }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r6)     // Catch:{ NoSuchMethodError -> 0x0324 }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.error(r3)     // Catch:{ NoSuchMethodError -> 0x0324 }
            com.bumptech.glide.RequestBuilder r0 = r0.apply(r2)     // Catch:{ NoSuchMethodError -> 0x0324 }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x0324 }
            r0.into(r2)     // Catch:{ NoSuchMethodError -> 0x0324 }
            goto L_0x03aa
        L_0x0324:
            com.clevertap.android.sdk.Logger.d(r5)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x065e }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoClassDefFoundError -> 0x065e }
            java.lang.String r2 = r13.media     // Catch:{ NoClassDefFoundError -> 0x065e }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.into(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            goto L_0x03aa
        L_0x033d:
            boolean r0 = r13.mediaIsGIF()     // Catch:{ NoClassDefFoundError -> 0x065e }
            if (r0 == 0) goto L_0x03ad
            android.widget.RelativeLayout r0 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065e }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.setScaleType(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x038e }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x038e }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoSuchMethodError -> 0x038e }
            com.bumptech.glide.RequestBuilder r0 = r0.asGif()     // Catch:{ NoSuchMethodError -> 0x038e }
            java.lang.String r2 = r13.media     // Catch:{ NoSuchMethodError -> 0x038e }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoSuchMethodError -> 0x038e }
            com.bumptech.glide.request.RequestOptions r2 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x038e }
            r2.<init>()     // Catch:{ NoSuchMethodError -> 0x038e }
            android.content.Context r3 = r1.context     // Catch:{ NoSuchMethodError -> 0x038e }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r6)     // Catch:{ NoSuchMethodError -> 0x038e }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.placeholder(r3)     // Catch:{ NoSuchMethodError -> 0x038e }
            com.bumptech.glide.request.RequestOptions r2 = (com.bumptech.glide.request.RequestOptions) r2     // Catch:{ NoSuchMethodError -> 0x038e }
            android.content.Context r3 = r1.context     // Catch:{ NoSuchMethodError -> 0x038e }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r6)     // Catch:{ NoSuchMethodError -> 0x038e }
            com.bumptech.glide.request.BaseRequestOptions r2 = r2.error(r3)     // Catch:{ NoSuchMethodError -> 0x038e }
            com.bumptech.glide.RequestBuilder r0 = r0.apply(r2)     // Catch:{ NoSuchMethodError -> 0x038e }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x038e }
            r0.into(r2)     // Catch:{ NoSuchMethodError -> 0x038e }
            goto L_0x03aa
        L_0x038e:
            com.clevertap.android.sdk.Logger.d(r5)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x065e }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoClassDefFoundError -> 0x065e }
            com.bumptech.glide.RequestBuilder r0 = r0.asGif()     // Catch:{ NoClassDefFoundError -> 0x065e }
            java.lang.String r2 = r13.media     // Catch:{ NoClassDefFoundError -> 0x065e }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.into(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
        L_0x03aa:
            r0 = 2
            goto L_0x0664
        L_0x03ad:
            boolean r0 = r13.mediaIsVideo()     // Catch:{ NoClassDefFoundError -> 0x065e }
            if (r0 == 0) goto L_0x0468
            java.lang.String r0 = r13.posterUrl     // Catch:{ NoClassDefFoundError -> 0x065e }
            boolean r0 = r0.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x065e }
            if (r0 != 0) goto L_0x0428
            android.widget.RelativeLayout r0 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065e }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.setVisibility(r2)     // Catch:{ NoClassDefFoundError -> 0x065e }
            int r0 = com.clevertap.android.sdk.inbox.CTInboxActivity.orientation     // Catch:{ NoClassDefFoundError -> 0x065e }
            r2 = 2
            if (r0 != r2) goto L_0x03d3
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.setScaleType(r4)     // Catch:{ NoClassDefFoundError -> 0x065e }
            goto L_0x03da
        L_0x03d3:
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.setScaleType(r4)     // Catch:{ NoClassDefFoundError -> 0x065e }
        L_0x03da:
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x040f }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoSuchMethodError -> 0x040f }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoSuchMethodError -> 0x040f }
            java.lang.String r4 = r13.posterUrl     // Catch:{ NoSuchMethodError -> 0x040f }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r4)     // Catch:{ NoSuchMethodError -> 0x040f }
            com.bumptech.glide.request.RequestOptions r4 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x040f }
            r4.<init>()     // Catch:{ NoSuchMethodError -> 0x040f }
            android.content.Context r6 = r1.context     // Catch:{ NoSuchMethodError -> 0x040f }
            int r6 = com.clevertap.android.sdk.Utils.getThumbnailImage(r6, r3)     // Catch:{ NoSuchMethodError -> 0x040f }
            com.bumptech.glide.request.BaseRequestOptions r4 = r4.placeholder(r6)     // Catch:{ NoSuchMethodError -> 0x040f }
            com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4     // Catch:{ NoSuchMethodError -> 0x040f }
            android.content.Context r6 = r1.context     // Catch:{ NoSuchMethodError -> 0x040f }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r6, r3)     // Catch:{ NoSuchMethodError -> 0x040f }
            com.bumptech.glide.request.BaseRequestOptions r3 = r4.error(r3)     // Catch:{ NoSuchMethodError -> 0x040f }
            com.bumptech.glide.RequestBuilder r0 = r0.apply(r3)     // Catch:{ NoSuchMethodError -> 0x040f }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoSuchMethodError -> 0x040f }
            r0.into(r3)     // Catch:{ NoSuchMethodError -> 0x040f }
            goto L_0x03aa
        L_0x040f:
            com.clevertap.android.sdk.Logger.d(r5)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r0 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.content.Context r0 = r0.getContext()     // Catch:{ NoClassDefFoundError -> 0x065e }
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)     // Catch:{ NoClassDefFoundError -> 0x065e }
            java.lang.String r3 = r13.posterUrl     // Catch:{ NoClassDefFoundError -> 0x065e }
            com.bumptech.glide.RequestBuilder r0 = r0.load(r3)     // Catch:{ NoClassDefFoundError -> 0x065e }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065e }
            r0.into(r3)     // Catch:{ NoClassDefFoundError -> 0x065e }
            goto L_0x03aa
        L_0x0428:
            r0 = 2
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065f }
            r5 = 0
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            int r2 = com.clevertap.android.sdk.inbox.CTInboxActivity.orientation     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r2 != r0) goto L_0x0440
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setScaleType(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            goto L_0x0447
        L_0x0440:
            android.widget.ImageView r2 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setScaleType(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
        L_0x0447:
            android.content.Context r2 = r1.context     // Catch:{ NoClassDefFoundError -> 0x065f }
            int r2 = com.clevertap.android.sdk.Utils.getThumbnailImage(r2, r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r2 == r4) goto L_0x0664
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestBuilder r2 = r3.load(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            goto L_0x0664
        L_0x0468:
            r0 = 2
            boolean r3 = r13.mediaIsAudio()     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r3 == 0) goto L_0x0664
            android.widget.RelativeLayout r3 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065f }
            r5 = 0
            r3.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r3.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x065f }
            r3.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r3.setBackgroundColor(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r3 = r1.context     // Catch:{ NoClassDefFoundError -> 0x065f }
            int r2 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r2 == r4) goto L_0x0664
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestBuilder r2 = r3.load(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.squareImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            goto L_0x0664
        L_0x04a7:
            r0 = 2
            boolean r7 = r13.mediaIsImage()     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r7 == 0) goto L_0x0510
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065f }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x04f6 }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoSuchMethodError -> 0x04f6 }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoSuchMethodError -> 0x04f6 }
            java.lang.String r3 = r13.media     // Catch:{ NoSuchMethodError -> 0x04f6 }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoSuchMethodError -> 0x04f6 }
            com.bumptech.glide.request.RequestOptions r3 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x04f6 }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x04f6 }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x04f6 }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r6)     // Catch:{ NoSuchMethodError -> 0x04f6 }
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.placeholder(r4)     // Catch:{ NoSuchMethodError -> 0x04f6 }
            com.bumptech.glide.request.RequestOptions r3 = (com.bumptech.glide.request.RequestOptions) r3     // Catch:{ NoSuchMethodError -> 0x04f6 }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x04f6 }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r6)     // Catch:{ NoSuchMethodError -> 0x04f6 }
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.error(r4)     // Catch:{ NoSuchMethodError -> 0x04f6 }
            com.bumptech.glide.RequestBuilder r2 = r2.apply(r3)     // Catch:{ NoSuchMethodError -> 0x04f6 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x04f6 }
            r2.into(r3)     // Catch:{ NoSuchMethodError -> 0x04f6 }
            goto L_0x0664
        L_0x04f6:
            com.clevertap.android.sdk.Logger.d(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            java.lang.String r3 = r13.media     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            goto L_0x0664
        L_0x0510:
            boolean r7 = r13.mediaIsGIF()     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r7 == 0) goto L_0x0580
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065f }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setVisibility(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setScaleType(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x0562 }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoSuchMethodError -> 0x0562 }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoSuchMethodError -> 0x0562 }
            com.bumptech.glide.RequestBuilder r2 = r2.asGif()     // Catch:{ NoSuchMethodError -> 0x0562 }
            java.lang.String r3 = r13.media     // Catch:{ NoSuchMethodError -> 0x0562 }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoSuchMethodError -> 0x0562 }
            com.bumptech.glide.request.RequestOptions r3 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x0562 }
            r3.<init>()     // Catch:{ NoSuchMethodError -> 0x0562 }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x0562 }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r6)     // Catch:{ NoSuchMethodError -> 0x0562 }
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.placeholder(r4)     // Catch:{ NoSuchMethodError -> 0x0562 }
            com.bumptech.glide.request.RequestOptions r3 = (com.bumptech.glide.request.RequestOptions) r3     // Catch:{ NoSuchMethodError -> 0x0562 }
            android.content.Context r4 = r1.context     // Catch:{ NoSuchMethodError -> 0x0562 }
            int r4 = com.clevertap.android.sdk.Utils.getThumbnailImage(r4, r6)     // Catch:{ NoSuchMethodError -> 0x0562 }
            com.bumptech.glide.request.BaseRequestOptions r3 = r3.error(r4)     // Catch:{ NoSuchMethodError -> 0x0562 }
            com.bumptech.glide.RequestBuilder r2 = r2.apply(r3)     // Catch:{ NoSuchMethodError -> 0x0562 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x0562 }
            r2.into(r3)     // Catch:{ NoSuchMethodError -> 0x0562 }
            goto L_0x0664
        L_0x0562:
            com.clevertap.android.sdk.Logger.d(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestBuilder r2 = r2.asGif()     // Catch:{ NoClassDefFoundError -> 0x065f }
            java.lang.String r3 = r13.media     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            goto L_0x0664
        L_0x0580:
            boolean r6 = r13.mediaIsVideo()     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r6 == 0) goto L_0x0621
            java.lang.String r2 = r13.posterUrl     // Catch:{ NoClassDefFoundError -> 0x065f }
            boolean r2 = r2.isEmpty()     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r2 != 0) goto L_0x05ef
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065f }
            r4 = 0
            r2.setVisibility(r4)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setVisibility(r4)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setScaleType(r4)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x05d6 }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoSuchMethodError -> 0x05d6 }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoSuchMethodError -> 0x05d6 }
            java.lang.String r4 = r13.posterUrl     // Catch:{ NoSuchMethodError -> 0x05d6 }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r4)     // Catch:{ NoSuchMethodError -> 0x05d6 }
            com.bumptech.glide.request.RequestOptions r4 = new com.bumptech.glide.request.RequestOptions     // Catch:{ NoSuchMethodError -> 0x05d6 }
            r4.<init>()     // Catch:{ NoSuchMethodError -> 0x05d6 }
            android.content.Context r6 = r1.context     // Catch:{ NoSuchMethodError -> 0x05d6 }
            int r6 = com.clevertap.android.sdk.Utils.getThumbnailImage(r6, r3)     // Catch:{ NoSuchMethodError -> 0x05d6 }
            com.bumptech.glide.request.BaseRequestOptions r4 = r4.placeholder(r6)     // Catch:{ NoSuchMethodError -> 0x05d6 }
            com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4     // Catch:{ NoSuchMethodError -> 0x05d6 }
            android.content.Context r6 = r1.context     // Catch:{ NoSuchMethodError -> 0x05d6 }
            int r3 = com.clevertap.android.sdk.Utils.getThumbnailImage(r6, r3)     // Catch:{ NoSuchMethodError -> 0x05d6 }
            com.bumptech.glide.request.BaseRequestOptions r3 = r4.error(r3)     // Catch:{ NoSuchMethodError -> 0x05d6 }
            com.bumptech.glide.RequestBuilder r2 = r2.apply(r3)     // Catch:{ NoSuchMethodError -> 0x05d6 }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoSuchMethodError -> 0x05d6 }
            r2.into(r3)     // Catch:{ NoSuchMethodError -> 0x05d6 }
            goto L_0x0664
        L_0x05d6:
            com.clevertap.android.sdk.Logger.d(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r2 = r2.getContext()     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            java.lang.String r3 = r13.posterUrl     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestBuilder r2 = r2.load(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            goto L_0x0664
        L_0x05ef:
            android.widget.RelativeLayout r2 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065f }
            r5 = 0
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r2 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.setScaleType(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r2 = r1.context     // Catch:{ NoClassDefFoundError -> 0x065f }
            int r2 = com.clevertap.android.sdk.Utils.getThumbnailImage(r2, r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r2 == r4) goto L_0x0664
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestBuilder r2 = r3.load(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            goto L_0x0664
        L_0x0621:
            boolean r3 = r13.mediaIsAudio()     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r3 == 0) goto L_0x0664
            android.widget.RelativeLayout r3 = r1.mediaLayout     // Catch:{ NoClassDefFoundError -> 0x065f }
            r5 = 0
            r3.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r3.setVisibility(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView$ScaleType r6 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoClassDefFoundError -> 0x065f }
            r3.setScaleType(r6)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r3.setBackgroundColor(r5)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r3 = r1.context     // Catch:{ NoClassDefFoundError -> 0x065f }
            int r2 = com.clevertap.android.sdk.Utils.getThumbnailImage(r3, r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            if (r2 == r4) goto L_0x0664
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.content.Context r3 = r3.getContext()     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            com.bumptech.glide.RequestBuilder r2 = r3.load(r2)     // Catch:{ NoClassDefFoundError -> 0x065f }
            android.widget.ImageView r3 = r1.mediaImage     // Catch:{ NoClassDefFoundError -> 0x065f }
            r2.into(r3)     // Catch:{ NoClassDefFoundError -> 0x065f }
            goto L_0x0664
        L_0x065e:
            r0 = 2
        L_0x065f:
            java.lang.String r2 = "CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info"
            com.clevertap.android.sdk.Logger.d(r2)
        L_0x0664:
            android.content.Context r2 = r1.context
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.clevertap.android.sdk.inbox.CTInboxActivity.orientation
            if (r3 != r0) goto L_0x067d
            android.util.DisplayMetrics r3 = r2.getDisplayMetrics()
            int r3 = r3.heightPixels
            int r3 = r3 / r0
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            int r2 = r2 / r0
            goto L_0x0698
        L_0x067d:
            android.util.DisplayMetrics r0 = r2.getDisplayMetrics()
            int r3 = r0.widthPixels
            java.lang.String r0 = r9.orientation
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x0697
            float r0 = (float) r3
            r2 = 1058013184(0x3f100000, float:0.5625)
            float r0 = r0 * r2
            int r0 = java.lang.Math.round(r0)
            r2 = r3
            r3 = r0
            goto L_0x0698
        L_0x0697:
            r2 = r3
        L_0x0698:
            android.widget.FrameLayout r0 = r1.progressBarFrameLayout
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r4.<init>(r2, r3)
            r0.setLayoutParams(r4)
            com.clevertap.android.sdk.inbox.CTSimpleMessageViewHolder$1 r0 = new com.clevertap.android.sdk.inbox.CTSimpleMessageViewHolder$1
            r3 = r20
            r0.<init>(r3)
            android.os.Handler r2 = new android.os.Handler
            r2.<init>()
            r4 = 2000(0x7d0, double:9.88E-321)
            r2.postDelayed(r0, r4)
            if (r11 == 0) goto L_0x06c8
            android.widget.RelativeLayout r0 = r1.clickLayout
            com.clevertap.android.sdk.inbox.CTInboxButtonClickListener r10 = new com.clevertap.android.sdk.inbox.CTInboxButtonClickListener
            r5 = 0
            r6 = 0
            r8 = 1
            r2 = r10
            r3 = r20
            r4 = r18
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.setOnClickListener(r10)
        L_0x06c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.CTSimpleMessageViewHolder.configureWithMessage(com.clevertap.android.sdk.inbox.CTInboxMessage, com.clevertap.android.sdk.inbox.CTInboxListViewFragment, int):void");
    }
}
