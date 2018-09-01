package com.example.yasinkhan.mealexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yasinkhan.mealexplorer.database.MemberDatabaseManager;
import com.example.yasinkhan.mealexplorer.models.Member;

public class UpdateMember extends AppCompatActivity {
    private EditText memberIdEt,memberNameEt, memberDepositeEt, memberMealEt;
    private Button findBtn, updateBtn, backBtn, viewBtn;
    MemberDatabaseManager memberDatabaseManager;
    Member member;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_member);

        memberIdEt = findViewById(R.id.memberIdEt);
        memberNameEt = findViewById(R.id.memberNameEt);
        memberDepositeEt = findViewById(R.id.memberDepositeEt);
        memberMealEt = findViewById(R.id.memberMealEt);
        findBtn = findViewById(R.id.findBtn);
        updateBtn = findViewById(R.id.updateBtn);
        backBtn = findViewById(R.id.backBtn);
        viewBtn = findViewById(R.id.viewBtn);

        memberDatabaseManager = new MemberDatabaseManager(this);

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = Integer.parseInt(memberIdEt.getText().toString());
                member = memberDatabaseManager.getSingleMember(id);
                memberNameEt.setText(member.getMemberName());
                memberDepositeEt.setText(member.getMemberDeposite());
                memberMealEt.setText(member.getMemberMeal());
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member(id, memberNameEt.getText().toString(), memberDepositeEt.getText().toString(),memberMealEt.getText().toString());
                memberDatabaseManager = new MemberDatabaseManager(UpdateMember.this);
                long updatedRow = memberDatabaseManager.updateMember(member);
                if(updatedRow>0){
                    Toast.makeText(UpdateMember.this, ""+updatedRow, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(UpdateMember.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateMember.this, FunctionalActivity.class));
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateMember.this, ViewMember.class));
            }
        });

    }
}
