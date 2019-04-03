package com.example.viewmodel_example

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mCounterViewModel: CounterViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCounterViewModel = ViewModelProviders.of(this).get(CounterViewmodel::class.java)

        displayCount()

        btnDown.setOnClickListener(this)
        btnUp.setOnClickListener(this)
        btnsend.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnUp -> {
                mCounterViewModel.Count = mCounterViewModel.Count.plus(1)
                displayCount()
            }
            R.id.btnDown -> {
                mCounterViewModel.Count = mCounterViewModel.Count.minus(1)
                displayCount()
            }
            R.id.btnsend -> {
                mCounterViewModel.User = edtUser.text.toString()
                mCounterViewModel.Pass = edtPass.text.toString()
                displayCount()
            }

        }
    }

    private fun displayCount() {
        tvCount.text = mCounterViewModel.Count.toString()
        tvgetPass.text = mCounterViewModel.Pass
        tvgetUser.text = mCounterViewModel.User
    }
}
