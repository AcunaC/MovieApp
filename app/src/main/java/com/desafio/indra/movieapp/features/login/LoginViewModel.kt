package com.desafio.indra.movieapp.features.login

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.None
import com.desafio.indra.movieapp.R
import com.desafio.indra.movieapp.features.login.LoginFailure.PasswordInvalid
import com.desafio.indra.movieapp.features.login.LoginFailure.UsernameNotFound
import com.desafio.indra.movieapp.util.Event
import com.desafio.indra.movieapp.util.toEvent
import com.desafio.indra.usecases.ValidUser
import com.desafio.indra.usecases.ValidUser.Request
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

const val USERNAME_FIELD_CODE = 1
const val PASSWORD_FIELD_CODE = 2

@HiltViewModel
class LoginViewModel @Inject constructor(private val validUser: ValidUser) : ViewModel() {

    val loading = ObservableBoolean()

    val usernameText = MutableLiveData<String>("Admin")
    val passwordText = MutableLiveData<String>("Password*123")

    private val _formErrors = MutableLiveData<Event<Map<Int, Int>>>()
    val formErrors: LiveData<Event<Map<Int, Int>>> get() = _formErrors

    private val _toastMessage = MutableLiveData<Event<Int>>()
    val toastMessage: LiveData<Event<Int>> get() = _toastMessage

    private val _navigateToLogin = MutableLiveData<Event<None>>()
    val navigateToLogin: LiveData<Event<None>> get() = _navigateToLogin

    fun onLoginClick() {
        viewModelScope.launch {
            val errors = findFormErrors()
            if (errors.isEmpty()) {
                loading.set(true)
                delay(900)
                validUser(Request(usernameText.value!!, passwordText.value!!)) {
                    it.fold(::handleFailure, ::handleSuccess)
                }
                loading.set(false)
            } else {
                _formErrors.value = errors.toEvent()
            }
        }
    }

    private fun handleFailure(failure: Failure) {
        val errors = when (failure) {
            is UsernameNotFound -> mapOf(USERNAME_FIELD_CODE to R.string.username_not_registered)
            is PasswordInvalid -> mapOf(PASSWORD_FIELD_CODE to R.string.invalid_password)
            else -> null
        }

        if (errors != null) {
            _formErrors.value = errors.toEvent()
        } else {
            _toastMessage.value = (R.string.unknown_error).toEvent()
        }

    }

    private fun handleSuccess(none: None) {
        _navigateToLogin.value = None().toEvent()
    }


    private fun findFormErrors(): Map<Int, Int> {
        val errors = mutableMapOf<Int, Int>()
        if (usernameText.value.isNullOrBlank()) {
            errors[USERNAME_FIELD_CODE] = R.string.must_enter_username
        }
        if (passwordText.value.isNullOrBlank()) {
            errors[PASSWORD_FIELD_CODE] = R.string.must_enter_password
        }
        return errors
    }

}