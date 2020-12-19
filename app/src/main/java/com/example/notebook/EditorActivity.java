package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.io.BufferedReader;

public class EditorActivity extends AppCompatActivity {
    EditText title, content;
    int titleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        getSupportActionBar().setTitle("Go to MainActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);

        Intent intent = getIntent();
        titleId = intent.getIntExtra("titleId", -1);
        if (titleId == -1) {
            MainActivity.titles.add("");
            MainActivity.content.add("");
            titleId = MainActivity.titles.size() - 1;
            MainActivity.adapter.notifyDataSetChanged();
        } else {
            title.setText(MainActivity.titles.get(titleId));
            content.setText(MainActivity.content.get(titleId));
        }

        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.titles.set(titleId, String.valueOf(charSequence));
                MainActivity.adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.content.set(titleId, String.valueOf(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
