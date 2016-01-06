package com.example.aacommomadapter.withinterface;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aacommomadapter.R;
import com.example.aacommomadapter.withinterface.ViewAdapter.OnItemClickListener;

@EActivity(R.layout.test_acty_layout)
public class TestActivity extends Activity{
	@ViewById(R.id.test_recyclerview)
	MyRecyclerView mRecyclerView;
	ListView mListView;
	private List<MyBean> mDatas;
	private ViewAdapter<MyBean,MyViewGroup> mAdapter;
	
	@AfterViews
	void afterViews(){
		 initDatas();
		LinearLayoutManager manager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		mRecyclerView.setLayoutManager(manager);
		mRecyclerView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
					Toast.makeText(TestActivity.this, position+"", 0).show();
			}
		});
		mRecyclerView.setAdapter(mAdapter);
	}
	
	private void initDatas() {
		MyRecyclerView view=new MyRecyclerView(TestActivity.this);
		
		mDatas=new ArrayList<MyBean>();
		for (int i = 0; i < 51; i++) {
			MyBean bean=new MyBean(R.drawable.ic_launcher, "新闻"+i, "新闻内容~~~~~~~~~~~~~~~~~~~"+i);
			mDatas.add(bean);
		}
		mAdapter=new ViewAdapter<MyBean, MyViewGroup>(this,mDatas) {
			@Override
			protected MyViewGroup onCreateItemView(ViewGroup parent, int viewType) {
				return MyViewGroup_.build(TestActivity.this);
			}
			
		};
		
	}
}
