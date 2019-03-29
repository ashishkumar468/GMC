package com.android.gmc.interfaces;

import com.android.gmc.model.domain.NewsItem;
import java.util.List;

public interface INews {
    public interface View {
        void showNews(List<NewsItem> newsItemList);

        void showProgress(boolean shouldShow);
    }
}
