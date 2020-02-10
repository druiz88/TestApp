package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView firstID = convertView.findViewById(R.id.textID);
            TextView firstName = convertView.findViewById(R.id.textFirstName);
            TextView lastName = convertView.findViewById(R.id.textLastName);
            TextView eMail = convertView.findViewById(R.id.textEmail);

            firstID.setText(String.valueOf(user.getID()));

            if (firstName != null) {
                firstName.setText(user.getFirstName());
            }
            if (lastName != null) {
                lastName.setText((user.getLastName()));
            }
            if (eMail != null) {
                eMail.setText((user.getEmail()));
            }
        }

        return convertView;
    }
}
