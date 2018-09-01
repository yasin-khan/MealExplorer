package com.example.yasinkhan.mealexplorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yasinkhan.mealexplorer.database.ExpenseDatabaseManager;
import com.example.yasinkhan.mealexplorer.database.MemberDatabaseManager;
import com.example.yasinkhan.mealexplorer.models.Member;

import java.util.ArrayList;

public class CalculateIndividual extends AppCompatActivity {
    private EditText memberIdEt,memberNameEt, memberDepositeEt, memberMealEt, mealRateEt, consumedEt, returnEt;
    private Button findBtn, calculateBtn;
    MemberDatabaseManager memberDatabaseManager;
    ExpenseDatabaseManager expenseDatabaseManager;
    Member member;
    private int id;
    ArrayList<Double> allExpenses;
    ArrayList<Double> allMeals;
    Double deposite, meal, rate, totalmeal, totalexpense, consumed, returnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_individual);

        memberIdEt = findViewById(R.id.memberIdEt);
        memberNameEt = findViewById(R.id.memberNameEt);
        memberDepositeEt = findViewById(R.id.memberDepositeEt);
        memberMealEt = findViewById(R.id.memberMealEt);
        mealRateEt = findViewById(R.id.mealRateEt);
        consumedEt = findViewById(R.id.consumedEt);
        returnEt = findViewById(R.id.returnEt);
        findBtn = findViewById(R.id.findBtn);
        calculateBtn = findViewById(R.id.calculateBtn);

        memberDatabaseManager = new MemberDatabaseManager(this);
        expenseDatabaseManager = new ExpenseDatabaseManager(this);

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = Integer.parseInt(memberIdEt.getText().toString());
                member = memberDatabaseManager.getSingleMember(id);
                memberNameEt.setText(member.getMemberName());
                memberDepositeEt.setText(member.getMemberDeposite());
                memberMealEt.setText(member.getMemberMeal());
                consumedEt.setText("");
                returnEt.setText("");
                deposite = Double.parseDouble(member.getMemberDeposite());
                meal = Double.parseDouble(member.getMemberMeal());
            }
        });

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalexpense =0.0;
                totalmeal = 0.0;
                rate = 0.0;
                consumed = 0.0;
                returnn = 0.0;

                allExpenses = expenseDatabaseManager.allExpenseReturn();
                for(Double item: allExpenses){
                    totalexpense = totalexpense+item;
                }

                allMeals = memberDatabaseManager.allMealReturn();
                for(Double item: allMeals){
                    totalmeal = totalmeal+item;
                }

                rate = totalexpense/totalmeal;
                consumed = meal*rate;
                returnn = deposite - consumed;

                mealRateEt.setText(String.valueOf(rate));
                consumedEt.setText(String.valueOf(consumed));
                returnEt.setText(String.valueOf(returnn));
            }
        });
    }
}
