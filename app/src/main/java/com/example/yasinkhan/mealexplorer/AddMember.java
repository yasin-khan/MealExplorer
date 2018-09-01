package com.example.yasinkhan.mealexplorer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

import com.example.yasinkhan.mealexplorer.R;
import com.example.yasinkhan.mealexplorer.database.MemberDatabaseManager;
import com.example.yasinkhan.mealexplorer.models.Member;

public class AddMember extends AppCompatActivity {
    private EditText memberNameEt;
    private EditText memberDepositeEt;
    private EditText memberMealEt;
    private Button addMemberBtn, backBtn, viewBtn;
    MemberDatabaseManager memberDatabaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        memberNameEt = findViewById(R.id.memberNameEt);
        memberMealEt = findViewById(R.id.memberMealEt);
        memberDepositeEt = findViewById(R.id.memberDepositeEt);
        addMemberBtn = findViewById(R.id.addMemberBtn);
        backBtn = findViewById(R.id.backBtn);
        viewBtn = findViewById(R.id.viewBtn);

        addMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member(memberNameEt.getText().toString(), memberDepositeEt.getText().toString(), memberMealEt.getText().toString());
                memberDatabaseManager = new MemberDatabaseManager(AddMember.this);
                long insertedRow = memberDatabaseManager.addMember(member);
                if(insertedRow>0){
                    Toast.makeText(AddMember.this, ""+insertedRow, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AddMember.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddMember.this, FunctionalActivity.class));
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddMember.this, ViewMember.class));
            }
        });
    }

}
