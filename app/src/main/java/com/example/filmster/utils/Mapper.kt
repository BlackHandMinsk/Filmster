package com.example.filmster.utils

interface Mapper<in E, out T> {
    fun map(from: E): T
    fun mapList(from: List<E>): List<T> = from.mapTo(mutableListOf(), ::map)
}