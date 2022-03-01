package com.example.ebook_esenin_mart_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class PageFragment : Fragment() {

    val viewModel = ViewModelProvider(this).get(ViewModel::class.java)


    companion object {
        private val KEY_TEXT = "Special text"

        fun newInstance(text: String): PageFragment {
            val fragment = PageFragment()
            val args: Bundle = Bundle()

            args.putString(KEY_TEXT, text)
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_page, container, false)
        val textView = view.findViewById<TextView>(R.id.text_view_fragment)
        val message = arguments?.getString(KEY_TEXT)
        textView.text = message

        //нажимаем на кнопку "Вперед"
        val buttonNext = view.findViewById<Button>(R.id.button_next)
        buttonNext.setOnClickListener { v ->
            viewModel.onNextPageListener()
        }

        //нажимаем на кнопку "Назад"
        val buttonBack = view.findViewById<Button>(R.id.button_back)
        buttonBack.setOnClickListener { v ->
            viewModel.onBackPageListener()
        }

        return view
    }


}