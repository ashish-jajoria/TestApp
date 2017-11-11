package com.aasofwaredevelopers.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTestActivity extends AppCompatActivity {

    public static final String UPDATED_DATA_TEXT = "updated data text";

    EditText etData;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test);
        etData = findViewById(R.id.et_data);
        btnSubmit = findViewById(R.id.btn_submit);

        etData.setText(getIntent().getStringExtra(TestActivity.DATA_TEXT));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(UPDATED_DATA_TEXT, etData.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
