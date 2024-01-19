package com.facebook.imagepipeline.datasource;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
    public final DataSource<CloseableReference<T>>[] mDataSources;
    public int mFinishedDataSources = 0;

    public class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
        public boolean mFinished;

        public InternalDataSubscriber() {
            this.mFinished = false;
        }

        private synchronized boolean tryFinish() {
            if (this.mFinished) {
                return false;
            }
            this.mFinished = true;
            return true;
        }

        public void onCancellation(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceCancelled();
        }

        public void onFailure(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceFailed(dataSource);
        }

        public void onNewResult(DataSource<CloseableReference<T>> dataSource) {
            if (dataSource.isFinished() && tryFinish()) {
                ListDataSource.this.onDataSourceFinished();
            }
        }

        public void onProgressUpdate(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceProgress();
        }
    }

    public ListDataSource(DataSource<CloseableReference<T>>[] dataSourceArr) {
        this.mDataSources = dataSourceArr;
    }

    public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... dataSourceArr) {
        if (dataSourceArr != null) {
            k.checkState(dataSourceArr.length > 0);
            ListDataSource<T> listDataSource = new ListDataSource<>(dataSourceArr);
            for (DataSource<CloseableReference<T>> dataSource : dataSourceArr) {
                if (dataSource != null) {
                    listDataSource.getClass();
                    dataSource.subscribe(new InternalDataSubscriber(), CallerThreadExecutor.sInstance);
                }
            }
            return listDataSource;
        }
        throw null;
    }

    private synchronized boolean increaseAndCheckIfLast() {
        boolean z;
        z = true;
        int i = this.mFinishedDataSources + 1;
        this.mFinishedDataSources = i;
        if (i != this.mDataSources.length) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void onDataSourceCancelled() {
        setFailure(new CancellationException());
    }

    /* access modifiers changed from: private */
    public void onDataSourceFailed(DataSource<CloseableReference<T>> dataSource) {
        setFailure(dataSource.getFailureCause());
    }

    /* access modifiers changed from: private */
    public void onDataSourceFinished() {
        if (increaseAndCheckIfLast()) {
            setResult(null, true);
        }
    }

    /* access modifiers changed from: private */
    public void onDataSourceProgress() {
        float f2 = 0.0f;
        for (DataSource<CloseableReference<T>> progress : this.mDataSources) {
            f2 += progress.getProgress();
        }
        setProgress(f2 / ((float) this.mDataSources.length));
    }

    public boolean close() {
        if (!super.close()) {
            return false;
        }
        for (DataSource<CloseableReference<T>> close : this.mDataSources) {
            close.close();
        }
        return true;
    }

    public synchronized boolean hasResult() {
        return !isClosed() && this.mFinishedDataSources == this.mDataSources.length;
    }

    public synchronized List<CloseableReference<T>> getResult() {
        if (!hasResult()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.mDataSources.length);
        for (DataSource<CloseableReference<T>> result : this.mDataSources) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
