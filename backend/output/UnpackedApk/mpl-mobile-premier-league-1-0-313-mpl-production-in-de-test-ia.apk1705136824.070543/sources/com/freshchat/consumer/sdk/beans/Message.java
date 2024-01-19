package com.freshchat.consumer.sdk.beans;

import co.apptailor.googlesignin.RNGoogleSigninModule;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.google.gson.annotations.SerializedName;
import com.mpl.androidapp.utils.Constant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class Message {
    public static final int DO_NOT_DISPLAY = -1;
    public static final int DO_NOT_TRANSLATE = 0;
    public static final int MESSAGE_READ = 1;
    public static final int MESSAGE_UNREAD = 0;
    public static final int MUST_TRANSLATE = 1;
    public static final int MUST_TRANSLATE_BUT_TRANSLATION_FAILED = 2;
    public static final int RESPONSE_GIVEN = 1;
    public static final int RESPONSE_PENDING = 0;
    public static final int SHOULD_DELETE = 1;
    public static final int SHOULD_NOT_DELETE = 0;
    public static final int SOURCE_MOBILE = 2;
    public static final int UPLOAD_STATE_PENDING = 0;
    public static final int UPLOAD_STATE_UPLOADED = 1;
    public String alias;
    public long channelId;
    public long conversationId;
    public long createdMillis;
    public String flowStepId;
    @SerializedName("messageId")
    public long id;
    public MessageInternalMeta internalMeta;
    public boolean isResponded;
    public long marketingId;
    public List<MessageFragment> messageFragments;
    public int messageType;
    public String messageUserAlias;
    public String messageUserName;
    public String messageUserProfilePic;
    public int messageUserType;
    @SerializedName("readByUser")
    public boolean read;
    public List<MessageFragment> replyFragments;
    public ReplyTo replyTo;
    public int shouldTranslate;
    public int source = 2;
    public List<TriggeredRuleId> triggeredRuleIds;
    public transient int uploadState;

    public static class Builder {
        public String alias;
        public long channelId;
        public long createdMillis;
        public String flowStepId;
        public long hostConversationId;
        public long id;
        public MessageInternalMeta internalMeta;
        public boolean isResponded;
        public long marketingId;
        public int messageType;
        public String messageUserAlias;
        public String messageUserName;
        public String messageUserProfilePic;
        public int messageUserType;
        public boolean read;
        public List<MessageFragment> replyFragments;
        public ReplyTo replyTo;
        public int shouldTranslate;
        public int source = 2;
        public int uploadState;

        public Builder alias(String str) {
            this.alias = str;
            return this;
        }

        public Message build() {
            Message message = new Message();
            message.id = this.id;
            message.alias = this.alias;
            message.channelId = this.channelId;
            message.marketingId = this.marketingId;
            message.messageType = this.messageType;
            message.conversationId = this.hostConversationId;
            message.messageUserType = this.messageUserType;
            message.messageUserAlias = this.messageUserAlias;
            message.source = this.source;
            message.read = this.read;
            message.createdMillis = this.createdMillis;
            message.uploadState = this.uploadState;
            message.replyFragments = this.replyFragments;
            message.internalMeta = this.internalMeta;
            message.replyTo = this.replyTo;
            message.isResponded = this.isResponded;
            message.shouldTranslate = this.shouldTranslate;
            message.flowStepId = this.flowStepId;
            message.messageUserName = this.messageUserName;
            message.messageUserProfilePic = this.messageUserProfilePic;
            return message;
        }

        public Builder channelId(long j) {
            this.channelId = j;
            return this;
        }

        public Builder createdMillis(long j) {
            this.createdMillis = j;
            return this;
        }

        public Builder hostConversationId(long j) {
            this.hostConversationId = j;
            return this;
        }

        public Builder id(long j) {
            this.id = j;
            return this;
        }

        public Builder internalMeta(MessageInternalMeta messageInternalMeta) {
            this.internalMeta = messageInternalMeta;
            return this;
        }

        public Builder isResponded(boolean z) {
            this.isResponded = z;
            return this;
        }

        public Builder marketingId(long j) {
            this.marketingId = j;
            return this;
        }

        public Builder messageType(int i) {
            this.messageType = i;
            return this;
        }

        public Builder messageUserAlias(String str) {
            this.messageUserAlias = str;
            return this;
        }

        public Builder messageUserType(int i) {
            this.messageUserType = i;
            return this;
        }

        public Builder read(boolean z) {
            this.read = z;
            return this;
        }

        public Builder replyFragments(List<MessageFragment> list) {
            this.replyFragments = list;
            return this;
        }

        public Builder replyTo(ReplyTo replyTo2) {
            this.replyTo = replyTo2;
            return this;
        }

        public Builder setFlowStepId(String str) {
            this.flowStepId = str;
            return this;
        }

        public Builder setMessageUserName(String str) {
            this.messageUserName = str;
            return this;
        }

        public Builder setMessageUserProfilePic(String str) {
            this.messageUserProfilePic = str;
            return this;
        }

        public Builder setShouldTranslate(int i) {
            this.shouldTranslate = i;
            return this;
        }

        public Builder uploadState(int i) {
            this.uploadState = i;
            return this;
        }
    }

    public enum MessageType {
        MESSAGE_TYPE_UNKNOWN(-1),
        MESSAGE_TYPE_NORMAL(1),
        BOT(2),
        FREDDY_BOT(3),
        POSTBACK_MESSAGE(1001),
        MESSAGE_TYPE_CALENDER_INVITE_SENT_BY_AGENT(RNGoogleSigninModule.RC_SIGN_IN),
        MESSAGE_TYPE_CALENDER_INVITE_CANCELLED_BY_USER(Constant.REQUEST_CODE_WEB_GAME),
        MESSAGE_TYPE_CALENDER_BOOKING_SUCCESS(9003),
        MESSAGE_TYPE_CALENDER_BOOKING_FAILURE(9004);
        
        public final int intValue;

        /* access modifiers changed from: public */
        MessageType(int i) {
            this.intValue = i;
        }

        public static MessageType getMessageTypeFromIntValue(int i) {
            for (MessageType messageType : values()) {
                if (messageType.getIntValue() == i) {
                    return messageType;
                }
            }
            return MESSAGE_TYPE_UNKNOWN;
        }

        public int getIntValue() {
            return this.intValue;
        }
    }

    public static class ReplyTo {
        public long originalMessageId;

        public long getOriginalMessageId() {
            return this.originalMessageId;
        }

        public void setOriginalMessageId(long j) {
            this.originalMessageId = j;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ReplyTo{originalMessageId=");
            outline73.append(this.originalMessageId);
            outline73.append('}');
            return outline73.toString();
        }
    }

    public void addMessageFragment(MessageFragment messageFragment) {
        if (this.messageFragments == null) {
            this.messageFragments = new ArrayList();
        }
        if (messageFragment != null) {
            this.messageFragments.add(messageFragment);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Message.class != obj.getClass()) {
            return false;
        }
        Message message = (Message) obj;
        int b2 = k.b((Collection<?>) this.messageFragments);
        boolean z = this.marketingId == message.marketingId && this.channelId == message.channelId && this.conversationId == message.conversationId && this.messageUserType == message.messageUserType && this.source == message.source && this.read == message.read && this.createdMillis == message.createdMillis && this.uploadState == message.uploadState && this.messageType == message.messageType && as.o(this.alias, message.alias) && as.o(this.messageUserAlias, message.messageUserAlias) && b2 == k.b((Collection<?>) message.messageFragments) && k.b((Collection<?>) this.replyFragments) == k.b((Collection<?>) message.replyFragments) && ((this.internalMeta == null && message.internalMeta == null) || !(this.internalMeta == null || message.internalMeta == null)) && this.id == message.id && this.isResponded == message.isResponded && this.shouldTranslate == message.shouldTranslate && as.o(this.flowStepId, message.flowStepId) && as.o(this.messageUserName, message.messageUserName) && as.o(this.messageUserProfilePic, message.messageUserProfilePic);
        ReplyTo replyTo2 = this.replyTo;
        long j = 0;
        long access$000 = replyTo2 != null ? replyTo2.originalMessageId : 0;
        ReplyTo replyTo3 = message.replyTo;
        if (replyTo3 != null) {
            j = replyTo3.originalMessageId;
        }
        if (!(z && access$000 == j)) {
            return false;
        }
        if (!(this.messageFragments == null || message.messageFragments == null)) {
            for (int i = 0; i < b2; i++) {
                if (!this.messageFragments.get(i).equals(message.getMessageFragments().get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getAlias() {
        return this.alias;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public long getCreatedMillis() {
        return this.createdMillis;
    }

    public String getFlowStepId() {
        return this.flowStepId;
    }

    public long getId() {
        return this.id;
    }

    public MessageInternalMeta getInternalMeta() {
        return this.internalMeta;
    }

    public long getMarketingId() {
        return this.marketingId;
    }

    public List<MessageFragment> getMessageFragments() {
        return this.messageFragments;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getMessageUserAlias() {
        return this.messageUserAlias;
    }

    public String getMessageUserName() {
        return this.messageUserName;
    }

    public String getMessageUserProfilePic() {
        return this.messageUserProfilePic;
    }

    public int getMessageUserType() {
        return this.messageUserType;
    }

    public List<MessageFragment> getReplyFragments() {
        return this.replyFragments;
    }

    public ReplyTo getReplyTo() {
        return this.replyTo;
    }

    public int getShouldTranslate() {
        return this.shouldTranslate;
    }

    public List<TriggeredRuleId> getTriggeredRuleIds() {
        return this.triggeredRuleIds;
    }

    public int getUploadState() {
        return this.uploadState;
    }

    public boolean isRead() {
        return this.read;
    }

    public boolean isResponded() {
        return this.isResponded;
    }

    public boolean isUploaded() {
        return this.uploadState == 1;
    }

    public boolean isUserMessage() {
        return this.messageUserType == 0;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public void setConversationId(long j) {
        this.conversationId = j;
    }

    public void setCreatedMillis(long j) {
        this.createdMillis = j;
    }

    public void setFlowStepId(String str) {
        this.flowStepId = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setInternalMeta(MessageInternalMeta messageInternalMeta) {
        this.internalMeta = messageInternalMeta;
    }

    public void setMarketingId(long j) {
        this.marketingId = j;
    }

    public void setMessageFragments(List<MessageFragment> list) {
        if (this.messageFragments == null) {
            this.messageFragments = new ArrayList();
        }
        if (k.a(list)) {
            this.messageFragments.clear();
            this.messageFragments.addAll(list);
        }
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setMessageUserAlias(String str) {
        this.messageUserAlias = str;
    }

    public void setMessageUserName(String str) {
        this.messageUserName = str;
    }

    public void setMessageUserProfilePic(String str) {
        this.messageUserProfilePic = str;
    }

    public void setMessageUserType(int i) {
        this.messageUserType = i;
    }

    public void setRead(boolean z) {
        this.read = z;
    }

    public void setReplyFragments(List<MessageFragment> list) {
        this.replyFragments = list;
    }

    public void setReplyTo(ReplyTo replyTo2) {
        this.replyTo = replyTo2;
    }

    public void setResponded(boolean z) {
        this.isResponded = z;
    }

    public void setShouldTranslate(int i) {
        this.shouldTranslate = i;
    }

    public void setTriggeredRuleIds(List<TriggeredRuleId> list) {
        this.triggeredRuleIds = list;
    }

    public void setUploadState(int i) {
        this.uploadState = i;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("Message{", "alias='");
        GeneratedOutlineSupport.outline99(outline77, this.alias, ExtendedMessageFormat.QUOTE, ", marketingId=");
        outline77.append(this.marketingId);
        outline77.append(", id=");
        outline77.append(this.id);
        outline77.append(", channelId='");
        outline77.append(this.channelId);
        outline77.append(ExtendedMessageFormat.QUOTE);
        outline77.append(", messageType= '");
        outline77.append(this.messageType);
        outline77.append(ExtendedMessageFormat.QUOTE);
        outline77.append(", conversationId=");
        outline77.append(this.conversationId);
        outline77.append(", messageUserType=");
        outline77.append(this.messageUserType);
        outline77.append(", messageUserAlias='");
        GeneratedOutlineSupport.outline99(outline77, this.messageUserAlias, ExtendedMessageFormat.QUOTE, ", source=");
        outline77.append(this.source);
        outline77.append(", read=");
        outline77.append(this.read);
        outline77.append(", createdMillis=");
        outline77.append(this.createdMillis);
        outline77.append(", uploadState=");
        outline77.append(this.uploadState);
        outline77.append(", messageFragments=");
        outline77.append(this.messageFragments);
        outline77.append(", replyFragments=");
        outline77.append(this.replyFragments);
        outline77.append(", internalMeta=");
        outline77.append(this.internalMeta);
        outline77.append(", replyTo=");
        outline77.append(this.replyTo);
        outline77.append(", isResponded=");
        outline77.append(this.isResponded);
        outline77.append(", shouldTranslate=");
        outline77.append(this.shouldTranslate);
        outline77.append(", flowStepId=");
        outline77.append(this.flowStepId);
        outline77.append(", messageUserName=");
        outline77.append(this.messageUserName);
        outline77.append(", messageUserProfilePic=");
        return GeneratedOutlineSupport.outline59(outline77, this.messageUserProfilePic, '}');
    }
}
