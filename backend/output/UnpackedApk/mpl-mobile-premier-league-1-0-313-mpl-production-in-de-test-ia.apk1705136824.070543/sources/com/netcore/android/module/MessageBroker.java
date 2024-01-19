package com.netcore.android.module;

import com.netcore.android.h.a;
import java.util.ArrayList;
import java.util.HashMap;

public class MessageBroker {
    public HashMap<String, ArrayList<IDataSubscriber>> allsubscribers = new HashMap<>();
    public a taskHandler = new a();

    public void publishBlockingEvent(String str, Object obj) {
        ArrayList arrayList = this.allsubscribers.get(str);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                try {
                    ((IDataSubscriber) arrayList.get(i)).handleEventData(str, obj);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public Object publishBlockingEventForReturn(String str, Object obj) {
        ArrayList arrayList = this.allsubscribers.get(str);
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                try {
                    return ((IDataSubscriber) arrayList.get(i)).returnEventData(str, obj);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i++;
                }
            }
        }
        return null;
    }

    public void publishEvent(final String str, final Object obj) {
        this.taskHandler.a(new Runnable() {
            public void run() {
                ArrayList arrayList = MessageBroker.this.allsubscribers.get(str);
                if (arrayList != null) {
                    int i = 0;
                    while (i < arrayList.size()) {
                        try {
                            final IDataSubscriber iDataSubscriber = (IDataSubscriber) arrayList.get(i);
                            MessageBroker.this.taskHandler.a(new Runnable() {
                                public void run() {
                                    try {
                                        IDataSubscriber iDataSubscriber = iDataSubscriber;
                                        AnonymousClass1 r1 = AnonymousClass1.this;
                                        iDataSubscriber.handleEventData(str, obj);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            });
                            i++;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                }
            }
        });
    }

    public void setSubscriber(String str, IDataSubscriber iDataSubscriber) {
        ArrayList arrayList = this.allsubscribers.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.allsubscribers.put(str, arrayList);
        }
        arrayList.add(iDataSubscriber);
    }
}
