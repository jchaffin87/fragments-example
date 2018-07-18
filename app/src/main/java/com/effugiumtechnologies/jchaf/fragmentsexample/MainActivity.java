package com.effugiumtechnologies.jchaf.fragmentsexample;

import android.app.Fragment;
import android.app.FragmentManager;
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

        if(findViewById(R.id.layout_default) != null){
            android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();

        }

        if(findViewById(R.id.layout_land) != null){
            android.support.v4.app.FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .commit();
        }
    }

    @Override
    public void onChessPieceSelected(int index) {

        if(findViewById(R.id.layout_default) != null){
            android.support.v4.app.FragmentManager manager =  this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .addToBackStack(null)
                    .commit();
        }
        String [] descriptions = getResources().getStringArray(R.array.descriptions);

        tvDetails.setText(descriptions[index]);
    }
}
