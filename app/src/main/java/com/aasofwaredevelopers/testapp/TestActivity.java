package com.aasofwaredevelopers.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TestActivity extends AppCompatActivity {

    public static final String DATA_TEXT = "data_text";
    private final int requestCodeUpdateData = 23834;

    EditText etData;
    EditText etUpdatedData;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        etData = findViewById(R.id.et_data);
        etUpdatedData = findViewById(R.id.et_updated_data);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setEnabled(false);

        etData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                btnSubmit.setEnabled(etData.getText().length() != 0);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, NewTestActivity.class);
                intent.putExtra(DATA_TEXT, etData.getText().toString());
                startActivityForResult(intent, requestCodeUpdateData);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCodeUpdateData) {
            etUpdatedData.setText(data.getStringExtra(NewTestActivity.UPDATED_DATA_TEXT));
        }
    }
}
