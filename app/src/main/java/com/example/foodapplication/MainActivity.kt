package com.example.foodapplication

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CraversApp()
        }
    }
}

@Composable
fun rememberNavController(): NavHostController {
    return rememberNavController()
}



@Composable
fun CraversApp() {
    val navController = rememberNavController()
    val viewModel = remember { CraversViewModel() }

    NavHost(navController, startDestination = "login") {
        composable("login") {
            LoginPage {
                navController.navigate("foodItems")
            }
        }
        composable("foodItems") {
            FoodItemsPage(
                nonVegItems = viewModel.nonVegItems,
                vegItems = viewModel.vegItems,
                onAddToCartClick = {
                    // Add logic to add items to cart
                },
                onNextClick = {
                    navController.navigate("cart")
                }
            )
        }
        composable("cart") {
            CartPage(cartItems = viewModel.cartItems)
        }
    }
}

@Composable
fun MyScreen() {
    CraversApp()
}

@Preview
@Composable
fun PreviewMyScreen() {
    MyScreen()
}






