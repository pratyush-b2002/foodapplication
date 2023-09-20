package com.example.foodapplication

import androidx.lifecycle.ViewModel

data class FoodItem(val name: String, val price: Double)

data class CartItem(val foodItem: FoodItem, val quantity: Int)

class CraversViewModel : ViewModel() {
    val nonVegItems = listOf(
        FoodItem("Chicken Burger", 5.99),
        // Add more non-veg items
    )

    val vegItems = listOf(
        FoodItem("Veggie Burger", 4.99),
        // Add more veg items
    )

    val cartItems = mutableListOf<CartItem>()

    // Add methods to add items to cart, calculate total, etc.
}