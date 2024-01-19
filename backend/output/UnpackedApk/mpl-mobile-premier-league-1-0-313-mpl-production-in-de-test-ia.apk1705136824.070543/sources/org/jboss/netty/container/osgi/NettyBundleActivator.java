package org.jboss.netty.container.osgi;

import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.logging.OsgiLoggerFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class NettyBundleActivator implements BundleActivator {
    public OsgiLoggerFactory loggerFactory;

    public void start(BundleContext bundleContext) throws Exception {
        OsgiLoggerFactory osgiLoggerFactory = new OsgiLoggerFactory(bundleContext);
        this.loggerFactory = osgiLoggerFactory;
        InternalLoggerFactory.setDefaultFactory(osgiLoggerFactory);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        OsgiLoggerFactory osgiLoggerFactory = this.loggerFactory;
        if (osgiLoggerFactory != null) {
            InternalLoggerFactory.setDefaultFactory(osgiLoggerFactory.getFallback());
            this.loggerFactory.destroy();
            this.loggerFactory = null;
        }
    }
}
