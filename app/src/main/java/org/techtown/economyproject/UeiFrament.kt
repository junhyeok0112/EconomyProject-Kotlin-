package org.techtown.economyproject

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import org.techtown.economyproject.databinding.FragmentUeiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UeiFrament : Fragment() , AdapterView.OnItemSelectedListener{

    lateinit var navController: NavController
    lateinit var binding : FragmentUeiBinding
    val data_entry : ArrayList<Entry> = ArrayList<Entry>()
    val labels = arrayOfNulls<String>(12)
    var title:String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUeiBinding.inflate(layoutInflater, container, false);
        binding.uei = this

        //초기 설정
        //CallRetrofit("085Y026","MM","202007","202109","I16E","")

        //아이템 선택했을 때 리스너 등록
        binding.spinner.onItemSelectedListener = this


        return binding.root;
    }
    //Spinner 클릭했을때 실행
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(position){
            0 ->{
                data_entry.clear()             //들어가 있던 값 초기화 후 다시 셋팅
                CallRetrofit("085Y026","MM","202007","202109","I16E","")
            }
            1->{
                data_entry.clear()
                CallRetrofit("022Y013","MM","202007","202108","000000","")
            }
            2->{
                data_entry.clear()
                CallRetrofit("098Y001","MM","202008","202108","0101000","")
            }
            3->{
                data_entry.clear()
                CallRetrofit("021Y125","MM","202008","202108","0","")
            }
            4->{
                data_entry.clear()
                CallRetrofit("080Y101","MM","202007","202108","I11AC","3")
            }
            5->{
                data_entry.clear()
                CallRetrofit("036Y004","MM","202008","202108","0000001","0000100")
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    //Retrofit으로 데이터 가져옴
    fun CallRetrofit(mainCode:String, cycle:String, startDay:String, endDay:String, subCode1:String, subCode2:String?){
        val retrofit = RetrofitApi.getSix()
        val indicatorApi:IndicatorApi = retrofit.create(IndicatorApi::class.java)
        indicatorApi.getSix(mainCode, cycle , startDay,endDay ,subCode1 , subCode2).enqueue(object :Callback<SixItems>{
            override fun onResponse(call: Call<SixItems>, response: Response<SixItems>) {
                Log.d("SixItems 성공" , "${response.body()?.StatisticSearch?.list_total_count}")
                Log.d("SixItems 성공" , "${response.body()?.StatisticSearch!!.row[0]?.ITEM_NAME1}")
                setChart(response.body()?.StatisticSearch?.row!!)
            }

            override fun onFailure(call: Call<SixItems>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    //가져온 데이터로 꺽은선 형 차트 셋팅
    fun setChart(items : List<SixItemsResult>){
        val chartData:LineData = getLineData(items)         //리턴 받은 데이터로 차트에 적용
        chartData.setValueFormatter(MyValueFormatter())     //데이터 텍스트 형식 ->클래스만듬
        chartData.setValueTextSize(10f)                     //데이터 텍스트 크기
        chartData.setValueTextColor(Color.parseColor("#03DAC5")) //데이터 텍스트 색
        binding.linechart.data = chartData

        //오른쪽 y축 비활성화
        val yr: YAxis = binding.linechart.getAxisRight()
        yr.setDrawLabels(false)
        yr.setDrawAxisLine(false)
        yr.setDrawGridLines(false)

        //X축 위치 설정
        val x: XAxis = binding.linechart.getXAxis()
        x.position = XAxis.XAxisPosition.BOTTOM
        x.valueFormatter = IndexAxisValueFormatter(labels)
        x.labelCount = 10
        x.textSize = 7f

        binding.linechart.invalidate()
    }

    //차트 데이터 , 차트 디자인 셋팅
    fun getLineData(items : List<SixItemsResult>) : LineData{

        //차트에 들어갈 내용들 전부 셋팅
        for(i in 0 until items.size){
            //데이터 엔트리 추가
            data_entry.add(Entry(i.toFloat(), items[i].DATA_VALUE.toFloat()))
            //가독성 있게 time 가공하기
            //년도의 뒤에 2개 , 월만 나오게 가공
            val tempYM: String = items[i].TIME
            val year = tempYM.substring(2, 4)
            val month = tempYM.substring(4, 6)
            labels[i] = year +"."+ month
            //X에 시간 추가
        }

        //차트에 들어갈 디자인 셋팅
        val lineDataset : LineDataSet = LineDataSet(data_entry , items[0].ITEM_NAME1)
        lineDataset.setLineWidth(1.75f);
        lineDataset.setCircleRadius(5f);
        lineDataset.setCircleHoleRadius(2.5f);
        lineDataset.setColor(Color.BLACK);
        lineDataset.setCircleColor(Color.BLACK);
        lineDataset.setHighLightColor(Color.BLACK);
        lineDataset.setDrawValues(true);
        return LineData(lineDataset)        //그 후 DataSet을 Data에 넣어서 리턴
    }

}