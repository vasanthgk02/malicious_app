package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.net.Uri;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.Callback;
import androidx.recyclerview.widget.DiffUtil.Diagonal;
import androidx.recyclerview.widget.DiffUtil.DiffResult;
import androidx.recyclerview.widget.DiffUtil.Range;
import androidx.recyclerview.widget.DiffUtil.Snake;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.CalendarDay.TimeSlot;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Message.MessageType;
import com.freshchat.consumer.sdk.beans.MessageInternalMeta;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.av;
import com.freshchat.consumer.sdk.j.be;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.ct;
import com.freshchat.consumer.sdk.j.cy;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.l.j;
import com.paynimo.android.payment.UPIFragment;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class c extends b {
    public long nq;
    public long ok;
    public final com.freshchat.consumer.sdk.l.c qr = new com.freshchat.consumer.sdk.l.c();

    public class a extends Callback {
        public final List<Message> lA;
        public final List<Message> lB;

        public a(List<Message> list, List<Message> list2) {
            this.lA = list;
            this.lB = list2;
        }

        public boolean areContentsTheSame(int i, int i2) {
            return this.lA.get(i).equals(this.lB.get(i2));
        }

        public boolean areItemsTheSame(int i, int i2) {
            return as.o(this.lA.get(i).getAlias(), this.lB.get(i2).getAlias());
        }

        public int getNewListSize() {
            return k.b((Collection<?>) this.lB);
        }

        public int getOldListSize() {
            return k.b((Collection<?>) this.lA);
        }
    }

    public enum b {
        INPUT_TYPE_DEFAULT("default", R.string.freshchat_chat_message_composer_hint, 0, 1, false),
        INPUT_TYPE_EMAIL("email", R.string.freshchat_input_email_hint, R.string.freshchat_input_invalid_email, 32, true),
        INPUT_TYPE_PHONE("phone", R.string.freshchat_input_phone_number_hint, R.string.freshchat_input_invalid_phone_number, 3, true),
        INPUT_TYPE_NUMBER(UPIFragment.CONFIG_TYPE_NUMBER, R.string.freshchat_input_number_hint, R.string.freshchat_input_invalid_number, 3, true);
        
        public final String ti;
        public final int tj;
        public final int tk;
        public final int tl;
        public final boolean tm;

        /* access modifiers changed from: public */
        b(String str, int i, int i2, int i3, boolean z) {
            this.ti = str;
            this.tj = i;
            this.tk = i2;
            this.tl = i3;
            this.tm = z;
        }

        public static b bO(String str) {
            if (as.isEmpty(str)) {
                return INPUT_TYPE_DEFAULT;
            }
            for (b bVar : values()) {
                if (as.o(str, bVar.ti)) {
                    return bVar;
                }
            }
            return INPUT_TYPE_DEFAULT;
        }

        public static int c(b bVar) {
            if (bVar == null) {
                bVar = INPUT_TYPE_DEFAULT;
            }
            return bVar.tk;
        }

        public static int d(b bVar) {
            if (bVar == null) {
                bVar = INPUT_TYPE_DEFAULT;
            }
            return bVar.tj;
        }

        public static int e(b bVar) {
            if (bVar == null) {
                bVar = INPUT_TYPE_DEFAULT;
            }
            return bVar.tl;
        }

        public static boolean f(b bVar) {
            if (bVar == null) {
                bVar = INPUT_TYPE_DEFAULT;
            }
            return bVar.tm;
        }

        public boolean bP(String str) {
            int i = aa.tc[bO(this.ti).ordinal()];
            if (i == 1) {
                return av.aK(str);
            }
            if (i == 2) {
                return av.bN(str);
            }
            if (i != 3) {
                return true;
            }
            return av.bM(str);
        }
    }

    public c(Context context) {
        super(context);
    }

    private MessageInternalMeta c(CalendarMessageMeta calendarMessageMeta) {
        MessageInternalMeta messageInternalMeta = new MessageInternalMeta();
        messageInternalMeta.setCalendarMessageMeta(calendarMessageMeta);
        return messageInternalMeta;
    }

    public void A(Message message) {
        String t = cm.t(message);
        if (as.a(t)) {
            bg.J(getContext(), t);
        }
    }

    public void B(Message message) {
        String t = cm.t(message);
        if (as.a(t)) {
            bg.K(getContext(), t);
        }
    }

    public boolean G(long j) {
        return j == 22;
    }

    public boolean I(List<Message> list) {
        if (k.isEmpty(list)) {
            return false;
        }
        return cm.u(list.get(k.b((Collection<?>) list) - 1));
    }

    public List<Message> K(List<Message> list) {
        if (k.isEmpty(list)) {
            return null;
        }
        int b2 = k.b((Collection<?>) list) - 1;
        if (!cy.aT(list.get(b2).getAlias())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (b2 >= 0) {
            if (cy.aT(list.get(b2).getAlias())) {
                arrayList.add(0, list.get(b2));
            }
            b2--;
        }
        if (k.a(arrayList)) {
            for (int i = 0; i < k.b((Collection<?>) arrayList); i++) {
                Message message = (Message) arrayList.get(i);
                message.setAlias(cy.a(((Message) arrayList.get(0)).getCreatedMillis(), i));
                message.setUploadState(1);
                message.setRead(true);
            }
        }
        return arrayList;
    }

    public b P(List<Message> list) {
        if (k.a(list)) {
            List<MessageFragment> replyFragments = ((Message) GeneratedOutlineSupport.outline29(list, -1)).getReplyFragments();
            if (k.a(replyFragments)) {
                return b.bO(replyFragments.get(0).getInputType());
            }
        }
        return b.INPUT_TYPE_DEFAULT;
    }

    public int a(int i, int i2, int i3) {
        if (i >= i2) {
            i = i2;
        }
        return i * i3;
    }

    public Message a(CalendarMessageMeta calendarMessageMeta, long j, long j2) {
        if (calendarMessageMeta == null) {
            return null;
        }
        String C = new j().C(getContext());
        if (as.isEmpty(C)) {
            return null;
        }
        TextFragment textFragment = new TextFragment();
        textFragment.setContent(getContext().getString(R.string.freshchat_calendar_cancel_invite_message));
        textFragment.setContentType(RNCWebViewManager.HTML_MIME_TYPE);
        MessageInternalMeta c2 = c(calendarMessageMeta);
        Message a2 = a(C, textFragment, MessageType.MESSAGE_TYPE_CALENDER_INVITE_CANCELLED_BY_USER, j, j2, -1);
        if (a2 == null) {
            return null;
        }
        a2.setInternalMeta(c2);
        return a2;
    }

    public Message a(CalendarMessageMeta calendarMessageMeta, TimeSlot timeSlot, int i, long j, long j2) {
        if (calendarMessageMeta == null || timeSlot == null) {
            return null;
        }
        j jVar = new j();
        String C = jVar.C(getContext());
        CalendarEventFragment calendarEventFragment = new CalendarEventFragment();
        calendarEventFragment.setStartMillis(timeSlot.getFromMillis());
        calendarEventFragment.setEndMillis(timeSlot.getToMillis());
        calendarEventFragment.setEventProviderType(i);
        calendarEventFragment.setUserTimeZone(ct.hX());
        Message a2 = a(C, calendarEventFragment, MessageType.MESSAGE_TYPE_NORMAL, j, j2, -1);
        if (a2 == null) {
            return null;
        }
        MessageInternalMeta c2 = c(calendarMessageMeta);
        calendarMessageMeta.setCalendarBookingEmail(jVar.cd(getContext()));
        a2.setInternalMeta(c2);
        return a2;
    }

    public Message a(String str, MessageFragment messageFragment, long j, long j2, long j3) {
        return a(str, messageFragment, MessageType.MESSAGE_TYPE_NORMAL, j, j2, j3);
    }

    public Message a(String str, MessageFragment messageFragment, MessageType messageType, long j, long j2, long j3) {
        Message message = null;
        if (messageFragment == null) {
            return null;
        }
        try {
            message = com.freshchat.consumer.sdk.service.d.c.a(str, messageFragment, messageType, j, j2, j3);
        } catch (Exception e2) {
            q.a(e2);
        }
        return message;
    }

    public String a(CalendarMessageMeta calendarMessageMeta, Map<String, Participant> map) {
        if (calendarMessageMeta == null || k.c(map)) {
            return null;
        }
        String calendarAgentAlias = calendarMessageMeta.getCalendarAgentAlias();
        if (as.isEmpty(calendarAgentAlias)) {
            return null;
        }
        Participant participant = map.get(calendarAgentAlias);
        if (participant == null) {
            return null;
        }
        return participant.getProfilePicUrl();
    }

    public void a(long j, com.freshchat.consumer.sdk.l.c.b bVar) {
        this.qr.a(getContext(), j, bVar);
    }

    public void a(List<Message> list, CallbackButtonFragment callbackButtonFragment) {
        Message L = L(list);
        if (callbackButtonFragment != null && L != null && !as.isEmpty(L.getAlias())) {
            com.freshchat.consumer.sdk.j.b.a(getContext(), L.getAlias(), callbackButtonFragment);
        }
    }

    public DiffResult b(List<Message> list, List<Message> list2) {
        Range range;
        ArrayList arrayList;
        ArrayList arrayList2;
        Snake snake;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Range range2;
        Range range3;
        Diagonal diagonal;
        int i;
        Snake snake2;
        Snake snake3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        a aVar = new a(list, list2);
        int oldListSize = aVar.getOldListSize();
        int newListSize = aVar.getNewListSize();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new Range(0, oldListSize, 0, newListSize));
        int i7 = oldListSize + newListSize;
        int i8 = 1;
        int i9 = (((i7 + 1) / 2) * 2) + 1;
        int[] iArr = new int[i9];
        int i10 = i9 / 2;
        int[] iArr2 = new int[i9];
        ArrayList arrayList7 = new ArrayList();
        while (!arrayList6.isEmpty()) {
            Range range4 = (Range) arrayList6.remove(arrayList6.size() - i8);
            if (range4.oldSize() >= i8 && range4.newSize() >= i8) {
                int newSize = ((range4.newSize() + range4.oldSize()) + i8) / 2;
                int i11 = i8 + i10;
                iArr[i11] = range4.oldListStart;
                iArr2[i11] = range4.oldListEnd;
                int i12 = 0;
                while (true) {
                    if (i12 >= newSize) {
                        break;
                    }
                    boolean z2 = Math.abs(range4.oldSize() - range4.newSize()) % 2 == i8;
                    int oldSize = range4.oldSize() - range4.newSize();
                    int i13 = -i12;
                    int i14 = i13;
                    while (true) {
                        if (i14 > i12) {
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            i = newSize;
                            snake2 = null;
                            break;
                        }
                        if (i14 == i13 || (i14 != i12 && iArr[i14 + 1 + i10] > iArr[(i14 - 1) + i10])) {
                            i5 = iArr[i14 + 1 + i10];
                            i4 = i5;
                        } else {
                            i5 = iArr[(i14 - 1) + i10];
                            i4 = i5 + 1;
                        }
                        i = newSize;
                        arrayList2 = arrayList6;
                        int i15 = ((i4 - range4.oldListStart) + range4.newListStart) - i14;
                        if (i12 == 0 || i4 != i5) {
                            arrayList = arrayList7;
                            i6 = i15;
                        } else {
                            i6 = i15 - 1;
                            arrayList = arrayList7;
                        }
                        while (i4 < range4.oldListEnd && i15 < range4.newListEnd && aVar.areItemsTheSame(i4, i15)) {
                            i4++;
                            i15++;
                        }
                        iArr[i14 + i10] = i4;
                        if (z2) {
                            int i16 = oldSize - i14;
                            z = z2;
                            if (i16 >= i13 + 1 && i16 <= i12 - 1 && iArr2[i16 + i10] <= i4) {
                                snake2 = new Snake();
                                snake2.startX = i5;
                                snake2.startY = i6;
                                snake2.endX = i4;
                                snake2.endY = i15;
                                snake2.reverse = false;
                                break;
                            }
                        } else {
                            z = z2;
                        }
                        i14 += 2;
                        newSize = i;
                        arrayList6 = arrayList2;
                        arrayList7 = arrayList;
                        z2 = z;
                    }
                    if (snake2 != null) {
                        snake = snake2;
                        range = range4;
                        break;
                    }
                    boolean z3 = (range4.oldSize() - range4.newSize()) % 2 == 0;
                    int oldSize2 = range4.oldSize() - range4.newSize();
                    int i17 = i13;
                    while (true) {
                        if (i17 > i12) {
                            range = range4;
                            snake3 = null;
                            break;
                        }
                        if (i17 == i13 || (i17 != i12 && iArr2[i17 + 1 + i10] < iArr2[(i17 - 1) + i10])) {
                            i3 = iArr2[i17 + 1 + i10];
                            i2 = i3;
                        } else {
                            i3 = iArr2[(i17 - 1) + i10];
                            i2 = i3 - 1;
                        }
                        int i18 = range4.newListEnd - ((range4.oldListEnd - i2) - i17);
                        int i19 = (i12 == 0 || i2 != i3) ? i18 : i18 + 1;
                        while (true) {
                            if (i2 > range4.oldListStart && i18 > range4.newListStart) {
                                int i20 = i2 - 1;
                                range = range4;
                                int i21 = i18 - 1;
                                if (!aVar.areItemsTheSame(i20, i21)) {
                                    break;
                                }
                                i2 = i20;
                                i18 = i21;
                                range4 = range;
                            } else {
                                range = range4;
                            }
                        }
                        range = range4;
                        iArr2[i17 + i10] = i2;
                        if (z3) {
                            int i22 = oldSize2 - i17;
                            if (i22 >= i13 && i22 <= i12 && iArr[i22 + i10] >= i2) {
                                snake3 = new Snake();
                                snake3.startX = i2;
                                snake3.startY = i18;
                                snake3.endX = i3;
                                snake3.endY = i19;
                                snake3.reverse = true;
                                break;
                            }
                        }
                        i17 += 2;
                        range4 = range;
                    }
                    if (snake3 != null) {
                        snake = snake3;
                        break;
                    }
                    i12++;
                    newSize = i;
                    arrayList6 = arrayList2;
                    arrayList7 = arrayList;
                    range4 = range;
                    i8 = 1;
                }
            }
            arrayList = arrayList7;
            arrayList2 = arrayList6;
            range = range4;
            snake = null;
            if (snake != null) {
                if (snake.diagonalSize() > 0) {
                    if (!(snake.endY - snake.startY != snake.endX - snake.startX)) {
                        int i23 = snake.startX;
                        diagonal = new Diagonal(i23, snake.startY, snake.endX - i23);
                    } else if (snake.reverse) {
                        diagonal = new Diagonal(snake.startX, snake.startY, snake.diagonalSize());
                    } else {
                        if (snake.endY - snake.startY > snake.endX - snake.startX) {
                            diagonal = new Diagonal(snake.startX, snake.startY + 1, snake.diagonalSize());
                        } else {
                            diagonal = new Diagonal(snake.startX + 1, snake.startY, snake.diagonalSize());
                        }
                    }
                    arrayList5.add(diagonal);
                }
                if (arrayList.isEmpty()) {
                    range3 = new Range();
                    arrayList4 = arrayList;
                    range2 = range;
                    i8 = 1;
                } else {
                    i8 = 1;
                    arrayList4 = arrayList;
                    range3 = (Range) arrayList4.remove(arrayList.size() - 1);
                    range2 = range;
                }
                range3.oldListStart = range2.oldListStart;
                range3.newListStart = range2.newListStart;
                range3.oldListEnd = snake.startX;
                range3.newListEnd = snake.startY;
                arrayList3 = arrayList2;
                arrayList3.add(range3);
                range2.oldListEnd = range2.oldListEnd;
                range2.newListEnd = range2.newListEnd;
                range2.oldListStart = snake.endX;
                range2.newListStart = snake.endY;
                arrayList3.add(range2);
            } else {
                arrayList3 = arrayList2;
                arrayList4 = arrayList;
                i8 = 1;
                arrayList4.add(range);
            }
            arrayList7 = arrayList4;
            arrayList6 = arrayList3;
        }
        Collections.sort(arrayList5, DiffUtil.DIAGONAL_COMPARATOR);
        DiffResult diffResult = new DiffResult(aVar, arrayList5, iArr, iArr2, true);
        return diffResult;
    }

    public Uri w(Message message) {
        return cm.w(message);
    }

    public CalendarMessageMeta x(Message message) {
        MessageInternalMeta internalMeta = message.getInternalMeta();
        if (internalMeta == null) {
            return null;
        }
        return internalMeta.getCalendarMessageMeta();
    }

    public void x(long j) {
        if (j != this.nq && ha()) {
            this.nq = j;
            bg.bY(getContext());
        }
    }

    public void y(long j) {
        if (j != this.ok && ha()) {
            this.ok = j;
            bg.bZ(getContext());
        }
    }

    public String z(Message message) {
        return cm.g(getContext(), message);
    }

    public void z(List<Message> list) {
        be.eC().gZ().execute(new d(this, list));
    }
}
