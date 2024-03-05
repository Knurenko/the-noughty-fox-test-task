package com.example.thenoughtyfoxtestapp.domain.exceptions

/**
 * @author Knurenko Bogdan 05.03.2024
 */
sealed class FetchFailureReason : Throwable() {
    data object NoInternetConnection: FetchFailureReason()
    data object RequestTooLong: FetchFailureReason()
    data class UnexpectedException(val exception: Exception) : FetchFailureReason()
}