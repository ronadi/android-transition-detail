package com.ronadi.example.transitiondetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ronadi.example.transitiondetail.adapter.RecyclerItemClickListener;
import com.ronadi.example.transitiondetail.adapter.SportAdapter;
import com.ronadi.example.transitiondetail.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView.LayoutManager mLayoutManager;
    SportAdapter sa;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        sa = new SportAdapter(getData());
        rv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(sa);

        rv.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), rv ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                // do whatever
                String transitionName = getString(R.string.detailsport);
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRADATA, sa.getItemData(position));

                ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity) context, view, transitionName);
                startActivity(intent, options.toBundle());
            }

            @Override public void onLongItemClick(View view, int position) {
                // do whatever
            }
        }));

    }
    private List<Sport> getData(){
        List<Sport> sport = new ArrayList<>();
        String url = "http://lorempixel.com/400/200/sports/";
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        for (int i = 1; i < 11 ; i++) {
            Sport newSport = new Sport(i,"Sport-"+i,description, url+i+"/");
            sport.add(newSport);
        }
        return sport;
    }

}


