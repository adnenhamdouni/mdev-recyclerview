package com.squeezer.android.recyclerview_cardview.wrapper;

import com.squeezer.android.recyclerview_cardview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adnen on 1/8/16.
 */
public class UserWrapper {

    private int mType;
    private String mName;
    private String mAge;
    private int mPhotoId;

    public UserWrapper() {}

    public UserWrapper(String name, String age, int photoId, int type) {
        this.mName = name;
        this.mAge = age;
        this.mPhotoId = photoId;
        this.mType = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getAge() {
        return mAge;
    }

    public void setAge(String age) {
        this.mAge = age;
    }

    public int getPhotoId() {
        return mPhotoId;
    }

    public void setPhotoId(int photoId) {
        this.mPhotoId = photoId;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

}
