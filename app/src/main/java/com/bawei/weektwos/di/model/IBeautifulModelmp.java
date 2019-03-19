package com.bawei.weektwos.di.model;

import android.util.Log;

import com.bawei.weektwos.data.bean.BeautifulBean;
import com.bawei.weektwos.data.utils.ApiService;
import com.bawei.weektwos.data.utils.RectrofitUtils;
import com.bawei.weektwos.di.contract.IBeautifulContract;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class IBeautifulModelmp implements IBeautifulContract.IBeautifulModel {
    @Override
    public void requestData(final CallBack callBack) {
        ApiService apiService = RectrofitUtils.getInstance().response(ApiService.class);
        Observable<BeautifulBean> observable = apiService.getBeautiful();
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BeautifulBean>() {
                    @Override
                    public void accept(BeautifulBean beautifulBean) throws Exception {
                          callBack.onCallBack(beautifulBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("WSH",throwable.getMessage()+"sss");
                    }
                });
    }
}
