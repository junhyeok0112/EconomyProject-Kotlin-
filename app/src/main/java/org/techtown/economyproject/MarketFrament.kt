package org.techtown.economyproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import org.techtown.economyproject.databinding.FragmentExplainBinding
import org.techtown.economyproject.databinding.FragmentMarketBinding
import org.techtown.economyproject.databinding.FragmentMenuBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MarketFrament : Fragment() {

    lateinit var navController: NavController
    lateinit var binding : FragmentMarketBinding
    var result:String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarketBinding.inflate(layoutInflater,container , false);
        binding.makret = this

        callMarket()

        return binding.root;
    }


    fun callMarket(){
        val retrofit = RetrofitApi.getMarket()
        val indicatorApi:IndicatorApi? = retrofit.create(IndicatorApi::class.java)   //인터페이스 객체 생성
        indicatorApi?.getMarket()?.enqueue(object : Callback<MarketValue>{
            override fun onResponse(call: Call<MarketValue>, response: Response<MarketValue>) {
                Log.d("MarketValue 성공" , "MarketValue 성공")
                Log.d("MarketValue 값 ","${response.body()?.Value}" )                //값 가져오기
                Log.d("MarketValue 값 ","${response.code()}" )
                result = response.body()?.Value                                     //가져온 값 result 에 넣기
                binding.invalidateAll()                                            //새로고침
            }

            override fun onFailure(call: Call<MarketValue>, t: Throwable) {
                Log.d("MarketValue 실패" , "MarketValue 실패")
            }
        })
    }
}