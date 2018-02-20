package com.altv.dugoutapp.trending_list;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.altv.dugout_domain.model.News;
import com.altv.dugoutapp.R;
import com.altv.dugoutapp.mvp.BaseView;
import com.altv.dugoutapp.state_machines.StateMachine;
import com.altv.dugoutapp.trending_list.adapters.TrendingListAdapter;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rubenbujalance on 26/01/2018.
 */

public class TrendingListView extends BaseView<ITrendingListView, ITrendingListPresenter<ITrendingListView>, ViewState<ITrendingListView>> implements ITrendingListView, TrendingListAdapter.TrendingListListener {

    @BindView(R.id.trending_list)
    public RecyclerView recyclerView;

    public TrendingListAdapter adapter;

    /*
    Constructors
     */

    public TrendingListView() {
        super();
    }

    public TrendingListView(StateMachine stateMachineHandler, Bundle args) {
        super(stateMachineHandler, args);
    }

    /*
    Methods from BaseView
     */

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater,
                                @NonNull ViewGroup container) {
        RecyclerView view = (RecyclerView)
                inflater.inflate(R.layout.layout_trending_list, container, false);

        ButterKnife.bind(this, view);
        view.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        getPresenter().initialiseData();
    }

    /*
    View methods
     */

    @Override
    public void onItemClicked(int position) {
        getPresenter().itemClicked(position);
    }

    @Override
    public void setListData(List<News> data) {
        adapter = new TrendingListAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }
}
