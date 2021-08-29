package org.techtown.economyproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface IndicatorApi {

    @GET("KeyStatisticList/8YLLJIA5R5RPARXVAFW1/json/kr/{start}/{end}")
    //? 이후 [key] = [value] 형식은 Query ,
    fun getIndicator(@Path("start" , encoded = true) start:Int,
                     @Path("end",encoded = true) end:Int) : Call<EIndicators>

    @GET("ans")
    fun getMarket () :Call<MarketValue>

    @GET("{mainCode}/{cycle}/{startDay}/{endDay}/{subCode1}/{subCode2}")
    fun getSix(@Path("mainCode" , encoded = true) mainCode:String,
                @Path("cycle", encoded = true) cycle:String,
                @Path("startDay" , encoded = true) startDay:String,
                @Path("endDay" , encoded = true) endDay:String,
                @Path("subCode1" , encoded = true) subCode1:String,
                @Path("subCode2" , encoded = true) subCode2:String?) :Call<SixItems>

}