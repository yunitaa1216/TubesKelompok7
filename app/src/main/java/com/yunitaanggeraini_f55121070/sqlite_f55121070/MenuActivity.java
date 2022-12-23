package com.yunitaanggeraini_f55121070.sqlite_f55121070;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private String[] menu_title;
    private String[] menu_desc;
    private TypedArray menu_poster;
    private MenuAdapter adapter;
    private ArrayList<Menu> menulist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
        adapter = new MenuAdapter(this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Menu list = menulist.get(i);
                Intent intent = new Intent(MenuActivity.this, DetailMenu.class);
                intent.putExtra("title", list.getJudul());
                intent.putExtra("desc", list.getDescr());
                intent.putExtra("poster", list.getPhoto());
                startActivity(intent);
            }
        });

    }
    private void prepare() {
        menu_title =
                getResources().getStringArray(R.array.menu_title);
        menu_desc =
                getResources().getStringArray(R.array.menu_desc);
        menu_poster =
                getResources().obtainTypedArray(R.array.menu_poster);
    }
    private void addItem() {
        menulist = new ArrayList<>();
        for (int i = 0; i < menu_title.length; i++) {
            Menu Menu = new Menu();
            Menu.setPhoto(menu_poster.getResourceId(i, -1));
            Menu.setJudul(menu_title[i]);
            Menu.setDescr(menu_desc[i]);
            menulist.add(Menu);
        }
        adapter.setMembers(menulist);
    }
}