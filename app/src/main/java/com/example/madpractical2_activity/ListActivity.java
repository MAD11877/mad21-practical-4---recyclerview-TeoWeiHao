package com.example.madpractical2_activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    static ArrayList<User> usersList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for(int i = 0; i < 20; i++){
            User newUser = new User();
            newUser.setName("Name" + new Random().nextInt());
            newUser.setDescription("Description " + new Random().nextInt());
            newUser.setId(i+1);
            newUser.setFollowed(new Random().nextBoolean());
            usersList.add(newUser);
        }

        RecyclerView rv = findViewById(R.id.recyclerView);
        UsersAdapter usersAdapter = new UsersAdapter(usersList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(usersAdapter);
    }
}