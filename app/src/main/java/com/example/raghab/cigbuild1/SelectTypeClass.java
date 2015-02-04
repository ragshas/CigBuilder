package com.example.raghab.cigbuild1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by Raghab on 1/18/2015.
 */
public class SelectTypeClass extends ActionBarActivity {

    RadioButton mQuitRadioButton, mTrackRadioButton;
    EditText mPerPieceEditText, mTenPieceEditText, mTweEditText;
    Button mDoneButton;

    TextWatcher forPerEditText, forTenEditText, forTwentyEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_type_layout);

        mQuitRadioButton = (RadioButton) findViewById(R.id.quit_radioButton);
        mTrackRadioButton = (RadioButton) findViewById(R.id.track_radioButton);

        mDoneButton = (Button) findViewById(R.id.done_button_selectType);

        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mQuitRadioButton.isChecked()&&(mPerPieceEditText.length()>0 || mTenPieceEditText.length()>0 || mTweEditText.length()>0)) {
                    Intent i = new Intent(SelectTypeClass.this, QuitActivity.class);
                    startActivity(i);

                } else if (mTrackRadioButton.isChecked() && (mPerPieceEditText.length() > 0 || mTenPieceEditText.length() > 0 || mTweEditText.length() > 0)) {
                    Intent i = new Intent(SelectTypeClass.this, SmokeViewPager.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"Please enter the price for cigarette",Toast.LENGTH_SHORT).show();
                }
            }
        });


        mPerPieceEditText = (EditText) findViewById(R.id.perPiece_editText);
        mTenPieceEditText = (EditText) findViewById(R.id.tenPrice_editText);
        mTweEditText = (EditText) findViewById(R.id.twentyPrice_editText);


        forPerEditText = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mPerPieceEditText.getText().toString().length() == 0) {
                    return;
                } else {
                    float p1 = Float.parseFloat(mPerPieceEditText.getText().toString());
                    float calForTen = p1 * 10;
                    float calForTwe = p1 * 20;
                    DecimalFormat formatCost = new DecimalFormat("00.00");
                    String formatForTen = formatCost.format(calForTen);
                    String formatForTwenty = formatCost.format(calForTwe);
                    //Disable listener on other edit text
                    mTenPieceEditText.removeTextChangedListener(forTenEditText);
                    mTweEditText.removeTextChangedListener(forTwentyEditText);

                    mTenPieceEditText.setText(String.valueOf(formatForTen));
                    mTweEditText.setText(String.valueOf(formatForTwenty));

                    mTenPieceEditText.addTextChangedListener(forTenEditText);
                    mTweEditText.addTextChangedListener(forTwentyEditText);

                }

            }
        };

        forTenEditText = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mTenPieceEditText.getText().toString().length() == 0) {
                    return;
                } else {
                    float p1 = Float.parseFloat(mTenPieceEditText.getText().toString());
                    float calForPerPiece = p1 / 10;
                    float calForTwenty = calForPerPiece * 20;
                    DecimalFormat formatCost = new DecimalFormat("00.00");
                    String formatForPer = formatCost.format(calForPerPiece);
                    String formatForTwenty = formatCost.format(calForTwenty);

                    //Disable listener on other edittext
                    mPerPieceEditText.removeTextChangedListener(forPerEditText);
                    mTweEditText.removeTextChangedListener(forTwentyEditText);

                    mPerPieceEditText.setText(String.valueOf(formatForPer));
                    mTweEditText.setText(String.valueOf(formatForTwenty));

                    mPerPieceEditText.addTextChangedListener(forPerEditText);
                    mTweEditText.addTextChangedListener(forTwentyEditText);
                }

            }
        };

        forTwentyEditText = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mTweEditText.getText().toString().length() == 0) {
                    return;
                } else {
                    float p1 = Float.parseFloat(mTweEditText.getText().toString());
                    float calForPerPiece = p1 / 20;
                    float calForTen = calForPerPiece * 10;
                    DecimalFormat formatCost = new DecimalFormat("00.00");
                    String formatForPer = formatCost.format(calForPerPiece);
                    String formatForTen = formatCost.format(calForTen);

                    //Disable listener on other edittext
                    mTenPieceEditText.removeTextChangedListener(forTenEditText);
                    mPerPieceEditText.removeTextChangedListener(forPerEditText);

                    mPerPieceEditText.setText(String.valueOf(formatForPer));
                    mTenPieceEditText.setText(String.valueOf(formatForTen));

                    mPerPieceEditText.addTextChangedListener(forPerEditText);
                    mTenPieceEditText.addTextChangedListener(forTenEditText);
                }

            }
        };

        mPerPieceEditText.addTextChangedListener(forPerEditText);
        mTenPieceEditText.addTextChangedListener(forTenEditText);
        mTweEditText.addTextChangedListener(forTwentyEditText);

    }


}
