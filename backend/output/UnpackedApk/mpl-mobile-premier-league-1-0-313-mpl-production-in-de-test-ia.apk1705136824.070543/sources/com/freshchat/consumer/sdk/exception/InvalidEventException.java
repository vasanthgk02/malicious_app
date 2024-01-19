package com.freshchat.consumer.sdk.exception;

import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.j.as;

public class InvalidEventException extends Exception {
    public InvalidEventException(String str, int i) {
        super(composeErrorMessage(str, i));
    }

    public static String composeErrorMessage(String str, int i) {
        String cVar = c.USER_EVENT_NAME_KEY_LENGTH_ERROR.toString();
        if (as.isEmpty(str)) {
            cVar = c.USER_EVENT_NAME_KEY_EMPTY_ERROR.toString();
        }
        return cVar.replace("{{user_event_key_placeholder}}", str).replace("{{user_event_name_length_placeholder}}", String.valueOf(i));
    }
}
