package com.altv.dugoutapp.news_detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.altv.dugout_domain.model.News;
import com.altv.dugoutapp.R;
import com.altv.dugoutapp.mvp.BaseView;
import com.altv.dugoutapp.state_machines.StateMachine;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rubenbujalance on 30/01/2018.
 */

public class NewsDetailView extends BaseView<INewsDetailView, INewsDetailPresenter<INewsDetailView>, ViewState<INewsDetailView>> implements INewsDetailView {

    @BindView(R.id.news_detail_main_image)
    ImageView mainImage;
    @BindView(R.id.news_detail_team_logo)
    ImageView teamLogo;
    @BindView(R.id.news_detail_team_name)
    TextView teamName;
    @BindView(R.id.news_detail_date)
    TextView date;
    @BindView(R.id.news_detail_title)
    TextView title;
    @BindView(R.id.news_detail_description)
    TextView description;

    /*
    Constructors
     */

    public NewsDetailView() {
        super();
    }

    public NewsDetailView(StateMachine stateMachineHandler, Bundle args) {
        super(stateMachineHandler, args);
    }

    /*
    Methods from BaseView
     */

    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater,
                                @NonNull ViewGroup container) {

        View view = inflater.inflate(R.layout.layout_news_detail, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    /*
    Listeners
     */

    @OnClick(R.id.news_detail_close_button)
    void onCloseButtonClick() {
        getPresenter().goBack();
    }

    /*
    View methods
     */

    @Override
    public void setFields(News news) {
        teamName.setText(news.getTeamName());
        date.setText("21st Dec 2017");
        title.setText(news.getTitle());
        description.setText(news.getText());

        Glide.with(getActivity())
                .load(news.getImageUrl())
                .apply(new RequestOptions().centerCrop())
                .into(mainImage);

        Glide.with(getActivity())
                .load("https://i.pinimg.com/originals/01/1d/88/011d889c74933e3721d9e3d455a2ddc3.jpg")
                .apply(new RequestOptions().centerInside())
                .into(teamLogo);
    }

}
