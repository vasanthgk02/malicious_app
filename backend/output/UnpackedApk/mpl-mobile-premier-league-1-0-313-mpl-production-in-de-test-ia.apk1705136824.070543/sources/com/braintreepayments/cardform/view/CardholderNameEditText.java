package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.R$string;
import sfs2x.client.entities.invitation.InvitationReply;

public class CardholderNameEditText extends ErrorEditText {
    public CardholderNameEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setInputType(1);
        setFilters(new InputFilter[]{new LengthFilter(InvitationReply.EXPIRED)});
    }

    public String getErrorMessage() {
        return getContext().getString(R$string.bt_cardholder_name_required);
    }

    public boolean isValid() {
        return this.mOptional || !getText().toString().trim().isEmpty();
    }

    public CardholderNameEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setInputType(1);
        setFilters(new InputFilter[]{new LengthFilter(InvitationReply.EXPIRED)});
    }
}
