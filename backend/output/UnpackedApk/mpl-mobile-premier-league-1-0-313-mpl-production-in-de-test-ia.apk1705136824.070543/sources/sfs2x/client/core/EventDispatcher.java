package sfs2x.client.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventDispatcher {
    public Map<String, List<IEventListener>> listeners = new HashMap();
    public Logger log;
    public Object target;

    public EventDispatcher(Object obj) {
        this.target = obj;
        this.log = LoggerFactory.getLogger(EventDispatcher.class);
    }

    public void addEventListener(String str, IEventListener iEventListener) {
        List list = this.listeners.get(str);
        if (list == null) {
            list = new ArrayList();
            this.listeners.put(str, list);
        }
        if (!list.contains(iEventListener)) {
            list.add(iEventListener);
        }
    }

    public void dispatchEvent(BaseEvent baseEvent) {
        List<IEventListener> list = this.listeners.get(baseEvent.getType());
        if (list != null) {
            baseEvent.setTarget(this.target);
            if (this.log.isDebugEnabled()) {
                Logger logger = this.log;
                logger.debug("Dispatching event " + baseEvent.getType() + " to " + list.size() + " listeners");
            }
            try {
                for (IEventListener dispatch : list) {
                    dispatch.dispatch(baseEvent);
                }
            } catch (Exception e2) {
                Logger logger2 = this.log;
                logger2.error("Error dispatching event " + baseEvent.getType() + " :" + e2.getLocalizedMessage());
                e2.printStackTrace();
            }
        }
    }

    public void removeAll() {
        this.listeners.clear();
    }

    public void removeEventListener(String str, IEventListener iEventListener) {
        List list = this.listeners.get(str);
        if (list != null) {
            list.remove(iEventListener);
        }
    }
}
