package com.example.aacommomadapter.no;


import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class MyViewHolder2<V extends View>  extends ViewHolder{

	private V view;
	
	public MyViewHolder2(V view) {
		super(view);
		this.view=view;
	}
	
	public V  getView(){
		return view;
	}
	
}
