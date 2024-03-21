package com.example.viikko10;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView txtUsers;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        Toast.makeText(context, context.getFilesDir().toString(), Toast.LENGTH_LONG).show();

        UserStorage.getInstance().loadUsers(context);

    }

    public void switchToAddUser(View view){
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void switchToListUsers(View view){
        Intent intent = new Intent(this, ListUserInRecycleViewActivity.class);
        startActivity(intent);
    }

    /*public void saveUsers(View view){
        UserStorage.getInstance().saveUsers(context);
    }*/

}