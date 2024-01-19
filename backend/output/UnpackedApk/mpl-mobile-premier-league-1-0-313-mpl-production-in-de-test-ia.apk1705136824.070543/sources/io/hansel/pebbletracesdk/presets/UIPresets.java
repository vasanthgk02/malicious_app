package io.hansel.pebbletracesdk.presets;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.hansel.core.logger.HSLLogger;

public class UIPresets {
    public static View findViewById(Activity activity, String str) {
        return activity.findViewById(activity.getResources().getIdentifier(str, "id", activity.getPackageName()));
    }

    public static View findViewById(Fragment fragment, String str) {
        Activity activity = fragment.getActivity();
        return activity.findViewById(activity.getResources().getIdentifier(str, "id", activity.getPackageName()));
    }

    public static View findViewById(Context context, View view, String str) {
        return view.findViewById(context.getResources().getIdentifier(str, "id", context.getPackageName()));
    }

    public static int getId(Activity activity, String str) {
        return getId(activity, activity.getPackageName(), str);
    }

    public static int getId(Activity activity, String str, String str2) {
        return activity.getResources().getIdentifier(str2, "id", str);
    }

    public static int getId(Context context, String str, String str2, String str3) {
        return context.getResources().getIdentifier(str, str2, str3);
    }

    public static void removeMenuItemByName(Menu menu, String str) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            if (item.getTitle().equals(str)) {
                menu.removeItem(item.getItemId());
            }
        }
    }

    public static void setBackgroundColorOnViewById(Activity activity, String str, int i) {
        View findViewById = findViewById(activity, str);
        if (findViewById != null) {
            findViewById.setBackgroundColor(i);
        }
    }

    public static void setTextOnViewById(Activity activity, String str, String str2) {
        View findViewById = findViewById(activity, str);
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setText(str2);
        }
    }

    public static void setVisibilityOnViewById(Activity activity, String str, int i) {
        View findViewById = findViewById(activity, str);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
    }

    public static void swapViews(Activity activity, String str, String str2) {
        View findViewById = findViewById(activity, str);
        View findViewById2 = findViewById(activity, str2);
        if (!(findViewById == null || findViewById2 == null)) {
            try {
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                ViewGroup viewGroup2 = (ViewGroup) findViewById2.getParent();
                if (!(viewGroup == null || viewGroup2 == null)) {
                    int indexOfChild = viewGroup.indexOfChild(findViewById);
                    int indexOfChild2 = viewGroup2.indexOfChild(findViewById2);
                    if (indexOfChild >= 0 && indexOfChild2 >= 0) {
                        if (indexOfChild2 < indexOfChild) {
                            View view = findViewById;
                            findViewById = findViewById2;
                            findViewById2 = view;
                            ViewGroup viewGroup3 = viewGroup2;
                            viewGroup2 = viewGroup;
                            viewGroup = viewGroup3;
                            int i = indexOfChild2;
                            indexOfChild2 = indexOfChild;
                            indexOfChild = i;
                        }
                        viewGroup.removeViewAt(indexOfChild);
                        viewGroup2.addView(findViewById, indexOfChild2);
                        viewGroup2.removeViewAt(viewGroup == viewGroup2 ? indexOfChild2 - 1 : indexOfChild2 + 1);
                        viewGroup.addView(findViewById2, indexOfChild);
                    }
                }
            } catch (ClassCastException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }
}
