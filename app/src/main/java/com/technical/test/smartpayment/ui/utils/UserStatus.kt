package com.technical.test.smartpayment.ui.utils

sealed class UserStatus<T> {
    class Exists<T> : UserStatus<T>()

    class NoExists<T> : UserStatus<T>()
}