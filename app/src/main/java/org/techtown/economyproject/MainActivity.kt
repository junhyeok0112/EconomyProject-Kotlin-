package org.techtown.economyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.techtown.economyproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var mOnKeyBackPressedListener : onKeyBackPressedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_main)

    }

    override fun onBackPressed() {
        if(mOnKeyBackPressedListener != null){
            mOnKeyBackPressedListener!!.onBack()
        } else{
            super.onBackPressed()
        }

    }

    fun setOnKeyBackPressedListener(listener: onKeyBackPressedListener?) {
        mOnKeyBackPressedListener = listener;
    }



}