package com.example.code.local

import java.util.*

class InMemoryFavorites : Favorites {
    private val map: MutableMap<String, Boolean> = HashMap()
    override fun get(id: String): Boolean {
        val value = map[id]
        return value ?: false
    }

    override fun toggle(id: String): Boolean {
        val value = get(id)
        map[id] = !value
        return !value
    }

    fun put(id: String, value: Boolean) {
        map[id] = value
    }

    fun clear() {
        map.clear()
    }
}