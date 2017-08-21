package com.example.jessie.nancy.Controller.PlannerController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.example.jessie.nancy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jessie on 2017-08-21.
 */

public class BrainDumpActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        //Calls activity to display list view
        listView = (ExpandableListView)findViewById(R.id.exp_task_list);
        initData();

        //Calls Adapter to control list
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    //Sample class of taska and subtasks
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        //Project Title list aka keys
        listDataHeader.add("Grad Studies");
        listDataHeader.add("Strength Traning");
        listDataHeader.add("Nancy Start-Up");

        //Creating sublist for each item
        List<String> gradStudies = new ArrayList<>();
        gradStudies.add("BNDF/Exercise Protocol");
        gradStudies.add("Code 7 pages of transcript");
        gradStudies.add("Begin Manuscript");

        List<String> sTraining = new ArrayList<>();
        sTraining.add("Join the Climbing Committee");
        sTraining.add("Eat pasta");

        List<String> startUp = new ArrayList<>();
        startUp.add("Send Shammy the notes");

        listHash.put(listDataHeader.get(0), gradStudies);
        listHash.put(listDataHeader.get(1), sTraining);
        listHash.put(listDataHeader.get(2), startUp);

    }
}
