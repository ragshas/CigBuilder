package com.example.raghab.cigbuild1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Raghab on 1/18/2015.
 */
public class SelectTypeClass extends ActionBarActivity implements View.OnClickListener{

    Button mButtonQuit, mButtonSmoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_type_layout);

        //Referencing and initializing quit button
        mButtonQuit = (Button) findViewById(R.id.select_type_button_QUIT);
        mButtonQuit.setOnClickListener(this);

        mButtonSmoke = (Button) findViewById(R.id.select_type_button_SMOKE);
        mButtonSmoke.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_type_button_QUIT:
                Intent i = new Intent(this, QuitActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.select_type_button_SMOKE:
                Intent intent = new Intent(this, SmokeActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"clicked", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

}
