package com.milople.mydemoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class GetnumberActivity extends AppCompatActivity {
    TextInputEditText edtqty;
    MaterialButton btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getnumber);
        edtqty=findViewById(R.id.edtqty);
        btnsubmit=findViewById(R.id.btnsubmit);
        handleevent();
    }

    private void handleevent() {
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GetnumberActivity.this,MainActivity.class);
                String i= edtqty.getText().toString().trim();
                        intent.putExtra("qty",i);
                startActivity(intent);
            }
        });
    }

}