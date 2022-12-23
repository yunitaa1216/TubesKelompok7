package com.yunitaanggeraini_f55121070.sqlite_f55121070;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailLaundry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_laundry);

        ImageView poster = findViewById(R.id.imgDetail);
        TextView title = findViewById(R.id.DetailTitle);
        TextView desc = findViewById(R.id.detailDesc);

        Bundle bundle = getIntent().getExtras();
        poster.setImageResource(bundle.getInt("poster"));
        title.setText(bundle.getString("title"));
        desc.setText(bundle.getString("desc"));
    }
}