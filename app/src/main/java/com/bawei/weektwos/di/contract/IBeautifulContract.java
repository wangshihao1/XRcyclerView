package com.bawei.weektwos.di.contract;

import com.bawei.weektwos.data.bean.BeautifulBean;

public interface IBeautifulContract {

    public interface IBeautifulContractView{

        void showDataView(BeautifulBean beautifulBean);
    }

    public interface IBeautifulPresenter<IBeautifulContractView>{

        void atteachView(IBeautifulContractView contractView);

        void detachView(IBeautifulContractView contractView);

        void responseData();
    }

    public interface IBeautifulModel{

        public interface CallBack{

            void onCallBack(BeautifulBean beautifulBean);
        }

        void requestData(CallBack callBack);
    }
}
