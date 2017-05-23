package com.ronadi.example.transitiondetail;
/*
 * Created by ronadi on 5/23/17.
 */

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ronadi.example.transitiondetail.model.Sport;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRADATA ="SPORTDETAIL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Sport mSport = (Sport) getIntent().getSerializableExtra(EXTRADATA);
        SimpleDraweeView image = (SimpleDraweeView) findViewById(R.id.headerImage);
        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) findViewById(R.id.txtDescription);
        if(mSport != null){
            image.setImageURI(mSport.getUrl());
            txtTitle.setText(mSport.getTitle());
            txtDescription.setText(mSport.getDescription());
        }
        Slide slide = new Slide(Gravity.BOTTOM);
        slide.addTarget(R.id.contentDetail);
        slide.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator
            .linear_out_slow_in));
        slide.setDuration(300);
        getWindow().setEnterTransition(slide);

    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(DetailActivity.this);
    }

}
