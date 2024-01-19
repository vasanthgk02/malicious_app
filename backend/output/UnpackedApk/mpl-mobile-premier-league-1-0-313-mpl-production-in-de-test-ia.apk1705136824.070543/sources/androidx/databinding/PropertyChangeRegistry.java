package androidx.databinding;

import androidx.databinding.CallbackRegistry.NotifierCallback;
import androidx.databinding.Observable.OnPropertyChangedCallback;
import androidx.databinding.ViewDataBinding.WeakListener;
import androidx.databinding.ViewDataBinding.WeakPropertyListener;

public class PropertyChangeRegistry extends CallbackRegistry<OnPropertyChangedCallback, Observable, Void> {
    public static final NotifierCallback<OnPropertyChangedCallback, Observable, Void> NOTIFIER_CALLBACK = new NotifierCallback<OnPropertyChangedCallback, Observable, Void>() {
        public void onNotifyCallback(Object obj, Object obj2, int i, Object obj3) {
            Observable observable = (Observable) obj2;
            Void voidR = (Void) obj3;
            WeakPropertyListener weakPropertyListener = (WeakPropertyListener) ((OnPropertyChangedCallback) obj);
            WeakListener<Observable> weakListener = weakPropertyListener.mListener;
            ViewDataBinding viewDataBinding = (ViewDataBinding) weakListener.get();
            if (viewDataBinding == null) {
                weakListener.unregister();
            }
            if (viewDataBinding != null) {
                WeakListener<Observable> weakListener2 = weakPropertyListener.mListener;
                if (((Observable) weakListener2.mTarget) == observable) {
                    viewDataBinding.handleFieldChange(weakListener2.mLocalFieldId, observable, i);
                }
            }
        }
    };

    public PropertyChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }
}
