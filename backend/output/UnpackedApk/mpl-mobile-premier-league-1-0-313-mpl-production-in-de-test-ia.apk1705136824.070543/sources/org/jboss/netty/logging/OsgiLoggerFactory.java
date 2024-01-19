package org.jboss.netty.logging;

import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

public class OsgiLoggerFactory extends InternalLoggerFactory {
    public final InternalLoggerFactory fallback;
    public volatile LogService logService;
    public final ServiceTracker logServiceTracker;

    public OsgiLoggerFactory(BundleContext bundleContext) {
        this(bundleContext, null);
    }

    public void destroy() {
        this.logService = null;
        this.logServiceTracker.close();
    }

    public InternalLoggerFactory getFallback() {
        return this.fallback;
    }

    public LogService getLogService() {
        return this.logService;
    }

    public InternalLogger newInstance(String str) {
        return new OsgiLogger(this, str, this.fallback.newInstance(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r4 = new org.jboss.netty.logging.JdkLoggerFactory();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OsgiLoggerFactory(org.osgi.framework.BundleContext r3, org.jboss.netty.logging.InternalLoggerFactory r4) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 == 0) goto L_0x0024
            if (r4 != 0) goto L_0x0014
            org.jboss.netty.logging.InternalLoggerFactory r4 = org.jboss.netty.logging.InternalLoggerFactory.getDefaultFactory()
            boolean r0 = r4 instanceof org.jboss.netty.logging.OsgiLoggerFactory
            if (r0 == 0) goto L_0x0014
            org.jboss.netty.logging.JdkLoggerFactory r4 = new org.jboss.netty.logging.JdkLoggerFactory
            r4.<init>()
        L_0x0014:
            r2.fallback = r4
            org.jboss.netty.logging.OsgiLoggerFactory$1 r4 = new org.jboss.netty.logging.OsgiLoggerFactory$1
            r0 = 0
            java.lang.String r1 = "org.osgi.service.log.LogService"
            r4.<init>(r3, r1, r0)
            r2.logServiceTracker = r4
            r4.open()
            return
        L_0x0024:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "ctx"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.logging.OsgiLoggerFactory.<init>(org.osgi.framework.BundleContext, org.jboss.netty.logging.InternalLoggerFactory):void");
    }
}
