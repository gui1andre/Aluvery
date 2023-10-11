package br.com.aluvery.ui.states

import br.com.aluvery.model.Product

data class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchText: String = "",
    val searchedProducts: List<Product> = emptyList(),
    val onSearchChange: (String) -> Unit = {}
) {
    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }
}