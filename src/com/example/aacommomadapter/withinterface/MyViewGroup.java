package com.example.aacommomadapter.withinterface;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aacommomadapter.R;
@EViewGroup(R.layout.bean_layout)
public class MyViewGroup extends LinearLayout implements MyInterface<MyBean>{

	@ViewById
	ImageView beanIv;
	
	@ViewById
	TextView beanTitle,beanContent;
	
	public MyViewGroup(Context context) {
		super(context);
	}
	
	@Override
	public void bind(MyBean bean){
		beanIv.setImageResource(bean.iconId);
		beanTitle.setText(bean.newsTitle);
		beanContent.setText(bean.newsContent);
	}

}
