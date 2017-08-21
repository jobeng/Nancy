package com.example.jessie.nancy.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jessie on 2017-08-01.
 */

public class Project extends Task {
    ArrayList<Task> subTaskList =  new ArrayList<Task>();

    public Project(String task_name, Date deadline, String note) {
        super(task_name, deadline, note);
    }

    public Project(String task_name, Date deadline) {
        super(task_name, deadline);
    }

}
