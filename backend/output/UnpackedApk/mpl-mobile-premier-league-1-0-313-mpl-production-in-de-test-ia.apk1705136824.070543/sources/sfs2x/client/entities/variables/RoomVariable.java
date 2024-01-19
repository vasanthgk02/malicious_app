package sfs2x.client.entities.variables;

public interface RoomVariable extends Variable {
    boolean isPersistent();

    boolean isPrivate();

    void setPersistent(boolean z);

    void setPrivate(boolean z);
}
