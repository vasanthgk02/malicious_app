package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat.WearableExtender;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Message.MessageType;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.UnknownFragment;
import com.freshchat.consumer.sdk.j.ak;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cf;
import com.freshchat.consumer.sdk.j.cj;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.cv;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.j.p;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.k.l;
import com.freshchat.consumer.sdk.ui.CalendarEventCardView;
import com.freshchat.consumer.sdk.ui.CarouselCardView;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d extends Adapter<ViewHolder> {
    public static final String TAG = "com.freshchat.consumer.sdk.a.d";
    public final List<Message> aM;
    public final Map<String, Participant> aN;
    public com.freshchat.consumer.sdk.ui.CarouselCardView.a bn;
    public f bo;
    public final Drawable cA;
    public final Drawable cB;
    public final int cC;
    public final String cD;
    public final String cE;
    public final String cF;
    public final int cK;
    public final com.freshchat.consumer.sdk.b.e cL;
    public final int cM;
    public final int cN;
    public final boolean cO;
    public final HashMap<String, com.freshchat.consumer.sdk.i.c> cP = new HashMap<>();
    public final com.freshchat.consumer.sdk.j.cj.a cX;
    public final Context context;
    public final LayoutInflater cr;
    public final ak cy;
    public final Drawable cz;
    public Boolean fM;
    public final c lZ;
    public boolean ma;
    public final int mb = com.freshchat.consumer.sdk.j.cf.a.CAROUSEL.asInt();
    public final int mc = com.freshchat.consumer.sdk.j.cf.a.CAROUSEL_CARD.asInt();
    public final g oq;
    public final int or = com.freshchat.consumer.sdk.j.cf.a.CALENDAR_EVENT.asInt();
    public Set<Long> pU = new HashSet();
    public int pV;
    public final float qy;
    public final float qz;

    public static class a extends ViewHolder {
        public final ImageView nF;
        public final CalendarEventCardView ou;
        public final TextView ov;

        public a(View view) {
            super(view);
            this.ou = (CalendarEventCardView) view.findViewById(R.id.freshchat_calendar_event);
            this.ov = (TextView) view.findViewById(R.id.freshchat_message_time);
            this.nF = (ImageView) view.findViewById(R.id.freshchat_message_upload_status);
        }

        public void a(l lVar) {
            this.ou.setCalendarTimeSlotMessageViewModel(lVar);
        }

        public ImageView hk() {
            return this.nF;
        }

        public TextView hv() {
            return this.ov;
        }
    }

    public static class b extends ViewHolder {
        public final CarouselCardView mW;
        public final TextView no;

        public b(View view) {
            super(view);
            this.mW = (CarouselCardView) view.findViewById(R.id.freshchat_carousel_card);
            this.no = (TextView) view.findViewById(R.id.freshchat_message_time);
        }

        public CarouselCardView aZ() {
            return this.mW;
        }

        public TextView ba() {
            return this.no;
        }
    }

    public static class c extends ItemDecoration {
        public final int np;

        public c(int i) {
            this.np = i;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (rect != null) {
                rect.right = this.np;
            }
        }
    }

    /* renamed from: com.freshchat.consumer.sdk.a.d$d  reason: collision with other inner class name */
    public static class C0024d extends e {
        public final RecyclerView cG;

        public C0024d(View view) {
            super(view);
            this.cG = (RecyclerView) view.findViewById(R.id.freshchat_message_carousel_recycler_view);
        }

        public RecyclerView ay() {
            return this.cG;
        }
    }

    public static class e extends ViewHolder {
        public final RelativeLayout nA;
        public final LinearLayout nB;
        public final ImageView nC;
        public final TextView nD;
        public final TextView nE;
        public final ImageView nF;
        public final RelativeLayout nz;
        public final LinearLayout qB;
        public final View qC;
        public final View qD;

        public e(View view) {
            super(view);
            this.nz = (RelativeLayout) view.findViewById(R.id.freshchat_message_root);
            this.nA = (RelativeLayout) view.findViewById(R.id.freshchat_message_content_wrapper);
            this.nB = (LinearLayout) view.findViewById(R.id.freshchat_message_fragment_wrapper);
            this.nC = (ImageView) view.findViewById(R.id.freshchat_message_avatar);
            this.nD = (TextView) view.findViewById(R.id.freshchat_message_user_name);
            this.nE = (TextView) view.findViewById(R.id.freshchat_message_time);
            this.nF = (ImageView) view.findViewById(R.id.freshchat_message_upload_status);
            this.qC = view.findViewById(R.id.freshchat_show_original_content_btn);
            View findViewById = view.findViewById(R.id.freshchat_original_message_container);
            this.qD = findViewById;
            this.qB = (LinearLayout) findViewById.findViewById(R.id.freshchat_message_fragment_wrapper);
        }

        public RelativeLayout bc() {
            return this.nz;
        }

        public RelativeLayout bd() {
            return this.nA;
        }

        public LinearLayout hg() {
            return this.nB;
        }

        public ImageView hh() {
            return this.nC;
        }

        public TextView hi() {
            return this.nD;
        }

        public TextView hj() {
            return this.nE;
        }

        public ImageView hk() {
            return this.nF;
        }

        public LinearLayout ip() {
            return this.qB;
        }

        public View iq() {
            return this.qC;
        }

        public View ir() {
            return this.qD;
        }
    }

    public interface f {
        void f(Message message);
    }

    public interface g {
        void a(Message message, boolean z);
    }

    public class h implements OnLongClickListener {
        public final Message gz;
        public final g oq;
        public final boolean qE;

        public h(Message message, g gVar, boolean z) {
            this.qE = z;
            this.gz = message;
            this.oq = gVar;
        }

        public boolean onLongClick(View view) {
            g gVar = this.oq;
            if (gVar == null) {
                return false;
            }
            gVar.a(this.gz, this.qE);
            return true;
        }
    }

    public d(Context context2, List<Message> list, Map<String, Participant> map, g gVar, com.freshchat.consumer.sdk.j.cj.a aVar) {
        this.context = context2;
        this.aM = list;
        this.cr = LayoutInflater.from(context2);
        this.cL = com.freshchat.consumer.sdk.b.e.i(context2.getApplicationContext());
        this.cy = new ak(context2);
        this.aN = map;
        this.cO = this.cL.isTeamMemberInfoVisible();
        this.cC = aq.a(context2, R.attr.freshchatTeamMemberAvatarIcon, false);
        this.cB = com.freshchat.consumer.sdk.j.g.Q(context2);
        this.lZ = new c(context2.getResources().getDimensionPixelSize(R.dimen.freshchat_category_icon_padding));
        this.pV = context2.getResources().getDimensionPixelSize(R.dimen.freshchat_translation_toggle_btn_dimension);
        this.cM = aq.j(context2, R.attr.freshchatChatBubbleLeft);
        this.cN = aq.j(context2, R.attr.freshchatChatBubbleRight);
        this.cK = (int) (((float) p.ar(context2)) * 0.2f);
        Resources resources = context2.getResources();
        this.cA = resources.getDrawable(R.drawable.freshchat_ic_message_status_sent);
        this.cz = resources.getDrawable(R.drawable.freshchat_ic_message_status_pending);
        this.cD = e(context2);
        this.cF = resources.getString(R.string.freshchat_chat_deeplink);
        this.cE = resources.getString(R.string.freshchat_chat_deeplink_faq);
        this.oq = gVar;
        this.cX = aVar;
        this.qy = (float) aq.o(context2, R.dimen.freshchat_message_view_line_spacing_extra);
        this.qz = aq.a(resources, R.dimen.freshchat_message_view_line_spacing_multiplier).getFloat();
    }

    private String a(Message message, boolean z, String str) {
        String str2 = null;
        if (message == null) {
            return null;
        }
        Participant n = n(message.getMessageUserAlias());
        if (n != null && as.a(n.getFirstName())) {
            str2 = n.getFirstName();
        }
        if (message.getMessageType() != MessageType.FREDDY_BOT.getIntValue() && message.getMessageType() != MessageType.BOT.getIntValue()) {
            if (z && as.a(str2)) {
                str = str2;
            }
            return str;
        } else if (!as.a(str)) {
            return str;
        } else {
            if (as.a(message.getMessageUserName())) {
                str = message.getMessageUserName();
            } else if (as.a(str2)) {
                str = str2;
            }
            return str;
        }
    }

    private void a(Context context2, TextView textView, long j) {
        int i;
        if (context2 != null && textView != null) {
            if (j > 100) {
                textView.setText(n.i(context2, j));
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    public void a(View view, boolean z) {
        Context context2;
        int i;
        if (z) {
            context2 = this.context;
            i = R.string.freshchat_content_description_hide_original_content;
        } else {
            context2 = this.context;
            i = R.string.freshchat_content_description_show_original_content;
        }
        view.setContentDescription(context2.getString(i));
    }

    private void a(LinearLayout linearLayout, Message message, boolean z, boolean z2, boolean z3) {
        linearLayout.removeAllViews();
        if (!k.isEmpty(message.getMessageFragments())) {
            for (MessageFragment next : message.getMessageFragments()) {
                View a2 = this.cy.a(linearLayout, next, z, z3, z2, message.getAlias());
                if (a2 != null) {
                    a(z2, next, a2);
                    linearLayout.addView(a2);
                }
            }
        }
    }

    private void a(e eVar) {
        if (this.fM == null) {
            this.fM = Boolean.valueOf(eVar.hh().getVisibility() == 0);
        }
    }

    private void a(e eVar, Message message) {
        boolean z;
        boolean isUserMessage = message.isUserMessage();
        boolean z2 = true;
        if (isUserMessage) {
            eVar.bc().setHorizontalGravity(WearableExtender.DEFAULT_CONTENT_ICON_GRAVITY);
            Drawable drawable = aq.getDrawable(this.context, this.cN);
            if (drawable != null) {
                eVar.bd().setBackground(drawable);
            }
            eVar.hh().setVisibility(8);
            eVar.hi().setVisibility(8);
            eVar.hk().setVisibility(0);
            eVar.hk().setImageDrawable(g(message.getUploadState()));
            i.c(eVar.iq());
            i.a(this.context, eVar.bc(), this.cK, 0);
            i.a(this.context, eVar.hj(), R.attr.freshchatUserMessageTimeTextStyle);
            z = false;
        } else {
            boolean h2 = cv.h(this.context, message);
            eVar.bc().setHorizontalGravity(8388611);
            Drawable drawable2 = aq.getDrawable(this.context, this.cM);
            if (drawable2 != null) {
                eVar.bd().setBackground(drawable2);
            }
            c(eVar, message);
            String a2 = a(message, this.cO, this.cD);
            if (as.a(a2)) {
                eVar.hi().setVisibility(0);
                eVar.hi().setText(a2);
            } else {
                eVar.hi().setVisibility(8);
            }
            eVar.hk().setVisibility(8);
            i.a(this.context, eVar.bc(), 0, this.cK);
            i.a(this.context, eVar.hj(), R.attr.freshchatTeamMemberMessageTimeTextStyle);
            a(eVar, message, h2);
            a(eVar.iq(), eVar.ir().getVisibility() == 0);
            z = h2;
        }
        i.c(eVar.ir());
        eVar.hj().setVisibility(0);
        a(eVar.hg(), message, z, isUserMessage, true);
        if (this.pU.contains(Long.valueOf(message.getId()))) {
            b(eVar, message, z);
        }
        View iq = eVar.iq();
        if (eVar.ir().getVisibility() != 0) {
            z2 = false;
        }
        a(iq, z2);
        a(message, eVar.hg());
        a(this.context, eVar.hj(), message.getCreatedMillis());
        b(eVar, message);
    }

    private void a(e eVar, Message message, boolean z) {
        View iq = eVar.iq();
        if (!z) {
            i.c(iq);
            return;
        }
        i.b(iq);
        if (this.pV == 0) {
            iq.post(new h(this, iq, eVar));
        } else {
            i.a(this.context, eVar.bc(), 0, this.cK - this.pV);
        }
        p pVar = new p(this, eVar, message, z, iq);
        iq.setOnClickListener(pVar);
    }

    private void a(Message message, LinearLayout linearLayout) {
        MessageType messageTypeFromIntValue = MessageType.getMessageTypeFromIntValue(message.getMessageType());
        if (!message.isResponded() && cm.u(message)) {
            linearLayout.addView(cj.a(this.context, linearLayout, message, this.cX));
        } else if (messageTypeFromIntValue == MessageType.MESSAGE_TYPE_CALENDER_INVITE_CANCELLED_BY_USER) {
            TextView textView = (TextView) linearLayout.findViewById(R.id.freshchat_text);
            textView.setCompoundDrawablesWithIntrinsicBounds(this.context.getResources().getDrawable(aq.j(this.context, R.attr.freshchatCalendarCancelInviteIcon)), null, null, null);
            textView.setCompoundDrawablePadding(aq.o(this.context, R.dimen.freshchat_calendar_cancel_invite_icon_padding));
        }
    }

    private void a(boolean z, MessageFragment messageFragment, View view) {
        TextView textView;
        int i;
        if (messageFragment.getFragmentType() == FragmentType.TEXT.asInt() || messageFragment.getFragmentType() == FragmentType.QUICK_REPLY_BUTTON.asInt()) {
            textView = (TextView) view.findViewById(R.id.freshchat_text);
            i = z ? R.attr.freshchatUserMessageTextStyle : R.attr.freshchatTeamMemberMessageTextStyle;
        } else if (messageFragment instanceof UnknownFragment) {
            textView = (TextView) view.findViewById(R.id.freshchat_unknown_fragment_text);
            i = z ? R.attr.freshchatUnsupportedUserMessageTextStyle : R.attr.freshchatUnsupportedTeamMemberMessageTextStyle;
        } else {
            textView = null;
            i = 0;
        }
        if (textView != null) {
            i.a(this.context, textView, i);
        }
    }

    private void b(e eVar, Message message) {
        h hVar = new h(message, this.oq, true);
        eVar.bc().setOnLongClickListener(hVar);
        eVar.hg().setOnLongClickListener(hVar);
    }

    /* access modifiers changed from: private */
    public void b(e eVar, Message message, boolean z) {
        a(eVar.ip(), message, z, false, false);
        i.b(eVar.ir());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r4.cO != false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.freshchat.consumer.sdk.a.d.e r5, com.freshchat.consumer.sdk.beans.Message r6) {
        /*
            r4 = this;
            android.widget.ImageView r5 = r5.hh()     // Catch:{ Exception -> 0x008d }
            java.lang.Boolean r0 = r4.fM     // Catch:{ Exception -> 0x008d }
            if (r0 == 0) goto L_0x0087
            java.lang.Boolean r0 = r4.fM     // Catch:{ Exception -> 0x008d }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x008d }
            if (r0 == 0) goto L_0x0087
            r0 = 0
            r5.setVisibility(r0)     // Catch:{ Exception -> 0x008d }
            r0 = 0
            if (r6 == 0) goto L_0x0048
            java.lang.String r1 = r6.getMessageUserAlias()     // Catch:{ Exception -> 0x008d }
            com.freshchat.consumer.sdk.beans.Participant r1 = r4.n(r1)     // Catch:{ Exception -> 0x008d }
            if (r1 == 0) goto L_0x0026
            java.lang.String r1 = r1.getProfilePicUrl()     // Catch:{ Exception -> 0x008d }
            goto L_0x0027
        L_0x0026:
            r1 = r0
        L_0x0027:
            int r2 = r6.getMessageType()     // Catch:{ Exception -> 0x008d }
            com.freshchat.consumer.sdk.beans.Message$MessageType r3 = com.freshchat.consumer.sdk.beans.Message.MessageType.FREDDY_BOT     // Catch:{ Exception -> 0x008d }
            int r3 = r3.getIntValue()     // Catch:{ Exception -> 0x008d }
            if (r2 != r3) goto L_0x0043
            java.lang.String r0 = r6.getMessageUserProfilePic()     // Catch:{ Exception -> 0x008d }
            boolean r0 = com.freshchat.consumer.sdk.j.as.a(r0)     // Catch:{ Exception -> 0x008d }
            if (r0 == 0) goto L_0x0047
            java.lang.String r6 = r6.getMessageUserProfilePic()     // Catch:{ Exception -> 0x008d }
            r0 = r6
            goto L_0x0048
        L_0x0043:
            boolean r6 = r4.cO     // Catch:{ Exception -> 0x008d }
            if (r6 == 0) goto L_0x0048
        L_0x0047:
            r0 = r1
        L_0x0048:
            boolean r6 = com.freshchat.consumer.sdk.j.as.a(r0)     // Catch:{ Exception -> 0x008d }
            if (r6 == 0) goto L_0x0073
            com.freshchat.consumer.sdk.FreshchatImageLoaderRequest$a r6 = new com.freshchat.consumer.sdk.FreshchatImageLoaderRequest$a     // Catch:{ Exception -> 0x008d }
            r6.<init>(r0)     // Catch:{ Exception -> 0x008d }
            int r0 = r5.getWidth()     // Catch:{ Exception -> 0x008d }
            int r1 = r5.getHeight()     // Catch:{ Exception -> 0x008d }
            com.freshchat.consumer.sdk.FreshchatImageLoaderRequest$a r6 = r6.a(r0, r1)     // Catch:{ Exception -> 0x008d }
            com.freshchat.consumer.sdk.FreshchatImageLoaderRequest$TransformType r0 = com.freshchat.consumer.sdk.FreshchatImageLoaderRequest.TransformType.CIRCULAR     // Catch:{ Exception -> 0x008d }
            com.freshchat.consumer.sdk.FreshchatImageLoaderRequest$a r6 = r6.a(r0)     // Catch:{ Exception -> 0x008d }
            com.freshchat.consumer.sdk.FreshchatImageLoaderRequest r6 = r6.dM()     // Catch:{ Exception -> 0x008d }
            com.freshchat.consumer.sdk.FreshchatImageLoader r0 = com.freshchat.consumer.sdk.j.af.eK()     // Catch:{ Exception -> 0x008d }
            if (r0 == 0) goto L_0x0072
            r0.load(r6, r5)     // Catch:{ Exception -> 0x008d }
        L_0x0072:
            return
        L_0x0073:
            int r6 = r4.cC     // Catch:{ Exception -> 0x008d }
            if (r6 <= 0) goto L_0x007d
            int r6 = r4.cC     // Catch:{ Exception -> 0x008d }
            r5.setImageResource(r6)     // Catch:{ Exception -> 0x008d }
            return
        L_0x007d:
            android.graphics.drawable.Drawable r6 = r4.cB     // Catch:{ Exception -> 0x008d }
            if (r6 == 0) goto L_0x0091
            android.graphics.drawable.Drawable r6 = r4.cB     // Catch:{ Exception -> 0x008d }
            r5.setImageDrawable(r6)     // Catch:{ Exception -> 0x008d }
            return
        L_0x0087:
            r6 = 8
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x008d }
            return
        L_0x008d:
            r5 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r5)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.a.d.c(com.freshchat.consumer.sdk.a.d$e, com.freshchat.consumer.sdk.beans.Message):void");
    }

    private String e(Context context2) {
        return context2.getString(R.string.freshchat_default_agent_name);
    }

    private Message f(int i) {
        List<Message> list = this.aM;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.aM.get(i);
    }

    private Drawable g(int i) {
        return i == 1 ? this.cA : this.cz;
    }

    private Participant n(String str) {
        if (!as.a(str) || !k.d(this.aN)) {
            return null;
        }
        return this.aN.get(str);
    }

    public void a(f fVar) {
        this.bo = fVar;
    }

    public void a(com.freshchat.consumer.sdk.ui.CarouselCardView.a aVar) {
        this.bn = aVar;
    }

    public int getItemCount() {
        return k.b((Collection<?>) this.aM);
    }

    public int getItemViewType(int i) {
        Message f2 = f(i);
        boolean z = true;
        if (i != getItemCount() - 1) {
            z = false;
        }
        return cf.a(f2, z, this.ma).asInt();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Context context2;
        TextView hv;
        long createdMillis;
        e eVar;
        try {
            Message message = this.aM.get(i);
            if (viewHolder instanceof C0024d) {
                C0024d dVar = (C0024d) viewHolder;
                List<MessageFragment> k = cf.k(message);
                if (k.a(k)) {
                    dVar.ay().setAdapter(new g(this.context, k, this.bn));
                }
                if (this.bo != null) {
                    this.bo.f(message);
                }
                eVar = (e) viewHolder;
            } else if (viewHolder instanceof e) {
                eVar = (e) viewHolder;
            } else {
                if (viewHolder instanceof b) {
                    b bVar = (b) viewHolder;
                    CarouselCardDefaultFragment m = cf.m(message);
                    if (m != null) {
                        m.setSelected(true);
                        bVar.aZ().setData(m);
                        bVar.aZ().setUploadedStateDrawable(g(message.getUploadState()));
                    }
                    context2 = this.context;
                    hv = bVar.ba();
                    createdMillis = message.getCreatedMillis();
                } else if (viewHolder instanceof a) {
                    a aVar = (a) viewHolder;
                    CalendarEventFragment s = cm.s(message);
                    if (s != null) {
                        l lVar = new l(this.context);
                        lVar.b(s);
                        lVar.y(message.isUploaded());
                        lVar.br(cm.a(this.aN, message));
                        aVar.a(lVar);
                    }
                    aVar.hk().setImageDrawable(g(message.getUploadState()));
                    context2 = this.context;
                    hv = aVar.hv();
                    createdMillis = message.getCreatedMillis();
                } else {
                    return;
                }
                a(context2, hv, createdMillis);
                return;
            }
            a(eVar, message);
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == this.mb) {
            C0024d dVar = new C0024d(LayoutInflater.from(this.context).inflate(R.layout.freshchat_listitem_carousel, viewGroup, false));
            dVar.ay().setLayoutManager(new LinearLayoutManager(this.context, 0, false));
            dVar.ay().addItemDecoration(this.lZ);
            a((e) dVar);
            return dVar;
        } else if (i == this.mc) {
            return new b(this.cr.inflate(R.layout.freshchat_listitem_carousel_card, viewGroup, false));
        } else {
            if (i == this.or) {
                return new a(this.cr.inflate(R.layout.freshchat_list_item_calendar_event, viewGroup, false));
            }
            e eVar = new e(LayoutInflater.from(this.context).inflate(R.layout.freshchat_listitem_message, viewGroup, false));
            a(eVar);
            return eVar;
        }
    }

    public void x(boolean z) {
        this.ma = z;
    }
}
