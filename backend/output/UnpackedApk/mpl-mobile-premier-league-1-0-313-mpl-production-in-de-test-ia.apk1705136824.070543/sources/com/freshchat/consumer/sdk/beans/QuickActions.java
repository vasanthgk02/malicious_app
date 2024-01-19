package com.freshchat.consumer.sdk.beans;

import com.freshchat.consumer.sdk.service.d.j;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuickActions {
    public List<Map<String, String>> menu = new ArrayList();
    public List<String> quickActionsMenuList = new ArrayList();
    public List<String> quickActionsSlashCommandList = new ArrayList();
    @SerializedName("slash_command")
    public List<Map<String, String>> slashCommand = new ArrayList();

    public List<Map<String, String>> getMenu() {
        return this.menu;
    }

    public List<String> getQuickActionsMenuList() {
        List<String> N = j.N(this.menu);
        this.quickActionsMenuList = N;
        return N;
    }

    public List<String> getQuickActionsSlashCommandList() {
        List<String> N = j.N(this.slashCommand);
        this.quickActionsSlashCommandList = N;
        return N;
    }

    public List<Map<String, String>> getSlashCommand() {
        return this.slashCommand;
    }

    public void setMenu(List<Map<String, String>> list) {
        this.menu = list;
    }

    public void setSlashCommand(List<Map<String, String>> list) {
        this.slashCommand = list;
    }
}
