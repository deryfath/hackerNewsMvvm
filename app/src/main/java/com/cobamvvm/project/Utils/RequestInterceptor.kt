package com.cobamvvm.project.Utils

import com.cobamvvm.project.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()
        val newRequest = request?.newBuilder()

        //get the token
        try {
            newRequest?.addHeader("Accept", "application/json")
            newRequest?.addHeader("Authorization", BuildConfig.AUTH_BEARER)

        } catch (ex: Throwable) {
            print(ex)
        }

        return chain?.proceed(newRequest!!.build())!!
    }
}