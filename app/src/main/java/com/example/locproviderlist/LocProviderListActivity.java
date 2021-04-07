package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.util.Range;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager locMgr;
    List<String> locProviders;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        mButton = findViewById(R.id.button);
        locMgr = (LocationManager) getSystemService(LOCATION_SERVICE); // new LocationManager()

        locProviders = locMgr.getAllProviders();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = "";
                for (String i : locProviders){
                    s += "Loc. Provider " + i + "\n"
                            + "Status: " + locMgr.isProviderEnabled(i) + "\n\n";
                }
                mTextView.setText(s);
            }
        });
    }
}