package com.example.aacommomadapter.withinterface;



import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class MyViewHolder<V extends MyInterface<T>, T>  extends ViewHolder{

	private V view;
	
	public MyViewHolder(V view) {
		super((View) view);
		this.view=view;
	}
	
	public V  getView(){
		return view;
	}

}
