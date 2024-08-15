package com.technical.test.smartpayment.api.util

import okhttp3.Interceptor
import okhttp3.Response

object ApiServiceInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println(request.url())
        val requestBuilder = request.newBuilder()
        return chain.proceed(requestBuilder.build())
    }
}