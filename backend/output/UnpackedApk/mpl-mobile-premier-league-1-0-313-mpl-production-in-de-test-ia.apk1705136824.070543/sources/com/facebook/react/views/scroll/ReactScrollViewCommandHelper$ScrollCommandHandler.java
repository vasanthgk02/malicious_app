package com.facebook.react.views.scroll;

public interface ReactScrollViewCommandHelper$ScrollCommandHandler<T> {
    void flashScrollIndicators(T t);

    void scrollTo(T t, ReactScrollViewCommandHelper$ScrollToCommandData reactScrollViewCommandHelper$ScrollToCommandData);

    void scrollToEnd(T t, ReactScrollViewCommandHelper$ScrollToEndCommandData reactScrollViewCommandHelper$ScrollToEndCommandData);
}
