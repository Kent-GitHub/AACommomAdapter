package com.example.aacommomadapter.no;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aacommomadapter.R;
@EViewGroup(R.layout.bean_layout)
public class MyViewGroup2 extends LinearLayout{

	@ViewById
	ImageView beanIv;
	
	@ViewById
	TextView beanTitle,beanContent;
	
	public MyViewGroup2(Context context) {
		super(context);
	}
	
	public void bind(MyBean2 bean){
		beanIv.setImageResource(bean.iconId);
		beanTitle.setText(bean.newsTitle);
		beanContent.setText(bean.newsContent);
	}

}
