package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import com.android.tools.r8.GeneratedOutlineSupport;
import sfs2x.client.entities.invitation.InvitationReply;

public class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    public static final ArgbEvaluatorCompat instance = new ArgbEvaluatorCompat();

    public Integer evaluate(float f2, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f3 = ((float) ((intValue >> 24) & InvitationReply.EXPIRED)) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & InvitationReply.EXPIRED)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & InvitationReply.EXPIRED)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & InvitationReply.EXPIRED)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & InvitationReply.EXPIRED)) / 255.0f), 2.2d);
        float outline3 = GeneratedOutlineSupport.outline3(((float) ((intValue2 >> 24) & InvitationReply.EXPIRED)) / 255.0f, f3, f2, f3);
        float outline32 = GeneratedOutlineSupport.outline3(pow4, pow, f2, pow);
        float outline33 = GeneratedOutlineSupport.outline3((float) Math.pow((double) (((float) ((intValue2 >> 8) & InvitationReply.EXPIRED)) / 255.0f), 2.2d), pow2, f2, pow2);
        float outline34 = GeneratedOutlineSupport.outline3((float) Math.pow((double) (((float) (intValue2 & InvitationReply.EXPIRED)) / 255.0f), 2.2d), pow3, f2, pow3);
        int round = Math.round(((float) Math.pow((double) outline32, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow((double) outline34, 0.45454545454545453d)) * 255.0f) | round | (Math.round(outline3 * 255.0f) << 24) | (Math.round(((float) Math.pow((double) outline33, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
