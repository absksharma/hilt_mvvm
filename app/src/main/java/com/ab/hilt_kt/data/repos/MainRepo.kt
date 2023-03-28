package com.ab.hilt_kt.data.repos

import com.ab.hilt_kt.data.api.API
import javax.inject.Inject

class MainRepo @Inject constructor(private val api: API) {

    suspend fun getData() = api.getDog()
}