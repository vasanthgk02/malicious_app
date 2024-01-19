package io.hansel.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import io.hansel.R;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.utils.HSLUtils;
import java.util.Objects;

public class a {
    public static void a(View view, String str) {
        String str2;
        StringBuilder sb;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewPager) && !(parent instanceof RecyclerView)) {
                sb = new StringBuilder();
                sb.append("HSLIndexManager: Hansel index does not support ");
                sb.append(parent);
                str = " as parent view";
            } else if (a((ViewGroup) parent)) {
                view.setTag(R.id.hansel_index, str);
                sb = new StringBuilder();
                sb.append("HSLIndexManager: Hansel index assigned is ");
            } else {
                return;
            }
            sb.append(str);
            str2 = sb.toString();
        } else {
            str2 = "HSLIndexManager: Error assigning Hansel index";
        }
        HSLLogger.d(str2);
    }

    public static boolean a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            Object tag = viewGroup.getTag(R.id.enable_hansel_indices);
            if (tag == null) {
                viewGroup.setTag(R.id.enable_hansel_indices, Boolean.TRUE);
                HSLLogger.d("HSLIndexManager: Hansel Indices enabled");
                return true;
            }
            boolean equals = Objects.equals(HSLUtils.parseBooleanTagValue(tag, "enable_hansel_indices"), Boolean.TRUE);
            if (!equals) {
                HSLLogger.d("HSLIndexManager: Hansel Indices are disabled for parent view");
            }
            return equals;
        }
        HSLLogger.d("HSLIndexManager: Error enabling Hansel indices. Parent view is null");
        return false;
    }
}
