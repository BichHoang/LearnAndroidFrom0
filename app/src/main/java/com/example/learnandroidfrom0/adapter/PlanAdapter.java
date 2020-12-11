package com.example.learnandroidfrom0.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.learnandroidfrom0.R;
import com.example.learnandroidfrom0.model.Plan;

import java.util.List;

/**
 * Created by Bich Hoang on 12/11/2020.
 */
public class PlanAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Plan> planList;

    public PlanAdapter(Context context, int laout, List<Plan> planList) {
        this.context = context;
        this.layout = layout;
        this.planList = planList;
    }

    @Override
    public int getCount() {
        return planList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        CheckBox plan_checkbox = convertView.findViewById(R.id.plan_checkbox);
        TextView plan_name = convertView.findViewById(R.id.plan_name);

        Plan plan = planList.get(position);

        plan_checkbox.setChecked(plan.isDone());
        plan_name.setText(plan.getPlanName());
        return convertView;
    }
}
