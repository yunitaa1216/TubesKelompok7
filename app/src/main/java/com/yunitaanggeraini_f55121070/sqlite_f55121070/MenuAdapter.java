package com.yunitaanggeraini_f55121070.sqlite_f55121070;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<Menu> menus;

    public MenuAdapter(Context context) {
            this.context = context;
            menus = new ArrayList<>();
        }

        public void setMembers(ArrayList<Menu> menus) {
            this.menus = menus;
        }

        @Override
        public int getCount() {
            return menus.size();
        }

        @Override
        public Object getItem(int i) {
            return menus.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.item_promo,
                        viewGroup, false);
            }
            MenuAdapter.ViewHolder viewHolder = new MenuAdapter.ViewHolder(view);
            Menu member = (Menu) getItem(i);
            viewHolder.bind(member);
            return view;
        }

        private class ViewHolder {
            private TextView txtName;
            private TextView txtDescription;
            private ImageView imgPhoto;

            ViewHolder(View view) {
                txtName = view.findViewById(R.id.txt_name);
                txtDescription = view.findViewById(R.id.txt_description);
                imgPhoto = view.findViewById(R.id.img_photo);
            }
            void bind (Menu member) {
                txtName.setText(member.getJudul());
                txtDescription.setText(member.getDescr());
                imgPhoto.setImageResource(member.getPhoto());
            }
        }
    }
