package com.example.aacommomadapter.no;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.aacommomadapter.R;

@EActivity(R.layout.test_acty_layout)
public class TestActivity2 extends Activity{
	@ViewById(R.id.test_recyclerview)
	RecyclerView mRecyclerView;
	
	private List<MyBean2> mDatas;
	private ViewAdapter2<MyBean2,MyViewGroup2> mAdapter;
	
	@AfterViews
	void afterViews(){
		 initDatas();
		LinearLayoutManager manager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		mRecyclerView.setLayoutManager(manager);
		mRecyclerView.setAdapter(mAdapter);
	}
	
	private void initDatas() {
		mDatas=new ArrayList<MyBean2>();
		for (int i = 0; i < 51; i++) {
			MyBean2 bean=new MyBean2(R.drawable.ic_launcher, "新闻"+i, "新闻内容~~~~~~~~~~~~~~~~~~~"+i);
			mDatas.add(bean);
		}
		
		mAdapter=new ViewAdapter2<MyBean2, MyViewGroup2>(this,mDatas) {
			
			@Override
			protected MyViewGroup2 onCreateItemView(ViewGroup parent, int viewType) {
				
				return MyViewGroup2_.build(TestActivity2.this);
			}
			
			@Override
			protected void onBindView(MyViewHolder2<MyViewGroup2> holder, int position) {
				MyViewGroup2 view= holder.getView();
				view.bind(mDatas.get(position));
			}
		};
		
	}
	
}
