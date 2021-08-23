package org.techtown.economyproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.techtown.economyproject.databinding.FragmentExplainBinding
import org.techtown.economyproject.databinding.FragmentMenuBinding
import org.techtown.economyproject.databinding.FragmentOneeiBinding

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
        navController.navigate(R.id.action_oneeiFrament_to_showOneeiFrament)
    }
}