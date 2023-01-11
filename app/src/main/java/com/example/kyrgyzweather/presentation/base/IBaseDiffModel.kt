package com.example.kyrgyzweather.presentation.base

interface IBaseDiffModel<T> {
    val name: T
    override fun equals(other: Any?): Boolean
}