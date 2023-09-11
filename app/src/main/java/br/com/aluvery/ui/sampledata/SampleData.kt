package br.com.aluvery.ui.sampledata

import br.com.aluvery.R
import br.com.aluvery.model.Product
import java.math.BigDecimal

val sampleProducts = listOf<Product>(

    Product(
        name = "Hamburguer", price = BigDecimal("12.99"), image = R.drawable.burger
    ),

    Product(
        name = "Pizza", price = BigDecimal("19.99"), image = R.drawable.pizza
    ),

    Product(
        name = "Batata frita", price = BigDecimal("7.99"), image = R.drawable.fries
    ),
)