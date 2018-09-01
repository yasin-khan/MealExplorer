package com.example.yasinkhan.mealexplorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.yasinkhan.mealexplorer.database.ExpenseDatabaseManager;
import com.example.yasinkhan.mealexplorer.models.Expense;

import java.util.ArrayList;

public class ViewExpense extends AppCompatActivity {
    private ArrayList<Expense> allExpenses;
    private ListView listView;
    ExpenseDatabaseManager expenseDatabaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expense);

        listView = findViewById(R.id.expenseListViewId);
        expenseDatabaseManager = new ExpenseDatabaseManager(this);

        allExpenses = expenseDatabaseManager.getAllExpenses();
        CusAd4ViewAllExpense adapter = new CusAd4ViewAllExpense(this, allExpenses);
        listView.setAdapter((ListAdapter) adapter);
    }
}
