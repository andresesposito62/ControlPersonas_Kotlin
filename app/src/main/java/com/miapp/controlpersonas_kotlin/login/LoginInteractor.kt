package com.miapp.controlpersonas_kotlin.login

import android.os.Handler
import android.text.TextUtils
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.coroutines.CoroutineScope

class LoginInteractor {

    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    fun login(username: String, password: String, listener: OnLoginFinishedListener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        postDelayed(2000) {
            when {
                username.isEmpty() -> listener.onUsernameError()
                password.isEmpty() -> listener.onPasswordError()
                else -> listener.onSuccess()
            }
        }
    }

    fun postDelayed(delayMillis: Long, task: () -> Unit) {
        Handler().postDelayed(task, delayMillis)
    }


}