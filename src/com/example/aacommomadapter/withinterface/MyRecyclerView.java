package com.example.aacommomadapter.withinterface;

import com.example.aacommomadapter.withinterface.ViewAdapter.OnItemClickListener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

public class MyRecyclerView extends RecyclerView{

	public MyRecyclerView(Context context) {
	super(context);
	}
	public MyRecyclerView(Context context, AttributeSet attrs) {
	super(context, attrs);
	}
	public MyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
    
	private OnItemClickListener mOnItemClickListener = null; 
	
	public <T> void setAdapter(ViewAdapter<T, MyInterface<T>> adapter) {
		super.setAdapter(adapter);
		adapter.setOnItemClickListener(mOnItemClickListener);
		Log.d("MyRecyclerView", "Adapter listener setted");
	}
	
	public void setOnItemClickListener(OnItemClickListener listener) {  
        mOnItemClickListener = listener;  
        Log.d("MyRecyclerView", "recyclerView listener setted");
    } 
	
	public final OnItemClickListener getOnItemClickListener() {  
        return mOnItemClickListener;  
    }  
	
	
}
