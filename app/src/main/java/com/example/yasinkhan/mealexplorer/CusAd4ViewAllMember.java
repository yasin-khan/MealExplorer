package com.example.yasinkhan.mealexplorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yasinkhan.mealexplorer.models.Member;

import java.util.ArrayList;

import static com.example.yasinkhan.mealexplorer.R.layout.sample_member_view;

/**
 * Created by YasinKhan on 28-Aug-18.
 */

public class CusAd4ViewAllMember extends BaseAdapter{
    private Context context;
    private ArrayList<Member> allMembers;
    private LayoutInflater inf;

    public CusAd4ViewAllMember(Context context, ArrayList<Member> allMembers) {
        this.context = context;
        this.allMembers = allMembers;
    }

    @Override
    public int getCount() {
        if(allMembers!=null){
            return allMembers.size();
        }else{
            return 0;
        }

    }

    @Override
    public Object getItem(int position) {
        return allMembers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.sample_member_view, parent,false);
        }

        //View v = View.inflate(context,R.layout.sample_member_view, null);

        TextView memIdTv = convertView.findViewById(R.id.memberIdTv);
        TextView memNameTv = convertView.findViewById(R.id.memberNameTv);
        TextView memDepositeTv = convertView.findViewById(R.id.memberDepositeTv);
        TextView memMealTv = convertView.findViewById(R.id.memberMealTv);

        if (allMembers!=null) {
            memIdTv.setText(String.valueOf(allMembers.get(position).getMemberId()) + "");
            memNameTv.setText(allMembers.get(position).getMemberName());
            memDepositeTv.setText(allMembers.get(position).getMemberDeposite());
            memMealTv.setText(allMembers.get(position).getMemberMeal());
        }

        return convertView;
    }
}
