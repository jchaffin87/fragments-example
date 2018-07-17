package com.effugiumtechnologies.jchaf.fragmentsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ChessPieceListener{

    TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails = (TextView) findViewById(R.id.tvDetails);
    }

    @Override
    public void onChessPieceSelected(int index) {
        String [] descriptions = getResources().getStringArray(R.array.descriptions);

        tvDetails.setText(descriptions[index]);
    }
}
