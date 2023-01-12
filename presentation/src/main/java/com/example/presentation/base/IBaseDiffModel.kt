package com.example.presentation.base

interface IBaseDiffModel<T> {
    val name: T
    override fun equals(other: Any?): Boolean
}