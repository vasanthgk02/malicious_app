package com.mpl.androidapp.spacemanagment;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.Util;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GamesViewModel extends ViewModel {
    public static final String TAG = "GameSpaceManagement";
    public final CompositeDisposable compositeDisposable = new CompositeDisposable();
    public MutableLiveData<List<GamesModel>> gamesListMutableLiveData;
    public MutableLiveData<Long> totInstalledAppSizeLiveData;

    public void getAllInstalledAppsInDevice(Context context) {
        Single<Map> gamesUseCase = new GamesUseCase().getGamesUseCase(context);
        Scheduler scheduler = Schedulers.IO;
        if (gamesUseCase != null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            SingleSubscribeOn singleSubscribeOn = new SingleSubscribeOn(gamesUseCase, scheduler);
            Scheduler scheduler2 = AndroidSchedulers.MAIN_THREAD;
            if (scheduler2 != null) {
                ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
                new SingleObserveOn(singleSubscribeOn, scheduler2).subscribe(new SingleObserver<Map>() {
                    public void onError(Throwable th) {
                    }

                    public void onSubscribe(Disposable disposable) {
                        GamesViewModel.this.compositeDisposable.add(disposable);
                    }

                    public void onSuccess(Map map) {
                        MLogger.d("GameSpaceManagement", Thread.currentThread().getName());
                        List list = (List) map.get(SpaceUtils.INSTALLED_APP_LIST);
                        long longValue = ((Long) map.get(SpaceUtils.TOT_APPS_SIZE)).longValue();
                        Collections.sort(list, $$Lambda$GamesViewModel$3$l7_w30btI4TvMtdjRXF2RMH64sw.INSTANCE);
                        GamesViewModel.this.gamesListMutableLiveData.setValue(list);
                        GamesViewModel.this.totInstalledAppSizeLiveData.setValue(Long.valueOf(longValue));
                    }
                });
                return;
            }
            throw new NullPointerException("scheduler == null");
        }
        throw null;
    }

    public void getAllMPLGames(String str) {
        List list = (List) new Gson().fromJson(str, new TypeToken<List<GamesModel>>() {
        }.getType());
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            try {
                GamesModel gamesModel = (GamesModel) list.get(i);
                if (Util.appInstalledOrNot(MPLApplication.getInstance().getApplicationContext(), gamesModel.getPackageName())) {
                    MLogger.d("GameSpaceManagement", gamesModel.getPackageName() + "found");
                    arrayList.add(gamesModel);
                }
                i++;
            } catch (Exception e2) {
                MLogger.d("GameSpaceManagement", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in getAllMPLGames ")));
            }
        }
        Collections.sort(arrayList, new Comparator<GamesModel>() {
            public int compare(GamesModel gamesModel, GamesModel gamesModel2) {
                return Long.compare(gamesModel2.getSize().longValue(), gamesModel.getSize().longValue());
            }
        });
        this.gamesListMutableLiveData.setValue(arrayList);
        long j = 0;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            j += ((GamesModel) it.next()).getSize().longValue();
        }
        this.totInstalledAppSizeLiveData.setValue(Long.valueOf(j));
    }

    public MutableLiveData<List<GamesModel>> getAppsLiveData() {
        if (this.gamesListMutableLiveData == null) {
            this.gamesListMutableLiveData = new MutableLiveData<>();
        }
        return this.gamesListMutableLiveData;
    }

    public MutableLiveData<Long> getTotInstalledAppSizeLiveData() {
        if (this.totInstalledAppSizeLiveData == null) {
            this.totInstalledAppSizeLiveData = new MutableLiveData<>();
        }
        return this.totInstalledAppSizeLiveData;
    }

    public void getTotSize(List<GamesModel> list) {
        long j = 0;
        for (GamesModel size : list) {
            j += size.getSize().longValue();
        }
        this.totInstalledAppSizeLiveData.setValue(Long.valueOf(j));
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}
