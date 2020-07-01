package com.ayvytr.coroutines.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.ayvytr.coroutine.BaseActivity
import com.ayvytr.coroutines.R
import com.ayvytr.ktx.ui.hide
import com.ayvytr.ktx.ui.show
import com.ayvytr.logger.L
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {


    override fun showLoading(isShow: Boolean) {
        pb.show(isShow)
    }

//    override fun getViewModelClass(): Class<MainViewModel> {
//        return MainViewModel::class.java
//    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initData(savedInstanceState: Bundle?) {
//        mViewModel.androidAndIosLiveData.observe(this, Observer {
//            tv_value.text = it.toString()
//            tv_error.text = null
//        })

        btn_get_data.setOnClickListener {
//            mViewModel.getAndroidAndIos()
            mViewModel.getAndroidAndIosPost()
        }
//
//        mViewModel.getAndroidAndIosPost()
//
        mViewModel.androidAndIosLiveDataPost.observe(this, Observer {
            if(it.isSucceed) {
                tv_value.text = it.data.toString()
//                tv_value.text = it.toString()
                tv_error.text = null
            } else {
                tv_error.text = it.exception?.message
            }
        })
    }

    override fun showMessage(message: String) {
        super.showMessage(message)
        L.e("errorLiveData", message)
        tv_error.text = message
        pb.hide()
    }
}
