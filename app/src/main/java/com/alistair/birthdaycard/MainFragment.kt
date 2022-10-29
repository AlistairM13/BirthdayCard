package com.alistair.birthdaycard

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText

class MainFragment : Fragment() {

    lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val birthdayDude = view.findViewById<TextInputEditText>(R.id.etBirthdayDude)
        val fromDude = view.findViewById<TextInputEditText>(R.id.etFromDude)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button).setOnClickListener{
            if(!TextUtils.isEmpty(birthdayDude.text.toString()) || !TextUtils.isEmpty(fromDude.text.toString())){
                val bundle = bundleOf("birthdayDude" to birthdayDude.text.toString(), "fromDude" to fromDude.text.toString())
                navController.navigate(R.id.action_mainFragment_to_cardFragment, bundle)
            }else{
                Toast.makeText(context, "Please fill both the fields", Toast.LENGTH_SHORT).show();
            }

        }
    }

}