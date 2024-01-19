package com.freshchat.consumer.sdk.e;

import android.content.Context;
import android.util.Base64;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.ConversationReadStatus;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;
import com.freshchat.consumer.sdk.beans.reqres.ChannelsResponseTimeResponse;
import com.freshchat.consumer.sdk.beans.reqres.ConversationsResponse;
import com.freshchat.consumer.sdk.beans.reqres.CsatResponseRequest;
import com.freshchat.consumer.sdk.beans.reqres.UploadImageResponse;
import com.freshchat.consumer.sdk.beans.reqres.UploadInboundEventsResponse;
import com.freshchat.consumer.sdk.beans.reqres.UserRequest;
import com.freshchat.consumer.sdk.beans.reqres.UserResponse;
import com.freshchat.consumer.sdk.beans.reqres.ValidateJwtIdTokenResponse;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ab.d;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a.c;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public class a {
    public final Context context;

    public a(Context context2) {
        this.context = context2;
        aa.fF();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r0.getErrorCode() == com.freshchat.consumer.sdk.beans.reqres.ErrorResponse.ServerErrorCodes.ERROR_CODE_JWT_CLAIMS_TOO_LARGE) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r0.getErrorCode() == com.freshchat.consumer.sdk.beans.reqres.ErrorResponse.ServerErrorCodes.ERROR_CODE_INVALID_JWT_TOKEN) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r4, java.lang.String r5) throws com.freshchat.consumer.sdk.exception.DeletedException {
        /*
            r3 = this;
            com.freshchat.consumer.sdk.j.ab r0 = new com.freshchat.consumer.sdk.j.ab
            r0.<init>()
            java.lang.Class<com.freshchat.consumer.sdk.beans.reqres.ErrorResponse> r1 = com.freshchat.consumer.sdk.beans.reqres.ErrorResponse.class
            java.lang.Object r0 = r0.fromJson(r5, r1)     // Catch:{ Exception -> 0x000e }
            com.freshchat.consumer.sdk.beans.reqres.ErrorResponse r0 = (com.freshchat.consumer.sdk.beans.reqres.ErrorResponse) r0     // Catch:{ Exception -> 0x000e }
            goto L_0x0017
        L_0x000e:
            r0 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r0)
            com.freshchat.consumer.sdk.beans.reqres.ErrorResponse r0 = new com.freshchat.consumer.sdk.beans.reqres.ErrorResponse
            r0.<init>()
        L_0x0017:
            r1 = 410(0x19a, float:5.75E-43)
            r2 = 1
            if (r4 != r1) goto L_0x0024
            android.content.Context r4 = r3.getContext()
            com.freshchat.consumer.sdk.e.f.o(r4, r5)
            goto L_0x005d
        L_0x0024:
            r5 = 428(0x1ac, float:6.0E-43)
            if (r4 != r5) goto L_0x0030
        L_0x0028:
            android.content.Context r4 = r3.getContext()
            com.freshchat.consumer.sdk.j.o.bA(r4)
            goto L_0x005d
        L_0x0030:
            r5 = 413(0x19d, float:5.79E-43)
            if (r4 != r5) goto L_0x003d
            com.freshchat.consumer.sdk.beans.reqres.ErrorResponse$ServerErrorCodes r4 = r0.getErrorCode()
            com.freshchat.consumer.sdk.beans.reqres.ErrorResponse$ServerErrorCodes r5 = com.freshchat.consumer.sdk.beans.reqres.ErrorResponse.ServerErrorCodes.ERROR_CODE_JWT_CLAIMS_TOO_LARGE
            if (r4 != r5) goto L_0x005c
            goto L_0x0028
        L_0x003d:
            r5 = 412(0x19c, float:5.77E-43)
            if (r4 != r5) goto L_0x005c
            com.freshchat.consumer.sdk.beans.reqres.ErrorResponse$ServerErrorCodes r4 = r0.getErrorCode()
            com.freshchat.consumer.sdk.beans.reqres.ErrorResponse$ServerErrorCodes r5 = com.freshchat.consumer.sdk.beans.reqres.ErrorResponse.ServerErrorCodes.ERROR_CODE_JWT_TOKEN_EXPIRED
            if (r4 != r5) goto L_0x0053
            android.content.Context r4 = r3.getContext()
            com.freshchat.consumer.sdk.JwtTokenStatus r5 = com.freshchat.consumer.sdk.JwtTokenStatus.TOKEN_EXPIRED
            com.freshchat.consumer.sdk.j.o.a(r4, r5)
            goto L_0x005d
        L_0x0053:
            com.freshchat.consumer.sdk.beans.reqres.ErrorResponse$ServerErrorCodes r4 = r0.getErrorCode()
            com.freshchat.consumer.sdk.beans.reqres.ErrorResponse$ServerErrorCodes r5 = com.freshchat.consumer.sdk.beans.reqres.ErrorResponse.ServerErrorCodes.ERROR_CODE_INVALID_JWT_TOKEN
            if (r4 != r5) goto L_0x005c
            goto L_0x0028
        L_0x005c:
            r2 = 0
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.e.a.a(int, java.lang.String):boolean");
    }

    private Context getContext() {
        return this.context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r4 == false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse a(int r3, java.util.List<java.lang.String> r4) {
        /*
            r2 = this;
            com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse r0 = new com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse
            r0.<init>()
            android.content.Context r1 = r2.getContext()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = com.freshchat.consumer.sdk.j.a.a(r1, r3, r4)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.e.c r4 = new com.freshchat.consumer.sdk.e.c     // Catch:{ Exception -> 0x0054 }
            android.content.Context r1 = r2.context     // Catch:{ Exception -> 0x0054 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.e.d r3 = r4.ae(r3)     // Catch:{ Exception -> 0x0054 }
            int r4 = r3.getStatusCode()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r1 = com.freshchat.consumer.sdk.e.c.a(r3)     // Catch:{ Exception -> 0x0054 }
            boolean r4 = r2.a(r4, r1)     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0027
            goto L_0x0049
        L_0x0027:
            int r3 = r3.getStatusCode()     // Catch:{ Exception -> 0x0054 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x0049
            com.freshchat.consumer.sdk.j.ab r3 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0054 }
            java.lang.Class<com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse> r4 = com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse.class
            java.lang.Object r3 = r3.fromJson(r1, r4)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse r3 = (com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse) r3     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.service.Status r4 = com.freshchat.consumer.sdk.service.Status.SUCCESS     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r3.setStatus(r4)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r4 = 0
            r0 = r3
            goto L_0x004a
        L_0x0043:
            r4 = move-exception
            r0 = r3
            goto L_0x005a
        L_0x0046:
            r4 = move-exception
            r0 = r3
            goto L_0x0055
        L_0x0049:
            r4 = 1
        L_0x004a:
            if (r4 == 0) goto L_0x0059
        L_0x004c:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
            goto L_0x0059
        L_0x0052:
            r4 = move-exception
            goto L_0x005a
        L_0x0054:
            r4 = move-exception
        L_0x0055:
            com.freshchat.consumer.sdk.j.q.a(r4)     // Catch:{ all -> 0x0052 }
            goto L_0x004c
        L_0x0059:
            return r0
        L_0x005a:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.e.a.a(int, java.util.List):com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse");
    }

    public ConversationsResponse a(String str, int i) throws DeletedException {
        try {
            d ae = new c(this.context).ae(com.freshchat.consumer.sdk.j.a.a(this.context, str, i));
            int statusCode = ae.getStatusCode();
            String a2 = c.a(ae);
            if (!a(statusCode, a2)) {
                if (statusCode != 200) {
                    throw new b("sc: " + statusCode + " m: " + a2);
                }
            }
            ConversationsResponse conversationsResponse = (ConversationsResponse) new ab().fromJson(a2, ConversationsResponse.class);
            conversationsResponse.setStatusCode(statusCode);
            return conversationsResponse;
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public UploadImageResponse a(MessageFragment messageFragment, int i) throws DeletedException {
        try {
            e eVar = new e(this.context, com.freshchat.consumer.sdk.j.a.J(this.context));
            String content = messageFragment.getContent();
            InputStream aE = as.a(content) ? ad.aE(content) : null;
            if (aE != null) {
                eVar.a("pic", "picFile", aE, messageFragment.getContentType());
            }
            eVar.f("name", "pic_" + i);
            d dc = eVar.dc();
            String a2 = c.a(dc);
            if (a(dc.getStatusCode(), a2)) {
                return null;
            }
            return (UploadImageResponse) new ab().fromJson(a2, UploadImageResponse.class);
        } catch (DeletedException e2) {
            throw e2;
        } catch (Exception e3) {
            q.a(e3);
        }
    }

    public UserResponse a(UserRequest userRequest) throws DeletedException {
        try {
            String G = com.freshchat.consumer.sdk.j.a.G(this.context);
            User user = userRequest.getUser();
            c cVar = new c(this.context);
            ab abVar = new ab();
            d c2 = cVar.c(G, abVar.toJson(userRequest));
            int statusCode = c2.getStatusCode();
            String a2 = c.a(c2);
            if (!a(statusCode, a2)) {
                if (statusCode != 201) {
                    if (statusCode == 304) {
                        return new UserResponse(statusCode, user);
                    }
                    if (statusCode == 409) {
                        return new UserResponse(statusCode, null);
                    }
                    throw new b("sc: " + statusCode + " m: " + a2);
                }
            }
            return new UserResponse(statusCode, (User) abVar.fromJson(a2, User.class));
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r4 == false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.ai a(int r3, java.lang.String r4, java.util.List<java.lang.String> r5) {
        /*
            r2 = this;
            com.freshchat.consumer.sdk.service.e.ai r0 = new com.freshchat.consumer.sdk.service.e.ai
            r0.<init>()
            android.content.Context r1 = r2.getContext()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = com.freshchat.consumer.sdk.j.a.a(r1, r3, r4, r5)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.e.c r4 = new com.freshchat.consumer.sdk.e.c     // Catch:{ Exception -> 0x0054 }
            android.content.Context r5 = r2.context     // Catch:{ Exception -> 0x0054 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.e.d r3 = r4.ae(r3)     // Catch:{ Exception -> 0x0054 }
            int r4 = r3.getStatusCode()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r5 = com.freshchat.consumer.sdk.e.c.a(r3)     // Catch:{ Exception -> 0x0054 }
            boolean r4 = r2.a(r4, r5)     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0027
            goto L_0x0049
        L_0x0027:
            int r3 = r3.getStatusCode()     // Catch:{ Exception -> 0x0054 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x0049
            com.freshchat.consumer.sdk.j.ab r3 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0054 }
            java.lang.Class<com.freshchat.consumer.sdk.service.e.ai> r4 = com.freshchat.consumer.sdk.service.e.ai.class
            java.lang.Object r3 = r3.fromJson(r5, r4)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.service.e.ai r3 = (com.freshchat.consumer.sdk.service.e.ai) r3     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.service.Status r4 = com.freshchat.consumer.sdk.service.Status.SUCCESS     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r3.setStatus(r4)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r4 = 0
            r0 = r3
            goto L_0x004a
        L_0x0043:
            r4 = move-exception
            r0 = r3
            goto L_0x005a
        L_0x0046:
            r4 = move-exception
            r0 = r3
            goto L_0x0055
        L_0x0049:
            r4 = 1
        L_0x004a:
            if (r4 == 0) goto L_0x0059
        L_0x004c:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
            goto L_0x0059
        L_0x0052:
            r4 = move-exception
            goto L_0x005a
        L_0x0054:
            r4 = move-exception
        L_0x0055:
            com.freshchat.consumer.sdk.j.q.a(r4)     // Catch:{ all -> 0x0052 }
            goto L_0x004c
        L_0x0059:
            return r0
        L_0x005a:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.e.a.a(int, java.lang.String, java.util.List):com.freshchat.consumer.sdk.service.e.ai");
    }

    public void a(ConversationReadStatus conversationReadStatus) throws DeletedException {
        try {
            d c2 = new c(this.context).c(com.freshchat.consumer.sdk.j.a.B(this.context), new ab().toJson(conversationReadStatus));
            String a2 = c.a(c2);
            if (!a(c2.getStatusCode(), a2)) {
                if (c2.getStatusCode() != 200) {
                    throw new b("sc: " + c2.getStatusCode() + " m: " + a2);
                }
            }
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public void a(String str, String str2, String str3, String str4) throws DeletedException {
        try {
            d af = new c(this.context).af(com.freshchat.consumer.sdk.j.a.a(this.context, str, str2, str3, str4));
            int statusCode = af.getStatusCode();
            String a2 = c.a(af);
            if (!a(statusCode, a2)) {
                if (statusCode != 200) {
                    throw new b("sc: " + statusCode + " m: " + a2);
                }
            }
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public boolean a(CsatResponseRequest csatResponseRequest, String str, String str2) throws DeletedException {
        try {
            d c2 = new c(this.context).c(com.freshchat.consumer.sdk.j.a.b(this.context, str, str2), new ab().toJson(csatResponseRequest));
            int statusCode = c2.getStatusCode();
            return !a(statusCode, c.a(c2)) && statusCode == 201;
        } catch (DeletedException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public boolean a(String str, CallbackButtonFragment callbackButtonFragment, String str2) throws DeletedException {
        try {
            d c2 = new c(this.context).c(com.freshchat.consumer.sdk.j.a.j(this.context, str, str2), ab.in().toJson(callbackButtonFragment));
            int statusCode = c2.getStatusCode();
            return !a(statusCode, c.a(c2)) && statusCode == 200;
        } catch (DeletedException e2) {
            throw e2;
        } catch (Exception e3) {
            q.a(e3);
            return false;
        }
    }

    public boolean a(String str, String str2, JSONObject jSONObject) throws DeletedException {
        try {
            d d2 = new c(this.context).d(com.freshchat.consumer.sdk.j.a.a(this.context, str, str2), jSONObject.toString());
            if (!a(d2.getStatusCode(), c.a(d2))) {
                if (d2.getStatusCode() == 200) {
                    return true;
                }
            }
            return false;
        } catch (DeletedException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public ValidateJwtIdTokenResponse aZ(String str) {
        try {
            String bv = com.freshchat.consumer.sdk.j.a.bv(this.context);
            c cVar = new c(this.context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jwtAuthToken", str);
            d c2 = cVar.c(bv, jSONObject.toString());
            int statusCode = c2.getStatusCode();
            String a2 = c.a(c2);
            if (!a(statusCode, a2)) {
                if (statusCode != 200) {
                    throw new b("sc: " + statusCode + " m: " + a2);
                }
            }
            return (ValidateJwtIdTokenResponse) new ab().fromJson(a2, ValidateJwtIdTokenResponse.class);
        } catch (DeletedException unused) {
            return null;
        } catch (b e2) {
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public boolean ad(String str) throws DeletedException {
        try {
            d af = new c(this.context).af(com.freshchat.consumer.sdk.j.a.g(this.context, str));
            int statusCode = af.getStatusCode();
            return !a(statusCode, c.a(af)) && statusCode == 200;
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public boolean ap(String str) {
        try {
            d af = new c(this.context).af(com.freshchat.consumer.sdk.j.a.h(this.context, str));
            if (!a(af.getStatusCode(), c.a(af))) {
                if (af.getStatusCode() == 202) {
                    return true;
                }
            }
            return false;
        } catch (DeletedException unused) {
            return true;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public UserResponse b(UserRequest userRequest) throws DeletedException {
        try {
            String H = com.freshchat.consumer.sdk.j.a.H(this.context);
            c cVar = new c(this.context);
            ab abVar = new ab();
            d d2 = cVar.d(H, abVar.toJson(userRequest));
            int statusCode = d2.getStatusCode();
            String a2 = c.a(d2);
            if (!a(statusCode, a2)) {
                if (statusCode == 409) {
                    return new UserResponse(statusCode, null);
                }
                if (statusCode != 200) {
                    throw new b("sc: " + statusCode + " m: " + a2);
                }
            }
            return new UserResponse(statusCode, (User) abVar.fromJson(a2, User.class));
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r4 == false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.ai b(int r3, java.lang.String r4, java.util.List<java.lang.String> r5) {
        /*
            r2 = this;
            com.freshchat.consumer.sdk.service.e.ai r0 = new com.freshchat.consumer.sdk.service.e.ai
            r0.<init>()
            android.content.Context r1 = r2.getContext()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = com.freshchat.consumer.sdk.j.a.b(r1, r3, r4, r5)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.e.c r4 = new com.freshchat.consumer.sdk.e.c     // Catch:{ Exception -> 0x0054 }
            android.content.Context r5 = r2.context     // Catch:{ Exception -> 0x0054 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.e.d r3 = r4.ae(r3)     // Catch:{ Exception -> 0x0054 }
            int r4 = r3.getStatusCode()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r5 = com.freshchat.consumer.sdk.e.c.a(r3)     // Catch:{ Exception -> 0x0054 }
            boolean r4 = r2.a(r4, r5)     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0027
            goto L_0x0049
        L_0x0027:
            int r3 = r3.getStatusCode()     // Catch:{ Exception -> 0x0054 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x0049
            com.freshchat.consumer.sdk.j.ab r3 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0054 }
            java.lang.Class<com.freshchat.consumer.sdk.service.e.ai> r4 = com.freshchat.consumer.sdk.service.e.ai.class
            java.lang.Object r3 = r3.fromJson(r5, r4)     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.service.e.ai r3 = (com.freshchat.consumer.sdk.service.e.ai) r3     // Catch:{ Exception -> 0x0054 }
            com.freshchat.consumer.sdk.service.Status r4 = com.freshchat.consumer.sdk.service.Status.SUCCESS     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r3.setStatus(r4)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r4 = 0
            r0 = r3
            goto L_0x004a
        L_0x0043:
            r4 = move-exception
            r0 = r3
            goto L_0x005a
        L_0x0046:
            r4 = move-exception
            r0 = r3
            goto L_0x0055
        L_0x0049:
            r4 = 1
        L_0x004a:
            if (r4 == 0) goto L_0x0059
        L_0x004c:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
            goto L_0x0059
        L_0x0052:
            r4 = move-exception
            goto L_0x005a
        L_0x0054:
            r4 = move-exception
        L_0x0055:
            com.freshchat.consumer.sdk.j.q.a(r4)     // Catch:{ all -> 0x0052 }
            goto L_0x004c
        L_0x0059:
            return r0
        L_0x005a:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.e.a.b(int, java.lang.String, java.util.List):com.freshchat.consumer.sdk.service.e.ai");
    }

    public AgentAvailabilityResponse bp(String str) throws DeletedException {
        try {
            d ae = new c(this.context).ae(com.freshchat.consumer.sdk.j.a.H(this.context, str));
            int statusCode = ae.getStatusCode();
            String a2 = c.a(ae);
            if (!a(statusCode, a2)) {
                if (statusCode != 200) {
                    throw new b("sc: " + statusCode + " m: " + a2);
                }
            }
            return (AgentAvailabilityResponse) new ab().fromJson(a2, AgentAvailabilityResponse.class);
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public UserResponse c(UserRequest userRequest) throws DeletedException {
        User user;
        try {
            String bw = com.freshchat.consumer.sdk.j.a.bw(this.context);
            c cVar = new c(this.context);
            ab abVar = new ab();
            d c2 = cVar.c(bw, abVar.toJson(userRequest));
            int statusCode = c2.getStatusCode();
            String a2 = c.a(c2);
            if (!a(statusCode, a2)) {
                if (statusCode == 200) {
                    user = (User) abVar.fromJson(a2, User.class);
                    return new UserResponse(statusCode, user);
                }
            }
            user = null;
            return new UserResponse(statusCode, user);
        } catch (DeletedException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public boolean cV() throws DeletedException {
        try {
            d ag = new c(this.context).ag(com.freshchat.consumer.sdk.j.a.D(this.context));
            int statusCode = ag.getStatusCode();
            return !a(statusCode, c.a(ag)) && statusCode == 200;
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public boolean cW() throws DeletedException {
        try {
            d ag = new c(this.context).ag(com.freshchat.consumer.sdk.j.a.E(this.context));
            int statusCode = ag.getStatusCode();
            return !a(statusCode, c.a(ag)) && statusCode == 200;
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public boolean cX() throws DeletedException {
        try {
            d af = new c(this.context).af(com.freshchat.consumer.sdk.j.a.F(this.context));
            int statusCode = af.getStatusCode();
            return !a(statusCode, c.a(af)) && statusCode == 200;
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public ChannelsResponseTimeResponse cZ() throws DeletedException {
        try {
            d ae = new c(this.context).ae(com.freshchat.consumer.sdk.j.a.K(this.context));
            int statusCode = ae.getStatusCode();
            String a2 = c.a(ae);
            if (!a(statusCode, a2)) {
                if (statusCode != 200) {
                    throw new b("sc: " + statusCode + " m: " + a2);
                }
            }
            return (ChannelsResponseTimeResponse) new ab().fromJson(a2, ChannelsResponseTimeResponse.class);
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public Message d(Message message) throws DeletedException {
        try {
            String I = com.freshchat.consumer.sdk.j.a.I(this.context);
            ab abVar = new ab(new d());
            d c2 = new c(this.context).c(I, abVar.toJson(message));
            String a2 = c.a(c2);
            int statusCode = c2.getStatusCode();
            com.freshchat.consumer.sdk.b.a.a aVar = new com.freshchat.consumer.sdk.b.a.a(a2);
            if (!a(statusCode, a2)) {
                if (statusCode != 201) {
                    String str = "sc: " + statusCode + " m: " + a2;
                    ai.d("FRESHCHAT", str);
                    if (aVar.isValid() && aVar.cm() != null) {
                        JSONObject cm = aVar.cm();
                        if (cm.has("errorCode") && cm.getInt("errorCode") == -1) {
                            e.i(this.context).c(false);
                            if (!c.t(this.context)) {
                                b.a(this.context, (User) null, true);
                            }
                            b.M(this.context);
                        }
                    }
                    throw new b(str);
                }
            }
            return (Message) abVar.fromJson(a2, Message.class);
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        if (r4 == false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.an d(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            com.freshchat.consumer.sdk.service.e.an r0 = new com.freshchat.consumer.sdk.service.e.an
            r0.<init>()
            android.content.Context r1 = r2.context     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = com.freshchat.consumer.sdk.j.a.b(r1, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0047 }
            com.freshchat.consumer.sdk.e.c r4 = new com.freshchat.consumer.sdk.e.c     // Catch:{ Exception -> 0x0047 }
            android.content.Context r5 = r2.context     // Catch:{ Exception -> 0x0047 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0047 }
            com.freshchat.consumer.sdk.e.d r3 = r4.af(r3)     // Catch:{ Exception -> 0x0047 }
            int r4 = r3.getStatusCode()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r5 = com.freshchat.consumer.sdk.e.c.a(r3)     // Catch:{ Exception -> 0x0047 }
            boolean r4 = r2.a(r4, r5)     // Catch:{ Exception -> 0x0047 }
            if (r4 == 0) goto L_0x0025
            goto L_0x003c
        L_0x0025:
            int r3 = r3.getStatusCode()     // Catch:{ Exception -> 0x0047 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x003c
            com.freshchat.consumer.sdk.j.ab r3 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0047 }
            java.lang.Class<com.freshchat.consumer.sdk.service.e.an> r4 = com.freshchat.consumer.sdk.service.e.an.class
            java.lang.Object r3 = r3.fromJson(r5, r4)     // Catch:{ Exception -> 0x0047 }
            com.freshchat.consumer.sdk.service.e.an r3 = (com.freshchat.consumer.sdk.service.e.an) r3     // Catch:{ Exception -> 0x0047 }
            r4 = 0
            r0 = r3
            goto L_0x003d
        L_0x003c:
            r4 = 1
        L_0x003d:
            if (r4 == 0) goto L_0x004c
        L_0x003f:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
            goto L_0x004c
        L_0x0045:
            r3 = move-exception
            goto L_0x004d
        L_0x0047:
            r3 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r3)     // Catch:{ all -> 0x0045 }
            goto L_0x003f
        L_0x004c:
            return r0
        L_0x004d:
            com.freshchat.consumer.sdk.service.Status r4 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.e.a.d(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.freshchat.consumer.sdk.service.e.an");
    }

    public RemoteConfig gg() throws DeletedException {
        try {
            d ae = new c(this.context).ae(com.freshchat.consumer.sdk.j.a.y(this.context));
            int statusCode = ae.getStatusCode();
            String a2 = c.a(ae);
            if (!a(statusCode, a2)) {
                if (statusCode == 200) {
                    return (RemoteConfig) new ab().fromJson(a2, RemoteConfig.class);
                }
            }
            return null;
        } catch (DeletedException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public UploadInboundEventsResponse h(String str, String str2) throws DeletedException {
        try {
            d c2 = new c(this.context).c(com.freshchat.consumer.sdk.j.a.G(this.context, str2), str);
            int statusCode = c2.getStatusCode();
            String a2 = c.a(c2);
            if (!a(statusCode, a2)) {
                if (statusCode != 202) {
                    throw new b("sc: " + statusCode + " m: " + a2);
                }
            }
            return (UploadInboundEventsResponse) new ab().fromJson(a2, UploadInboundEventsResponse.class);
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        if (r3 == false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.reqres.FAQFetchResponse l(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            com.freshchat.consumer.sdk.beans.reqres.FAQFetchResponse r0 = new com.freshchat.consumer.sdk.beans.reqres.FAQFetchResponse
            r0.<init>()
            android.content.Context r1 = r2.getContext()     // Catch:{ Exception -> 0x004b }
            java.lang.String r3 = com.freshchat.consumer.sdk.j.a.g(r1, r3, r4)     // Catch:{ Exception -> 0x004b }
            com.freshchat.consumer.sdk.e.c r4 = new com.freshchat.consumer.sdk.e.c     // Catch:{ Exception -> 0x004b }
            android.content.Context r1 = r2.context     // Catch:{ Exception -> 0x004b }
            r4.<init>(r1)     // Catch:{ Exception -> 0x004b }
            com.freshchat.consumer.sdk.e.d r3 = r4.ae(r3)     // Catch:{ Exception -> 0x004b }
            int r4 = r3.getStatusCode()     // Catch:{ Exception -> 0x004b }
            java.lang.String r1 = com.freshchat.consumer.sdk.e.c.a(r3)     // Catch:{ Exception -> 0x004b }
            boolean r4 = r2.a(r4, r1)     // Catch:{ Exception -> 0x004b }
            if (r4 == 0) goto L_0x0027
            goto L_0x0045
        L_0x0027:
            int r3 = r3.getStatusCode()     // Catch:{ Exception -> 0x004b }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x0045
            com.freshchat.consumer.sdk.j.ab r3 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x004b }
            java.lang.Class<com.freshchat.consumer.sdk.beans.FAQ> r4 = com.freshchat.consumer.sdk.beans.FAQ.class
            java.lang.Object r3 = r3.fromJson(r1, r4)     // Catch:{ Exception -> 0x004b }
            com.freshchat.consumer.sdk.beans.FAQ r3 = (com.freshchat.consumer.sdk.beans.FAQ) r3     // Catch:{ Exception -> 0x004b }
            r0.setFaq(r3)     // Catch:{ Exception -> 0x004b }
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.SUCCESS     // Catch:{ Exception -> 0x004b }
            r0.setStatus(r3)     // Catch:{ Exception -> 0x004b }
            r3 = 0
            goto L_0x0046
        L_0x0045:
            r3 = 1
        L_0x0046:
            if (r3 == 0) goto L_0x0054
            goto L_0x004f
        L_0x0049:
            r3 = move-exception
            goto L_0x0055
        L_0x004b:
            r3 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r3)     // Catch:{ all -> 0x0049 }
        L_0x004f:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
        L_0x0054:
            return r0
        L_0x0055:
            com.freshchat.consumer.sdk.service.Status r4 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.e.a.l(java.lang.String, java.lang.String):com.freshchat.consumer.sdk.beans.reqres.FAQFetchResponse");
    }

    public UserResponse n(String str, String str2) throws DeletedException {
        User user;
        try {
            d ae = new c(getContext()).ae(com.freshchat.consumer.sdk.j.a.e(getContext(), Base64.encodeToString(str.getBytes(), 11), str2));
            int statusCode = ae.getStatusCode();
            String a2 = c.a(ae);
            if (!a(statusCode, a2)) {
                if (statusCode == 200) {
                    user = (User) new ab().fromJson(a2, User.class);
                    return new UserResponse(statusCode, user);
                }
            }
            user = null;
            return new UserResponse(statusCode, user);
        } catch (DeletedException e2) {
            throw e2;
        } catch (b e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public boolean q(long j) throws DeletedException {
        try {
            e eVar = new e(this.context, com.freshchat.consumer.sdk.j.a.b(this.context, j), "PUT");
            eVar.a(AnalyticsConstants.LOG, ai.aR(this.context));
            d dc = eVar.dc();
            int statusCode = dc.getStatusCode();
            if (statusCode == 410) {
                f.o(this.context, c.a(dc));
            } else if (statusCode == 200) {
                return true;
            }
        } catch (DeletedException e2) {
            throw e2;
        } catch (IOException unused) {
            ai.e("FRESHCHAT", "Failed to upload log");
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (r3 == false) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.beans.reqres.BotFAQFetchResponse z(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            com.freshchat.consumer.sdk.beans.reqres.BotFAQFetchResponse r0 = new com.freshchat.consumer.sdk.beans.reqres.BotFAQFetchResponse
            r0.<init>()
            android.content.Context r1 = r2.getContext()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = com.freshchat.consumer.sdk.j.a.i(r1, r3, r4)     // Catch:{ Exception -> 0x0047 }
            com.freshchat.consumer.sdk.e.c r4 = new com.freshchat.consumer.sdk.e.c     // Catch:{ Exception -> 0x0047 }
            android.content.Context r1 = r2.context     // Catch:{ Exception -> 0x0047 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0047 }
            com.freshchat.consumer.sdk.e.d r3 = r4.ae(r3)     // Catch:{ Exception -> 0x0047 }
            int r4 = r3.getStatusCode()     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = com.freshchat.consumer.sdk.e.c.a(r3)     // Catch:{ Exception -> 0x0047 }
            boolean r1 = r2.a(r4, r3)     // Catch:{ Exception -> 0x0047 }
            if (r1 == 0) goto L_0x0027
            goto L_0x0041
        L_0x0027:
            r1 = 200(0xc8, float:2.8E-43)
            if (r4 != r1) goto L_0x0041
            com.freshchat.consumer.sdk.j.ab r4 = com.freshchat.consumer.sdk.j.ab.in()     // Catch:{ Exception -> 0x0047 }
            java.lang.Class<com.freshchat.consumer.sdk.beans.BotFAQ> r1 = com.freshchat.consumer.sdk.beans.BotFAQ.class
            java.lang.Object r3 = r4.fromJson(r3, r1)     // Catch:{ Exception -> 0x0047 }
            com.freshchat.consumer.sdk.beans.BotFAQ r3 = (com.freshchat.consumer.sdk.beans.BotFAQ) r3     // Catch:{ Exception -> 0x0047 }
            r0.setBotFAQ(r3)     // Catch:{ Exception -> 0x0047 }
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.SUCCESS     // Catch:{ Exception -> 0x0047 }
            r0.setStatus(r3)     // Catch:{ Exception -> 0x0047 }
            r3 = 0
            goto L_0x0042
        L_0x0041:
            r3 = 1
        L_0x0042:
            if (r3 == 0) goto L_0x0050
            goto L_0x004b
        L_0x0045:
            r3 = move-exception
            goto L_0x0051
        L_0x0047:
            r3 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r3)     // Catch:{ all -> 0x0045 }
        L_0x004b:
            com.freshchat.consumer.sdk.service.Status r3 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r3)
        L_0x0050:
            return r0
        L_0x0051:
            com.freshchat.consumer.sdk.service.Status r4 = com.freshchat.consumer.sdk.service.Status.ERROR
            r0.setStatus(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.e.a.z(java.lang.String, java.lang.String):com.freshchat.consumer.sdk.beans.reqres.BotFAQFetchResponse");
    }
}
