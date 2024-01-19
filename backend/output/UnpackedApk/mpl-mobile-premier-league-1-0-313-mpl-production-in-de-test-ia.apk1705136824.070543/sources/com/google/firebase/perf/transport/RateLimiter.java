package com.google.firebase.perf.transport;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.ConfigurationConstants$NetworkEventCountBackground;
import com.google.firebase.perf.config.ConfigurationConstants$NetworkEventCountForeground;
import com.google.firebase.perf.config.ConfigurationConstants$TraceEventCountBackground;
import com.google.firebase.perf.config.ConfigurationConstants$TraceEventCountForeground;
import com.google.firebase.perf.config.DeviceCacheManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.PerfSession.AnonymousClass1;
import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal$ListAdapter$Converter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RateLimiter {
    public final ConfigResolver configResolver;
    public boolean isLogcatEnabled;
    public RateLimiterImpl networkLimiter = null;
    public final float samplingBucketId;
    public RateLimiterImpl traceLimiter = null;

    public static class RateLimiterImpl {
        public static final long MICROS_IN_A_SECOND = TimeUnit.SECONDS.toMicros(1);
        public static final AndroidLogger logger = AndroidLogger.getInstance();
        public long backgroundCapacity;
        public Rate backgroundRate;
        public long capacity;
        public final Clock clock;
        public long foregroundCapacity;
        public Rate foregroundRate;
        public final boolean isLogcatEnabled;
        public Timer lastTimeTokenReplenished;
        public Rate rate;
        public long tokenCount;

        public RateLimiterImpl(Rate rate2, long j, Clock clock2, ConfigResolver configResolver, String str, boolean z) {
            long j2;
            long j3;
            long j4;
            long j5;
            ConfigurationConstants$NetworkEventCountBackground configurationConstants$NetworkEventCountBackground;
            ConfigurationConstants$TraceEventCountBackground configurationConstants$TraceEventCountBackground;
            ConfigurationConstants$NetworkEventCountForeground configurationConstants$NetworkEventCountForeground;
            ConfigurationConstants$TraceEventCountForeground configurationConstants$TraceEventCountForeground;
            long j6 = j;
            Clock clock3 = clock2;
            ConfigResolver configResolver2 = configResolver;
            String str2 = str;
            boolean z2 = z;
            this.clock = clock3;
            this.capacity = j6;
            this.rate = rate2;
            this.tokenCount = j6;
            if (clock3 != null) {
                this.lastTimeTokenReplenished = new Timer();
                if (str2 == "Trace") {
                    j2 = configResolver.getRateLimitSec();
                } else {
                    j2 = configResolver.getRateLimitSec();
                }
                long j7 = j2;
                if (str2 == "Trace") {
                    if (configResolver2 != null) {
                        synchronized (ConfigurationConstants$TraceEventCountForeground.class) {
                            if (ConfigurationConstants$TraceEventCountForeground.instance == null) {
                                ConfigurationConstants$TraceEventCountForeground.instance = new ConfigurationConstants$TraceEventCountForeground();
                            }
                            configurationConstants$TraceEventCountForeground = ConfigurationConstants$TraceEventCountForeground.instance;
                        }
                        Optional<Long> remoteConfigLong = configResolver2.getRemoteConfigLong(configurationConstants$TraceEventCountForeground);
                        if (!remoteConfigLong.isAvailable() || !configResolver2.isEventCountValid(((Long) remoteConfigLong.get()).longValue())) {
                            Optional<Long> deviceCacheLong = configResolver2.getDeviceCacheLong(configurationConstants$TraceEventCountForeground);
                            if (deviceCacheLong.isAvailable() && configResolver2.isEventCountValid(((Long) deviceCacheLong.get()).longValue())) {
                                j3 = ((Long) deviceCacheLong.get()).longValue();
                            } else if (configurationConstants$TraceEventCountForeground != null) {
                                j3 = Long.valueOf(300).longValue();
                            } else {
                                throw null;
                            }
                        } else {
                            DeviceCacheManager deviceCacheManager = configResolver2.deviceCacheManager;
                            if (configurationConstants$TraceEventCountForeground != null) {
                                j3 = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong.get(), deviceCacheManager, "com.google.firebase.perf.TraceEventCountForeground", remoteConfigLong)).longValue();
                            } else {
                                throw null;
                            }
                        }
                    } else {
                        throw null;
                    }
                } else if (configResolver2 != null) {
                    synchronized (ConfigurationConstants$NetworkEventCountForeground.class) {
                        if (ConfigurationConstants$NetworkEventCountForeground.instance == null) {
                            ConfigurationConstants$NetworkEventCountForeground.instance = new ConfigurationConstants$NetworkEventCountForeground();
                        }
                        configurationConstants$NetworkEventCountForeground = ConfigurationConstants$NetworkEventCountForeground.instance;
                    }
                    Optional<Long> remoteConfigLong2 = configResolver2.getRemoteConfigLong(configurationConstants$NetworkEventCountForeground);
                    if (!remoteConfigLong2.isAvailable() || !configResolver2.isEventCountValid(((Long) remoteConfigLong2.get()).longValue())) {
                        Optional<Long> deviceCacheLong2 = configResolver2.getDeviceCacheLong(configurationConstants$NetworkEventCountForeground);
                        if (deviceCacheLong2.isAvailable() && configResolver2.isEventCountValid(((Long) deviceCacheLong2.get()).longValue())) {
                            j3 = ((Long) deviceCacheLong2.get()).longValue();
                        } else if (configurationConstants$NetworkEventCountForeground != null) {
                            j3 = Long.valueOf(700).longValue();
                        } else {
                            throw null;
                        }
                    } else {
                        DeviceCacheManager deviceCacheManager2 = configResolver2.deviceCacheManager;
                        if (configurationConstants$NetworkEventCountForeground != null) {
                            j3 = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong2.get(), deviceCacheManager2, "com.google.firebase.perf.NetworkEventCountForeground", remoteConfigLong2)).longValue();
                        } else {
                            throw null;
                        }
                    }
                } else {
                    throw null;
                }
                Rate rate3 = new Rate(j3, j7, TimeUnit.SECONDS);
                this.foregroundRate = rate3;
                this.foregroundCapacity = j3;
                if (z2) {
                    logger.debug("Foreground %s logging rate:%f, burst capacity:%d", str2, rate3, Long.valueOf(j3));
                }
                if (str2 == "Trace") {
                    j4 = configResolver.getRateLimitSec();
                } else {
                    j4 = configResolver.getRateLimitSec();
                }
                long j8 = j4;
                if (str2 == "Trace") {
                    synchronized (ConfigurationConstants$TraceEventCountBackground.class) {
                        if (ConfigurationConstants$TraceEventCountBackground.instance == null) {
                            ConfigurationConstants$TraceEventCountBackground.instance = new ConfigurationConstants$TraceEventCountBackground();
                        }
                        configurationConstants$TraceEventCountBackground = ConfigurationConstants$TraceEventCountBackground.instance;
                    }
                    Optional<Long> remoteConfigLong3 = configResolver2.getRemoteConfigLong(configurationConstants$TraceEventCountBackground);
                    if (!remoteConfigLong3.isAvailable() || !configResolver2.isEventCountValid(((Long) remoteConfigLong3.get()).longValue())) {
                        Optional<Long> deviceCacheLong3 = configResolver2.getDeviceCacheLong(configurationConstants$TraceEventCountBackground);
                        if (deviceCacheLong3.isAvailable() && configResolver2.isEventCountValid(((Long) deviceCacheLong3.get()).longValue())) {
                            j5 = ((Long) deviceCacheLong3.get()).longValue();
                        } else if (configurationConstants$TraceEventCountBackground != null) {
                            j5 = Long.valueOf(30).longValue();
                        } else {
                            throw null;
                        }
                    } else {
                        DeviceCacheManager deviceCacheManager3 = configResolver2.deviceCacheManager;
                        if (configurationConstants$TraceEventCountBackground != null) {
                            j5 = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong3.get(), deviceCacheManager3, "com.google.firebase.perf.TraceEventCountBackground", remoteConfigLong3)).longValue();
                        } else {
                            throw null;
                        }
                    }
                } else {
                    synchronized (ConfigurationConstants$NetworkEventCountBackground.class) {
                        if (ConfigurationConstants$NetworkEventCountBackground.instance == null) {
                            ConfigurationConstants$NetworkEventCountBackground.instance = new ConfigurationConstants$NetworkEventCountBackground();
                        }
                        configurationConstants$NetworkEventCountBackground = ConfigurationConstants$NetworkEventCountBackground.instance;
                    }
                    Optional<Long> remoteConfigLong4 = configResolver2.getRemoteConfigLong(configurationConstants$NetworkEventCountBackground);
                    if (!remoteConfigLong4.isAvailable() || !configResolver2.isEventCountValid(((Long) remoteConfigLong4.get()).longValue())) {
                        Optional<Long> deviceCacheLong4 = configResolver2.getDeviceCacheLong(configurationConstants$NetworkEventCountBackground);
                        if (deviceCacheLong4.isAvailable() && configResolver2.isEventCountValid(((Long) deviceCacheLong4.get()).longValue())) {
                            j5 = ((Long) deviceCacheLong4.get()).longValue();
                        } else if (configurationConstants$NetworkEventCountBackground != null) {
                            j5 = Long.valueOf(70).longValue();
                        } else {
                            throw null;
                        }
                    } else {
                        DeviceCacheManager deviceCacheManager4 = configResolver2.deviceCacheManager;
                        if (configurationConstants$NetworkEventCountBackground != null) {
                            j5 = ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong4.get(), deviceCacheManager4, "com.google.firebase.perf.NetworkEventCountBackground", remoteConfigLong4)).longValue();
                        } else {
                            throw null;
                        }
                    }
                }
                Rate rate4 = new Rate(j5, j8, TimeUnit.SECONDS);
                this.backgroundRate = rate4;
                this.backgroundCapacity = j5;
                if (z2) {
                    logger.debug("Background %s logging rate:%f, capacity:%d", str2, rate4, Long.valueOf(j5));
                }
                this.isLogcatEnabled = z2;
                return;
            }
            throw null;
        }

        public synchronized void changeRate(boolean z) {
            this.rate = z ? this.foregroundRate : this.backgroundRate;
            this.capacity = z ? this.foregroundCapacity : this.backgroundCapacity;
        }

        public synchronized boolean check() {
            try {
                if (this.clock != null) {
                    TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
                    long max = Math.max(0, (long) ((((double) TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.lastTimeTokenReplenished.highResTime)) * this.rate.getTokensPerSeconds()) / ((double) MICROS_IN_A_SECOND)));
                    this.tokenCount = Math.min(this.tokenCount + max, this.capacity);
                    if (max > 0) {
                        this.lastTimeTokenReplenished = new Timer(this.lastTimeTokenReplenished.timeInMicros + ((long) (((double) (max * MICROS_IN_A_SECOND)) / this.rate.getTokensPerSeconds())));
                    }
                    if (this.tokenCount > 0) {
                        this.tokenCount--;
                        return true;
                    }
                    if (this.isLogcatEnabled) {
                        logger.warn("Exceeded log rate limit, dropping the log.");
                    }
                    return false;
                }
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0028, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RateLimiter(android.content.Context r12, com.google.firebase.perf.util.Rate r13, long r14) {
        /*
            r11 = this;
            com.google.firebase.perf.util.Clock r8 = new com.google.firebase.perf.util.Clock
            r8.<init>()
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            float r0 = r0.nextFloat()
            com.google.firebase.perf.config.ConfigResolver r9 = com.google.firebase.perf.config.ConfigResolver.getInstance()
            r11.<init>()
            r1 = 0
            r11.traceLimiter = r1
            r11.networkLimiter = r1
            r1 = 0
            r11.isLogcatEnabled = r1
            r2 = 0
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0029
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0029
            r1 = 1
        L_0x0029:
            if (r1 == 0) goto L_0x0052
            r11.samplingBucketId = r0
            r11.configResolver = r9
            com.google.firebase.perf.transport.RateLimiter$RateLimiterImpl r10 = new com.google.firebase.perf.transport.RateLimiter$RateLimiterImpl
            boolean r7 = r11.isLogcatEnabled
            java.lang.String r6 = "Trace"
            r0 = r10
            r1 = r13
            r2 = r14
            r4 = r8
            r5 = r9
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r11.traceLimiter = r10
            com.google.firebase.perf.transport.RateLimiter$RateLimiterImpl r10 = new com.google.firebase.perf.transport.RateLimiter$RateLimiterImpl
            boolean r7 = r11.isLogcatEnabled
            java.lang.String r6 = "Network"
            r0 = r10
            r0.<init>(r1, r2, r4, r5, r6, r7)
            r11.networkLimiter = r10
            boolean r12 = com.google.firebase.perf.util.Utils.isDebugLoggingEnabled(r12)
            r11.isLogcatEnabled = r12
            return
        L_0x0052:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Sampling bucket ID should be in range [0.0f, 1.0f)."
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.transport.RateLimiter.<init>(android.content.Context, com.google.firebase.perf.util.Rate, long):void");
    }

    public void changeRate(boolean z) {
        this.traceLimiter.changeRate(z);
        this.networkLimiter.changeRate(z);
    }

    public final boolean hasVerboseSessions(List<PerfSession> list) {
        boolean z = false;
        if (list.size() <= 0 || list.get(0).sessionVerbosity_.size() <= 0) {
            return false;
        }
        Internal$ListAdapter$Converter<Integer, SessionVerbosity> internal$ListAdapter$Converter = PerfSession.sessionVerbosity_converter_;
        IntArrayList intArrayList = (IntArrayList) list.get(0).sessionVerbosity_;
        intArrayList.ensureIndexInRange(0);
        Integer valueOf = Integer.valueOf(intArrayList.array[0]);
        if (((AnonymousClass1) internal$ListAdapter$Converter) != null) {
            SessionVerbosity forNumber = SessionVerbosity.forNumber(valueOf.intValue());
            if (forNumber == null) {
                forNumber = SessionVerbosity.SESSION_VERBOSITY_NONE;
            }
            if (forNumber == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
                z = true;
            }
            return z;
        }
        throw null;
    }
}
