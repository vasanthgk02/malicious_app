package com.clevertap.android.sdk.interfaces;

import android.os.Bundle;

public interface INotificationParser<T> {
    Bundle toBundle(T t);
}
