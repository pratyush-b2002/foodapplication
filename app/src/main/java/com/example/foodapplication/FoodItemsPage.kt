package com.example.foodapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FoodItemsPage(
    nonVegItems: List<FoodItem>,
    vegItems: List<FoodItem>,
    onAddToCartClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Non-Veg Items", style = MaterialTheme.typography.headlineMedium)
        FoodItemList(nonVegItems, onAddToCartClick)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Veg Items", style = MaterialTheme.typography.headlineMedium)
        FoodItemList(vegItems, onAddToCartClick)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onNextClick() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun FoodItemList(items: List<FoodItem>, onAddToCartClick: () -> Unit) {
    Column {
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Add code to display food item image here
                Text(text = item.name, modifier = Modifier.weight(1f))
                Text(text = "$${item.price}", modifier = Modifier.padding(end = 16.dp))
                Button(
                    onClick = { onAddToCartClick() },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Add to Cart")
                }
            }
        }
    }
}
