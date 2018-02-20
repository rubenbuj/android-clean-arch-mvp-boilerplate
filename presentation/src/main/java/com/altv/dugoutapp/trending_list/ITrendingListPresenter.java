package com.altv.dugoutapp.trending_list;

import com.altv.dugoutapp.mvp.IBasePresenter;
import com.altv.dugoutapp.mvp.IBaseView;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public interface ITrendingListPresenter<V extends IBaseView> extends IBasePresenter<V> {
    void itemClicked(int position);
    void initialiseData();
}
