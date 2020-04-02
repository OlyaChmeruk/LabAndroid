package com.example.myapplication

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class Result : Fragment() {

    companion object {
        fun newInstance(text: String, index: Int): Result{

            val args = Bundle()
            args.putString("text", text)
            args.putInt("index", index)
            val fragment = Result()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = getArguments()
        if (args != null) {
            var index = args.getInt("index", 4)
            var text = args.getString("text", "")


            val view = inflater.inflate(R.layout.fragment_result, container, false) as View
            val textField = view.findViewById(R.id.textView) as TextView

            textField.setText(text)

            when (index) {
                0 -> textField.setTypeface(Typeface.MONOSPACE)
                1 -> textField.setTypeface(Typeface.SANS_SERIF)
                2 -> textField.setTypeface(Typeface.SERIF)
                3 -> textField.setTypeface(Typeface.DEFAULT_BOLD)
                4 -> textField.setTypeface(Typeface.DEFAULT)
            }

            return view
        }

        return inflater.inflate(R.layout.fragment_result, container, false) as View

    }

}
