package com.example.jessie.nancy.Controller.PlannerController;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.jessie.nancy.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/** Summary of Class:
 *  Adapter that controls the function of the adapter view
 *
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    //Returns number of items in the list
    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    //Retruns the number of items in the sub list
    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).size();
    }

    //Returns the list item
    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    //Returns sublist item
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /*
    * This method controls the display of the expandable list cie adapter
    * Displays group headers in the fasion we want displayed
    * */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //sets the header title
        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            //Sets view to return the layout of the header for the expandable list
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Calls task list group XML file
            convertView = inflater.inflate(R.layout.task_list_group, null);
        }

        //Sets layout for the header to be the task list header XML file
        TextView taskListHeader = (TextView)convertView.findViewById(R.id.task_list_header);
        taskListHeader.setTypeface(null, Typeface.BOLD);

        //Sets text
        taskListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //Sets the list item
        final String childText = (String)getChild(groupPosition,childPosition);
        if (convertView == null) {
            //Sets view to return the layout of the header for the expandable list
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Calls task list group XML file
            convertView = inflater.inflate(R.layout.task_list_item, null);
        }

        TextView taskSubList = (TextView)convertView.findViewById(R.id.task_list_item);
        taskSubList.setText(childText);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
