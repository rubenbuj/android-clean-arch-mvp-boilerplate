package com.altv.dugoutapp.trending_list.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.altv.dugout_domain.model.News;
import com.altv.dugoutapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rubenbujalance on 26/01/2018.
 */

public class TrendingListAdapter extends RecyclerView.Adapter<TrendingListAdapter.ViewHolder> {

    List<News> data;
    TrendingListListener handler;

    /*
    Adapter contructor
     */

    public TrendingListAdapter(List<News> newsList, TrendingListListener trendingListListener) {
        data = newsList;
        handler = trendingListListener;
    }

    /*
    Adapter methods
     */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_trending_list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(holder.getImage().getContext())
                .load(data.get(position).getImageUrl())
                .apply(new RequestOptions().centerCrop())
                .into(holder.getImage());

        Glide.with(holder.getTeamLogo().getContext())
                .load("https://i.pinimg.com/originals/01/1d/88/011d889c74933e3721d9e3d455a2ddc3.jpg")
                .apply(new RequestOptions().centerInside())
                .into(holder.getTeamLogo());

        holder.getTeamTitle().setText(data.get(position).getTeamName());
        holder.getNewsTitle().setText(data.get(position).getTitle());
        holder.getNewsSubtitle().setText(data.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /*
    ViewHolder definition
     */

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.trending_list_item_image)
        ImageView image;
        @BindView(R.id.trending_list_item_team_logo)
        ImageView teamLogo;
        @BindView(R.id.trending_list_item_team_name)
        TextView teamTitle;
        @BindView(R.id.trending_list_item_news_title)
        TextView newsTitle;
        @BindView(R.id.trending_list_item_news_subtitle)
        TextView newsSubtitle;

        @BindView(R.id.reactions_likes_text)
        TextView reactionsLikesText;
        @BindView(R.id.reactions_comments_text)
        TextView reactionsCommentsText;
        @BindView(R.id.reactions_favourites_text)
        TextView reactionsFavouritesText;
        @BindView(R.id.reactions_shares_text)
        TextView reactionsSharesText;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handler.onItemClicked(getAdapterPosition());
                }
            });

            // For this screen, we don't want the numbers to be shown
            reactionsLikesText.setVisibility(View.GONE);
            reactionsCommentsText.setVisibility(View.GONE);
            reactionsFavouritesText.setVisibility(View.GONE);
            reactionsSharesText.setVisibility(View.GONE);
        }

        public ImageView getImage() {
            return image;
        }
        public ImageView getTeamLogo() {
            return teamLogo;
        }
        public TextView getTeamTitle() {
            return teamTitle;
        }
        public TextView getNewsTitle() {
            return newsTitle;
        }
        public TextView getNewsSubtitle() {
            return newsSubtitle;
        }
    }

    /*
    Callback interface
     */

    public interface TrendingListListener {
        void onItemClicked(int position);
    }

}
