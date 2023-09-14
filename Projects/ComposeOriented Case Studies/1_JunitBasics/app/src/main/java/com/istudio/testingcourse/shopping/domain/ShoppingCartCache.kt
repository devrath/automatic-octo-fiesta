package com.istudio.testingcourseexamples.part1.domain

import com.istudio.testingcourse.shopping.domain.Product

interface ShoppingCartCache {
    fun saveCart(items: List<Product>)
    fun loadCart(): List<Product>
    fun clearCart()
}