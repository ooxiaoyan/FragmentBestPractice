package com.example.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {

    public void actionStart(Context context, String newsTitle, String newsContent) {//2.6.3启动活动的最佳写法
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news title", newsTitle);
        intent.putExtra("news content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        String newsTitle = getIntent().getStringExtra("news title");//获取传入的新闻标题
        String newsContent = getIntent().getStringExtra("news content");//获取传入的新闻内容
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle, newsContent);//刷新NewsContentFragment界面
    }
}
