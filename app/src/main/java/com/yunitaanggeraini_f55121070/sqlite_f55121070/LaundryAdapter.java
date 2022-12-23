package com.yunitaanggeraini_f55121070.sqlite_f55121070;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LaundryAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<laundry> laundries;

    public LaundryAdapter(Context context) {
            this.context = context;
            laundries = new ArrayList<>();
        }

        public void setMembers(ArrayList<laundry> laundries) {
            this.laundries = laundries;
        }

        @Override
        public int getCount() {
            return laundries.size();
        }

        @Override
        public Object getItem(int i) {
            return laundries.get(i);
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
            ViewHolder viewHolder = new ViewHolder(view);
            laundry member = (laundry) getItem(i);
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
            void bind (laundry member) {
                txtName.setText(member.getTitle());
                txtDescription.setText(member.getDesc());
                imgPhoto.setImageResource(member.getPoster());
            }
        }
    }
