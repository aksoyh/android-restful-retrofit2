package com.bacbenc.android_restful_retrofit2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.bacbenc.android_restful_retrofit2.model.UserModel;

import java.util.List;

public class UserAdapter extends ArrayAdapter<UserModel> {

    private Context context;
    private List<UserModel> users;

    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<UserModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.users = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_user, parent, false);

        TextView txtUserId = (TextView) rowView.findViewById(R.id.txtUserId);
        TextView txtUsername = (TextView) rowView.findViewById(R.id.txtUsername);

        txtUserId.setText(String.format("#ID: %d", users.get(pos).getId()));
        txtUsername.setText(String.format("USER NAME: %s", users.get(pos).getName()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("user_id", String.valueOf(users.get(pos).getId()));
                intent.putExtra("user_name", users.get(pos).getName());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
