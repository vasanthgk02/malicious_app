package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger implements LottieLogger {
    public static final Set<String> loggedMessages = new HashSet();
}
