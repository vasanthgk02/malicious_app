package co.apptailor.googlesignin;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.common.SignInButton;

public class RNGoogleSigninButtonViewManager extends SimpleViewManager<SignInButton> {
    public String getName() {
        return "RNGoogleSigninButton";
    }

    @ReactProp(name = "color")
    public void setColor(SignInButton signInButton, int i) {
        signInButton.setColorScheme(i);
    }

    @ReactProp(name = "disabled")
    public void setDisabled(SignInButton signInButton, boolean z) {
        signInButton.setEnabled(!z);
    }

    @ReactProp(name = "size")
    public void setSize(SignInButton signInButton, int i) {
        signInButton.setSize(i);
    }

    public SignInButton createViewInstance(final ThemedReactContext themedReactContext) {
        SignInButton signInButton = new SignInButton(themedReactContext, null);
        signInButton.setSize(0);
        signInButton.setColorScheme(2);
        signInButton.setOnClickListener(new OnClickListener(this) {
            public void onClick(View view) {
                ((RCTDeviceEventEmitter) themedReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("RNGoogleSigninButtonClicked", null);
            }
        });
        return signInButton;
    }
}
