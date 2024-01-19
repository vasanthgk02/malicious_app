package com.crimzoncode.tqcontests.api.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericResponse {
    public static final String TAG = "GENERIC_RESPONSE";
    @SerializedName("message")
    public String message;
    @SerializedName("result")
    public ArrayList<ResultResponse> resultList = new ArrayList<>();
    @SerializedName("status")
    public String status;

    public ErrorResponse getErrorResponse() {
        if (this.resultList.size() == 0) {
            return null;
        }
        return this.resultList.get(0).getErrorResponse();
    }

    public String getMessage() {
        return this.message;
    }

    public ResultResponse getResultWithKey(String str) {
        Iterator<ResultResponse> it = this.resultList.iterator();
        while (it.hasNext()) {
            ResultResponse next = it.next();
            if (next.getName().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public boolean isSuccessful() {
        return this.status.equals("SUCCESS");
    }
}
