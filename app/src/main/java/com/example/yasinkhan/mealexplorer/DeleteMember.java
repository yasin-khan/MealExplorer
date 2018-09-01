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

public class DeleteMember extends AppCompatActivity {
    private EditText memberIdEt,memberNameEt, memberDepositeEt,memberMealEt;
    private Button findBtn, deleteBtn, backBtn, viewBtn;
    MemberDatabaseManager memberDatabaseManager;
    Member member;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_member);

        memberIdEt = findViewById(R.id.memberIdEt);
        memberNameEt = findViewById(R.id.memberNameEt);
        memberDepositeEt = findViewById(R.id.memberDepositeEt);
        memberMealEt = findViewById(R.id.memberMealEt);
        findBtn = findViewById(R.id.findBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
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

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member(id, memberNameEt.getText().toString(), memberDepositeEt.getText().toString(),memberMealEt.getText().toString());
                memberDatabaseManager = new MemberDatabaseManager(DeleteMember.this);
                long deletedRow = memberDatabaseManager.deleteMember(id);
                if(deletedRow>0){
                    Toast.makeText(DeleteMember.this, ""+deletedRow, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DeleteMember.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteMember.this, FunctionalActivity.class));
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteMember.this, ViewMember.class));
            }
        });
    }
}
