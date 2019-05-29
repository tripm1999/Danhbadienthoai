package com.phamminhtri.danhbadienthoai;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import com.phamminhtri.danhbadienthoai.adapter.AdapterContact;
import com.phamminhtri.danhbadienthoai.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtNumber;
    private RadioButton rdbtnMan;
    private RadioButton rdbtnWoman;
    private Button btnAdd;
    private ListView lvContac;
    private List<Contact> arrayList;
    AdapterContact adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        arrayList = new ArrayList<>();
        adapterContact = new AdapterContact(MainActivity.this, R.layout.item_listview, arrayList);
        lvContac.setAdapter(adapterContact);
        lvContac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialogcofirm(position);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                String number = edtNumber.getText().toString().trim();
                Boolean male;
                if (rdbtnMan.isChecked()) {
                    male = true;
                } else {
                    male = false;
                }

                if (name.equals("")) {
                    edtName.setError("không được để trống!");
                } else if (number.equals("")) {
                    edtNumber.setError("không được để trống!");
                } else {
                    Contact contact = new Contact(male, name, number);
                    arrayList.add(contact);
                }
                adapterContact.notifyDataSetChanged();
            }
        });

    }

    public void anhxa() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtNumber = (EditText) findViewById(R.id.edt_number);
        rdbtnMan = (RadioButton) findViewById(R.id.rdbtn_man);
        rdbtnWoman = (RadioButton) findViewById(R.id.rdbtn_woman);
        btnAdd = (Button) findViewById(R.id.btn_add);
        lvContac = (ListView) findViewById(R.id.lv_contac);
    }

    public void dialogcofirm(final int position) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_layout);
        Button btnCall = (Button) dialog.findViewById(R.id.btn_call);
        Button btnMess = (Button) dialog.findViewById(R.id.btn_mess);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentcall(position);
            }
        });
        btnMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentmess(position);
            }
        });
        dialog.show();
    }

//    private void checkAndRequestPermissions() {
//        String[] permissions = new String[]{
//                Manifest.permission.CALL_PHONE,
//                Manifest.permission.SEND_SMS
//        };
//        List<String> listPermissionsNeeded = new ArrayList<>();
//        for (String permission : permissions) {
//            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
//                listPermissionsNeeded.add(permission);
//            }
//        }
//        if (!listPermissionsNeeded.isEmpty()) {
//            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
//        }
//    }

    private void intentcall(int position) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + arrayList.get(position).getmNumber()));
        startActivity(intent);
    }

    private void intentmess(int position) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:" + arrayList.get(position).getmNumber()));
        startActivity(intent);
    }
}
