package org.techtown.economyproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import org.techtown.economyproject.databinding.FragmentExplainBinding
import org.techtown.economyproject.databinding.FragmentMenuBinding
import org.techtown.economyproject.databinding.FragmentShowoneeiBinding

class ShowOneeiFrament : Fragment() {

    lateinit var navController: NavController
    lateinit var binding : FragmentShowoneeiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowoneeiBinding.inflate(layoutInflater,container , false);
        return binding.root;
    }
}