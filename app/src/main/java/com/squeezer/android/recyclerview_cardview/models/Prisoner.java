package com.squeezer.android.recyclerview_cardview.models;

import java.io.Serializable;

/**
 * Created by adnenhamdouni on 26/03/2016.
 */
public class Prisoner implements Serializable{

    private String mName;
    private String mMatricule;
    private String mDuration;
    private int mImageRes;

    public Prisoner(String name, String matricule, String duration, int imageRes) {
        this.mName = name;
        this.mMatricule = matricule;
        this.mDuration = duration;
        this.mImageRes = imageRes;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getMatricule() {
        return mMatricule;
    }

    public void setMatricule(String matricule) {
        this.mMatricule = matricule;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        this.mDuration = duration;
    }

    public int getImageRes() {
        return mImageRes;
    }

    public void setImageRes(int imageRes) {
        this.mImageRes = imageRes;
    }

    @Override
    public String toString() {
        return "Prisoner{" +
                "mName='" + mName + '\'' +
                ", mMatricule='" + mMatricule + '\'' +
                ", mDuration='" + mDuration + '\'' +
                ", mImageRes=" + mImageRes +
                '}';
    }
}
