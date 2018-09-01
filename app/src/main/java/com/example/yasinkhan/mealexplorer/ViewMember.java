package com.example.yasinkhan.mealexplorer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import com.example.yasinkhan.mealexplorer.database.MemberDatabaseManager;
import com.example.yasinkhan.mealexplorer.models.Member;

import java.util.ArrayList;

public class ViewMember extends AppCompatActivity {
    private ArrayList<Member> allMembers;
    private ListView listView;
    MemberDatabaseManager memberDatabaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member);

        listView = findViewById(R.id.listViewId);
        memberDatabaseManager = new MemberDatabaseManager(this);

        allMembers = memberDatabaseManager.getAllMembers();
        CusAd4ViewAllMember adapter = new CusAd4ViewAllMember(this, allMembers);
        listView.setAdapter(adapter);
    }
}
