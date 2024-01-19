package com.freshchat.consumer.sdk.activity;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.core.content.ContextCompat;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.aa;
import com.freshchat.consumer.sdk.a.d;
import com.freshchat.consumer.sdk.a.d.f;
import com.freshchat.consumer.sdk.a.y;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.beans.Csat.CSatStatus;
import com.freshchat.consumer.sdk.beans.CsatResponse;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Message.MessageType;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.QuickActions;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.beans.fragment.AudioFragment;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.ImageFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyDropDownFragment;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.beans.reqres.CsatResponseRequest;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.j.ag;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.am;
import com.freshchat.consumer.sdk.j.an;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.ax;
import com.freshchat.consumer.sdk.j.az;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.by;
import com.freshchat.consumer.sdk.j.cj;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.cy;
import com.freshchat.consumer.sdk.j.dd;
import com.freshchat.consumer.sdk.j.de;
import com.freshchat.consumer.sdk.j.h;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.p;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.x;
import com.freshchat.consumer.sdk.k.z;
import com.freshchat.consumer.sdk.l.c.b;
import com.freshchat.consumer.sdk.m.f.a;
import com.freshchat.consumer.sdk.service.d.c;
import com.freshchat.consumer.sdk.service.d.j;
import com.freshchat.consumer.sdk.service.e.r;
import com.freshchat.consumer.sdk.service.e.t;
import com.freshchat.consumer.sdk.ui.CarouselCardView;
import com.freshchat.consumer.sdk.ui.FlowLayout;
import com.freshchat.consumer.sdk.ui.QuickActionsAutoCompleteView;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.payment.paytm.PaytmRequestConstants;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.notification.SMTNotificationConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConversationDetailActivity extends b implements ax, a {
    public static final String TAG = ConversationDetailActivity.class.getName();
    public static long aS;
    public View aA;
    public RecyclerView aB;
    public LinearLayoutManager aC;
    public View aD;
    public View aE;
    public View aF;
    public View aG;
    public ProgressBar aH;
    public TextView aI;
    public LinearLayoutManager aJ;
    public String aK;
    public Conversation aL;
    public List<Message> aM = new ArrayList();
    public Map<String, Participant> aN = new HashMap();
    public boolean aO;
    public d aQ;
    public String aR;
    public CountDownTimer aT;
    public AlertDialog aU;
    public TextWatcher aV = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
            boolean z = editable != null && editable.length() > 0;
            ConversationDetailActivity.this.aE.setAlpha(z ? 1.0f : 0.6f);
            ConversationDetailActivity.this.a(true ^ z);
            if (ConversationDetailActivity.this.dH()) {
                ConversationDetailActivity.this.onUserInteraction();
            }
            ConversationDetailActivity.this.kC();
            if (editable != null && p.aD(ConversationDetailActivity.this.getContext())) {
                i.a(ConversationDetailActivity.this.getContext(), (EditText) ConversationDetailActivity.this.bm);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    public OnClickListener aW = new OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                ConversationDetailActivity.this.aa();
            } else if (i == 1) {
                ConversationDetailActivity.this.Z();
            }
        }
    };
    public View.OnClickListener aX = new View.OnClickListener() {
        public void onClick(View view) {
            ConversationDetailActivity.this.Y();
            i.a(ConversationDetailActivity.this.getContext(), (View) ConversationDetailActivity.this.bm);
        }
    };
    public View.OnClickListener aY = new View.OnClickListener() {
        public void onClick(View view) {
            i.a(ConversationDetailActivity.this.getContext(), (View) ConversationDetailActivity.this.bm);
            ConversationDetailActivity.this.T();
        }
    };
    public OnLongClickListener aZ = new OnLongClickListener() {
        public boolean onLongClick(View view) {
            i.a(ConversationDetailActivity.this.getContext(), (View) ConversationDetailActivity.this.bm);
            ConversationDetailActivity.this.T();
            return true;
        }
    };
    public e aq;
    public g av;
    public ClipboardManager aw;
    public h ax;
    public View ay;
    public View az;
    public RecyclerView ba;
    public LoaderCallbacks<List<Message>> bb = new f(this);
    public View.OnClickListener bc = new o(this);
    public View.OnClickListener bd = new u(this);
    public View bf;
    public View bg;
    public LoaderCallbacks<Channel> bh = new n(this);
    public View bi;
    public com.freshchat.consumer.sdk.k.g bj;
    public View.OnClickListener bk = new d(this);
    public com.freshchat.consumer.sdk.a.e.a bl = new e(this);
    public QuickActionsAutoCompleteView bm;
    public CarouselCardView.a bn = new CarouselCardView.a() {
        public void a(CarouselCardDefaultFragment carouselCardDefaultFragment) {
            ConversationDetailActivity.this.ao();
            Message a2 = ConversationDetailActivity.this.lz.a(ConversationDetailActivity.this.G().bj(), (MessageFragment) carouselCardDefaultFragment, ConversationDetailActivity.this.af(), ConversationDetailActivity.this.channelId, ConversationDetailActivity.this.lz.E(ConversationDetailActivity.this.aM));
            if (a2 != null) {
                ConversationDetailActivity.this.a(a2);
                bg.a(ConversationDetailActivity.this.getContext(), carouselCardDefaultFragment);
            }
        }
    };
    public f bo = new f() {
        public void f(Message message) {
            if (message != null) {
                ConversationDetailActivity.this.lz.y(message.getId());
            }
        }
    };
    public View bp;
    public TextView bq;
    public com.freshchat.consumer.sdk.m.f cT;
    public final d.g cU = new d.g() {
        public void a(Message message, boolean z) {
            if (aw.eS() && ConversationDetailActivity.this.J() != null && message != null) {
                String string = ConversationDetailActivity.this.getString(R.string.freshchat_message_content_copied_to_clipboard);
                String a2 = c.a(ConversationDetailActivity.this.getContext(), message, z);
                if (as.a(a2)) {
                    ConversationDetailActivity.this.J().setPrimaryClip(ClipData.newPlainText(a2, a2));
                    Toast.makeText(ConversationDetailActivity.this.getContext(), string, 1).show();
                }
            }
        }
    };
    public b cW = new h(this);
    public final cj.a cX = new bu(this);
    public RecyclerView cY;
    public MenuItem cZ;
    public long channelId;
    public String channelType;
    public com.freshchat.consumer.sdk.c.e eT;
    public NetworkCallback hE;
    public de hF;
    public com.freshchat.consumer.sdk.ui.g hl;
    public View jZ;
    public TextView jn;
    public boolean jo;
    public y jp;
    public z jq;
    public List<MessageFragment> jr = new ArrayList();
    public dd js;
    public View jt;
    public View ju;
    public aa.a jv = new aa.a() {
        public void bL(String str) {
            ConversationDetailActivity.this.a(j.a.BUTTON, str);
        }
    };
    public OrientationEventListener jw;
    public long jy = -1;
    public ScrollView jz;
    public String[] lE;
    public View le;
    public View lf;
    public RemoteConfig lg;
    public com.freshchat.consumer.sdk.k.c lz;
    public int orientation;
    public QuickActions quickActions;
    public List<String> quickActionsMenuList = new ArrayList();
    public List<String> quickActionsSlashCommandList = new ArrayList();

    public static long H() {
        return aS;
    }

    public static void a(Context context, long j, long j2, boolean z, int i, String str) {
        if (j != 0 && j2 != 0) {
            new com.freshchat.consumer.sdk.c.e(context).U(Long.toString(j));
            t tVar = new t();
            CsatResponseRequest csatResponseRequest = new CsatResponseRequest();
            CsatResponse conversationId = new CsatResponse().setCsatId(j2).setIssueResolved(z).setConversationId(j);
            if (i > 0) {
                conversationId.setStars(i);
            }
            if (!as.isEmpty(str)) {
                conversationId.setResponse(str);
            }
            csatResponseRequest.setCsatResponse(conversationId);
            tVar.a(csatResponseRequest);
            com.freshchat.consumer.sdk.service.d.d.b(context, tVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public e G() {
        if (this.aq == null) {
            this.aq = e.i(getApplicationContext());
        }
        return this.aq;
    }

    /* access modifiers changed from: 0000 */
    public d I() {
        if (this.aQ == null) {
            d dVar = new d(this, this.aM, this.aN, this.cU, this.cX);
            this.aQ = dVar;
            dVar.a(this.bn);
            this.aQ.a(this.bo);
        }
        return this.aQ;
    }

    /* access modifiers changed from: 0000 */
    public ClipboardManager J() {
        if (this.aw == null && aw.eS()) {
            this.aw = (ClipboardManager) getContext().getSystemService("clipboard");
        }
        return this.aw;
    }

    /* access modifiers changed from: 0000 */
    public void K() {
        O();
        N();
        c(getIntent());
    }

    /* access modifiers changed from: 0000 */
    public void L() {
        if (this.ax != null) {
            if (M()) {
                this.ax.eh();
            }
            this.ax.el();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean M() {
        h hVar = this.ax;
        return (hVar == null || hVar.ek() == null || !this.ax.ek().M()) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    public void N() {
        if (ac().m(this.channelId) > 0 && at()) {
            com.freshchat.consumer.sdk.j.b.b(getContext(), this.channelId, this.aL.getConversationId());
        }
    }

    /* access modifiers changed from: 0000 */
    public void O() {
        try {
            Set<Long> i = ac().i(this.channelId);
            String str = TAG;
            ai.d(str, "Unread marketing Ids for channel " + this.channelId + " are " + i);
            for (Long longValue : i) {
                long longValue2 = longValue.longValue();
                com.freshchat.consumer.sdk.j.aa.g(getApplicationContext(), longValue2);
                com.freshchat.consumer.sdk.h.b.a(getContext(), 0, longValue2);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public com.freshchat.consumer.sdk.c.e P() {
        if (this.eT == null) {
            this.eT = new com.freshchat.consumer.sdk.c.e(getApplicationContext());
        }
        return this.eT;
    }

    /* access modifiers changed from: 0000 */
    public boolean Q() {
        return am.a(this, am.iE);
    }

    /* access modifiers changed from: 0000 */
    public void R() {
        if (Q()) {
            S();
            return;
        }
        this.aD.setOnClickListener(this.aY);
        this.aD.setOnLongClickListener(this.aZ);
    }

    /* access modifiers changed from: 0000 */
    public void S() {
        this.ax = new h(getApplicationContext(), this, this.channelId);
        setVolumeControlStream(3);
        com.freshchat.consumer.sdk.f.b bVar = new com.freshchat.consumer.sdk.f.b(this, this.ax);
        this.aH = (ProgressBar) findViewById(R.id.freshchat_conv_detail_voice_reply_progressbar);
        this.aI = (TextView) findViewById(R.id.freshchat_conv_detail_voice_reply_time_elapsed_text);
        this.aD.setOnClickListener(null);
        this.aD.setOnLongClickListener(null);
        this.aD.setOnTouchListener(bVar);
    }

    /* access modifiers changed from: 0000 */
    public void T() {
        String str;
        int i;
        if (aw.fa()) {
            ai.i(TAG, "Permissions required for voice messaging has NOT been granted. Requesting permission.");
            boolean shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO");
            boolean shouldShowRequestPermissionRationale2 = shouldShowRequestPermissionRationale(SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY);
            if (shouldShowRequestPermissionRationale && shouldShowRequestPermissionRationale2) {
                i = R.string.freshchat_chat_voice_messaging_permissions_rationale;
            } else if (shouldShowRequestPermissionRationale2) {
                i = R.string.freshchat_chat_voice_messaging_write_storage_permission_rationale;
            } else if (shouldShowRequestPermissionRationale) {
                i = R.string.freshchat_chat_voice_messaging_audio_recording_permission_rationale;
            } else {
                str = "";
                i.e(getContext(), str);
                requestPermissions(am.b(getContext(), am.iE), 100);
            }
            str = getString(i);
            i.e(getContext(), str);
            requestPermissions(am.b(getContext(), am.iE), 100);
        }
    }

    public void U() {
        Bundle bundle = new Bundle();
        bundle.putLong(PaytmRequestConstants.PARAMS_CHANNEL_ID, this.channelId);
        getSupportLoaderManager().restartLoader(0, bundle, this.bb);
    }

    public void V() {
        Bundle bundle = new Bundle();
        bundle.putLong(PaytmRequestConstants.PARAMS_CHANNEL_ID, this.channelId);
        bundle.putBoolean("EXTRA_FORCE_CLEAN_UP_EXPIRED_CSAT", true);
        getSupportLoaderManager().restartLoader(0, bundle, this.bh);
    }

    /* access modifiers changed from: 0000 */
    public void W() {
        if (G().bn()) {
            try {
                com.freshchat.consumer.sdk.i.c.dW();
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void X() {
        if (G().isGallerySelectionEnabled() || G().isCameraCaptureEnabled()) {
            i.b(this.aF);
        } else {
            i.c(this.aF);
        }
    }

    /* access modifiers changed from: 0000 */
    public void Y() {
        boolean isCameraCaptureEnabled = G().isCameraCaptureEnabled();
        boolean isGallerySelectionEnabled = G().isGallerySelectionEnabled();
        if (isCameraCaptureEnabled && isGallerySelectionEnabled) {
            ab();
        } else if (isCameraCaptureEnabled) {
            aa();
        } else if (isGallerySelectionEnabled) {
            Z();
        }
    }

    /* access modifiers changed from: 0000 */
    public void Z() {
        Intent intent = new Intent();
        intent.setType(az.b.TYPE_IMAGE.getType());
        intent.setAction((!aw.eY() || !getResources().getBoolean(R.bool.freshchat_document_provider_enabled)) ? "android.intent.action.GET_CONTENT" : "android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 125);
    }

    public void a(Context context, Intent intent) {
        String action = intent.getAction();
        ag.a("FRESHCHAT", intent);
        if ("com.freshchat.consumer.sdk.actions.ExpectedConversationResponseTimeUpdated".equals(action)) {
            ae();
        } else if ("com.freshchat.consumer.sdk.actions.ChannelsUpdated".equals(action) || "com.freshchat.consumer.sdk.actions.MessagesUpdated".equals(action) || "com.freshchat.consumer.sdk.actions.MessageStatusChanged".equals(action)) {
            if (!"com.freshchat.consumer.sdk.actions.MessageStatusChanged".equals(action) || ag.d(intent, PaytmRequestConstants.PARAMS_CHANNEL_ID) != this.channelId || intent.getBooleanExtra("STATUS_SUCCESS", true)) {
                if ("com.freshchat.consumer.sdk.actions.MessagesUpdated".equals(action) || "com.freshchat.consumer.sdk.actions.MessageStatusChanged".equals(action)) {
                    et();
                    ke();
                    kg();
                }
                V();
                if (this.bm.hasFocus()) {
                    this.bm.requestFocus();
                } else {
                    this.aB.requestFocus();
                }
            } else {
                i.a(getContext(), R.string.freshchat_message_sending_failed);
            }
        } else if ("com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged".equalsIgnoreCase(action) || "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated".equalsIgnoreCase(action) || ("com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount".equalsIgnoreCase(action) && ap.aZ(getContext()) && o.bB(getContext()))) {
            gb();
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Uri uri, int i) {
        startActivityForResult(PictureAttachmentActivity.a(getContext(), uri, i, this.bm.getText().toString()), 127);
    }

    /* access modifiers changed from: 0000 */
    public void a(MenuItem menuItem, boolean z) {
        int i;
        Context context;
        if (G().bo()) {
            int a2 = aq.a(getContext(), R.attr.freshchatSpeakerIcon, false);
            if (a2 > 0) {
                menuItem.setVisible(true);
                menuItem.setIcon(a2);
                if (z) {
                    context = getContext();
                    i = R.string.freshchat_speaker_phone_on;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            int a3 = aq.a(getContext(), R.attr.freshchatEarpieceIcon, false);
            if (a3 > 0) {
                menuItem.setVisible(true);
                menuItem.setIcon(a3);
                if (z) {
                    context = getContext();
                    i = R.string.freshchat_speaker_phone_off;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        i.a(context, i);
    }

    /* access modifiers changed from: 0000 */
    public void a(LinearLayoutManager linearLayoutManager) {
        if (linearLayoutManager != null) {
            ImageButton imageButton = (ImageButton) findViewById(R.id.freshchat_quick_action_button_scroll);
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            List<MessageFragment> list = this.jr;
            if (list != null && findLastVisibleItemPosition == list.size() - 1) {
                i.c(imageButton);
            } else if (findFirstCompletelyVisibleItemPosition >= 0) {
                i.b(imageButton);
            }
        }
    }

    public void a(final RecyclerView recyclerView, final LinearLayoutManager linearLayoutManager) {
        recyclerView.addOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                ConversationDetailActivity.this.a(linearLayoutManager);
            }
        });
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ConversationDetailActivity.this.km();
                ConversationDetailActivity.this.a(linearLayoutManager);
            }
        });
        kx();
        ((ImageButton) findViewById(R.id.freshchat_quick_action_button_scroll)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                recyclerView.smoothScrollToPosition(linearLayoutManager.findLastVisibleItemPosition() + 1);
            }
        });
    }

    public void a(CalendarMessageMeta calendarMessageMeta) {
        Message a2 = this.lz.a(calendarMessageMeta, af(), this.channelId);
        if (a2 != null) {
            a(a2);
            this.lz.B(a2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(CalendarMessageMeta calendarMessageMeta, TimeSlot timeSlot, int i) {
        Message a2 = this.lz.a(calendarMessageMeta, timeSlot, i, af(), this.channelId);
        if (a2 != null) {
            a(a2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Csat csat, boolean z) {
        a(csat, z, 0, (String) null);
    }

    /* access modifiers changed from: 0000 */
    public void a(Csat csat, boolean z, int i, String str) {
        a(getApplicationContext(), this.aL.getConversationId(), csat.getCsatId(), z, i, str);
        ad();
        i.e(this.bm);
    }

    /* access modifiers changed from: 0000 */
    public void a(Message message) {
        if (message != null) {
            if (i.f(this.jz)) {
                i.c(this.jz);
            }
            this.jo = true;
            bg.l(getContext(), this.channelId);
            if (!al.aS(getContext())) {
                i.a(getContext(), R.string.freshchat_error_send_message_when_no_internet);
            }
            i.e(this.bm);
            List<Message> K = this.lz.K(this.aM);
            if (k.a(K)) {
                ac().a(K, this.channelId);
                message.setAlias(cy.b(K.get(0).getCreatedMillis(), k.b((Collection<?>) K)));
            }
            if (!ac().b(message)) {
                i.a(getContext(), com.freshchat.consumer.sdk.b.c.MESSAGE_SENDING_FAILED);
                return;
            }
            cm.a(getContext(), message, this.channelId);
            V();
            if (com.freshchat.consumer.sdk.service.a.c.bd(getContext())) {
                com.freshchat.consumer.sdk.service.a.c.d(getContext(), message);
                com.freshchat.consumer.sdk.j.b.M(getContext());
            } else {
                com.freshchat.consumer.sdk.j.b.a(getContext(), message, (com.freshchat.consumer.sdk.service.a) new com.freshchat.consumer.sdk.service.a<r>() {
                    public void a(r rVar) {
                        if (rVar.isSuccess()) {
                            ConversationDetailActivity.this.aj();
                        }
                    }
                });
            }
        }
    }

    public void a(h.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.er() == null) {
                    return;
                }
                if (!as.isEmpty(aVar.er().getAbsolutePath())) {
                    Message h = h((String) "");
                    AudioFragment audioFragment = new AudioFragment();
                    audioFragment.setContent(aVar.er().getAbsolutePath());
                    audioFragment.setContentType("audio/mpeg3");
                    audioFragment.setDuration(aVar.es());
                    h.addMessageFragment(audioFragment);
                    i.a(getContext(), (View) this.bm);
                    a(h);
                    f((String) "audio");
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public void a(com.freshchat.consumer.sdk.k.c.b bVar) {
        int i;
        Resources resources;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.bm.getLayoutParams();
        int i2 = bv.tc[bVar.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            resources = getResources();
            i = R.dimen.freshchat_text_view_placeholder_margin_left;
        } else {
            resources = getResources();
            i = R.dimen.freshchat_text_view_default_margin_left;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        marginLayoutParams.leftMargin = dimensionPixelSize;
        marginLayoutParams.setMarginStart(dimensionPixelSize);
        this.bm.setLayoutParams(marginLayoutParams);
        this.bm.setHint(com.freshchat.consumer.sdk.k.c.b.d(bVar));
    }

    /* access modifiers changed from: 0000 */
    public void a(j.a aVar, String str) {
        QuickReplyButtonFragment quickReplyButtonFragment = new QuickReplyButtonFragment();
        quickReplyButtonFragment.setLabel(str);
        Message a2 = this.lz.a(G().bj(), (MessageFragment) quickReplyButtonFragment, af(), this.channelId, this.lz.E(this.aM));
        String type = aVar.getType();
        if (a2 != null) {
            a(a2);
            bg.l(getContext(), type, str);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(String str, int i, int i2, String str2) {
        try {
            Message h = h(str2);
            ImageFragment imageFragment = new ImageFragment();
            imageFragment.setContent(str);
            imageFragment.setContentType("image/jpeg");
            imageFragment.setHeight(i2);
            imageFragment.setWidth(i);
            h.addMessageFragment(imageFragment);
            a(h);
            f((String) SMTNotificationConstants.NOTIF_IMAGE_URL_KEY);
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(boolean z) {
        View view;
        if (!z || !G().bn()) {
            i.b(this.aE);
            view = this.aD;
        } else {
            i.b(this.aD);
            view = this.aE;
        }
        i.c(view);
    }

    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount", "com.freshchat.consumer.sdk.actions.MessagesUpdated", "com.freshchat.consumer.sdk.actions.ChannelsUpdated", "com.freshchat.consumer.sdk.actions.MessageStatusChanged", "com.freshchat.consumer.sdk.actions.ExpectedConversationResponseTimeUpdated", "com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged", "com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated"};
    }

    /* access modifiers changed from: 0000 */
    public View aI(String str) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.freshchat_message_chip_text, null);
        textView.setMaxLines(2);
        textView.setEllipsize(TruncateAt.END);
        textView.setText(str);
        return textView;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r0 == com.freshchat.consumer.sdk.b.k.jI) goto L_0x001d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void aX() {
        /*
            r2 = this;
            r2.ad()
            com.freshchat.consumer.sdk.k.c r0 = r2.lz
            java.util.List<com.freshchat.consumer.sdk.beans.Message> r1 = r2.aM
            com.freshchat.consumer.sdk.b.k r0 = r0.C(r1)
            com.freshchat.consumer.sdk.b.k r1 = com.freshchat.consumer.sdk.b.k.NORMAL
            if (r0 == r1) goto L_0x0012
            r2.gC()
        L_0x0012:
            com.freshchat.consumer.sdk.b.k r1 = com.freshchat.consumer.sdk.b.k.DROP_DOWN
            if (r0 == r1) goto L_0x0019
            r2.gS()
        L_0x0019:
            com.freshchat.consumer.sdk.b.k r1 = com.freshchat.consumer.sdk.b.k.NORMAL
            if (r0 != r1) goto L_0x0021
        L_0x001d:
            r2.cu()
            goto L_0x0036
        L_0x0021:
            com.freshchat.consumer.sdk.b.k r1 = com.freshchat.consumer.sdk.b.k.DROP_DOWN
            if (r0 != r1) goto L_0x0029
            r2.fS()
            goto L_0x0036
        L_0x0029:
            com.freshchat.consumer.sdk.b.k r1 = com.freshchat.consumer.sdk.b.k.CAROUSEL
            if (r0 != r1) goto L_0x0031
            r2.ap()
            goto L_0x0036
        L_0x0031:
            com.freshchat.consumer.sdk.b.k r1 = com.freshchat.consumer.sdk.b.k.CALLBACK
            if (r0 != r1) goto L_0x0036
            goto L_0x001d
        L_0x0036:
            com.freshchat.consumer.sdk.k.c r0 = r2.lz
            java.util.List<com.freshchat.consumer.sdk.beans.Message> r1 = r2.aM
            boolean r0 = r0.I(r1)
            if (r0 == 0) goto L_0x0043
            r2.ap()
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.activity.ConversationDetailActivity.aX():void");
    }

    /* access modifiers changed from: 0000 */
    public void aY() {
        I().x(false);
        aX();
        if (this.lz.C(this.aM) == com.freshchat.consumer.sdk.b.k.CAROUSEL) {
            this.aB.post(new bs(this));
        }
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(23)
    public void aa() {
        if (!aw.fa() || am.aX(getContext())) {
            try {
                this.aR = null;
                File aF2 = x.aF(getContext());
                Intent a2 = an.a(getContext(), aF2);
                if (a2 != null) {
                    if (!a2.hasExtra("HAS_ERRORS")) {
                        this.aR = aF2.getAbsolutePath();
                        startActivityForResult(a2, 126);
                        return;
                    }
                }
                String stringExtra = a2 != null ? a2.getStringExtra("ERROR_MESSAGE") : "";
                if (as.isEmpty(stringExtra)) {
                    stringExtra = com.freshchat.consumer.sdk.b.c.PICTURE_ATTACHMENT_FAILED.toString();
                }
                Toast.makeText(getContext(), stringExtra, 1).show();
            } catch (Exception e2) {
                this.aR = null;
                ai.e("FRESHCHAT", "Exception while initiating camera capture", e2);
            }
        } else {
            if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                Toast.makeText(this, getString(R.string.freshchat_chat_camera_permissions_rationale), 1).show();
            }
            requestPermissions(new String[]{"android.permission.CAMERA"}, 101);
        }
    }

    /* access modifiers changed from: 0000 */
    public void ab() {
        String[] strArr = {getString(R.string.freshchat_chat_capture_from_camera), getString(R.string.freshchat_chat_select_from_gallery)};
        Builder m = i.m(this);
        OnClickListener onClickListener = this.aW;
        AlertParams alertParams = m.P;
        alertParams.mItems = strArr;
        alertParams.mOnClickListener = onClickListener;
        m.show();
    }

    /* access modifiers changed from: 0000 */
    public g ac() {
        if (this.av == null) {
            this.av = new g(getApplicationContext());
        }
        return this.av;
    }

    /* access modifiers changed from: 0000 */
    public void ad() {
        if (!M()) {
            if (ag()) {
                ah();
            } else {
                ao();
                an();
                ar();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void ae() {
        if (this.aq.isResponseExpectationEnabled()) {
            String d2 = com.freshchat.consumer.sdk.j.r.d(this, this.channelId);
            if (getSupportActionBar() != null && as.a(d2)) {
                getSupportActionBar().setSubtitle(d2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public long af() {
        if (at()) {
            return this.aL.getConversationId();
        }
        if (!k.a(this.aM)) {
            return 0;
        }
        for (Message next : this.aM) {
            if (!c.i(next) && next.getConversationId() != 0) {
                long conversationId = next.getConversationId();
                this.aL = new Conversation(conversationId).setChannelId(this.channelId);
                return conversationId;
            }
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean ag() {
        return Channel.CHANNEL_TYPE_AGENT_ONLY.equals(this.channelType);
    }

    /* access modifiers changed from: 0000 */
    public void ah() {
        ap();
        an();
        ar();
        this.aJ.setReverseLayout(false);
        List<Message> list = this.aM;
        if (list != null && list.size() > 0) {
            this.aB.scrollToPosition(this.aM.size() - 1);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean ai() {
        return this.aO && k.b((Collection<?>) this.aM) > 1;
    }

    /* access modifiers changed from: 0000 */
    public void aj() {
        try {
            if (ai()) {
                b(gg().getRefreshIntervals().getActiveConvMinFetchInterval());
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void ak() {
        CountDownTimer countDownTimer = this.aT;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void am() {
        b(this.az);
    }

    public void an() {
        c(this.az);
    }

    public void ao() {
        gS();
        b(this.ay);
    }

    public void ap() {
        c(this.ay);
        i.a(getContext(), this.ay);
    }

    /* access modifiers changed from: 0000 */
    public void aq() {
        i.a(getContext(), (View) this.bm);
        b(this.aA);
    }

    /* access modifiers changed from: 0000 */
    public void ar() {
        c(this.aA);
    }

    /* access modifiers changed from: 0000 */
    public void as() {
        View view = this.aA;
        if (view != null) {
            View findViewById = view.findViewById(R.id.freshchat_chat_resolution_positive_btn);
            if (findViewById != null) {
                findViewById.setOnClickListener(this.bd);
            }
            View findViewById2 = this.aA.findViewById(R.id.freshchat_chat_resolution_negative_btn);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(this.bd);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean at() {
        Conversation conversation = this.aL;
        return conversation != null && conversation.getConversationId() > 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean au() {
        return at() && this.aL.getCsat() != null && this.aL.getCsat().getCsatId() > 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean av() {
        Csat csat = (!au() || !this.aL.hasPendingCsat()) ? null : this.aL.getCsat();
        boolean z = false;
        if (csat == null) {
            return false;
        }
        boolean z2 = csat.getStatus() == CSatStatus.NOT_RATED;
        if (au.a(gg()) && au.a(gg(), csat)) {
            long af = af();
            P().t(af);
            bg.c(getContext(), af, this.channelId);
            z2 = false;
        }
        if (z2 && !aw() && !M()) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean aw() {
        QuickActionsAutoCompleteView quickActionsAutoCompleteView = this.bm;
        return quickActionsAutoCompleteView != null && as.a(quickActionsAutoCompleteView.getText());
    }

    /* access modifiers changed from: 0000 */
    public boolean ax() {
        AlertDialog alertDialog = this.aU;
        return alertDialog != null && alertDialog.isShowing();
    }

    /* access modifiers changed from: 0000 */
    public Message b(CallbackButtonFragment callbackButtonFragment) {
        Message h = h(callbackButtonFragment.getLabel());
        h.setMessageType(MessageType.POSTBACK_MESSAGE.getIntValue());
        return h;
    }

    public void b(int i) {
        runOnUiThread(new bl(this, i));
    }

    /* access modifiers changed from: 0000 */
    public void b(long j) {
        try {
            ak();
            p pVar = new p(this, j, j, j, gg().getConversationConfig().getActiveConvFetchBackoffRatio(), gg().getRefreshIntervals().getActiveConvMaxFetchInterval());
            this.aT = pVar;
            pVar.start();
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(Intent intent) {
        if (intent.hasExtra(PaytmRequestConstants.PARAMS_CHANNEL_ID)) {
            this.channelId = intent.getLongExtra(PaytmRequestConstants.PARAMS_CHANNEL_ID, 0);
            if (intent.hasExtra("UNFETCHED_CHANNEL")) {
                finish();
                startActivity(new Intent(getContext(), ChannelListActivity.class));
            }
            if (intent.hasExtra("CHANNEL_NAME") && !as.isEmpty(intent.getStringExtra("CHANNEL_NAME"))) {
                this.aK = intent.getStringExtra("CHANNEL_NAME");
            }
            if (intent.hasExtra("CHANNEL_TYPE") && !as.isEmpty(intent.getStringExtra("CHANNEL_TYPE"))) {
                this.channelType = intent.getStringExtra("CHANNEL_TYPE");
            }
            this.lE = intent.getStringArrayExtra("INPUT_TAGS");
            return;
        }
        finish();
        i.a((Context) this, com.freshchat.consumer.sdk.b.c.CHANNEL_ID_MISSING);
    }

    /* access modifiers changed from: 0000 */
    public void b(View view) {
        runOnUiThread(new q(this, view));
    }

    public void b(CalendarMessageMeta calendarMessageMeta) {
        a(calendarMessageMeta);
    }

    public void b(CalendarMessageMeta calendarMessageMeta, TimeSlot timeSlot, int i) {
        a(calendarMessageMeta, timeSlot, i);
    }

    /* access modifiers changed from: 0000 */
    public void b(com.freshchat.consumer.sdk.k.c.b bVar) {
        i.b(this.jt);
        i.c(this.jZ);
        int c2 = com.freshchat.consumer.sdk.k.c.b.c(bVar);
        if (c2 != 0) {
            this.jn.setText(c2);
        } else {
            i.b(this.jZ);
        }
    }

    /* access modifiers changed from: 0000 */
    public void b(boolean z) {
        boolean z2;
        Conversation conversation = this.aL;
        if (conversation != null) {
            Csat csat = conversation.getCsat();
            if (csat != null && !ax()) {
                Builder b2 = i.b((Context) this, R.attr.freshchatCustomerSurveyDialog);
                View inflate = LayoutInflater.from(this).inflate(R.layout.freshchat_dialog_customer_survey, null);
                TextView textView = (TextView) inflate.findViewById(R.id.freshchat_custsurvey_question_text);
                RatingBar ratingBar = (RatingBar) inflate.findViewById(R.id.freshchat_custsurvey_rating_bar);
                EditText editText = (EditText) inflate.findViewById(R.id.freshchat_custsurvey_user_comment);
                if (z) {
                    String string = getString(R.string.freshchat_chat_resolution_survey_question);
                    if (as.isEmpty(string)) {
                        string = csat.getQuestion();
                    }
                    textView.setText(as.fromHtml(string));
                    z2 = csat.isMobileUserCommentsAllowed();
                } else {
                    textView.setText(getString(R.string.freshchat_chat_resolution_suggestions_prompt));
                    z2 = true;
                }
                if (z) {
                    b((View) ratingBar);
                } else {
                    c((View) ratingBar);
                }
                if (z2) {
                    b((View) editText);
                } else {
                    c((View) editText);
                }
                int i = R.string.freshchat_chat_rating_submit;
                bo boVar = new bo(this, z, ratingBar, editText, csat, z);
                b2.setPositiveButton(i, (OnClickListener) boVar);
                bp bpVar = new bp(this, csat, z);
                AlertParams alertParams = b2.P;
                alertParams.mOnCancelListener = bpVar;
                alertParams.mView = inflate;
                alertParams.mViewLayoutResId = 0;
                alertParams.mViewSpacingSpecified = false;
                this.aU = b2.create();
                ratingBar.setOnRatingBarChangeListener(new bq(this, z));
                this.aU.setOnShowListener(new br(this, z));
                this.aU.show();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        this.ay = findViewById(R.id.freshchat_conv_detail_text_reply_layout);
        this.az = findViewById(R.id.freshchat_conv_detail_voice_reply_layout);
        this.aA = findViewById(R.id.freshchat_chat_resolution_confirmation_layout);
        this.aB = (RecyclerView) findViewById(R.id.freshchat_conv_detail_list);
        this.bm = (QuickActionsAutoCompleteView) findViewById(R.id.freshchat_conv_detail_reply_text);
        this.aD = findViewById(R.id.freshchat_conv_detail_record_voice_reply_button);
        this.aE = findViewById(R.id.freshchat_conv_detail_send_reply_button);
        this.aF = findViewById(R.id.freshchat_conv_detail_attach_image);
        this.aG = findViewById(R.id.freshchat_conversation_banner_message_text);
        this.le = findViewById(R.id.freshchat_activity_conversation_detail_progressbar);
        this.lf = findViewById(R.id.freshchat_activity_conversation_detail_content);
        this.bf = findViewById(R.id.freshchat_quick_reply_container);
        this.bi = findViewById(R.id.freshchat_drop_down_input_frame);
        this.ba = (RecyclerView) findViewById(R.id.freshchat_drop_down_recycler_view);
        this.bg = findViewById(R.id.freshchat_drop_down_recycler_view_container);
        this.bp = findViewById(R.id.freshchat_conversation_meeting_banner);
        this.bq = (TextView) findViewById(R.id.freshchat_meeting_banner_date_text);
        this.cY = (RecyclerView) findViewById(R.id.freshchat_quick_actions_button_recycler_view);
        this.aC = new LinearLayoutManager(this, 0, false);
        this.jz = (ScrollView) findViewById(R.id.freshchat_quick_actions_button_layout);
        this.ju = findViewById(R.id.freshchat_quick_action_divider);
        this.jn = (TextView) findViewById(R.id.bot_invalid_input_alert_text);
        this.jt = findViewById(R.id.freshchat_invalid_input_message);
        this.jZ = findViewById(R.id.freshchat_conv_detail_divider);
    }

    public void c(int i) {
        runOnUiThread(new bm(this, i));
    }

    /* access modifiers changed from: 0000 */
    public void c(Intent intent) {
        if (intent != null) {
            try {
                long longExtra = intent.getLongExtra("MARKETING_ID", -1);
                if (intent.getBooleanExtra("NOTIFICATION_CLICKED", false)) {
                    com.freshchat.consumer.sdk.j.aa.h(getApplicationContext(), longExtra);
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void c(final Uri uri, final int i) {
        az.a(getContext(), uri, az.b.TYPE_IMAGE, new az.a() {
            public void a(az.c cVar) {
                int i = bv.td[cVar.ordinal()];
                i.a(ConversationDetailActivity.this.getContext(), i != 1 ? i != 2 ? com.freshchat.consumer.sdk.b.c.PICTURE_ATTACHMENT_INVALID_PARAMS_ERROR : com.freshchat.consumer.sdk.b.c.PICTURE_ATTACHMENT_UNKNOWN_TYPE_ERROR : com.freshchat.consumer.sdk.b.c.PICTURE_ATTACHMENT_NON_IMAGE_URI_ERROR);
            }

            public void fQ() {
                ConversationDetailActivity.this.a(uri, i);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void c(View view) {
        runOnUiThread(new t(this, view));
    }

    /* access modifiers changed from: 0000 */
    public void cu() {
        boolean z;
        CollectionFragment M = this.lz.C(this.aM) == com.freshchat.consumer.sdk.b.k.CALLBACK ? this.lz.M(this.aM) : this.lz.B(this.aM);
        if (M != null) {
            FlowLayout flowLayout = (FlowLayout) findViewById(R.id.freshchat_chips_flowlayout);
            flowLayout.setRtl(p.aD(getContext()));
            flowLayout.removeAllViews();
            boolean z2 = false;
            if (k.a(M.getFragments())) {
                boolean z3 = false;
                for (MessageFragment next : M.getFragments()) {
                    if (next instanceof QuickReplyButtonFragment) {
                        com.freshchat.consumer.sdk.k.e eVar = new com.freshchat.consumer.sdk.k.e(this);
                        eVar.b((QuickReplyButtonFragment) next);
                        String jL = eVar.jL();
                        if (!as.isEmpty(jL)) {
                            View aI2 = aI(jL);
                            flowLayout.addView(aI2);
                            aI2.setOnClickListener(new i(this, eVar));
                        }
                    } else if (next instanceof TextFragment) {
                        z2 = true;
                    } else if (next instanceof CallbackButtonFragment) {
                        String label = ((CallbackButtonFragment) next).getLabel();
                        if (!as.isEmpty(label)) {
                            View aI3 = aI(label);
                            flowLayout.addView(aI3);
                            aI3.setOnClickListener(new l(this, next));
                        }
                    }
                    z3 = true;
                }
                z = z2;
                z2 = z3;
            } else {
                z = false;
            }
            if (z2) {
                this.bf.setVisibility(4);
                LayoutParams layoutParams = (LayoutParams) this.bf.getLayoutParams();
                layoutParams.height = -2;
                this.bf.setLayoutParams(layoutParams);
                if (!z) {
                    ap();
                }
                an();
                TypedValue typedValue = new TypedValue();
                getResources().getValue(R.dimen.freshchat_quick_reply_view_max_height_percentage, typedValue, true);
                this.bf.post(new m(this, typedValue.getFloat() / 100.0f));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public ConnectivityManager eB() {
        try {
            return (ConnectivityManager) getContext().getApplicationContext().getSystemService("connectivity");
        } catch (Exception e2) {
            q.a(e2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void et() {
        if (at()) {
            this.jy = this.aL.getStatus();
        }
    }

    /* access modifiers changed from: 0000 */
    public void f(String str) {
    }

    /* access modifiers changed from: 0000 */
    public void fS() {
        QuickReplyDropDownFragment A = this.lz.A(this.aM);
        if (A != null) {
            com.freshchat.consumer.sdk.k.g gVar = new com.freshchat.consumer.sdk.k.g(this);
            this.bj = gVar;
            gVar.a(A);
            List<MessageFragment> he = this.bj.he();
            if (!k.isEmpty(he)) {
                ap();
                setDropDownHeight(getResources().getConfiguration().orientation);
                gT();
                long E = this.lz.E(this.aM);
                this.lz.x(E);
                com.freshchat.consumer.sdk.a.e eVar = new com.freshchat.consumer.sdk.a.e(this, he, this.bl, E);
                this.ba.setAdapter(eVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean fT() {
        return aw.fc() && com.freshchat.consumer.sdk.j.g.ah(getContext()) >= 24;
    }

    /* access modifiers changed from: 0000 */
    public void fU() {
        try {
            if (fT()) {
                this.hE = new bt(this);
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                ConnectivityManager eB = eB();
                if (eB != null) {
                    eB.registerNetworkCallback(builder.build(), this.hE);
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void fV() {
        try {
            if (fT()) {
                ConnectivityManager eB = eB();
                if (eB != null && this.hE != null) {
                    eB.unregisterNetworkCallback(this.hE);
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean ff() {
        return at() && this.jo && this.aL.getStatus() == 2;
    }

    /* access modifiers changed from: 0000 */
    public void g(String str) {
        try {
            if (!as.isEmpty(str)) {
                Message h = h(str);
                com.freshchat.consumer.sdk.k.c.b P = this.lz.P(this.aM);
                if (P.bP(str)) {
                    this.bm.setText("");
                    this.bm.requestFocus();
                    kC();
                    a(h);
                    f((String) "text");
                } else {
                    b(P);
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void gB() {
        i.b(this.bf);
    }

    /* access modifiers changed from: 0000 */
    public void gC() {
        i.c(this.bf);
    }

    public void gS() {
        gU();
        gW();
        this.bj = null;
    }

    public void gT() {
        i.b(this.bi);
    }

    public void gU() {
        i.c(this.bi);
    }

    public void gV() {
        i.b(this.bg);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.freshchat_slide_up);
        loadAnimation.setDuration(300);
        this.ba.startAnimation(loadAnimation);
        this.ba.setVisibility(0);
        this.ba.bringToFront();
    }

    public void gW() {
        i.c(this.bg);
        this.ba.setVisibility(8);
    }

    /* access modifiers changed from: 0000 */
    public void ga() {
        this.lz = new com.freshchat.consumer.sdk.k.c(getContext());
    }

    /* access modifiers changed from: 0000 */
    public void gb() {
        x();
    }

    /* access modifiers changed from: 0000 */
    public void gf() {
        this.aJ = (LinearLayoutManager) this.aB.getLayoutManager();
        ad();
        this.aB.setAdapter(I());
        this.aE.setOnClickListener(this.bc);
        X();
        this.aF.setOnClickListener(this.aX);
        this.bm.addTextChangedListener(this.aV);
        this.bi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationDetailActivity.this.gV();
            }
        });
        this.bg.setOnClickListener(this.bk);
        this.ba.setLayoutManager(new LinearLayoutManager(this));
        a(true);
        R();
        ky();
        kz();
        String string = G().getString("CONFIG_CONVERSATION_BANNER_MESSAGE");
        if (as.a(string)) {
            i.b(this.aG);
            View view = this.aG;
            if (view instanceof TextView) {
                ((TextView) view).setText(string);
                return;
            }
            return;
        }
        i.c(this.aG);
    }

    /* access modifiers changed from: 0000 */
    public RemoteConfig gg() {
        if (this.lg == null) {
            this.lg = ap.bD(getContext());
        }
        return this.lg;
    }

    /* access modifiers changed from: 0000 */
    public void gv() {
        com.freshchat.consumer.sdk.m.f fVar = this.cT;
        if (fVar != null) {
            fVar.dismiss();
            this.cT = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public Message h(String str) {
        Message a2 = c.a(G().bj(), str, af(), this.channelId);
        a2.setConversationId(af());
        return a2;
    }

    /* access modifiers changed from: 0000 */
    public boolean hasPendingCsat() {
        Conversation conversation = this.aL;
        return conversation != null && conversation.hasPendingCsat();
    }

    public void i(String str) {
        runOnUiThread(new bn(this, str));
    }

    /* access modifiers changed from: 0000 */
    public void j(View view) {
        if (k.a(this.jr)) {
            if (i.k(view)) {
                if (this.jz != null) {
                    View findViewById = findViewById(R.id.freshchat_message_container);
                    int height = this.jz.getHeight();
                    int i = 0;
                    if (findViewById != null) {
                        i = findViewById.getHeight();
                    }
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.freshchat_min_space_for_quick_action_buttons);
                    if (i >= dimensionPixelSize) {
                        if (i - height <= dimensionPixelSize || i.f(this.jz)) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else if (i.f(this.jz)) {
                return;
            }
            ko();
            return;
        } else if (!i.f(this.jz)) {
            return;
        }
        i.c(this.jz);
    }

    /* access modifiers changed from: 0000 */
    public void kA() {
        int inputType = this.bm.getInputType();
        com.freshchat.consumer.sdk.k.c.b P = this.lz.P(this.aM);
        if (com.freshchat.consumer.sdk.k.c.b.f(P)) {
            i.c(this.aF);
            a(P);
            int e2 = com.freshchat.consumer.sdk.k.c.b.e(P);
            if (inputType != e2) {
                this.bm.setInputType(e2);
                return;
            }
            return;
        }
        kB();
    }

    /* access modifiers changed from: 0000 */
    public void kB() {
        this.bm.setHint(R.string.freshchat_chat_message_composer_hint);
        X();
        if (this.bm.getInputType() != 1) {
            this.bm.setInputType(1);
        }
    }

    /* access modifiers changed from: 0000 */
    public void kC() {
        if (i.f(this.jt)) {
            i.c(this.jt);
            i.b(this.jZ);
        }
    }

    /* access modifiers changed from: 0000 */
    public void ke() {
        if (this.cZ != null && !this.quickActionsMenuList.isEmpty() && !hasPendingCsat()) {
            this.cZ.setVisible(kf());
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean kf() {
        long j = this.jy;
        return j == -1 || this.lz.G(j) || this.jy == 2;
    }

    /* access modifiers changed from: 0000 */
    public void kg() {
        if (this.jp != null && !this.quickActionsMenuList.isEmpty() && !hasPendingCsat()) {
            this.jp.sy = kf();
        }
        this.bm.setAdapter(this.jp);
    }

    /* access modifiers changed from: 0000 */
    public void kh() {
        if (!kf()) {
            i.c(this.jz);
        } else if (k.a(this.jr) && !hasPendingCsat()) {
            kl();
            i.b(this.jz);
        }
    }

    /* access modifiers changed from: 0000 */
    public void ki() {
        this.hl.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ConversationDetailActivity.this.ao();
                ConversationDetailActivity.this.hl.dismiss();
                ConversationDetailActivity conversationDetailActivity = ConversationDetailActivity.this;
                conversationDetailActivity.a(j.a.MENU, conversationDetailActivity.quickActionsMenuList.get(i));
            }
        });
    }

    public void kj() {
        com.freshchat.consumer.sdk.ui.g gVar = new com.freshchat.consumer.sdk.ui.g(getContext(), null, R.attr.freshchatQuickActionMenuStyle);
        this.hl = gVar;
        gVar.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.freshchat_quick_actions_menu_popup));
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.freshchat_quick_action_menu_options, this.quickActionsMenuList);
        this.hl.setAdapter(arrayAdapter);
        this.hF = new de(getContext(), arrayAdapter);
        this.hl.setContentWidth(-2);
        this.hl.setInputMethodMode(2);
        this.hl.setVerticalOffset(-100);
        this.hl.setHeight(this.hF.af(this.hl.getHeight()));
        int kw = this.hF.kw();
        this.hl.setWidth(kw);
        this.hl.setHorizontalOffset(this.hF.ag(kw));
        ki();
    }

    public void kk() {
        if (this.js != null) {
            this.bm.setAdapter(this.jp);
            this.bm.setThreshold(1);
            this.bm.setDropDownVerticalOffset(0);
            int kv = this.js.kv();
            this.bm.setDropDownWidth(kv);
            this.bm.setDropDownHorizontalOffset(this.js.ae(kv));
            this.jp.registerDataSetObserver(new DataSetObserver() {
                public void onChanged() {
                    super.onChanged();
                    ConversationDetailActivity.this.bm.setDropDownHeight(ConversationDetailActivity.this.js.ku());
                    ConversationDetailActivity.this.bm.showDropDown();
                }
            });
            kn();
        }
    }

    public void kl() {
        aa aaVar = new aa(getContext(), this.jr, this.jv);
        this.cY.setLayoutManager(this.aC);
        this.cY.setAdapter(aaVar);
        a(this.cY, this.aC);
    }

    /* access modifiers changed from: 0000 */
    public void km() {
        if (this.bf.getVisibility() == 0) {
            i.c(this.ju);
        } else {
            i.b(this.ju);
        }
    }

    /* access modifiers changed from: 0000 */
    public void kn() {
        this.bm.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ConversationDetailActivity.this.bm.setText("");
                ConversationDetailActivity.this.a(j.a.SLASH_COMMAND, (String) adapterView.getItemAtPosition(i));
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void ko() {
        z zVar = new z(getContext());
        this.jq = zVar;
        this.jr = zVar.O(this.aM);
        kh();
    }

    /* access modifiers changed from: 0000 */
    public void kp() {
        com.freshchat.consumer.sdk.ui.g gVar = this.hl;
        if (gVar != null && gVar.isShowing()) {
            this.hl.dismiss();
            kj();
            this.hl.setAnchorView(findViewById(R.id.freshchat_quick_action_menu));
            this.hl.show();
        }
    }

    /* access modifiers changed from: 0000 */
    public void kq() {
        this.bm.dismissDropDown();
        dd ddVar = this.js;
        if (ddVar != null) {
            int kv = ddVar.kv();
            this.bm.setDropDownWidth(kv);
            this.bm.setDropDownHeight(this.js.ku());
            this.bm.setDropDownHorizontalOffset(this.js.ae(kv));
        }
        if (this.bm.isPopupShowing()) {
            this.bm.showDropDown();
        }
    }

    /* access modifiers changed from: 0000 */
    public void kx() {
        if (this.jw == null) {
            AnonymousClass4 r0 = new OrientationEventListener(getContext()) {
                public void onOrientationChanged(int i) {
                    ConversationDetailActivity conversationDetailActivity = ConversationDetailActivity.this;
                    conversationDetailActivity.a(conversationDetailActivity.aC);
                }
            };
            this.jw = r0;
            r0.enable();
        }
    }

    /* access modifiers changed from: 0000 */
    public void ky() {
        this.bm.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 0 && i != 5 && i != 6 && i != 7) {
                    return false;
                }
                i.a(ConversationDetailActivity.this.getContext().getApplicationContext(), ConversationDetailActivity.this.getCurrentFocus());
                return true;
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void kz() {
        final View a2 = i.a(getWindow());
        if (a2 != null) {
            a2.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ConversationDetailActivity.this.j(a2);
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    public void n(Message message) {
        CalendarMessageMeta x = this.lz.x(message);
        com.freshchat.consumer.sdk.m.f a2 = com.freshchat.consumer.sdk.m.f.a(this.orientation, x, this.lz.a(x, this.aN));
        this.cT = a2;
        a2.show(getSupportFragmentManager(), (String) "CalendarBottomSheet");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 125 && i2 == -1) {
            ai.d(TAG, "onActivityResult::REQUEST_CODE_GALLERY");
            try {
                c(intent.getData(), i);
            } catch (Exception e2) {
                q.a(e2);
            }
        } else if (i == 126 && i2 == -1) {
            ai.d(TAG, "onActivityResult::REQUEST_CODE_CAMERA");
            if (this.aR != null) {
                String str = TAG;
                ai.d(str, "Found Pic From Camera : " + this.aR);
                a(Uri.parse(this.aR), i);
                this.aR = null;
            }
        } else if (i == 127 && i2 == -1) {
            this.bm.setText("");
            PictureAttachmentActivity.a aVar = new PictureAttachmentActivity.a();
            aVar.d(intent);
            a(aVar.aK(), aVar.getWidth(), aVar.getHeight(), aVar.aL());
        } else {
            String str2 = TAG;
            ai.d(str2, "onActivityResult::Request Code " + i + ", Result: " + i2);
        }
    }

    public void onBackPressed() {
        i.a(getApplicationContext(), getCurrentFocus());
        if (i.f(this.ba)) {
            gW();
            return;
        }
        W();
        p();
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setDropDownHeight(configuration.orientation);
        this.orientation = configuration.orientation;
        kp();
        kq();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1638922340, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_conversation_detail, menu);
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_toggle_speakerphone);
        if (G().bn()) {
            a(findItem, false);
        } else {
            findItem.setVisible(false);
        }
        this.cZ = menu.findItem(R.id.freshchat_quick_action_menu);
        ke();
        kj();
        return true;
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, 749427533, new Object[0]);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.freshchat_menu_item_toggle_speakerphone) {
            if (G().bo()) {
                G().h(false);
            } else {
                G().h(true);
            }
            a(menuItem, true);
            return true;
        }
        int itemId = menuItem.getItemId();
        int i = R.id.freshchat_quick_action_menu;
        if (itemId != i) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.hl.setAnchorView(findViewById(i));
        this.hl.show();
        return true;
    }

    public void onPause() {
        iIiIiIiIii.IiiiIiiiII(this, -1213597086, new Object[0]);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str;
        int i2;
        if (i == 100) {
            ai.i(TAG, "Received response for audio recording permission request.");
            if (am.a(iArr)) {
                ai.i(TAG, getString(R.string.freshchat_chat_voice_messaging_permissions_granted));
                S();
                return;
            }
            str = TAG;
            i2 = R.string.freshchat_chat_voice_messaging_permissions_not_granted;
        } else if (i != 101) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            return;
        } else if (am.a(iArr)) {
            ai.i(TAG, getString(R.string.freshchat_chat_camera_permissions_granted));
            aa();
            return;
        } else {
            str = TAG;
            i2 = R.string.freshchat_chat_camera_permissions_not_granted;
        }
        ai.d(this, str, getString(i2));
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 467496057, new Object[0]);
    }

    public void onStop() {
        iIiIiIiIii.IiiiIiiiII(this, 1126563375, new Object[0]);
    }

    /* access modifiers changed from: 0000 */
    public void p() {
        try {
            if (isTaskRoot()) {
                String bT = G().bT();
                if (as.a(bT)) {
                    com.freshchat.consumer.sdk.j.aa.k(getContext(), bT);
                } else {
                    startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setDropDownHeight(int i) {
        Resources resources;
        int i2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.freshchat_drop_down_item_height);
        if (this.bj != null) {
            if (i == 2) {
                resources = getResources();
                i2 = R.integer.freshchat_drop_down_max_display_items_landscape;
            } else {
                resources = getResources();
                i2 = R.integer.freshchat_drop_down_max_display_items_portrait;
            }
            int integer = resources.getInteger(i2);
            i.b((View) this.ba, this.lz.a(this.bj.hf(), integer, dimensionPixelSize));
        }
    }

    /* access modifiers changed from: 0000 */
    public void x() {
        int i = bv.ld[this.lz.gq().ordinal()];
        if (i == 1) {
            i.b(this.le);
            i.c(this.lf);
        } else if (i == 2) {
            by.gN().d(getContext(), true);
            i.c(this.le);
            i.b(this.lf);
            if (this.bi.getVisibility() == 0) {
                this.lz.z(this.aM);
            }
        } else if (i == 3) {
            al();
        }
    }
}
