package org.techtown.economyproject

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import org.techtown.economyproject.databinding.FragmentKospiBinding

class KospiFragment : Fragment() , onKeyBackPressedListener {

    lateinit var binding :FragmentKospiBinding


    var url = "https://finance.naver.com/sise/sise_index.nhn?code=KPI200"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKospiBinding.inflate(layoutInflater, container , false)
        binding.webView.apply{
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        binding.webView.loadUrl(url)

        return binding.root
    }

    override fun onBack() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack();
        } else {
            val activity =  activity as MainActivity
            activity.setOnKeyBackPressedListener(null);
            activity.onBackPressed();
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity = activity as MainActivity
        activity.setOnKeyBackPressedListener(this)
    }
    
}
