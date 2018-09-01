package com.example.yasinkhan.mealexplorer.models;

/**
 * Created by YasinKhan on 29-Aug-18.
 */

public class Expense {
    private int ExpenseDate;
    private String ExpenseName;
    private String ExpenseAmount;

    public Expense(int expenseDate, String expenseName, String expenseAmount) {
        ExpenseDate = expenseDate;
        ExpenseName = expenseName;
        ExpenseAmount = expenseAmount;
    }

    public Expense(String expenseName, String expenseAmount) {
        ExpenseName = expenseName;
        ExpenseAmount = expenseAmount;
    }

    public Expense(String expenseAmount) {
        ExpenseAmount = expenseAmount;
    }

    public Expense() {

    }

    public int getExpenseDate() {
        return ExpenseDate;
    }

    public void setExpenseDate(int expenseDate) {
        ExpenseDate = expenseDate;
    }

    public String getExpenseName() {
        return ExpenseName;
    }

    public void setExpenseName(String expenseName) {
        ExpenseName = expenseName;
    }

    public String getExpenseAmount() {
        return ExpenseAmount;
    }

    public void setExpenseAmount(String expenseAmount) {
        ExpenseAmount = expenseAmount;
    }
}
