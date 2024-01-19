package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory.InstanceHolder;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {
    public Provider<SchedulerConfig> configProvider;
    public Provider creationContextFactoryProvider;
    public Provider<DefaultScheduler> defaultSchedulerProvider;
    public Provider<Executor> executorProvider = DoubleCheck.provider(InstanceHolder.INSTANCE);
    public Provider metadataBackendRegistryProvider;
    public Provider<String> packageNameProvider;
    public Provider<SQLiteEventStore> sQLiteEventStoreProvider;
    public Provider schemaManagerProvider;
    public Provider<Context> setApplicationContextProvider;
    public Provider<TransportRuntime> transportRuntimeProvider;
    public Provider<Uploader> uploaderProvider;
    public Provider<WorkInitializer> workInitializerProvider;
    public Provider<WorkScheduler> workSchedulerProvider;

    /* JADX WARNING: type inference failed for: r2v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory] */
    /* JADX WARNING: type inference failed for: r2v2, types: [javax.inject.Provider, com.google.android.datatransport.runtime.dagger.internal.InstanceFactory, javax.inject.Provider<android.content.Context>] */
    /* JADX WARNING: type inference failed for: r1v1, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r3v1, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    /* JADX WARNING: type inference failed for: r4v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory] */
    /* JADX WARNING: type inference failed for: r2v3, types: [javax.inject.Provider, com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory] */
    /* JADX WARNING: type inference failed for: r2v4, types: [javax.inject.Provider, com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory] */
    /* JADX WARNING: type inference failed for: r3v2, types: [com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory, javax.inject.Provider] */
    /* JADX WARNING: type inference failed for: r4v1, types: [javax.inject.Provider, com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory] */
    /* JADX WARNING: type inference failed for: r7v0, types: [com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory, javax.inject.Provider, javax.inject.Provider<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v3, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r4v2, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory, javax.inject.Provider] */
    /* JADX WARNING: type inference failed for: r1v8, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r2v6, types: [javax.inject.Provider, com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory, javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig>] */
    /* JADX WARNING: type inference failed for: r4v3, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    /* JADX WARNING: type inference failed for: r8v0, types: [com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory, javax.inject.Provider, javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler>] */
    /* JADX WARNING: type inference failed for: r18v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r19v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    /* JADX WARNING: type inference failed for: r9v1, types: [javax.inject.Provider, javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer>, com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory] */
    /* JADX WARNING: type inference failed for: r5v2, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory] */
    /* JADX WARNING: type inference failed for: r6v2, types: [javax.inject.Provider, com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [javax.inject.Provider, com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory]
      assigns: [com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory]
      uses: [javax.inject.Provider]
      mth insns count: 71
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DaggerTransportRuntimeComponent(android.content.Context r22, com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent.AnonymousClass1 r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r21.<init>()
            com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory r2 = com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory.InstanceHolder.INSTANCE
            javax.inject.Provider r2 = com.google.android.datatransport.runtime.dagger.internal.DoubleCheck.provider(r2)
            r0.executorProvider = r2
            com.google.android.datatransport.runtime.dagger.internal.InstanceFactory r2 = new com.google.android.datatransport.runtime.dagger.internal.InstanceFactory
            java.lang.String r3 = "instance cannot be null"
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.checkNotNull(r1, r3)
            r2.<init>(r1)
            r0.setApplicationContextProvider = r2
            com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory r1 = com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory r3 = com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory r4 = new com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory
            r4.<init>(r2, r1, r3)
            r0.creationContextFactoryProvider = r4
            javax.inject.Provider<android.content.Context> r1 = r0.setApplicationContextProvider
            com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory r2 = new com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory
            r2.<init>(r1, r4)
            javax.inject.Provider r1 = com.google.android.datatransport.runtime.dagger.internal.DoubleCheck.provider(r2)
            r0.metadataBackendRegistryProvider = r1
            javax.inject.Provider<android.content.Context> r1 = r0.setApplicationContextProvider
            com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory r2 = com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory r3 = com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory r4 = new com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory
            r4.<init>(r1, r2, r3)
            r0.schemaManagerProvider = r4
            javax.inject.Provider<android.content.Context> r1 = r0.setApplicationContextProvider
            com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory r7 = new com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory
            r7.<init>(r1)
            r0.packageNameProvider = r7
            com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory r3 = com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory r4 = com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory r5 = com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory.InstanceHolder.INSTANCE
            javax.inject.Provider r6 = r0.schemaManagerProvider
            com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory r1 = new com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            javax.inject.Provider r1 = com.google.android.datatransport.runtime.dagger.internal.DoubleCheck.provider(r1)
            r0.sQLiteEventStoreProvider = r1
            com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory r1 = com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory r2 = new com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory
            r2.<init>(r1)
            r0.configProvider = r2
            javax.inject.Provider<android.content.Context> r1 = r0.setApplicationContextProvider
            javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore> r3 = r0.sQLiteEventStoreProvider
            com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory r4 = com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory r8 = new com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory
            r8.<init>(r1, r3, r2, r4)
            r0.workSchedulerProvider = r8
            javax.inject.Provider<java.util.concurrent.Executor> r6 = r0.executorProvider
            javax.inject.Provider r7 = r0.metadataBackendRegistryProvider
            javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore> r10 = r0.sQLiteEventStoreProvider
            com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory r1 = new com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory
            r5 = r1
            r9 = r10
            r5.<init>(r6, r7, r8, r9, r10)
            r0.defaultSchedulerProvider = r1
            javax.inject.Provider<android.content.Context> r12 = r0.setApplicationContextProvider
            javax.inject.Provider r13 = r0.metadataBackendRegistryProvider
            javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore> r1 = r0.sQLiteEventStoreProvider
            javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler> r15 = r0.workSchedulerProvider
            javax.inject.Provider<java.util.concurrent.Executor> r2 = r0.executorProvider
            com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory r18 = com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory r19 = com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory r3 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory
            r11 = r3
            r14 = r1
            r16 = r2
            r17 = r1
            r20 = r1
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r0.uploaderProvider = r3
            javax.inject.Provider<java.util.concurrent.Executor> r1 = r0.executorProvider
            javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore> r2 = r0.sQLiteEventStoreProvider
            javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler> r3 = r0.workSchedulerProvider
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory r9 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory
            r9.<init>(r1, r2, r3, r2)
            r0.workInitializerProvider = r9
            com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory r5 = com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory.InstanceHolder.INSTANCE
            com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory r6 = com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE
            javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.DefaultScheduler> r7 = r0.defaultSchedulerProvider
            javax.inject.Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader> r8 = r0.uploaderProvider
            com.google.android.datatransport.runtime.TransportRuntime_Factory r1 = new com.google.android.datatransport.runtime.TransportRuntime_Factory
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9)
            javax.inject.Provider r1 = com.google.android.datatransport.runtime.dagger.internal.DoubleCheck.provider(r1)
            r0.transportRuntimeProvider = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent.<init>(android.content.Context, com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent$1):void");
    }
}
