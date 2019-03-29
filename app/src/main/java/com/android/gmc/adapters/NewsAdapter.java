package com.android.gmc.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.gmc.R;
import com.android.gmc.model.domain.NewsItem;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<NewsItem> newsItemList;

    public NewsAdapter() {
        newsItemList = new ArrayList<>();
    }

    @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.row_item_news, viewGroup, false));
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.init(position);
    }

    @Override public int getItemCount() {
        return newsItemList.size();
    }

    public void setNewsItemList(List<NewsItem> newsItemList) {
        this.newsItemList.clear();
        this.newsItemList.addAll(newsItemList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_news) ImageView ivNews;
        @BindView(R.id.tv_image_title) TextView tvTitle;
        @BindView(R.id.tv_description) TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void init(int position) {
            NewsItem newsItem = newsItemList.get(position);
            tvTitle.setText(newsItem.getTitle());
            tvDescription.setText(newsItem.getDescription());
            Glide.with(ivNews.getContext()).load(newsItem.getImageUrl()).into(ivNews);
        }
    }
}
