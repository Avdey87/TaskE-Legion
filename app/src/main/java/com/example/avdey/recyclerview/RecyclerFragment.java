package com.example.avdey.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.avdey.recyclerview.mock.MockAdapter;
import com.example.avdey.recyclerview.mock.MockGenerator;

import java.util.Random;

public class RecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recycler;
    private final MockAdapter mockAdapter = new MockAdapter();
    private SwipeRefreshLayout swipeRefreshLayout;
    private View errorView;
    private Random random = new Random();

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_inflater, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recycler = view.findViewById(R.id.recycler);
        swipeRefreshLayout = view.findViewById(R.id.refresher);
        swipeRefreshLayout.setOnRefreshListener(this);
        errorView = view.findViewById(R.id.error_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(mockAdapter);

    }

    @Override
    public void onRefresh() {

        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                int count = random.nextInt(4) ;

                if (count == 0) {
                    showError();
                } else {
                    showData(count);
                }


                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        }, 2000);

    }

    
    private void showData( int count) {
        mockAdapter.addData(MockGenerator.generate(count), true);
        errorView.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);

    }

    private void showError() {
        errorView.setVisibility(View.VISIBLE);
        recycler.setVisibility(View.GONE);

    }
}

