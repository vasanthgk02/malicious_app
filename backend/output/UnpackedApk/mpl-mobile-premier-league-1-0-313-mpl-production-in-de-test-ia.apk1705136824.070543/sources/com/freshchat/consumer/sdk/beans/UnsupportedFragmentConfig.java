package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnsupportedFragmentConfig {
    public boolean displayErrorCodes;
    public String errorCodePlaceholder;
    public List<FragmentErrorMessage> errorMessageByTypes;
    public HashMap<Integer, FragmentErrorMessage> errorMessageByTypesMap = null;
    public ErrorMessage globalErrorMessage;

    public class ErrorMessage {
        public String contentType;
        public long errorCode;
        public String errorMessage;

        public ErrorMessage() {
        }

        public String getContentType() {
            return this.contentType;
        }

        public long getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }
    }

    public class FragmentErrorMessage {
        public ErrorMessage defaultErrorMessage;
        public HashMap<String, ErrorMessage> errorMessageMap = null;
        public List<ErrorMessage> errorMessages;
        public int fragmentType;

        public FragmentErrorMessage() {
        }

        public HashMap<String, ErrorMessage> getErrorMessageMap() {
            if (k.d((Map<?, ?>) this.errorMessageMap)) {
                return this.errorMessageMap;
            }
            this.errorMessageMap = new HashMap<>();
            if (k.a(this.errorMessages)) {
                for (ErrorMessage next : this.errorMessages) {
                    this.errorMessageMap.put(next.getContentType(), next);
                }
            }
            return this.errorMessageMap;
        }
    }

    public String getDisplayableErrorMessage(ErrorMessage errorMessage) {
        if (errorMessage == null) {
            return null;
        }
        String errorMessage2 = errorMessage.getErrorMessage();
        if (this.displayErrorCodes && as.a(this.errorCodePlaceholder)) {
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(errorMessage2, "\n");
            outline78.append(this.errorCodePlaceholder.replace("%d", String.valueOf(errorMessage.getErrorCode())));
            errorMessage2 = outline78.toString();
        }
        return errorMessage2;
    }

    public ErrorMessage getErrorMessage(Integer num, String str) {
        ErrorMessage errorMessage;
        FragmentErrorMessage fragmentErrorMessage = getErrorMessageByTypesMap().get(num);
        if (fragmentErrorMessage != null) {
            errorMessage = fragmentErrorMessage.getErrorMessageMap().get(str);
            if (errorMessage == null || as.isEmpty(errorMessage.getErrorMessage())) {
                errorMessage = fragmentErrorMessage.defaultErrorMessage;
            }
        } else {
            errorMessage = null;
        }
        return (errorMessage == null || as.isEmpty(errorMessage.getErrorMessage())) ? this.globalErrorMessage : errorMessage;
    }

    public HashMap<Integer, FragmentErrorMessage> getErrorMessageByTypesMap() {
        if (k.d((Map<?, ?>) this.errorMessageByTypesMap)) {
            return this.errorMessageByTypesMap;
        }
        this.errorMessageByTypesMap = new HashMap<>();
        if (k.isEmpty(this.errorMessageByTypes)) {
            return this.errorMessageByTypesMap;
        }
        for (FragmentErrorMessage next : this.errorMessageByTypes) {
            this.errorMessageByTypesMap.put(Integer.valueOf(next.fragmentType), next);
        }
        return this.errorMessageByTypesMap;
    }

    public ErrorMessage getGlobalErrorMessage() {
        return this.globalErrorMessage;
    }
}
