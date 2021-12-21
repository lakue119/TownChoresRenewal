package com.lakue.townchoresrenewal.util

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDialog
import com.lakue.townchoresrenewal.R
import com.lakue.townchoresrenewal.base.BaseActivity
import com.lakue.townchoresrenewal.extention.isAvailableActivity

object LoadingDialog {

    var loadingDialog: AppCompatDialog? = null
    private const val TIME_OUT = 30000

    fun showLoading(activity: BaseActivity<*,*>){
        activity.isAvailableActivity{
            if(loadingDialog != null && loadingDialog?.isShowing!!){
                return@isAvailableActivity
            } else {
                loadingDialog = AppCompatDialog(activity).apply{
                    setCancelable(false)
                    window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    setContentView(R.layout.progress_loading)
                    show()
                }
            }
            Handler(Looper.getMainLooper()).postDelayed({
                //여기에 딜레이 후 시작할 작업들을 입력
                hideLoading(activity)
            }, TIME_OUT.toLong())// 0.5초 정도 딜레이를 준 후 시작
        }
    }

    fun hideLoading(activity: BaseActivity<*,*>){
        activity.isAvailableActivity{
            try{
                if(loadingDialog != null && loadingDialog?.isShowing!!){
                    loadingDialog?.dismiss()
                }
            } catch (e: Exception){

            }
        }
    }

    fun isLoading():Boolean{
        return loadingDialog?.isShowing!!
    }
}