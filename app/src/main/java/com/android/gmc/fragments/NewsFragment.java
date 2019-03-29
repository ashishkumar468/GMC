package com.android.gmc.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.gmc.R;
import com.android.gmc.adapters.NewsAdapter;
import com.android.gmc.interfaces.INews;
import com.android.gmc.model.domain.NewsItem;
import java.util.List;

public class NewsFragment extends BaseFragment implements INews.View {

    @BindView(R.id.rv_news) RecyclerView rvNews;
    @BindView(R.id.pb_news) ProgressBar pbNews;
    private NewsAdapter adapter;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        init();
    }

    private void init() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new NewsAdapter();
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNews.setAdapter(adapter);
    }

    @Override public void showNews(List<NewsItem> newsItemList) {
        adapter.setNewsItemList(newsItemList);
    }

    @Override public void showProgress(boolean shouldShow) {
        pbNews.setVisibility(shouldShow ? View.VISIBLE : View.GONE);
    }
}
