package androidx.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;
import android.service.media.MediaBrowserService.Result;
import java.util.ArrayList;
import java.util.List;

public class MediaBrowserServiceCompatApi21$ResultWrapper<T> {
    public Result mResultObj;

    public MediaBrowserServiceCompatApi21$ResultWrapper(Result result) {
        this.mResultObj = result;
    }

    public void sendResult(T t) {
        ArrayList arrayList = null;
        if (t instanceof List) {
            Result result = this.mResultObj;
            List<Parcel> list = (List) t;
            if (list != null) {
                arrayList = new ArrayList();
                for (Parcel parcel : list) {
                    parcel.setDataPosition(0);
                    arrayList.add(MediaItem.CREATOR.createFromParcel(parcel));
                    parcel.recycle();
                }
            }
            result.sendResult(arrayList);
        } else if (t instanceof Parcel) {
            Parcel parcel2 = (Parcel) t;
            parcel2.setDataPosition(0);
            this.mResultObj.sendResult(MediaItem.CREATOR.createFromParcel(parcel2));
            parcel2.recycle();
        } else {
            this.mResultObj.sendResult(null);
        }
    }
}
