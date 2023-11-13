package com.example.authenticationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.authenticationapp.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {
    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)

        binding.submitBtn.setOnClickListener {
            val login = binding.loginInput.text.toString()
            val pass = binding.passwordInput.text.toString()

            if (login == "starling" && pass == "12345") {
                val bundle = Bundle()
                bundle.putString("login", login)
                findNavController().navigate(R.id.action_authFragment_to_mainFragment, bundle)
            } else {
                Toast.makeText(context, "Incorrect login or password", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}
