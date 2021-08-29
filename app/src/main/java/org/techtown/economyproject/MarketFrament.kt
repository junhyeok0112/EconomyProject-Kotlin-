package org.techtown.economyproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import org.techtown.economyproject.databinding.FragmentMarketBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                val score :Float? = response.body()?.Value?.toFloat()
                //코틀린은 명시적으로 null을 넣을 수 있는 변수는 없음 . 따라서 null이 들어올만 하면 오류 그래서 nullable 체크
                score.let{          //null이 아니면실행
                    if (score!! >= 2.5) {
                        result = "점수가 2.5이상이면 매수하는게 좋은데 우리가 나온 점수는 ${score} 이므로 매수하는 것이 좋다\n"
                    } else {
                        result = "점수가 2.5이상이면 매수하는게 좋은데 우리가 나온 점수는 ${score} 이므로 매수하지 않는 것이 좋다\n"
                    }
                }
                binding.invalidateAll()                                            //새로고침
            }

            override fun onFailure(call: Call<MarketValue>, t: Throwable) {
                Log.d("MarketValue 실패" , "MarketValue 실패")
            }
        })
    }
}