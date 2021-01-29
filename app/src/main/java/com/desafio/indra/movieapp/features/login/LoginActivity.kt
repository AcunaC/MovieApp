package com.desafio.indra.movieapp.features.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.desafio.indra.movieapp.R
import com.desafio.indra.movieapp.databinding.ActivityLoginBinding
import com.desafio.indra.movieapp.features.movies.MoviesActivity
import com.desafio.indra.movieapp.util.Event
import com.desafio.indra.movieapp.util.EventObserver
import com.desafio.indra.movieapp.util.openActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.vm = viewModel


        viewModel.formErrors.observe(this, EventObserver(::handleErrors))

        viewModel.navigateToLogin.observe(this, EventObserver {
            openActivity(MoviesActivity::class.java)
            finish()
        })

        setContentView(binding.root)
    }

    private fun handleErrors(errors: Map<Int, Int>) {
        errors.entries.forEach { entry ->
            when (entry.key) {
                USERNAME_FIELD_CODE -> {
                    binding.inputLayoutUsername.error = getString(entry.value)
                }
                PASSWORD_FIELD_CODE -> {
                    binding.inputLayoutPassword.error = getString(entry.value)
                }
            }
        }

    }
}