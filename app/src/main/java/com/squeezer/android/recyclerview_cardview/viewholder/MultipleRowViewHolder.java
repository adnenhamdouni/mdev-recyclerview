package com.squeezer.android.recyclerview_cardview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squeezer.android.recyclerview_cardview.R;
import com.squeezer.android.recyclerview_cardview.utils.AppHelper;

/**
 * Created by adnenhamdouni on 21/03/2016.
 */
public class MultipleRowViewHolder extends RecyclerView.ViewHolder {

    public TextView firstRowText;


    public TextView mItemName;
    public TextView mItemAge;
    public ImageView mItemPhoto;

    private int type;

    public MultipleRowViewHolder(View itemView, int type) {
        super(itemView);

        if (type == AppHelper.FIRST_ROW){
            firstRowText = (TextView)itemView.findViewById(R.id.textview_first_row);
        }else if(type == AppHelper.OTHER_ROW) {
            mItemName = (TextView) itemView.findViewById(R.id.textview_user_name);
            mItemAge = (TextView) itemView.findViewById(R.id.textview_user_age);
            mItemPhoto = (ImageView) itemView.findViewById(R.id.imageview_user);
        }
    }
}
