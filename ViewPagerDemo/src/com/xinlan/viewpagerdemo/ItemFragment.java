package com.xinlan.viewpagerdemo;

import com.xinlan.components.ImageFetcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Õº∆¨œ‘ æ
 */
public class ItemFragment extends Fragment {
	private String mImageUrl;
	private Item data;
	private ImageFetcher mImageFetcher;

	public static ItemFragment newInstance(Item item, ImageFetcher mImageFetcher) {
		final ItemFragment f = new ItemFragment();
		f.data = item;
		f.mImageFetcher = mImageFetcher;
		return f;
	}

	public ItemFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.fgm_item, container, false);
		ImageView image=(ImageView)v.findViewById(R.id.img);
		mImageFetcher.loadImage(data.getUrl(), image);
		TextView title=(TextView)v.findViewById(R.id.btn);
		title.setText(data.getTitle());
		TextView content=(TextView)v.findViewById(R.id.text);
		content.setText(data.getText());
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (MainActivity.class.isInstance(getActivity())) {
			
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
