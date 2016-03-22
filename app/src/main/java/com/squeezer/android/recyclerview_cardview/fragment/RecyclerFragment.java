package com.squeezer.android.recyclerview_cardview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.squeezer.android.recyclerview_cardview.R;
import com.squeezer.android.recyclerview_cardview.adapter.RecyclerListAdapter;
import com.squeezer.android.recyclerview_cardview.helper.AppHelper;
import com.squeezer.android.recyclerview_cardview.utils.RecyclerViewPositionHelper;
import com.squeezer.android.recyclerview_cardview.wrapper.UserWrapper;

import java.util.ArrayList;

/**
 * Created by adnenhamdouni on 21/03/2016.
 */
public class RecyclerFragment extends Fragment {

    private int overallXScroll = 0;

    private String TAG = "RecyclerFragmentTag";

    private Context mContext;

    int firstVisibleItem, lastVisibleItem, visibleItemCount, totalItemCount;
    //RecyclerViewPositionHelper mRecyclerViewHelper;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter<RecyclerListAdapter.MainViewHolder> mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<UserWrapper> mUserList;
    private UserWrapper mUserWrapper;


    Button mButtonCountTop, mButtonCountBottom;

    public static RecyclerFragment newInstance() {
        RecyclerFragment fragment = new RecyclerFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity().getApplicationContext();


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_recycler,
                container, false);

        initView(view);

        initRecyclerView();


        mRecyclerView.computeVerticalScrollOffset();


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                //mRecyclerViewHelper = RecyclerViewPositionHelper.createHelper(recyclerView);

                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = getItemCount();
                firstVisibleItem = findFirstVisibleItemPosition();
                lastVisibleItem = findLastVisibleItemPosition();



                if (firstVisibleItem == 0){
                    mButtonCountTop.setVisibility(View.INVISIBLE);
                    mButtonCountBottom.setVisibility(View.VISIBLE);

                } else if (lastVisibleItem == mUserList.size()-1){
                    mButtonCountTop.setVisibility(View.VISIBLE);
                    mButtonCountBottom.setVisibility(View.INVISIBLE);
                } else {
                    mButtonCountTop.setVisibility(View.VISIBLE);
                    mButtonCountBottom.setVisibility(View.VISIBLE);
                }


                mButtonCountTop.setText(Integer.toString(firstVisibleItem));
                mButtonCountBottom.setText(Integer.toString(mUserList.size()-1 - lastVisibleItem));


                int sizeList = mUserList.size()-1;

                LogV(TAG, sizeList, visibleItemCount, totalItemCount, firstVisibleItem, lastVisibleItem);



            }
        });

        return view;

    }


    private void initView(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_list);


        mButtonCountTop = (Button) view.findViewById(R.id.button_count_top);
        mButtonCountBottom = (Button) view.findViewById(R.id.button_count_bottom);
    }

    private void initRecyclerView() {

        mUserWrapper = new UserWrapper();
        mUserList = fillAdapter();

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerListAdapter(mContext, mUserList, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<UserWrapper> fillAdapter() {

        int type;
        ArrayList<UserWrapper> users = new ArrayList<UserWrapper>();

        String content;

        for (int i = 0; i < 15; i++) {

            if (i == 0 || i == 5 || i == 10) {
                type = AppHelper.FIRST_ROW;
                content = "Multiple row layout";
            } else {
                type = AppHelper.SECOND_ROW;
                content = "User "+i;
            }

            users.add(new UserWrapper(content, "23 years old", R.drawable.user_profile, type));
        }

        return users;
    }


    private void LogV(String adnen, int sizeList, int visibleItemCount, int totalItemCount, int firstVisibleItem, int lastVisibleItem) {
        Log.i("adnen", "size list ->" + sizeList);
        Log.i("adnen", "*************************************");
        Log.i("adnen", "visibleItemCount ->" + visibleItemCount);
        Log.i("adnen", "totalItemCount ->" + totalItemCount);
        Log.i("adnen", "firstVisibleItem ->" + firstVisibleItem);
        Log.i("adnen", "lastVisibleItem ->" + lastVisibleItem);
    }

    /*************************
     *
     */

    public int getItemCount() {
        return mLayoutManager == null ? 0 : mLayoutManager.getItemCount();
    }


    public int findFirstVisibleItemPosition() {
        final View child = findOneVisibleChild(0, mLayoutManager.getChildCount(), false, true);
        return child == null ? RecyclerView.NO_POSITION : mRecyclerView.getChildAdapterPosition(child);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        final View child = findOneVisibleChild(0, mLayoutManager.getChildCount(), true, false);
        return child == null ? RecyclerView.NO_POSITION : mRecyclerView.getChildAdapterPosition(child);
    }


    public int findLastVisibleItemPosition() {
        final View child = findOneVisibleChild(mLayoutManager.getChildCount() - 1, -1, false, true);
        return child == null ? RecyclerView.NO_POSITION : mRecyclerView.getChildAdapterPosition(child);
    }

    public int findLastCompletelyVisibleItemPosition() {
        final View child = findOneVisibleChild(mLayoutManager.getChildCount() - 1, -1, true, false);
        return child == null ? RecyclerView.NO_POSITION : mRecyclerView.getChildAdapterPosition(child);
    }

    View findOneVisibleChild(int fromIndex, int toIndex, boolean completelyVisible,
                             boolean acceptPartiallyVisible) {
        OrientationHelper helper;
        if (mLayoutManager.canScrollVertically()) {
            helper = OrientationHelper.createVerticalHelper(mLayoutManager);
        } else {
            helper = OrientationHelper.createHorizontalHelper(mLayoutManager);
        }

        final int start = helper.getStartAfterPadding();
        final int end = helper.getEndAfterPadding();
        final int next = toIndex > fromIndex ? 1 : -1;
        View partiallyVisible = null;
        for (int i = fromIndex; i != toIndex; i += next) {
            final View child = mLayoutManager.getChildAt(i);
            final int childStart = helper.getDecoratedStart(child);
            final int childEnd = helper.getDecoratedEnd(child);
            if (childStart < end && childEnd > start) {
                if (completelyVisible) {
                    if (childStart >= start && childEnd <= end) {
                        return child;
                    } else if (acceptPartiallyVisible && partiallyVisible == null) {
                        partiallyVisible = child;
                    }
                } else {
                    return child;
                }
            }
        }
        return partiallyVisible;
    }
}
