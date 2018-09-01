package com.example.yasinkhan.mealexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yasinkhan.mealexplorer.database.ExpenseDatabaseManager;
import com.example.yasinkhan.mealexplorer.database.MemberDatabaseManager;

import java.util.ArrayList;

public class ViewAllCalculation extends AppCompatActivity {
    private EditText totalDepositeEt, totalExpenseEt, totalMealEt, mealRateEt, cashInHandEt;
    private Button backBtn;
    MemberDatabaseManager memberDatabaseManager;
    ExpenseDatabaseManager expenseDatabaseManager;
    ArrayList<Double> allDeposite;
    ArrayList<Double> allExpenses;
    ArrayList<Double> allMeals;
    Double totalDeposite, totalExpense, totalMeal, rate, cashInHand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_calculation);

        totalDepositeEt = findViewById(R.id.totalDepositeEt);
        totalExpenseEt = findViewById(R.id.totalExpenseEt);
        totalMealEt = findViewById(R.id.totalMealEt);
        mealRateEt = findViewById(R.id.mealRateEt);
        cashInHandEt = findViewById(R.id.cashInHandEt);
        backBtn = findViewById(R.id.backBtn);

        memberDatabaseManager = new MemberDatabaseManager(this);
        expenseDatabaseManager = new ExpenseDatabaseManager(this);

        totalDeposite = 0.0;
        totalExpense =0.0;
        totalMeal = 0.0;
        rate = 0.0;
        cashInHand = 0.0;

        allDeposite = memberDatabaseManager.allDepositeReturn();
        for(Double item: allDeposite){
            totalDeposite = totalDeposite+item;
        }


        allExpenses = expenseDatabaseManager.allExpenseReturn();
        for(Double item: allExpenses){
            totalExpense = totalExpense+item;
        }

        allMeals = memberDatabaseManager.allMealReturn();
        for(Double item: allMeals){
            totalMeal = totalMeal+item;
        }

        rate = totalExpense/totalMeal;
        cashInHand = totalDeposite-totalExpense;

        totalDepositeEt.setText(String.valueOf(totalDeposite));
        totalExpenseEt.setText(String.valueOf(totalExpense));
        totalMealEt.setText(String.valueOf(totalMeal));
        mealRateEt.setText(String.valueOf(rate));
        cashInHandEt.setText(String.valueOf(cashInHand));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewAllCalculation.this, FunctionalActivity.class));
            }
        });

    }
}
