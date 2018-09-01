package com.example.yasinkhan.mealexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yasinkhan.mealexplorer.database.ExpenseDatabaseManager;
import com.example.yasinkhan.mealexplorer.models.Expense;

public class AddExpense extends AppCompatActivity {
    private EditText expenseDateEt;
    private EditText expenseNameEt;
    private EditText expenseAmountEt;
    private Button addExpenseBtn, backBtn, viewBtn;
    ExpenseDatabaseManager expenseDatabaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        expenseDateEt = findViewById(R.id.expenseDateEt);
        expenseNameEt = findViewById(R.id.expenseNameEt);
        expenseAmountEt = findViewById(R.id.expenseAmountEt);
        addExpenseBtn = findViewById(R.id.addExpenseBtn);
        backBtn = findViewById(R.id.backBtn);
        viewBtn = findViewById(R.id.viewBtn);

        addExpenseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expense expense = new Expense(Integer.parseInt(expenseDateEt.getText().toString()),
                        expenseNameEt.getText().toString(), expenseAmountEt.getText().toString());
                expenseDatabaseManager = new ExpenseDatabaseManager(AddExpense.this);
                long insertedRow = expenseDatabaseManager.addExpense(expense);
                if(insertedRow>0){
                    Toast.makeText(AddExpense.this, ""+insertedRow, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AddExpense.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddExpense.this, FunctionalActivity.class));
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddExpense.this, ViewMember.class));
            }
        });

    }
}
