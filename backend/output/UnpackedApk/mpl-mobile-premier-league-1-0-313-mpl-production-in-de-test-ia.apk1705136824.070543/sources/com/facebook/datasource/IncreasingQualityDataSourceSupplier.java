package com.facebook.datasource;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    public final boolean mDataSourceLazy;
    public final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    public class IncreasingQualityDataSource extends AbstractDataSource<T> {
        public ArrayList<DataSource<T>> mDataSources;
        public Throwable mDelayedError;
        public AtomicInteger mFinishedDataSources;
        public int mIndexOfDataSourceWithResult;
        public int mNumberOfDataSources;

        public class InternalDataSubscriber implements DataSubscriber<T> {
            public int mIndex;

            public InternalDataSubscriber(int i) {
                this.mIndex = i;
            }

            public void onCancellation(DataSource<T> dataSource) {
            }

            public void onFailure(DataSource<T> dataSource) {
                IncreasingQualityDataSource.access$300(IncreasingQualityDataSource.this, this.mIndex, dataSource);
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    IncreasingQualityDataSource increasingQualityDataSource = IncreasingQualityDataSource.this;
                    int i = this.mIndex;
                    if (increasingQualityDataSource != null) {
                        boolean isFinished = dataSource.isFinished();
                        synchronized (increasingQualityDataSource) {
                            int i2 = increasingQualityDataSource.mIndexOfDataSourceWithResult;
                            if (dataSource == increasingQualityDataSource.getDataSource(i)) {
                                if (i != increasingQualityDataSource.mIndexOfDataSourceWithResult) {
                                    if (increasingQualityDataSource.getDataSourceWithResult() == null || (isFinished && i < increasingQualityDataSource.mIndexOfDataSourceWithResult)) {
                                        increasingQualityDataSource.mIndexOfDataSourceWithResult = i;
                                        i2 = i;
                                    }
                                    for (int i3 = increasingQualityDataSource.mIndexOfDataSourceWithResult; i3 > i2; i3--) {
                                        DataSource andClearDataSource = increasingQualityDataSource.getAndClearDataSource(i3);
                                        if (andClearDataSource != null) {
                                            andClearDataSource.close();
                                        }
                                    }
                                }
                            }
                        }
                        if (dataSource == increasingQualityDataSource.getDataSourceWithResult()) {
                            increasingQualityDataSource.setResult(null, i == 0 && dataSource.isFinished());
                        }
                        if (increasingQualityDataSource.mFinishedDataSources.incrementAndGet() == increasingQualityDataSource.mNumberOfDataSources) {
                            Throwable th = increasingQualityDataSource.mDelayedError;
                            if (th != null) {
                                increasingQualityDataSource.setFailure(th);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw null;
                } else if (dataSource.isFinished()) {
                    IncreasingQualityDataSource.access$300(IncreasingQualityDataSource.this, this.mIndex, dataSource);
                }
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                if (this.mIndex == 0) {
                    IncreasingQualityDataSource.this.setProgress(dataSource.getProgress());
                }
            }
        }

        public IncreasingQualityDataSource() {
            if (!IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
        }

        public static void access$300(IncreasingQualityDataSource increasingQualityDataSource, int i, DataSource dataSource) {
            DataSource dataSource2;
            synchronized (increasingQualityDataSource) {
                if (dataSource == increasingQualityDataSource.getDataSourceWithResult()) {
                    dataSource2 = null;
                } else if (dataSource == increasingQualityDataSource.getDataSource(i)) {
                    dataSource2 = increasingQualityDataSource.getAndClearDataSource(i);
                } else {
                    dataSource2 = dataSource;
                }
            }
            if (dataSource2 != null) {
                dataSource2.close();
            }
            if (i == 0) {
                increasingQualityDataSource.mDelayedError = dataSource.getFailureCause();
            }
            if (increasingQualityDataSource.mFinishedDataSources.incrementAndGet() == increasingQualityDataSource.mNumberOfDataSources) {
                Throwable th = increasingQualityDataSource.mDelayedError;
                if (th != null) {
                    increasingQualityDataSource.setFailure(th);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r0 == null) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r1 >= r0.size()) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            r2 = r0.get(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
            if (r2 == null) goto L_0x002c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean close() {
            /*
                r3 = this;
                com.facebook.datasource.IncreasingQualityDataSourceSupplier r0 = com.facebook.datasource.IncreasingQualityDataSourceSupplier.this
                boolean r0 = r0.mDataSourceLazy
                if (r0 == 0) goto L_0x0009
                r3.ensureDataSourceInitialized()
            L_0x0009:
                monitor-enter(r3)
                boolean r0 = super.close()     // Catch:{ all -> 0x0031 }
                r1 = 0
                if (r0 != 0) goto L_0x0013
                monitor-exit(r3)     // Catch:{ all -> 0x0031 }
                return r1
            L_0x0013:
                java.util.ArrayList<com.facebook.datasource.DataSource<T>> r0 = r3.mDataSources     // Catch:{ all -> 0x0031 }
                r2 = 0
                r3.mDataSources = r2     // Catch:{ all -> 0x0031 }
                monitor-exit(r3)     // Catch:{ all -> 0x0031 }
                if (r0 == 0) goto L_0x002f
            L_0x001b:
                int r2 = r0.size()
                if (r1 >= r2) goto L_0x002f
                java.lang.Object r2 = r0.get(r1)
                com.facebook.datasource.DataSource r2 = (com.facebook.datasource.DataSource) r2
                if (r2 == 0) goto L_0x002c
                r2.close()
            L_0x002c:
                int r1 = r1 + 1
                goto L_0x001b
            L_0x002f:
                r0 = 1
                return r0
            L_0x0031:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0031 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.close():boolean");
        }

        public final void ensureDataSourceInitialized() {
            if (this.mFinishedDataSources == null) {
                synchronized (this) {
                    if (this.mFinishedDataSources == null) {
                        int i = 0;
                        this.mFinishedDataSources = new AtomicInteger(0);
                        int size = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
                        this.mNumberOfDataSources = size;
                        this.mIndexOfDataSourceWithResult = size;
                        this.mDataSources = new ArrayList<>(size);
                        while (true) {
                            if (i >= size) {
                                break;
                            }
                            DataSource dataSource = (DataSource) IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i).get();
                            this.mDataSources.add(dataSource);
                            dataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.sInstance);
                            if (dataSource.hasResult()) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }

        public final synchronized DataSource<T> getAndClearDataSource(int i) {
            DataSource<T> dataSource;
            dataSource = null;
            if (this.mDataSources != null && i < this.mDataSources.size()) {
                dataSource = this.mDataSources.set(i, null);
            }
            return dataSource;
        }

        public final synchronized DataSource<T> getDataSource(int i) {
            return (this.mDataSources == null || i >= this.mDataSources.size()) ? null : this.mDataSources.get(i);
        }

        public final synchronized DataSource<T> getDataSourceWithResult() {
            return getDataSource(this.mIndexOfDataSourceWithResult);
        }

        public synchronized T getResult() {
            DataSource dataSourceWithResult;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        public synchronized boolean hasResult() {
            DataSource dataSourceWithResult;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null && dataSourceWithResult.hasResult();
        }
    }

    public IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list, boolean z) {
        k.checkArgument(!list.isEmpty(), (Object) "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
        this.mDataSourceLazy = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IncreasingQualityDataSourceSupplier)) {
            return false;
        }
        return k.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier) obj).mDataSourceSuppliers);
    }

    public Object get() {
        return new IncreasingQualityDataSource();
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
