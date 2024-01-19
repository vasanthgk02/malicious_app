package com.facebook.datasource;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Supplier;
import java.util.List;

public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    public class FirstAvailableDataSource extends AbstractDataSource<T> {
        public DataSource<T> mCurrentDataSource = null;
        public DataSource<T> mDataSourceWithResult = null;
        public int mIndex = 0;

        public class InternalDataSubscriber implements DataSubscriber<T> {
            public InternalDataSubscriber(AnonymousClass1 r2) {
            }

            public void onCancellation(DataSource<T> dataSource) {
            }

            public void onFailure(DataSource<T> dataSource) {
                FirstAvailableDataSource.access$200(FirstAvailableDataSource.this, dataSource);
            }

            /* JADX WARNING: Removed duplicated region for block: B:20:0x0029  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onNewResult(com.facebook.datasource.DataSource<T> r5) {
                /*
                    r4 = this;
                    boolean r0 = r5.hasResult()
                    if (r0 == 0) goto L_0x0040
                    com.facebook.datasource.FirstAvailableDataSourceSupplier$FirstAvailableDataSource r0 = com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this
                    r1 = 0
                    if (r0 == 0) goto L_0x003f
                    boolean r2 = r5.isFinished()
                    monitor-enter(r0)
                    com.facebook.datasource.DataSource<T> r3 = r0.mCurrentDataSource     // Catch:{ all -> 0x003c }
                    if (r5 != r3) goto L_0x002d
                    com.facebook.datasource.DataSource<T> r3 = r0.mDataSourceWithResult     // Catch:{ all -> 0x003c }
                    if (r5 != r3) goto L_0x0019
                    goto L_0x002d
                L_0x0019:
                    com.facebook.datasource.DataSource<T> r3 = r0.mDataSourceWithResult     // Catch:{ all -> 0x003c }
                    if (r3 == 0) goto L_0x0022
                    if (r2 == 0) goto L_0x0020
                    goto L_0x0022
                L_0x0020:
                    r2 = r1
                    goto L_0x0026
                L_0x0022:
                    com.facebook.datasource.DataSource<T> r2 = r0.mDataSourceWithResult     // Catch:{ all -> 0x003c }
                    r0.mDataSourceWithResult = r5     // Catch:{ all -> 0x003c }
                L_0x0026:
                    monitor-exit(r0)     // Catch:{ all -> 0x003c }
                    if (r2 == 0) goto L_0x002e
                    r2.close()
                    goto L_0x002e
                L_0x002d:
                    monitor-exit(r0)     // Catch:{ all -> 0x003c }
                L_0x002e:
                    com.facebook.datasource.DataSource r2 = r0.getDataSourceWithResult()
                    if (r5 != r2) goto L_0x004b
                    boolean r5 = r5.isFinished()
                    r0.setResult(r1, r5)
                    goto L_0x004b
                L_0x003c:
                    r5 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x003c }
                    throw r5
                L_0x003f:
                    throw r1
                L_0x0040:
                    boolean r0 = r5.isFinished()
                    if (r0 == 0) goto L_0x004b
                    com.facebook.datasource.FirstAvailableDataSourceSupplier$FirstAvailableDataSource r0 = com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this
                    com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.access$200(r0, r5)
                L_0x004b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.InternalDataSubscriber.onNewResult(com.facebook.datasource.DataSource):void");
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                FirstAvailableDataSource.this.setProgress(Math.max(FirstAvailableDataSource.this.getProgress(), dataSource.getProgress()));
            }
        }

        public FirstAvailableDataSource() {
            if (!startNextDataSource()) {
                setFailure(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        public static void access$200(FirstAvailableDataSource firstAvailableDataSource, DataSource dataSource) {
            boolean z;
            synchronized (firstAvailableDataSource) {
                if (!firstAvailableDataSource.isClosed()) {
                    if (dataSource == firstAvailableDataSource.mCurrentDataSource) {
                        firstAvailableDataSource.mCurrentDataSource = null;
                        z = true;
                    }
                }
                z = false;
            }
            if (z) {
                if (!(dataSource == firstAvailableDataSource.getDataSourceWithResult() || dataSource == null)) {
                    dataSource.close();
                }
                if (!firstAvailableDataSource.startNextDataSource()) {
                    firstAvailableDataSource.setFailure(dataSource.getFailureCause());
                }
            }
        }

        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                DataSource<T> dataSource = this.mCurrentDataSource;
                this.mCurrentDataSource = null;
                DataSource<T> dataSource2 = this.mDataSourceWithResult;
                this.mDataSourceWithResult = null;
                closeSafely(dataSource2);
                closeSafely(dataSource);
                return true;
            }
        }

        public final void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        public final synchronized DataSource<T> getDataSourceWithResult() {
            return this.mDataSourceWithResult;
        }

        public synchronized T getResult() {
            DataSource dataSourceWithResult;
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        public synchronized boolean hasResult() {
            DataSource dataSourceWithResult;
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null && dataSourceWithResult.hasResult();
        }

        public final boolean startNextDataSource() {
            Supplier supplier;
            boolean z;
            synchronized (this) {
                if (isClosed() || this.mIndex >= FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers.size()) {
                    supplier = null;
                } else {
                    List<Supplier<DataSource<T>>> list = FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers;
                    int i = this.mIndex;
                    this.mIndex = i + 1;
                    supplier = list.get(i);
                }
            }
            DataSource<T> dataSource = supplier != null ? (DataSource) supplier.get() : null;
            synchronized (this) {
                if (isClosed()) {
                    z = false;
                } else {
                    this.mCurrentDataSource = dataSource;
                    z = true;
                }
            }
            if (!z || dataSource == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                return false;
            }
            dataSource.subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.sInstance);
            return true;
        }
    }

    public FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        k.checkArgument(!list.isEmpty(), (Object) "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirstAvailableDataSourceSupplier)) {
            return false;
        }
        return k.equal(this.mDataSourceSuppliers, ((FirstAvailableDataSourceSupplier) obj).mDataSourceSuppliers);
    }

    public Object get() {
        return new FirstAvailableDataSource();
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = k.toStringHelper(this);
        stringHelper.addHolder("list", this.mDataSourceSuppliers);
        return stringHelper.toString();
    }
}
