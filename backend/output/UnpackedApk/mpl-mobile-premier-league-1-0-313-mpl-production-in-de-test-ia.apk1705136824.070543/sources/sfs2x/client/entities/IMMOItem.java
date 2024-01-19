package sfs2x.client.entities;

import java.util.List;
import sfs2x.client.entities.data.Vec3D;
import sfs2x.client.entities.variables.IMMOItemVariable;

public interface IMMOItem {
    boolean containsVariable(String str);

    Vec3D getAOIEntryPoint();

    int getId();

    IMMOItemVariable getVariable(String str);

    List<IMMOItemVariable> getVariables();

    void setVariable(IMMOItemVariable iMMOItemVariable);

    void setVariables(List<IMMOItemVariable> list);
}
