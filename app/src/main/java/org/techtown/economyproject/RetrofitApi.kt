package org.techtown.economyproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {        //Retrofit 객체 생성
    private var instance : Retrofit? = null
    private var marketInstance: Retrofit? = null        //instance 하나 쓰면 먼저 호출한 거의 instance를 다음거 쓸때 재활용하므로오류남
    //따라서 인스턴스 2개 설정해주어야함

    fun getInstnace() : Retrofit {
        if(instance == null){
            instance = Retrofit.Builder()
                .baseUrl("http://ecos.bok.or.kr/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }

    fun getMarket() : Retrofit{
        if(marketInstance == null){
            marketInstance = Retrofit.Builder()
                .baseUrl("https://economyapp.run.goorm.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return marketInstance!!
    }

}