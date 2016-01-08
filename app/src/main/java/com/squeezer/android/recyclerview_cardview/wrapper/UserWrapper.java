package com.squeezer.android.recyclerview_cardview.wrapper;

import com.squeezer.android.recyclerview_cardview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adnen on 1/8/16.
 */
public class UserWrapper {

    String mName;
    String mAge;
    int mPhotoId;

    public UserWrapper() {}

    public UserWrapper(String name, String age, int photoId) {
        this.mName = name;
        this.mAge = age;
        this.mPhotoId = photoId;
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

    public ArrayList<UserWrapper> initializeData(){
        ArrayList<UserWrapper> users = new ArrayList<UserWrapper>();
        users.add(new UserWrapper("Emma Wilson", "23 years old", R.drawable.user_profile));
        users.add(new UserWrapper("Lavery Maiss", "25 years old", R.drawable.user_profile));
        users.add(new UserWrapper("Lillie Watts", "35 years old", R.drawable.user_profile));

        return users;
    }
}
