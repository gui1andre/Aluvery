package br.com.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.aluvery.dao.ProductDao
import br.com.aluvery.model.Product
import br.com.aluvery.ui.sampledata.sampleCandies
import br.com.aluvery.ui.sampledata.sampleDrinks
import br.com.aluvery.ui.sampledata.sampleProducts
import br.com.aluvery.ui.states.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDao()
    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(HomeScreenUiState())
    val uiState get() = _uiState.asStateFlow()


    init {

        _uiState.update {
            it.copy(onSearchChange = {
                _uiState.value = _uiState.value.copy(
                    searchText = it, searchedProducts = searchedProducts(it)

                )
            })
        }
        viewModelScope.launch {
            dao.products().collect {
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "Todos produtos" to it,
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks
                    ), searchedProducts = searchedProducts(_uiState.value.searchText)
                )
            }
        }
    }

    private fun containsInNameOrDescription(text: String) = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) || product.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }

    private fun searchedProducts(text: String): List<Product> = if (text.isNotBlank()) {
        sampleProducts.filter(containsInNameOrDescription(text)) + dao.products().value.filter(
            containsInNameOrDescription(text)
        )
    } else emptyList()
}