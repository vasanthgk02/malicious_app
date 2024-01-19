package sfs2x.client.entities.variables;

public interface UserVariable extends Variable {
    boolean isPrivate();

    void setPrivate(boolean z);
}
