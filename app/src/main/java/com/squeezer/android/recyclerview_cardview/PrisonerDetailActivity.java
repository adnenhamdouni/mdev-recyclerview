package com.squeezer.android.recyclerview_cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squeezer.android.recyclerview_cardview.models.Prisoner;

public class PrisonerDetailActivity extends AppCompatActivity {

    private ImageView mIvPrisoner;
    private TextView mTvName, mTvMatricule, mTvDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prisoner_detail);

        mTvName = (TextView) findViewById(R.id.tv_prisoner_detail_name);
        mTvMatricule = (TextView) findViewById(R.id.tv_prisoner_detail_matricule);
        mTvDuration = (TextView) findViewById(R.id.tv_prisoner_detail_duration);
        mIvPrisoner = (ImageView) findViewById(R.id.img_prisoner_big);


        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            Prisoner prisoner = (Prisoner) bundle.getSerializable(MainActivity.PRISONER_OBJECT_KEY);
            mTvName.setText(prisoner.getName());
            mTvMatricule.setText(prisoner.getMatricule());
            mTvDuration.setText(prisoner.getDuration());
            mIvPrisoner.setBackgroundResource(prisoner.getImageRes());

        }

    }
}
