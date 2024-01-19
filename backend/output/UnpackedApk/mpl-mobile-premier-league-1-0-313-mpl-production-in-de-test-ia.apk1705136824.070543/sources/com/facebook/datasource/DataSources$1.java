package com.facebook.datasource;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Supplier;

public final class DataSources$1 implements Supplier<DataSource<T>> {
    public final /* synthetic */ Throwable val$failure;

    public DataSources$1(Throwable th) {
        this.val$failure = th;
    }

    public Object get() {
        return k.immediateFailedDataSource(this.val$failure);
    }
}
