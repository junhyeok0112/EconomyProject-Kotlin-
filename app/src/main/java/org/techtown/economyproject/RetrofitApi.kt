package org.techtown.economyproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {        //Retrofit 객체 생성
    private var instance : Retrofit? = null

    fun getInstnace() : Retrofit {
        if(instance == null){
            instance = Retrofit.Builder()
                .baseUrl("http://ecos.bok.or.kr/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }

}