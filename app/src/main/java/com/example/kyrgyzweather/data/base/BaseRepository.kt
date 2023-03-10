package com.example.kyrgyzweather.data.base

import com.example.kyrgyzweather.common.either.Either
import kotlinx.coroutines.flow.flow
import java.io.IOException

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> T) = flow {
        try {
            emit(Either.Right(result()))
        } catch (exception: IOException) {
            emit(Either.Left(exception.message.toString()))
        }
    }
}