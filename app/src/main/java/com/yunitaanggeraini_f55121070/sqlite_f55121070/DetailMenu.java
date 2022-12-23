package com.yunitaanggeraini_f55121070.sqlite_f55121070;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.utils.DatabaseHelper;
import com.yunitaanggeraini_f55121070.sqlite_f55121070.databinding.ActivityRegisterBinding;

public class DetailMenu extends AppCompatActivity {
    Button button;
    EditText Edtnama, Edtalamat, Edtnomor, Edtjumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailmenu);

        Edtnama = findViewById(R.id.editnama);
        Edtalamat = findViewById(R.id.editalamat);
        Edtnomor = findViewById(R.id.editnomor);
        Edtjumlah = findViewById(R.id.editjumlah);

        button = findViewById(R.id.btnkirim);
        final String num = "+6282114456007";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pesan1 = Edtnama.getText().toString();
                String pesan2 = Edtalamat.getText().toString();
                String pesan3 = Edtnomor.getText().toString();
                String pesan4 = Edtjumlah.getText().toString();
                String semuapesan = "Nama : " + pesan1 + "\n" +
                        "Alamat : " + pesan2 + "\n" +
                        "No. HP : " + pesan3 + "\n" +
                        "Jumlah pakaian/kg : " + pesan4;

                boolean installed = isAppInstalled("com.whatsapp");

                if (installed) {
                    Intent kirimWa = new Intent(Intent.ACTION_SEND);
                    kirimWa.setType("text/plain");
                    kirimWa.putExtra(Intent.EXTRA_TEXT, semuapesan);
                    kirimWa.putExtra("jid", "6282114456007" + "@s.whatsapp.net");
                    kirimWa.setPackage("com.whatsapp");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&semuapesan=" + semuapesan  ));
                    startActivity(kirimWa);
                } else {
                    Toast.makeText(DetailMenu.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }
}