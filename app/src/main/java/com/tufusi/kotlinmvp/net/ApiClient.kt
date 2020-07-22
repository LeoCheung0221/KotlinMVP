package com.tufusi.kotlinmvp.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description 访问服务器的API 的客户端统一管理
 */
class ApiClient {

    /**
     * 使用单例模式
     */
    private object Holder {
        val INSTANCE = ApiClient()
    }

    //派生出一个单例
    companion object {
        val instance = Holder.INSTANCE
    }

    fun <T> createRetrofit(apiInterface: Class<T>): T {
        val mOkHttpClient = OkHttpClient().newBuilder().myApply {

            //添加读取超时时间
            readTimeout(10000, TimeUnit.SECONDS)

            //添加连接超时时间
            connectTimeout(10000, TimeUnit.SECONDS)

            //添加写出超时时间
            writeTimeout(10000, TimeUnit.SECONDS)

        }.build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")

            //请求方 ←
            .client(mOkHttpClient)

            //接收方 →
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //RxJava处理接收数据
            .addConverterFactory(GsonConverterFactory.create()) //Gson解析数据
            .build()

        return retrofit.create(apiInterface)
    }
}

fun <T> T.myApply(kk: T.() -> Unit): T {
    kk()
    return this;
}