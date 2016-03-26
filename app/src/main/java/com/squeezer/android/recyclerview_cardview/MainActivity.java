package com.squeezer.android.recyclerview_cardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.squeezer.android.recyclerview_cardview.adapters.PrisonerAdapter;
import com.squeezer.android.recyclerview_cardview.models.Prisoner;
import com.squeezer.android.recyclerview_cardview.utils.PrisonerContent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PrisonerAdapter.OnItemClickListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter<PrisonerAdapter.ViewHolder> mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Prisoner>mPrisonerList;
    private Prisoner mPrisonerWrapper;

    FloatingActionButton fab;

    public static String TAG = "MainActivity";

    public static final String PRISONER_OBJECT_KEY = "prisoners";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initFab();
        initRecyclerView();


    }


    private void initFab() {

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initRecyclerView() {

        mPrisonerWrapper = new Prisoner();
        mPrisonerList = PrisonerContent.getPrisoners();




        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_card_list);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PrisonerAdapter(this, this, mPrisonerList);
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e(TAG, "Item Clicked = "+ position);
        Intent intent = new Intent(MainActivity.this, PrisonerDetailActivity.class);
        intent.putExtra(PRISONER_OBJECT_KEY, PrisonerContent.getPrisoners().get(position));
        startActivity(intent);
    }
}
