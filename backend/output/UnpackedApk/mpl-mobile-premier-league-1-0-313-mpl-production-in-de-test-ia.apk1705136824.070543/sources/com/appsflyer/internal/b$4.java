package com.appsflyer.internal;

import java.util.HashMap;
import sfs2x.client.requests.CreateRoomRequest;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

public class b$4 extends HashMap<String, String> {
    public b$4() {
        put("aa", "ro.arch");
        put("ab", "ro.chipname");
        put("ac", "ro.dalvik.vm.native.bridge");
        put("ad", "persist.sys.nativebridge");
        put("ae", "ro.enable.native.bridge.exec");
        put("af", "dalvik.vm.isa.x86.features");
        put("ag", "dalvik.vm.isa.x86.variant");
        put("ah", "ro.zygote");
        put("ai", "ro.allow.mock.location");
        put(CreateRoomRequest.KEY_AUTOJOIN, "ro.dalvik.vm.isa.arm");
        put("ak", "dalvik.vm.isa.arm.features");
        put("al", "dalvik.vm.isa.arm.variant");
        put("am", "dalvik.vm.isa.arm64.features");
        put("an", "dalvik.vm.isa.arm64.variant");
        put("ao", "vzw.os.rooted");
        put("ap", "ro.build.user");
        put("aq", "ro.kernel.qemu");
        put("ar", "ro.hardware");
        put(JoinRoomInvitationRequest.KEY_AS_SPECT, "ro.product.cpu.abi");
        put("at", "ro.product.cpu.abilist");
        put("au", "ro.product.cpu.abilist32");
        put("av", "ro.product.cpu.abilist64");
    }
}
