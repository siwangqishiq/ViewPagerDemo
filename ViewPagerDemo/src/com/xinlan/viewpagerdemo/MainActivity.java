package com.xinlan.viewpagerdemo;

import java.util.ArrayList;

import com.xinlan.components.ImageFetcher;
import com.xinlan.factory.ImageFetcherFactory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
	private ViewPager mGallery;
	private ImageFetcher mImageFetcher;
	private ArrayList<Item> data;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		addData();
		mImageFetcher = ImageFetcherFactory.genFetcher(this);
		mGallery = (ViewPager) findViewById(R.id.gallery);
		mGallery.setAdapter(new ItemAdapter(getSupportFragmentManager()));
	}
	
	private final class ItemAdapter extends FragmentStatePagerAdapter{
		public ItemAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int index) {
			return ItemFragment.newInstance(data.get(index), mImageFetcher);
		}

		@Override
		public int getCount() {
			return data.size();
		}
	}//end inner class
	
	private void addData(){
		data = new ArrayList<Item>();
		Item item1 = new Item();
		item1.setTitle("毛利兰");
		item1.setText("工藤新一");
		item1.setUrl("http://s1.t.itc.cn/mblog/pic/201110_5_12/154934577970191.jpg");
		Item item2 = new Item();
		item2.setTitle("毛利兰c");
		item2.setText("工藤新一d");
		item2.setUrl("http://img1.gtimg.com/3/336/33679/3367933_980x1200_0.jpg");
		Item item3 = new Item();
		item3.setTitle("毛利兰a");
		item3.setText("工藤新一b");
		item3.setUrl("http://img.ph.126.net/ltXaqMEj-FXdXu5c0DoSqg==/801077783720453791.jpg");
		
		data.add(item1);
		data.add(item2);
		data.add(item3);
	}
}// end class
