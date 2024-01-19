package io.hansel.userjourney.prompts;

import android.util.Pair;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import java.util.HashMap;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final IMessageBroker f5485a;

    public a0(IMessageBroker iMessageBroker) {
        this.f5485a = iMessageBroker;
    }

    public void a(HashMap<String, Object> hashMap) {
        this.f5485a.publishEvent(EventsConstants.FIRE_PROMPT_ACTION.name(), hashMap.get("signal_prompt"));
        hashMap.remove("signal_prompt");
    }

    public void a(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        this.f5485a.publishEvent(EventsConstants.FIRE_PROMPT_EVENT.name(), Pair.create(hashMap, hashMap2));
    }

    public void b(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2) {
        this.f5485a.publishEvent(EventsConstants.FIRE_PROMPT_SHOW_EVENT.name(), Pair.create(hashMap, hashMap2));
    }
}
