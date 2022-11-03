package com.lunn.common.util

import android.app.Application
import android.content.Context
import java.util.*

/**
 * @author mac
 * @date 2021/6/18
 * @description
 * @note
 */
class UtilCommon private constructor() {

    companion object {
        var application: Application? = null
            private set
        var baseUrl: String = ""
        var isDebug: Boolean = true
            private set
        private var onInitActionList: MutableList<OnInitAction>? = null

        /**
         * 添加在Application中初始化的action
         */
        fun addOnInitAction(onInitAction: OnInitAction) {
            if (onInitActionList == null) {
                onInitActionList = ArrayList()
            }
            onInitActionList?.add(onInitAction)
        }

        /**
         * 初始化工具类
         * @param isDebug 是否是调试模式
         */
        fun init(application: Application, isDebug: Boolean) {
            Companion.application = application
            Companion.isDebug = isDebug
            if (!onInitActionList.isNullOrEmpty()) {
                for (onInitAction in onInitActionList!!) {
                    onInitAction.onAppInit(application)
                }
            }
        }
    }

}

interface OnInitAction {

    /**
     * app初始化时的逻辑
     *
     * @param context
     */
    fun onAppInit(context: Context?)

}
