package sfs2x.client.bitswarm;

public interface IController {
    short getId();

    void handleMessage(IMessage iMessage);

    void setId(short s);
}
