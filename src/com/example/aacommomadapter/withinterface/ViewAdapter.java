package com.example.aacommomadapter.withinterface;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


public  abstract class ViewAdapter<T,V extends MyInterface<T>> extends RecyclerView.Adapter<MyViewHolder<V,T>>{
	protected List<T> mDatas;
	protected Context mContext;
	public ViewAdapter(Context context,List<T> datas){
		mDatas=datas;
		mContext=context;
	}
	
	@Override
	public int getItemCount() {
		return mDatas.size();
	}
	
	@Override
	public void onBindViewHolder(MyViewHolder<V,T> holder, int position) {
		holder.getView().bind(mDatas.get(position));
		if (mOnItemClickListener!=null) {
			bindListener(holder, position);
		}
	}
	
	@Override
	public MyViewHolder<V,T> onCreateViewHolder(ViewGroup parent, int viewType) {
		return new MyViewHolder<V,T>(onCreateItemView(parent, viewType));
	}
	
	protected abstract V onCreateItemView(ViewGroup parent, int viewType);
	
	/**
	 *	监听接口
	 */
//	public interface OnItemClickListener{
//		void onItemClick(View view,int position);
//		void onItemLongClick(View view,int position);
//	}

	
	public interface OnItemClickListener {  
        void onItemClick(View view, int position);  
    }  
	
	private OnItemClickListener mOnItemClickListener;
	/**
	 *	绑定监听接口
	 */
	public void setOnItemClickListener(OnItemClickListener listener){
		mOnItemClickListener=listener;
		Log.d("ViewAdapter", "adapter listener setted");
	}
	/**
	 *	给每个Item添加Click事件 
	 */
	private void  bindListener(MyViewHolder<V,T> holder,  final int position) {
			holder.itemView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Log.d("ViewAdapter", "on CLick");
					mOnItemClickListener.onItemClick(v, position);
				}
			});
	}
}
