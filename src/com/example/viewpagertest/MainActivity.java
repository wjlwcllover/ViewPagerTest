package com.example.viewpagertest;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {

	private ViewPager viewPager ;
	
	private int[] mImagesIds = new int[]{R.drawable.a1, R.drawable.a2,R.drawable.a3};
	
	List<ImageView> imageViews = new ArrayList<ImageView>();
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewPager= (ViewPager) findViewById( R.id.view_pager);
        
        
        //添加切换动画效果  3.0 之前不可以使用这种效果
        
      //  viewPager.setPageTransformer(true, new DepthPagesTransForm());
        
        viewPager.setAdapter(new PagerAdapter() {
			
        	@Override
        	public Object instantiateItem(ViewGroup container, int position) {
        		// TODO Auto-generated method stub
        		ImageView imageView =new ImageView(MainActivity.this);
        		imageView.setImageResource(mImagesIds[position]);
        		
        		imageView.setScaleType(ScaleType.CENTER_CROP);
        		
        		container.addView(imageView);
        		
        		imageViews.add(imageView);
        		
        		
        		return imageView;
        	}
        	
        	@Override
        	public void destroyItem(View container, int position, Object object) {
        		// TODO Auto-generated method stub
        		((ViewPager) container).removeView(imageViews.get(position));
        	}
        	
			@Override
			public boolean isViewFromObject(View view, Object object) {
				// TODO Auto-generated method stub
				return view == object;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mImagesIds.length;
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
