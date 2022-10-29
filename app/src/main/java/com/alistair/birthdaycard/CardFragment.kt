package com.alistair.birthdaycard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import java.lang.ProcessBuilder.Redirect.to

class CardFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var birthdayDude : String
    lateinit var fromDude : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        birthdayDude = requireArguments().getString("birthdayDude")!!
        fromDude = requireArguments().getString("fromDude")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tvBirthdayDude).text = getString(R.string.HappyBirthday, birthdayDude)
        view.findViewById<TextView>(R.id.tvFromDude).text = getString(R.string.From,fromDude)
    }
}