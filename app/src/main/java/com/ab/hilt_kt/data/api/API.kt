package com.ab.hilt_kt.data.api

import com.ab.hilt_kt.data.models.ImagesResponse
import com.ab.hilt_kt.utils.Constants.RANDOM_URL
import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET(RANDOM_URL)
    suspend fun getDog(): Response<ImagesResponse>

}