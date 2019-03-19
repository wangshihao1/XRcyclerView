package com.bawei.weektwos.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.bawei.weektwos.R;
import com.bawei.weektwos.data.bean.BeautifulBean;
import com.bawei.weektwos.di.contract.IBeautifulContract;
import com.bawei.weektwos.di.presenter.IBeautifulPresenterImp;
import com.bawei.weektwos.ui.adapter.BeautifulAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IBeautifulContract.IBeautifulContractView {


    @BindView(R.id.xr)
    XRecyclerView xr;
    private BeautifulAdapter adapter;
    private IBeautifulPresenterImp presenterImp;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenterImp = new IBeautifulPresenterImp();
        presenterImp.atteachView(this);
        presenterImp.responseData();
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                presenterImp.responseData();
            }

            @Override
            public void onLoadMore() {
                page++;
                presenterImp.responseData();
            }

        });



    }

    @Override
    public void showDataView(BeautifulBean beautifulBean) {
        List<BeautifulBean.ResultsBean> resultsBeanList = beautifulBean.getResults();
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        xr.setLayoutManager(manager);
        adapter = new BeautifulAdapter();
        adapter.setMlists(this,resultsBeanList);
        xr.setAdapter(adapter);
        xr.loadMoreComplete();
        xr.refreshComplete();
    }


}
