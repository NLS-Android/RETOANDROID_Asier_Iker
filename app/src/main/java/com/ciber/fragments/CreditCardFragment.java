package com.ciber.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ciber.retoandroid_asier_iker.CreditCardActivity;
import com.ciber.retoandroid_asier_iker.R;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

public class CreditCardFragment extends Fragment {

    private static final int SCAN_RESULT = 13274384;
    private static final int MY_SCAN_REQUEST_CODE = 100;
    private TextView textViewCard, textViewDate;
    private Button button_scan, button_rest;
    private Object View;

    public CreditCardFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_credit_card, container, false);
        textViewCard = (TextView) v.findViewById(R.id.textViewCard);
        textViewDate = (TextView) v.findViewById(R.id.textViewDate);
        button_scan = (Button) v.findViewById(R.id.button_scan);
        button_rest = (Button) v.findViewById(R.id.button_rest);
        button_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent rest = new Intent(getActivity(), CreditCardActivity.class);
                startActivity(rest);
            }
        });
        scanCard(v);
        return v;
    }

    public void scanCard(View v) {
        Intent scanIntent = new Intent(getActivity(), CardIOActivity.class);
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false); // default: false
        startActivityForResult(scanIntent, MY_SCAN_REQUEST_CODE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult ( requestCode, resultCode, data );

        if (resultCode == SCAN_RESULT){
            if (data != null && data.hasExtra (CardIOActivity.EXTRA_SCAN_RESULT)){
                CreditCard scanResult = data.getParcelableExtra (CardIOActivity.EXTRA_SCAN_RESULT);
                textViewCard.setText (scanResult.getFormattedCardNumber ());
                if (scanResult.isExpiryValid ()){
                    String mes = String.valueOf (scanResult.expiryMonth);
                    String an = String.valueOf (scanResult.expiryYear);
                    textViewDate.setText (mes + "/" + an);

                }
            }
        }
    }
}
