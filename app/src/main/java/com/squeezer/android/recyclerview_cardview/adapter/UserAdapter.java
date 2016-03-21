package com.squeezer.android.recyclerview_cardview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squeezer.android.recyclerview_cardview.R;
import com.squeezer.android.recyclerview_cardview.utils.AppHelper;
import com.squeezer.android.recyclerview_cardview.viewholder.MultipleRowViewHolder;
import com.squeezer.android.recyclerview_cardview.wrapper.UserWrapper;

import java.util.ArrayList;

/**
 * Created by adnen on 1/8/16.
 */
public class UserAdapter extends
        RecyclerView.Adapter<MultipleRowViewHolder>{

    private ArrayList<UserWrapper> mObjectsList = new ArrayList<UserWrapper>();

    private LayoutInflater inflater = null;

    public UserAdapter(Context context, ArrayList<UserWrapper> itemsList) {

        inflater = LayoutInflater.from(context);
        mObjectsList = itemsList;
    }

    @Override
    public MultipleRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        view = inflater.inflate(R.layout.second_card_layout, parent, false);
        if (viewType == AppHelper.FIRST_ROW)
            view = inflater.inflate(R.layout.first_card_layout, parent, false);
        else if (viewType == AppHelper.OTHER_ROW)
            view = inflater.inflate(R.layout.second_card_layout, parent, false);

        return new MultipleRowViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(MultipleRowViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case AppHelper.FIRST_ROW:
                holder.firstRowText.setText(mObjectsList.get(position).getName());
                break;

            case AppHelper.OTHER_ROW:
                holder.mItemName.setText(mObjectsList.get(position).getName());
                holder.mItemAge.setText(mObjectsList.get(position).getAge());
                holder.mItemPhoto.setImageResource(mObjectsList.get(position)
                        .getPhotoId());
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {

        UserWrapper userWrapper = mObjectsList.get(position);

        if (userWrapper != null)
            return userWrapper.getType();

        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        return (mObjectsList != null && mObjectsList.size() > 0 ) ? mObjectsList.size() : 0;
    }

}
