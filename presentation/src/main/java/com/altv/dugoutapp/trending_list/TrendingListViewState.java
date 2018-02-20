package com.altv.dugoutapp.trending_list;

import com.altv.dugout_domain.model.News;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

import java.util.List;

/**
 * Created by rubenbujalance on 08/02/2018.
 */

public class TrendingListViewState implements ViewState<ITrendingListView> {

    int scrollPosition = 0;
    State currentState = State.INIT;
    List<News> data;

    public enum State {
        INIT,
        SHOWING_LIST,
        ERROR
    }

    public void setScrollPosition(int position) {
        this.scrollPosition = position;
    }

    public void setData(List<News> data) {
        this.data = data;
        this.currentState = State.SHOWING_LIST;
    }

    @Override
    public void apply(ITrendingListView view, boolean retained) {
        switch (currentState) {
            case SHOWING_LIST:
                view.setListData(data);
                break;
        }
    }
}
