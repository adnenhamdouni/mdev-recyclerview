package com.squeezer.android.recyclerview_cardview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squeezer.android.recyclerview_cardview.R;
import com.squeezer.android.recyclerview_cardview.wrapper.UserWrapper;

import java.util.ArrayList;

/**
 * Created by adnen on 1/8/16.
 */
public class UserAdapter extends
        RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private ArrayList<UserWrapper> mObjectsList = new ArrayList<UserWrapper>();

    public UserAdapter(ArrayList<UserWrapper> itemsList) {

        mObjectsList = itemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_layout, parent, false);

        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mItemName.setText(mObjectsList.get(position).getName());
        holder.mItemAge.setText(mObjectsList.get(position).getAge());
        holder.mItemPhoto.setImageResource(mObjectsList.get(position)
                .getPhotoId());
    }

    @Override
    public int getItemCount() {
        return mObjectsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mItemName;
        public TextView mItemAge;
        public ImageView mItemPhoto;

        public ViewHolder(View view) {
            super(view);
            mItemName = (TextView) view.findViewById(R.id.textview_user_name);
            mItemAge = (TextView) view.findViewById(R.id.textview_user_age);
            mItemPhoto = (ImageView) view.findViewById(R.id.imageview_user);

        }
    }
}
