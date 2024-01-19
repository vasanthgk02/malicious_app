package com.mpl.androidapp.utils;

import java.util.Date;

public interface MTimeListener {
    void onFail(Exception exc);

    void onSuccess(Date date);
}
