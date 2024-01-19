package in.juspay.hypersdk.mystique;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.DuiCallback;

public class OnScroll implements OnScrollListener {
    public final DuiCallback duiCallback;
    public String scrollCallback;
    public String scrollChangeCallback;

    public OnScroll(DuiCallback duiCallback2) {
        this.duiCallback = duiCallback2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        DuiCallback duiCallback2 = this.duiCallback;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
        outline73.append(this.scrollCallback);
        outline73.append("','");
        outline73.append(i);
        outline73.append(",");
        outline73.append(i2);
        outline73.append(",");
        outline73.append(i3);
        outline73.append("');");
        duiCallback2.addJsToWebView(outline73.toString());
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        DuiCallback duiCallback2 = this.duiCallback;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
        outline73.append(this.scrollChangeCallback);
        outline73.append("',");
        outline73.append(i);
        outline73.append(");");
        duiCallback2.addJsToWebView(outline73.toString());
    }

    public void setScrollCallback(String str) {
        this.scrollCallback = str;
    }

    public void setScrollChangeCallback(String str) {
        this.scrollChangeCallback = str;
    }
}
