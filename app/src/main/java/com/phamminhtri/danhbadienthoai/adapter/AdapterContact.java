package com.phamminhtri.danhbadienthoai.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamminhtri.danhbadienthoai.R;
import com.phamminhtri.danhbadienthoai.model.Contact;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;

public class AdapterContact extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private List<Contact> arrContact;

    public AdapterContact(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrContact = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholer viewholer;
        if (convertView == null) {
            viewholer = new Viewholer();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview, parent, false);

            viewholer.imgavatar = convertView.findViewById(R.id.img_avartart);
            viewholer.tvname = convertView.findViewById(R.id.tv_name);
            viewholer.tvnumber = convertView.findViewById(R.id.tv_number);

            convertView.setTag(viewholer);
        } else {
            viewholer = (Viewholer) convertView.getTag();
        }

        Contact contact = arrContact.get(position);
        if (contact.ismAvatar()) {
            viewholer.imgavatar.setBackgroundResource(R.drawable.man);

        } else {
            viewholer.imgavatar.setBackgroundResource(R.drawable.images);
        }
        viewholer.tvname.setText(contact.getmName());
        viewholer.tvnumber.setText(contact.getmNumber());

        return convertView;
    }

    public class Viewholer {
        TextView tvname;
        TextView tvnumber;
        ImageView imgavatar;

    }
}
