package org.techtown.economyproject

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.techtown.economyproject.databinding.FragmentExplainBinding
import org.techtown.economyproject.databinding.FragmentMenuBinding
import org.techtown.economyproject.databinding.FragmentOneeiBinding

//ViewModel 만들어서 Retrofit에서 받은거 처리 , 데이터 공유 해보기
class OneeiFrament : Fragment() {

    lateinit var navController: NavController
    lateinit var binding : FragmentOneeiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneeiBinding.inflate(layoutInflater,container , false);
        binding.one = this
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    fun onNext(view:View){
        //navigation 의 safe args 로 프래그먼트간의 데이터 전달
        when(view.id){
            binding.first.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(1,18,"국민소득 , 경기 , 기업경영")
                navController.navigate(action)
            }
            binding.second.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(19,35,"산업활동 , 소비 , 투자")
                navController.navigate(action)
            }
            binding.third.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(36,43,"고용 , 임금 , 가계")
                navController.navigate(action)
            }
            binding.four.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(44,51,"통화, 금융")
                navController.navigate(action)
            }
            binding.five.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(52,63,"금리")
                navController.navigate(action)
            }
            binding.six.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(64,69,"증권")
                navController.navigate(action)
            }
            binding.seven.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(70,79,"물가")
                navController.navigate(action)
            }
            binding.eight.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(80,87,"국제수지, 대외거래")
                navController.navigate(action)
            }
            binding.nine.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(88,94,"환율, 외환보유")
                navController.navigate(action)
            }
            binding.ten.id ->{
                val action = OneeiFramentDirections.actionOneeiFramentToShowOneeiFrament(95,100,"경제관련 사회통계")
                navController.navigate(action)
            }
            binding.exit.id ->{ navController.navigate(R.id.action_oneeiFrament_to_menuFragment)}
        }


    }
}