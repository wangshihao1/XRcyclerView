package com.bawei.weektwos.data.utils;

import com.bawei.weektwos.data.bean.BeautifulBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/data/福利/10/1")
    Observable<BeautifulBean> getBeautiful();

}
