package cc.b2j.carmanager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import cc.b2j.carmanager.ui.HomeFragment;
import cc.b2j.carmanager.ui.MineFragment;
import cc.b2j.carmanager.ui.OrderFragment;
import cc.b2j.carmanager.view.ChangeColorIcon;

public class MainActivity extends FragmentActivity implements OnClickListener,
		OnPageChangeListener
{

	private ViewPager mViewPager;
	private List<Fragment> mTabs = new ArrayList<Fragment>();
	private String[] mTitles = new String[]
	{ "home Fragment !", "order Fragment !", "mine Fragment !" };
	private FragmentPagerAdapter mAdapter;

	private List<ChangeColorIcon> mTabIndicators = new ArrayList<ChangeColorIcon>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		initDatas();
		mViewPager.setAdapter(mAdapter);
		initEvent();

	}

	/**
	 * 初始化所有事件
	 */
	private void initEvent()
	{

		mViewPager.setOnPageChangeListener(this);

	}

	private void initDatas()
	{
		//主页
		HomeFragment homeFragment = new HomeFragment();
		Bundle hbundle = new Bundle();
		hbundle.putString("title", mTitles[0]);
		homeFragment.setArguments(hbundle);
		mTabs.add(homeFragment);
		//订单
		OrderFragment orderFragment = new OrderFragment();
		Bundle obundle = new Bundle();
		obundle.putString("title",mTitles[1]);
		orderFragment.setArguments(obundle);
		mTabs.add(orderFragment);
		
		//我的
		MineFragment mineFragment = new MineFragment();
		Bundle mbundle = new Bundle();
		mbundle.putString("title", mTitles[2]);
		mineFragment.setArguments(mbundle);
		mTabs.add(mineFragment);
		
	
		
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
		{

			@Override
			public int getCount()
			{
				return mTabs.size();
			}

			@Override
			public Fragment getItem(int position)
			{
				return mTabs.get(position);
			}
		};
	}

	private void initView()
	{
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

		ChangeColorIcon one = (ChangeColorIcon) findViewById(R.id.id_indicator_one);
		mTabIndicators.add(one);
		ChangeColorIcon two = (ChangeColorIcon) findViewById(R.id.id_indicator_two);
		mTabIndicators.add(two);
		ChangeColorIcon three = (ChangeColorIcon) findViewById(R.id.id_indicator_three);
		mTabIndicators.add(three);

		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);

		one.setIconAlpha(1.0f);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	@Override
	public void onClick(View v)
	{
		clickTab(v);

	}

	/**
	 * 点击Tab按钮
	 * 
	 * @param v
	 */
	private void clickTab(View v)
	{
		resetOtherTabs();

		switch (v.getId())
		{
		case R.id.id_indicator_one:
			mTabIndicators.get(0).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(0, false);
			break;
		case R.id.id_indicator_two:
			mTabIndicators.get(1).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(1, false);
			break;
		case R.id.id_indicator_three:
			mTabIndicators.get(2).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(2, false);
			break;
		}
	}

	/**
	 * 重置其他的TabIndicator的颜色
	 */
	private void resetOtherTabs()
	{
		for (int i = 0; i < mTabIndicators.size(); i++)
		{
			mTabIndicators.get(i).setIconAlpha(0);
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels)
	{
		// Log.e("TAG", "position = " + position + " ,positionOffset =  "
		// + positionOffset);
		if (positionOffset > 0)
		{
			ChangeColorIcon left = mTabIndicators.get(position);
			ChangeColorIcon right = mTabIndicators.get(position + 1);
			left.setIconAlpha(1 - positionOffset);
			right.setIconAlpha(positionOffset);
		}

	}

	@Override
	public void onPageSelected(int position)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrollStateChanged(int state)
	{
		// TODO Auto-generated method stub

	}

}
