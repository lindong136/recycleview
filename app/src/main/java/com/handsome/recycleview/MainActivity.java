package com.handsome.recycleview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.handsome.recycleviewdelete.HorizontalDividerItemDecoration;
import com.handsome.recycleviewdelete.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity implements MyRecyclerViewAdapter.IonSlidingViewClickListener{

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    private ArrayList<String> mDatas=new ArrayList<String>();
    private String[] myDataset = new String[]{"JAVA", "Objective-C", "C", "C++", "Swift",
            "GO", "JavaScript", "Python", "Ruby", "HTML", "SQL"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // 创建线性布局管理器
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 为RecyclerView指定布局管理对象
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mDatas.addAll(Arrays.asList(myDataset));
        adapter = new MyRecyclerViewAdapter(this,mDatas);
        //设置动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).
                color(Color.RED).size(getResources().getDimensionPixelSize(R.dimen.divider))
                .margin(getResources().getDimensionPixelSize(R.dimen.leftmargin),
                        getResources().getDimensionPixelSize(R.dimen.rightmargin)).build());

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(MainActivity.this, "click...."+position, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDeleteBtnCilck(View view, int position) {
        Toast.makeText(MainActivity.this, "delete...."+position, Toast.LENGTH_SHORT).show();
        adapter.removeData(position);
    }

}

