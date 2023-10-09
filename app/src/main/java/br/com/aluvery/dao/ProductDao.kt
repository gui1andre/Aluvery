package br.com.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.aluvery.model.Product
import br.com.aluvery.ui.sampledata.sampleProducts

class ProductDao {

    companion object {
        private val products = mutableStateListOf<Product>(*sampleProducts.toTypedArray())
    }

    fun products() = products.toList()
    fun save(product: Product) {
        products.add(product)
    }
}