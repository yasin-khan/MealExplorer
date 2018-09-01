package com.example.yasinkhan.mealexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class FunctionalActivity extends AppCompatActivity {
    private Button addMemberBtn, updateMemberBtn, deleteMemberBtn, viewMemberBtn, addExpenseBtn;
    private Button updateExpenseBtn, viewExpenseBtn, calcIndivBtn, viewAllCalculationBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functional);
        addMemberBtn = findViewById(R.id.addMemberBtn);
        updateMemberBtn = findViewById(R.id.updateMemberBtn);
        deleteMemberBtn = findViewById(R.id.deleteMemberBtn);
        viewMemberBtn = findViewById(R.id.viewMemberBtn);
        addExpenseBtn = findViewById(R.id.addExpenseBtn);
        updateExpenseBtn = findViewById(R.id.updateExpenseBtn);
        viewExpenseBtn = findViewById(R.id.viewExpenseBtn);
        calcIndivBtn = findViewById(R.id.calcIndivBtn);
        viewAllCalculationBtn = findViewById(R.id.viewAllCalculationBtn);


        addMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, AddMember.class));
            }
        });

        viewMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, ViewMember.class));
            }
        });

        updateMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, UpdateMember.class));
            }
        });

        deleteMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, DeleteMember.class));
            }
        });

        addExpenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, AddExpense.class));
            }
        });

        updateExpenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, UpdateExpense.class));
            }
        });

        viewExpenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, ViewExpense.class));
            }
        });

        calcIndivBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, CalculateIndividual.class));
            }
        });

        viewAllCalculationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FunctionalActivity.this, ViewAllCalculation.class));
            }
        });
    }
}
