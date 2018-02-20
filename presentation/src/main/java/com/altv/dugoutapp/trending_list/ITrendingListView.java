package com.altv.dugoutapp.trending_list;

import com.altv.dugout_domain.model.News;
import com.altv.dugoutapp.model.PlaylistContainer;
import com.altv.dugoutapp.mvp.IBaseView;

import java.util.List;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public interface ITrendingListView extends IBaseView {
    void setListData(List<News> data);
}
