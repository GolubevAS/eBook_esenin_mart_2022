package com.example.ebook_esenin_mart_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider


class MainFragment : Fragment() {

    val viewModel = ViewModelProvider(this).get(ViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val messageFragment = PageFragment.newInstance(
            viewModel.myArray[0].toString()
        )
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.add(R.id.fragment_container_middle, messageFragment)
            ?.commit()
    }


}