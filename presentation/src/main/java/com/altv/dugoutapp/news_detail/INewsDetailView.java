package com.altv.dugoutapp.news_detail;

import com.altv.dugout_domain.model.News;
import com.altv.dugoutapp.mvp.IBaseView;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public interface INewsDetailView extends IBaseView {
    void setFields(News news);
}
