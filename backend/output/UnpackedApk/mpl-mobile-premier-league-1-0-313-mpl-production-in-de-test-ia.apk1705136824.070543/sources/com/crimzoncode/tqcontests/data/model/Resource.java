package com.crimzoncode.tqcontests.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0010\u0011B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/crimzoncode/tqcontests/data/model/Resource;", "T", "", "status", "Lcom/crimzoncode/tqcontests/data/model/Resource$Status;", "data", "message", "", "(Lcom/crimzoncode/tqcontests/data/model/Resource$Status;Ljava/lang/Object;Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "getStatus", "()Lcom/crimzoncode/tqcontests/data/model/Resource$Status;", "Companion", "Status", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Resource.kt */
public final class Resource<T> {
    public static final Companion Companion = new Companion(null);
    public final T data;
    public final String message;
    public final Status status;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\tJ#\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\u000bJ/\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/crimzoncode/tqcontests/data/model/Resource$Companion;", "", "()V", "error", "Lcom/crimzoncode/tqcontests/data/model/Resource;", "T", "message", "", "data", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/crimzoncode/tqcontests/data/model/Resource;", "loading", "(Ljava/lang/Object;)Lcom/crimzoncode/tqcontests/data/model/Resource;", "success", "(Ljava/lang/Object;Ljava/lang/String;)Lcom/crimzoncode/tqcontests/data/model/Resource;", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Resource.kt */
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ Resource error$default(Companion companion, String str, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            return companion.error(str, obj);
        }

        public static /* synthetic */ Resource loading$default(Companion companion, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return companion.loading(obj);
        }

        public static /* synthetic */ Resource success$default(Companion companion, Object obj, String str, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.success(obj, str);
        }

        public final <T> Resource<T> error(String str, T t) {
            return new Resource<>(Status.ERROR, t, str);
        }

        public final <T> Resource<T> loading(T t) {
            return new Resource<>(Status.LOADING, t, null);
        }

        public final <T> Resource<T> success(T t, String str) {
            return new Resource<>(Status.SUCCESS, t, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/crimzoncode/tqcontests/data/model/Resource$Status;", "", "(Ljava/lang/String;I)V", "LOADING", "SUCCESS", "ERROR", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Resource.kt */
    public enum Status {
        LOADING,
        SUCCESS,
        ERROR
    }

    public Resource(Status status2, T t, String str) {
        Intrinsics.checkParameterIsNotNull(status2, "status");
        this.status = status2;
        this.data = t;
        this.message = str;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Status getStatus() {
        return this.status;
    }
}
