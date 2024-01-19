package io.sentry.transport;

import io.sentry.ILogger;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryLevel;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.util.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.fontbox.cmap.CMap;

public final class RateLimiter {
    public static final int HTTP_RETRY_AFTER_DEFAULT_DELAY_MILLIS = 60000;
    public final ICurrentDateProvider currentDateProvider;
    public final ILogger logger;
    public final Map<DataCategory, Date> sentryRetryAfterLimit;

    public enum DataCategory {
        All("__all__"),
        Default("default"),
        Error("error"),
        Session("session"),
        Attachment("attachment"),
        Transaction("transaction"),
        Security("security"),
        Unknown("unknown");
        
        public final String category;

        /* access modifiers changed from: public */
        DataCategory(String str) {
            this.category = str;
        }

        public String getCategory() {
            return this.category;
        }
    }

    public RateLimiter(ICurrentDateProvider iCurrentDateProvider, ILogger iLogger) {
        this.sentryRetryAfterLimit = new ConcurrentHashMap();
        this.currentDateProvider = iCurrentDateProvider;
        this.logger = iLogger;
    }

    private void applyRetryAfterOnlyIfLonger(DataCategory dataCategory, Date date) {
        Date date2 = this.sentryRetryAfterLimit.get(dataCategory);
        if (date2 == null || date.after(date2)) {
            this.sentryRetryAfterLimit.put(dataCategory, date);
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.sentry.transport.RateLimiter.DataCategory getCategoryFromItemType(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1963501277: goto L_0x002a;
                case 96891546: goto L_0x0020;
                case 1984987798: goto L_0x0016;
                case 2141246174: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0034
        L_0x000b:
            java.lang.String r0 = "transaction"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 3
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "session"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "event"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "attachment"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0049
            if (r5 == r3) goto L_0x0046
            if (r5 == r2) goto L_0x0043
            if (r5 == r1) goto L_0x0040
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Unknown
            return r5
        L_0x0040:
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Transaction
            return r5
        L_0x0043:
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Attachment
            return r5
        L_0x0046:
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Session
            return r5
        L_0x0049:
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Error
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.RateLimiter.getCategoryFromItemType(java.lang.String):io.sentry.transport.RateLimiter$DataCategory");
    }

    private boolean isRetryAfter(String str) {
        DataCategory categoryFromItemType = getCategoryFromItemType(str);
        Date date = new Date(this.currentDateProvider.getCurrentTimeMillis());
        Date date2 = this.sentryRetryAfterLimit.get(DataCategory.All);
        if (date2 != null && !date.after(date2)) {
            return true;
        }
        if (DataCategory.Unknown.equals(categoryFromItemType)) {
            return false;
        }
        Date date3 = this.sentryRetryAfterLimit.get(categoryFromItemType);
        if (date3 != null) {
            return !date.after(date3);
        }
        return false;
    }

    public static void markHintWhenSendingFailed(Object obj, boolean z) {
        if (obj instanceof SubmissionResult) {
            ((SubmissionResult) obj).setResult(false);
        }
        if (obj instanceof Retryable) {
            ((Retryable) obj).setRetry(z);
        }
    }

    private long parseRetryAfterOrDefault(String str) {
        if (str != null) {
            try {
                return (long) (Double.parseDouble(str) * 1000.0d);
            } catch (NumberFormatException unused) {
            }
        }
        return 60000;
    }

    public SentryEnvelope filter(SentryEnvelope sentryEnvelope, Object obj) {
        List list = null;
        for (SentryEnvelopeItem next : sentryEnvelope.getItems()) {
            if (isRetryAfter(next.getHeader().getType().getItemType())) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(next);
            }
        }
        if (list == null) {
            return sentryEnvelope;
        }
        this.logger.log(SentryLevel.INFO, (String) "%d items will be dropped due rate limiting.", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        for (SentryEnvelopeItem next2 : sentryEnvelope.getItems()) {
            if (!list.contains(next2)) {
                arrayList.add(next2);
            }
        }
        if (!arrayList.isEmpty()) {
            return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList);
        }
        this.logger.log(SentryLevel.INFO, (String) "Envelope discarded due all items rate limited.", new Object[0]);
        markHintWhenSendingFailed(obj, false);
        return null;
    }

    public void updateRetryAfterLimits(String str, String str2, int i) {
        String str3 = str;
        if (str3 != null) {
            int i2 = -1;
            String[] split = str3.split(",", -1);
            int length = split.length;
            int i3 = 0;
            while (i3 < length) {
                String[] split2 = split[i3].replace(CMap.SPACE, "").split(":", i2);
                if (split2.length > 0) {
                    long parseRetryAfterOrDefault = parseRetryAfterOrDefault(split2[0]);
                    if (split2.length > 1) {
                        String str4 = split2[1];
                        Date date = new Date(this.currentDateProvider.getCurrentTimeMillis() + parseRetryAfterOrDefault);
                        if (str4 == null || str4.isEmpty()) {
                            applyRetryAfterOnlyIfLonger(DataCategory.All, date);
                        } else {
                            for (String str5 : str4.split(";", i2)) {
                                DataCategory dataCategory = DataCategory.Unknown;
                                try {
                                    String capitalize = StringUtils.capitalize(str5);
                                    if (capitalize != null) {
                                        dataCategory = DataCategory.valueOf(capitalize);
                                    } else {
                                        this.logger.log(SentryLevel.ERROR, (String) "Couldn't capitalize: %s", str5);
                                    }
                                } catch (IllegalArgumentException e2) {
                                    this.logger.log(SentryLevel.INFO, e2, "Unknown category: %s", str5);
                                }
                                if (!DataCategory.Unknown.equals(dataCategory)) {
                                    applyRetryAfterOnlyIfLonger(dataCategory, date);
                                }
                            }
                        }
                    }
                }
                i3++;
                i2 = -1;
            }
        } else if (i == 429) {
            applyRetryAfterOnlyIfLonger(DataCategory.All, new Date(this.currentDateProvider.getCurrentTimeMillis() + parseRetryAfterOrDefault(str2)));
        }
    }

    public RateLimiter(ILogger iLogger) {
        this(CurrentDateProvider.getInstance(), iLogger);
    }
}
