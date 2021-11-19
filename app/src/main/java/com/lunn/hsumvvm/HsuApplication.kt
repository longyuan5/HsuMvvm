package com.lunn.hsumvvm

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import com.lunn.common.UtilCommon

/**
 * @author mac
 * @date 2021/6/18
 * @description
 * @note
 */

class HsuApplication : Application() {

    override fun onCreate() {
        initStrictMode()
        super.onCreate()
        UtilCommon.init(this, BuildConfig.DEBUG)

    }


    private fun initStrictMode() {
        if (BuildConfig.DEBUG) {
            val threadPolicyBuilder = StrictMode.ThreadPolicy.Builder()
            threadPolicyBuilder.detectAll()
            threadPolicyBuilder.penaltyLog()
            StrictMode.setThreadPolicy(threadPolicyBuilder.build())

            val vmPolicyBuilder = VmPolicy.Builder()
            vmPolicyBuilder.detectAll()
            vmPolicyBuilder.penaltyLog()
            StrictMode.setVmPolicy(vmPolicyBuilder.build())
        }
    }


}