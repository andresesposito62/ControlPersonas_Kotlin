package com.miapp.controlpersonas_kotlin.login

import android.os.Handler
import android.text.TextUtils

class LoginInteractor {

    interface OnLoginFinishedListener{
        fun onUsernameError()

        fun onPasswordError()

        fun onSuccess()
    }

    fun login(username: String?, password: String?, listener: OnLoginFinishedListener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        Handler().postDelayed({
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError()
                return@postDelayed
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError()
                return@postDelayed
            }
            listener.onSuccess()
        }, 2000)
    }
}