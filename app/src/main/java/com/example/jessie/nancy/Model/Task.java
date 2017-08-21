package com.example.jessie.nancy.Model;

import java.util.Date;

/**
 * Task
 *
 */


public class Task {
    private String task_name;
    private Date deadline;
    private double duration;
    private String note;

    //Constructor to create a task -- full constructor
    public Task(String task_name, Date deadline, String note) {
        this.task_name = task_name;
        this.deadline = deadline;
        this.note = note;
    }

    //Constructor to create task -- no note
    public Task(String task_name, Date deadline) {
        this.task_name = task_name;
        this.deadline = deadline;
    }

    //Constructor to creat task -- if no date is attributed
    public Task(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
