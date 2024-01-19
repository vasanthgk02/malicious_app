package sfs2x.client.requests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sfs2x.client.entities.variables.RoomVariable;

public class RoomSettings {
    public boolean allowOwnerInvitation = true;
    public RoomEvents events;
    public RoomExtension extension;
    public String groupId = "default";
    public boolean isGame = false;
    public int maxSpectators = 0;
    public int maxUsers = 10;
    public int maxVariables = 5;
    public String name;
    public String password = "";
    public RoomPermissions permissions;
    public List<RoomVariable> variables = new ArrayList();

    public RoomSettings(String str) {
        this.name = str;
    }

    public boolean allowOwnerOnlyInvitation() {
        return this.allowOwnerInvitation;
    }

    public RoomEvents getEvents() {
        return this.events;
    }

    public RoomExtension getExtension() {
        return this.extension;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getMaxSpectators() {
        return this.maxSpectators;
    }

    public int getMaxUsers() {
        return this.maxUsers;
    }

    public int getMaxVariables() {
        return this.maxVariables;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public RoomPermissions getPermissions() {
        return this.permissions;
    }

    public List<RoomVariable> getVariables() {
        return this.variables;
    }

    public boolean isGame() {
        return this.isGame;
    }

    public void setAllowOwnerOnlyInvitation(boolean z) {
        this.allowOwnerInvitation = z;
    }

    public void setEvents(RoomEvents roomEvents) {
        this.events = roomEvents;
    }

    public void setExtension(RoomExtension roomExtension) {
        this.extension = roomExtension;
    }

    public void setGame(boolean z) {
        this.isGame = z;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setMaxSpectators(int i) {
        this.maxSpectators = i;
    }

    public void setMaxUsers(int i) {
        this.maxUsers = i;
    }

    public void setMaxVariables(int i) {
        this.maxVariables = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPermissions(RoomPermissions roomPermissions) {
        this.permissions = roomPermissions;
    }

    public void setVariables(List<RoomVariable> list) {
        this.variables = Collections.unmodifiableList(new ArrayList(list));
    }
}
