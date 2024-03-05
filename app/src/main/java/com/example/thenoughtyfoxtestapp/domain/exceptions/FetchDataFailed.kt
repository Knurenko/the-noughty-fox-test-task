package com.example.thenoughtyfoxtestapp.domain.exceptions

/**
 * @author Knurenko Bogdan 05.03.2024
 */
sealed class FetchDataFailed : Throwable() {
    data object NoInternetConnection: FetchDataFailed()
    data object RequestTooLong: FetchDataFailed()
    data class UnexpectedException(val exception: Exception) : FetchDataFailed()
}