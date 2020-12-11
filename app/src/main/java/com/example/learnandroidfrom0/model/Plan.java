package com.example.learnandroidfrom0.model;

/**
 * Created by Bich Hoang on 12/11/2020.
 */
public class Plan {
    private String planName;
    private boolean isDone;

    public Plan(String planName, boolean isDone) {
        this.planName = planName;
        this.isDone = isDone;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
