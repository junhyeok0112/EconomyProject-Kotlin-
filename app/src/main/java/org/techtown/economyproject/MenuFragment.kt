package org.techtown.economyproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.techtown.economyproject.databinding.FragmentExplainBinding
import org.techtown.economyproject.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var binding : FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater,container , false);
        binding.menu = this
        return binding.root;

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)              //navController 생성성

    }
    //버튼 클릭 시 프래그먼트 이동
    fun onNext(view:View){
        when(view.id){
            binding.oneei.id ->{
                navController.navigate(R.id.action_menuFragment_to_oneeiFrament)
            }
            binding.uei.id->{
                navController.navigate(R.id.action_menuFragment_to_ueiFrament)
            }
            binding.markettiming.id->{
                navController.navigate(R.id.action_menuFragment_to_marketFrament)
            }
            binding.explain.id->{
                navController.navigate(R.id.action_menuFragment_to_explainFrament)
            }
            binding.kospi.id->{
                navController.navigate(R.id.action_menuFragment_to_kospiFragment)
            }
        }
    }


}