package sfs2x.client.core;

public interface IDispatchable {
    void addEventListener(String str, IEventListener iEventListener);

    EventDispatcher getDispatcher();
}
