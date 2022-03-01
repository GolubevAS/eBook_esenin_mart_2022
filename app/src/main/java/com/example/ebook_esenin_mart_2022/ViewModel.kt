package com.example.ebook_esenin_mart_2022

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class ViewModel (application: Application) : AndroidViewModel(application) {


    val context = application
    val myArray = arrayOf(
        R.string.myArray1,
        R.string.myArray2,
        R.string.myArray3
    )


    //мы по клику переходим на следующий элемент массива
    fun onNextPageListener() {
        val pageFragment = PageFragment.newInstance(
            context.applicationContext
                .resources.getString(myArray[1])
        )
        supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(R.id.fragment_container, pageFragment)
            ?.commit()
    }

    //мы по клику переходим на предыдущий элемент массива
    fun onBackPageListener() {
        TODO("Not yet implemented")
    }

    // клик по содержанию книги (на первых стих)
    fun onPageOne() {
        val messageFragment = PageFragment.newInstance(myArray[0].toString())
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_middle, messageFragment)
            .commit()
    }

    // клик по содержанию книги (на второй стих)
    fun onPageTwo() {
        val messageFragment = PageFragment.newInstance(myArray[1].toString())
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_middle, messageFragment)
            .commit()
    }

    // клик по содержанию книги (на третий стих)
    fun onPageThree() {
        val messageFragment = PageFragment.newInstance(myArray[2].toString())
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_middle, messageFragment)
            .commit()
    }


}