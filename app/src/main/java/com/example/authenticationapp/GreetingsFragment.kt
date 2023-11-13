package com.example.authenticationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.authenticationapp.databinding.FragmentGreetingsBinding

private const val LOGIN_PARAM = "login"

class MainFragment : Fragment() {
    private var login: String? = null

    private lateinit var binding: FragmentGreetingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            login = it.getString(LOGIN_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGreetingsBinding.inflate(inflater, container, false)
        binding.helloMessage.setText("Hello, $login")
        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_authFragment)
        }

        return binding.root
    }
}
