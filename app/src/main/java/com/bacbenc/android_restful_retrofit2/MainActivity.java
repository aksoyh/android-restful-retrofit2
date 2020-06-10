package com.bacbenc.android_restful_retrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bacbenc.android_restful_retrofit2.Utils.ApiUtils;
import com.bacbenc.android_restful_retrofit2.Utils.UserService;
import com.bacbenc.android_restful_retrofit2.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnaddUser, btnGetUsersList;
    TextView message;
    ListView listView;
    UserService userService;
    List<UserModel> list = new ArrayList<UserModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Retrofit Spring Restful");

        btnaddUser = (Button) findViewById(R.id.btnAddUser);
        btnGetUsersList = (Button) findViewById(R.id.btnGetUsersList);
        listView = (ListView) findViewById(R.id.listView);
        userService = ApiUtils.getuserService();
        message = (TextView) findViewById(R.id.tvEmptyListMessage);

        btnGetUsersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Position:", "Reached getuserlistbuttonclicked");
                getusersList();
            }
        });

        btnaddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                intent.putExtra("user_name", "");
                startActivity(intent);
            }
        });

    }

    private void getusersList() {
        Log.i("Position:", "Reached getuserslistmethd");
        Call<List<UserModel>> call = userService.getUsers();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                Log.i("Position:", "Reached onResponse");
                if(response.isSuccessful()){
                    if (response.body().size() != 0) {
                        list = response.body();
                        listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                    } else {
                        message.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.e("Position:", "Reached onFailure");
                Log.e("ERROR: ", t.getMessage());
                Toast.makeText(getApplicationContext(), "Bir hata oluştu" + t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
