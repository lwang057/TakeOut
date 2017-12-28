package com.lwang.takeout.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.LatLonPoint;
import com.lwang.takeout.R;
import com.lwang.takeout.app.Constants;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.fragment.HomeFragmentPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseFragment;
import com.lwang.takeout.utils.LogUtils;

import butterknife.BindView;
import butterknife.Unbinder;

import static android.R.attr.duration;
import static android.R.attr.scrollY;

/**
 * HomeFragment.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class HomeFragment extends BaseFragment<HomeFragmentPresenter> implements AppContract.HomeFragmentView, AMapLocationListener {

    @BindView(R.id.homeRecyclerView)
    RecyclerView mHomeRecyclerView;
    @BindView(R.id.homeTextAddress)
    TextView mHomeTextAddress;
    @BindView(R.id.homeTopLayoutSearch)
    LinearLayout mHomeTopLayoutSearch;
    @BindView(R.id.homeTopLayout)
    LinearLayout mHomeTopLayout;
    private Unbinder mUnbinder;

    private AMapLocationClient mMlocationClient;


    @Override
    protected void inject(ApiComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_frg;
    }

    @Override
    protected void initView() {
        LogUtils.i("HomeFragment");
        initLocation();
        initListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Constants.Location.isChange) {
            mHomeTextAddress.setText(Constants.Location.TITLE);

            Constants.Location.isChange = false;
            Constants.Location.TITLE = "";
            Constants.Location.SNIPPET = "";
            Constants.Location.LONGITUDE = 0;
            Constants.Location.LATITUDE = 0;
        }
    }

    private void initLocation() {
        mMlocationClient = new AMapLocationClient(getActivity());
        //初始化定位参数
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        //设置定位监听
        mMlocationClient.setLocationListener(this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置定位参数
        mMlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mMlocationClient.startLocation();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        LogUtils.i("aMapLocation:::"+aMapLocation);
        LogUtils.i("aMapLocation.getErrorCode():::"+aMapLocation.getErrorCode());
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            Constants.Location.LOCATION = new LatLonPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());

            String address = aMapLocation.getAddress();
            LogUtils.i("address:::" + address);
            mHomeTextAddress.setText(address);

            //停止定位
            mMlocationClient.stopLocation();
        }
    }

    private void initListener() {
        mHomeRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollY += dy;
                int bgColor = 0X993190E8;
                if (scrollY < 0) {
                    bgColor = 0X993190E8;
                } else if (scrollY > 150) {
                    bgColor = 0XFF3190E8;
                } else {
                    bgColor = (int) mArgbEvaluator.evaluate(scrollY / duration, 0X993190E8, 0XFF3190E8);
                }


                mHomeTopLayout.setBackgroundColor(bgColor);

            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showResult() {

    }


}
