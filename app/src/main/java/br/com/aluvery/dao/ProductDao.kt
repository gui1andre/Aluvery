package br.com.aluvery.dao

import br.com.aluvery.ui.sampledata.sampleProducts

class ProductDao {

    companion object {
        private val products = sampleProducts.toMutableList()
    }

    fun products() = products.toList()
}