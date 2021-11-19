package com.lunn.hsumvvm.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hi.dhl.binding.viewbind
import com.lunn.hsumvvm.R
import com.lunn.hsumvvm.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment) {

    private val binding: MainFragmentBinding by viewbind()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        binding.message.text = "我是测试"
    }


}