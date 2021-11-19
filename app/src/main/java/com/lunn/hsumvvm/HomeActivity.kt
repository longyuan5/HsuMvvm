package com.lunn.hsumvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hi.dhl.binding.viewbind
import com.lunn.hsumvvm.databinding.MainActivityBinding
import com.lunn.hsumvvm.ui.main.MainFragment

class HomeActivity : AppCompatActivity() {

    val binding: MainActivityBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, MainFragment.newInstance()).commitNow()
        }
    }


}