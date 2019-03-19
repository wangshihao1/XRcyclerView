package com.bawei.weektwos.di.presenter;

import com.bawei.weektwos.data.bean.BeautifulBean;
import com.bawei.weektwos.di.contract.IBeautifulContract;
import com.bawei.weektwos.di.model.IBeautifulModelmp;

import java.lang.ref.SoftReference;

public class IBeautifulPresenterImp implements IBeautifulContract.IBeautifulPresenter<IBeautifulContract.IBeautifulContractView> {

    private IBeautifulContract.IBeautifulModel beautifulModel;
    private IBeautifulContract.IBeautifulContractView beautifulContractView;
    private SoftReference<IBeautifulContract.IBeautifulContractView> reference;

    @Override
    public void atteachView(IBeautifulContract.IBeautifulContractView iBeautifulContractView) {
            this.beautifulContractView = iBeautifulContractView;
            beautifulModel = new IBeautifulModelmp();
            reference = new SoftReference<>(beautifulContractView);
    }

    @Override
    public void detachView(IBeautifulContract.IBeautifulContractView iBeautifulContractView) {
            reference.clear();
    }

    @Override
    public void responseData() {
            beautifulModel.requestData(new IBeautifulContract.IBeautifulModel.CallBack() {
                @Override
                public void onCallBack(BeautifulBean beautifulBean) {
                    beautifulContractView.showDataView(beautifulBean);
                }
            });
    }
}
