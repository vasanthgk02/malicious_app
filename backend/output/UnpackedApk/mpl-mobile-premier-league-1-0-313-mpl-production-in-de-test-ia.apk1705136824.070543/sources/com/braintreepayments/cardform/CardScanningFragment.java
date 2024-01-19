package com.braintreepayments.cardform;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.cardform.view.CardForm;
import io.card.payment.CardIOActivity;

public class CardScanningFragment extends Fragment {
    public CardForm mCardForm;

    public static CardScanningFragment requestScan(AppCompatActivity appCompatActivity, CardForm cardForm) {
        CardScanningFragment cardScanningFragment = (CardScanningFragment) appCompatActivity.getSupportFragmentManager().findFragmentByTag("com.braintreepayments.cardform.CardScanningFragment");
        if (cardScanningFragment != null) {
            appCompatActivity.getSupportFragmentManager().beginTransaction().remove(cardScanningFragment).commit();
        }
        CardScanningFragment cardScanningFragment2 = new CardScanningFragment();
        cardScanningFragment2.mCardForm = cardForm;
        appCompatActivity.getSupportFragmentManager().beginTransaction().add((Fragment) cardScanningFragment2, (String) "com.braintreepayments.cardform.CardScanningFragment").commit();
        return cardScanningFragment2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 12398) {
            this.mCardForm.handleCardIOResponse(i2, intent);
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (bundle == null || !bundle.getBoolean("resuming")) {
            startActivityForResult(new Intent(getActivity(), CardIOActivity.class).putExtra("io.card.payment.hideLogo", true).putExtra("io.card.payment.intentSenderIsPayPal", false).putExtra("io.card.payment.suppressManual", true).putExtra("io.card.payment.suppressConfirmation", true).putExtra("io.card.payment.scanExpiry", true).putExtra("io.card.payment.requireCVV", false).putExtra("io.card.payment.requirePostalCode", false).putExtra("io.card.payment.guideColor", k.getColor(getActivity(), "colorAccent", R$color.bt_blue)), 12398);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resuming", false);
    }
}
