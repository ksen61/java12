package com.example.pract12;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String name = getIntent().getStringExtra("name");
        String capital = getIntent().getStringExtra("capital");
        int flagResource = getIntent().getIntExtra("flag", 0);

        TextView nameTextView = findViewById(R.id.name_text_view);
        TextView capitalTextView = findViewById(R.id.capital_text_view);
        ImageView flagImageView = findViewById(R.id.flag_image_view);

        nameTextView.setText(name);
        capitalTextView.setText(capital);
        flagImageView.setImageResource(flagResource);
    }
}
