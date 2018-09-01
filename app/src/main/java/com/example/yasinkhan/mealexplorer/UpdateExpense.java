package com.example.yasinkhan.mealexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yasinkhan.mealexplorer.database.ExpenseDatabaseManager;
import com.example.yasinkhan.mealexplorer.database.MemberDatabaseManager;
import com.example.yasinkhan.mealexplorer.models.Expense;

public class UpdateExpense extends AppCompatActivity {
    private EditText expDateEt,expNameEt, expAmountEt;
    private Button findBtn, updateBtn, backBtn, viewBtn;
    ExpenseDatabaseManager expenseDatabaseManager;
    Expense expense;
    int date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_expense);

        expDateEt = findViewById(R.id.expDateEt);
        expNameEt = findViewById(R.id.expNameEt);
        expAmountEt = findViewById(R.id.expAmountEt);
        findBtn = findViewById(R.id.findBtn);
        updateBtn = findViewById(R.id.updateBtn);
        backBtn = findViewById(R.id.backBtn);
        viewBtn = findViewById(R.id.viewBtn);

        expenseDatabaseManager = new ExpenseDatabaseManager(this);

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = Integer.parseInt(expDateEt.getText().toString());
                expense = expenseDatabaseManager.getSingleExpense(date);
                expNameEt.setText(expense.getExpenseName());
                expAmountEt.setText(expense.getExpenseAmount());
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expense expense = new Expense(date, expNameEt.getText().toString(), expAmountEt.getText().toString());
                expenseDatabaseManager = new ExpenseDatabaseManager(UpdateExpense.this);
                long updatedRow = expenseDatabaseManager.updateExpense(expense);
                if(updatedRow>0){
                    Toast.makeText(UpdateExpense.this, ""+updatedRow, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(UpdateExpense.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateExpense.this, FunctionalActivity.class));
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateExpense.this, ViewMember.class));
            }
        });

    }
}
