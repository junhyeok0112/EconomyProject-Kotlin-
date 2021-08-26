package org.techtown.economyproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.economyproject.databinding.FragmentExplainBinding
import org.techtown.economyproject.databinding.FragmentMenuBinding
import org.techtown.economyproject.databinding.FragmentShowoneeiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ShowOneeiFrament : Fragment() {

    lateinit var navController: NavController
    lateinit var binding : FragmentShowoneeiBinding
    val adapter:EIndicatorsAdapter = EIndicatorsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowoneeiBinding.inflate(layoutInflater,container , false);

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        callRetrofit()
        return binding.root;
    }

    //"KeyStatisticList/8YLLJIA5R5RPARXVAFW1/json/kr/{start}/{end}"
    fun callRetrofit(){     //retrofit 호출 함수
        Log.d("진입" , "callRetrofit 진입")
        val retrofit = RetrofitApi.getInstnace()
        var indicatorApi:IndicatorApi? = retrofit.create(IndicatorApi::class.java) //retrofit 객체 사용해서 interface갖는 객체생성
        indicatorApi?.getIndicator(1,100)?.enqueue(object : Callback<EIndicators> {
            //파라미터 전달하고 결과는 Callback으로 받음 -> 우리가 정의한 거
            override fun onResponse(call: Call<EIndicators>, response: Response<EIndicators>) {
                //response로 요청한 데이터에 접근가능 response?.body()?.* 의 형식으로
                Log.d("성공","성공 : ${response.body()?.KeyStatisticList?.list_total_count}")

            }

            override fun onFailure(call: Call<EIndicators>, t: Throwable) {
                Log.d("실패" , " 실패")
            }
        })
    }
}