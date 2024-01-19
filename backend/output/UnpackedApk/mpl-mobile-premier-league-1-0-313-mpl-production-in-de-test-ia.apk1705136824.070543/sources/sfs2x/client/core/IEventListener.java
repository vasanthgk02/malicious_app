package sfs2x.client.core;

import com.smartfoxserver.v2.exceptions.SFSException;

@FunctionalInterface
public interface IEventListener {
    void dispatch(BaseEvent baseEvent) throws SFSException;
}
