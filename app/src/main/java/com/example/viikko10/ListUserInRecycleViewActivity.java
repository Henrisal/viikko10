package com.example.viikko10;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListUserInRecycleViewActivity extends AppCompatActivity {

    private UserStorage userStorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_in_recycle_view);

        userStorage = UserStorage.getInstance();
        recyclerView = findViewById(R.id.rvUserView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<User> sortedUsers = userStorage.getUsers();
        Collections.sort(sortedUsers, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getLastName().compareTo(u2.getLastName());
            }
        });

        recyclerView.setAdapter(new UserListAdapter(getApplicationContext(), sortedUsers));


    }
}