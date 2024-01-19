package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.navigation.Navigator.Name;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

@Name("activity")
public class ActivityNavigator extends Navigator<Destination> {
    public Context mContext;
    public Activity mHostActivity;

    public static class Destination extends NavDestination {
        public String mDataPattern;
        public Intent mIntent;

        public Destination(Navigator<? extends Destination> navigator) {
            super(navigator);
        }

        public void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.ActivityNavigator);
            String string = obtainAttributes.getString(R$styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            if (this.mIntent == null) {
                this.mIntent = new Intent();
            }
            this.mIntent.setPackage(string);
            String string2 = obtainAttributes.getString(R$styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                ComponentName componentName = new ComponentName(context, string2);
                if (this.mIntent == null) {
                    this.mIntent = new Intent();
                }
                this.mIntent.setComponent(componentName);
            }
            String string3 = obtainAttributes.getString(R$styleable.ActivityNavigator_action);
            if (this.mIntent == null) {
                this.mIntent = new Intent();
            }
            this.mIntent.setAction(string3);
            String string4 = obtainAttributes.getString(R$styleable.ActivityNavigator_data);
            if (string4 != null) {
                Uri parse = Uri.parse(string4);
                if (this.mIntent == null) {
                    this.mIntent = new Intent();
                }
                this.mIntent.setData(parse);
            }
            this.mDataPattern = obtainAttributes.getString(R$styleable.ActivityNavigator_dataPattern);
            obtainAttributes.recycle();
        }

        public boolean supportsActions() {
            return false;
        }

        public String toString() {
            ComponentName componentName;
            Intent intent = this.mIntent;
            String str = null;
            if (intent == null) {
                componentName = null;
            } else {
                componentName = intent.getComponent();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (componentName != null) {
                sb.append(" class=");
                sb.append(componentName.getClassName());
            } else {
                Intent intent2 = this.mIntent;
                if (intent2 != null) {
                    str = intent2.getAction();
                }
                if (str != null) {
                    sb.append(" action=");
                    sb.append(str);
                }
            }
            return sb.toString();
        }
    }

    public static final class Extras implements androidx.navigation.Navigator.Extras {
    }

    public ActivityNavigator(Context context) {
        this.mContext = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.mHostActivity = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    public NavDestination createDestination() {
        return new Destination(this);
    }

    public NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, androidx.navigation.Navigator.Extras extras) {
        Destination destination = (Destination) navDestination;
        if (destination.mIntent != null) {
            Intent intent = new Intent(destination.mIntent);
            if (bundle != null) {
                intent.putExtras(bundle);
                String str = destination.mDataPattern;
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + str);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z = extras instanceof Extras;
            int i = 0;
            if (z) {
                if (((Extras) extras) != null) {
                    intent.addFlags(0);
                } else {
                    throw null;
                }
            }
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            }
            if (navOptions != null && navOptions.mSingleTop) {
                intent.addFlags(536870912);
            }
            Activity activity = this.mHostActivity;
            if (activity != null) {
                Intent intent2 = activity.getIntent();
                if (intent2 != null) {
                    int intExtra = intent2.getIntExtra("android-support-navigation:ActivityNavigator:current", 0);
                    if (intExtra != 0) {
                        intent.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
                    }
                }
            }
            intent.putExtra("android-support-navigation:ActivityNavigator:current", destination.mId);
            if (navOptions != null) {
                intent.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", navOptions.mPopEnterAnim);
                intent.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", navOptions.mPopExitAnim);
            }
            if (!z) {
                this.mContext.startActivity(intent);
            } else if (((Extras) extras) != null) {
                this.mContext.startActivity(intent);
            } else {
                throw null;
            }
            if (!(navOptions == null || this.mHostActivity == null)) {
                int i2 = navOptions.mEnterAnim;
                int i3 = navOptions.mExitAnim;
                if (!(i2 == -1 && i3 == -1)) {
                    if (i2 == -1) {
                        i2 = 0;
                    }
                    if (i3 != -1) {
                        i = i3;
                    }
                    this.mHostActivity.overridePendingTransition(i2, i);
                }
            }
            return null;
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("Destination "), destination.mId, " does not have an Intent set."));
    }

    public boolean popBackStack() {
        Activity activity = this.mHostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
