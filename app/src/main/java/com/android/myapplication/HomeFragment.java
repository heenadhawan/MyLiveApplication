package com.android.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    private ViewPager mPager;
    View view;
    CircleIndicator indicator;
    Context context;
    private Recyler_caterory_Adapter horizontalAdapter;
    private ArrayList<Arraylist> horizontalList;
    private RecyclerView horizontal_recycler_view;
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.elec, R.drawable.medical
            , R.drawable.doc, R.drawable.download};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.category_activity, null);
        context = this.getActivity();
        context = this.getActivity();
        init();

        return view;

    }

    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(getActivity(), XMENArray));
        indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);


        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.nameArray[i],
                    MyData.drawableArray[i]
            ));
            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview);
            horizontalAdapter = new Recyler_caterory_Adapter(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(horizontalAdapter);
        }
    }
}

