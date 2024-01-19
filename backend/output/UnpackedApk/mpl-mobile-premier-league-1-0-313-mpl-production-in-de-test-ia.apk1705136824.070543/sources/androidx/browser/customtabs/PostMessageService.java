package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.customtabs.IPostMessageService$Stub;

public class PostMessageService extends Service {
    public IPostMessageService$Stub mBinder = new IPostMessageService$Stub() {
    };

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
