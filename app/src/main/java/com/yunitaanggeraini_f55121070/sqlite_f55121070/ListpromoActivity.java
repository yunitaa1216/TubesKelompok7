package com.yunitaanggeraini_f55121070.sqlite_f55121070;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class ListpromoActivity extends AppCompatActivity {
    private String[] promo_title;
    private String[] promo_desc;
    private TypedArray promo_poster;
    private LaundryAdapter adapter;
    private ArrayList<laundry> promolist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listpromo);
        adapter = new LaundryAdapter(this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                laundry list = promolist.get(i);
                Intent intent = new Intent(ListpromoActivity.this, DetailLaundry.class);
                intent.putExtra("title", list.getTitle());
                intent.putExtra("desc", list.getDesc());
                intent.putExtra("poster", list.getPoster());
                startActivity(intent);
            }
        });

    }
    private void prepare() {
        promo_title =
                getResources().getStringArray(R.array.promo_title);
        promo_desc =
                getResources().getStringArray(R.array.promo_desc);
        promo_poster =
                getResources().obtainTypedArray(R.array.promo_poster);
    }
    private void addItem() {
        promolist = new ArrayList<>();
        for (int i = 0; i < promo_title.length; i++) {
            laundry laundry = new laundry();
            laundry.setPoster(promo_poster.getResourceId(i, -1));
            laundry.setTitle(promo_title[i]);
            laundry.setDesc(promo_desc[i]);
            promolist.add(laundry);
        }
        adapter.setMembers(promolist);
    }
}