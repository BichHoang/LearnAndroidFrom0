package com.example.learnandroidfrom0.activity;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.learnandroidfrom0.R;
import com.example.learnandroidfrom0.adapter.PlanAdapter;
import com.example.learnandroidfrom0.model.Plan;

import java.util.ArrayList;

public class TabPlan extends Fragment {
    ListView listView;
    ArrayList<Plan> arrayList;
    PlanAdapter adapter;

    public TabPlan() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_plan, container, false);
        listView = view.findViewById(R.id.plan_listview);
        arrayList = new ArrayList<>();
        arrayList.add(new Plan("Ngam hoang hon", false));
        arrayList.add(new Plan("Ngam binh minh", false));
        arrayList.add(new Plan("Ngu nuong", true));
        adapter = new PlanAdapter(getActivity(), R.layout.plan_item, arrayList);
        listView.setAdapter(adapter);

        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}