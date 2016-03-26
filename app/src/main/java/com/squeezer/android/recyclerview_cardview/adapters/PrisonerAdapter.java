package com.squeezer.android.recyclerview_cardview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squeezer.android.recyclerview_cardview.R;
import com.squeezer.android.recyclerview_cardview.models.Prisoner;

import java.util.ArrayList;

/**
 * Created by adnen on 1/8/16.
 */
public class PrisonerAdapter extends
        RecyclerView.Adapter<PrisonerAdapter.ViewHolder>{

    private Context mContext;

    private OnItemClickListener mListener;

    private ArrayList<Prisoner> mObjectsList = new ArrayList<Prisoner>();

    public PrisonerAdapter(Context context, OnItemClickListener listener, ArrayList<Prisoner> itemsList) {

        this.mContext = context;
        this.mListener = listener;
        this.mObjectsList = itemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_prisoner, parent, false);

        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvName.setText(mObjectsList.get(position).getName());
        holder.mTvMatricule.setText(mObjectsList.get(position).getMatricule());
        holder.mTvDuration.setText(mObjectsList.get(position).getDuration());
        holder.mIvProsoner.setImageResource(mObjectsList.get(position)
                .getImageRes());
    }

    @Override
    public int getItemCount() {
        return mObjectsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTvName;
        TextView mTvMatricule;
        TextView mTvDuration;
        ImageView mIvProsoner;

        public ViewHolder(View view) {
            super(view);
            mTvName = (TextView) view.findViewById(R.id.tv_prisoner_name);
            mTvMatricule = (TextView) view.findViewById(R.id.tv_prisoner_matricule);
            mTvDuration = (TextView) view.findViewById(R.id.tv_prisoner_duration);
            mIvProsoner = (ImageView) view.findViewById(R.id.img_prisoner);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mListener.onItemClick(v, position);
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
}
