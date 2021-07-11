package com.example.code.local

interface Favorites {
    operator fun get(id: String): Boolean
    fun toggle(id: String): Boolean
}