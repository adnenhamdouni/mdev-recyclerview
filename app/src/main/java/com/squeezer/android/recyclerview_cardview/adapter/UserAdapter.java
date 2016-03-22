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
import com.squeezer.android.recyclerview_cardview.wrapper.UserWrapper;

import java.util.ArrayList;

/**
 * Created by adnen on 1/8/16.
 */
public class UserAdapter extends
        RecyclerView.Adapter<UserAdapter.MainViewHolder>{

    private ArrayList<UserWrapper> mObjectsList = new ArrayList<UserWrapper>();


    public UserAdapter(Context context, ArrayList<UserWrapper> itemsList) {

        mObjectsList = itemsList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater = LayoutInflater.from ( parent.getContext());
        switch ( viewType ) {

            case AppHelper.FIRST_ROW:
                ViewGroup firstGroup = (ViewGroup) mInflater.inflate ( R.layout.first_card_layout, parent, false );
                FirstViewHolder firstHolder = new FirstViewHolder(firstGroup);
                return firstHolder;
            case AppHelper.SECOND_ROW:
                ViewGroup secondGroup = ( ViewGroup ) mInflater.inflate ( R.layout.second_card_layout, parent, false );
                SecondViewHolder SecondHolder = new SecondViewHolder (secondGroup);
                return SecondHolder;
            default:
                ViewGroup secondGroup0 = ( ViewGroup ) mInflater.inflate ( R.layout.second_card_layout, parent, false );
                SecondViewHolder SecondHolder0 = new SecondViewHolder (secondGroup0);
                return SecondHolder0;
        }
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

        switch ( holder.getItemViewType () ) {

            case AppHelper.FIRST_ROW:

                FirstViewHolder firstViewHolder = (FirstViewHolder) holder;
                firstViewHolder.firstRowText.setText(mObjectsList.get(position).getName());
                break;

            case AppHelper.SECOND_ROW:

                SecondViewHolder SecondViewHolder = (SecondViewHolder) holder;
                SecondViewHolder.mItemName.setText(mObjectsList.get(position).getName());
                SecondViewHolder.mItemAge.setText(mObjectsList.get(position).getAge());
                SecondViewHolder.mItemPhoto.setImageResource(mObjectsList.get(position).getPhotoId());
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


    public class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder ( View itemView ) {

            super ( itemView );

        }
    }

    public class FirstViewHolder extends MainViewHolder {

        TextView firstRowText;

        public FirstViewHolder ( View view ) {

            super(view);
            firstRowText = (TextView) view.findViewById(R.id.textview_first_row);

        }

    }

    public class SecondViewHolder extends MainViewHolder {

        public TextView mItemName;
        public TextView mItemAge;
        public ImageView mItemPhoto;

        public SecondViewHolder(View view) {

            super(view);
            mItemName = (TextView) view.findViewById(R.id.textview_user_name);
            mItemAge = (TextView) view.findViewById(R.id.textview_user_age);
            mItemPhoto = (ImageView) view.findViewById(R.id.imageview_user);

        }

    }
}
