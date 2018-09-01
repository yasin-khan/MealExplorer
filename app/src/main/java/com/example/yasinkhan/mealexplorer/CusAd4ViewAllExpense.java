package com.example.yasinkhan.mealexplorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yasinkhan.mealexplorer.models.Expense;

import java.util.ArrayList;

/**
 * Created by YasinKhan on 29-Aug-18.
 */

public class CusAd4ViewAllExpense extends BaseAdapter{
    private Context context;
    private ArrayList<Expense> allExpenses;
    private LayoutInflater infl;

    public CusAd4ViewAllExpense(Context context, ArrayList<Expense> allExpenses) {
        this.context = context;
        this.allExpenses = allExpenses;
    }

    @Override
    public int getCount() {
        return allExpenses.size();
    }

    @Override
    public Object getItem(int position) {
        return allExpenses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            infl = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infl.inflate(R.layout.sample_expense_view, parent,false);
        }

        //View v = View.inflate(context,R.layout.sample_member_view, null);

        TextView expDateTv = convertView.findViewById(R.id.expDateTv);
        TextView expNameTv = convertView.findViewById(R.id.expNameTv);
        TextView expAmountTv = convertView.findViewById(R.id.expAmountTv);

        if (allExpenses!=null) {
            expDateTv.setText(String.valueOf(allExpenses.get(position).getExpenseDate())+"");
            expNameTv.setText(allExpenses.get(position).getExpenseName());
            expAmountTv.setText(allExpenses.get(position).getExpenseAmount());
        }

        return convertView;
    }
}
