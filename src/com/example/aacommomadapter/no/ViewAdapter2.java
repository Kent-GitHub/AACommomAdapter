package com.example.aacommomadapter.no;

import java.util.List;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public  abstract class ViewAdapter2<T,V extends View> extends RecyclerView.Adapter<MyViewHolder2<V>>{
	private List<T> mDatas;
	private Context mContext;
	public ViewAdapter2(Context context,List<T> datas){
		mDatas=datas;
		mContext=context;
	}
	
	@Override
	public int getItemCount() {
		return mDatas.size();
	}
	
	@Override
	public void onBindViewHolder(MyViewHolder2<V> holder, int position) {
		onBindView(holder,  position);
		if (mOnItemClickListener!=null) {
			bindListener(holder, position);
		}
	}
	
	protected abstract void onBindView(MyViewHolder2<V> holder, int position);
	
	@Override
	public MyViewHolder2<V> onCreateViewHolder(ViewGroup parent, int viewType) {
		return new MyViewHolder2<V>(onCreateItemView(parent, viewType));
	}
	
	protected abstract V onCreateItemView(ViewGroup parent, int viewType);
	
	/**
	 *	监听接口
	 */
	public interface OnItemClickListener{
		void onItemClick(View view,int position);
		void onItemLongClick(View view,int position);
	}

	private OnItemClickListener mOnItemClickListener;
	/**
	 *	绑定监听接口
	 */
	public void setOnItemClickListener(OnItemClickListener listener){
		mOnItemClickListener=listener;
	}
	/**
	 *	给每个Item添加Click事件 
	 */
	private void  bindListener(MyViewHolder2<V> holder,  final int position) {
			holder.itemView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mOnItemClickListener.onItemClick(v, position);
				}
			});
			holder.itemView.setOnLongClickListener(new OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					// TODO Auto-generated method stub
					mOnItemClickListener.onItemLongClick(v, position);
					return false;
				}
			});
	}
}
