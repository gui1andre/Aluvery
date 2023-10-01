import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.aluvery.model.Product
import br.com.aluvery.ui.components.CardProductItem
import br.com.aluvery.ui.components.ProductsSection
import br.com.aluvery.ui.components.SearchTextField
import br.com.aluvery.ui.sampledata.sampleProducts
import br.com.aluvery.ui.sampledata.sampleSections
import br.com.aluvery.ui.theme.AluveryTheme


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>, searchText: String = ""
) {
    var text by remember {
        mutableStateOf(searchText)
    }
    var searchedProducts = remember(text) {
        if (text.isNotBlank()) {
            sampleProducts.filter {
                it.name.contains(text, ignoreCase = true) || it.description?.contains(
                    searchText,
                    ignoreCase = true
                ) ?: false
            }
        } else emptyList()
    }
    Column {
        SearchTextField(searchText = searchText, onSearchChange = {
            text = it
        })
        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (text.isBlank()) {
                item {
                    for (section in sections) {
                        ProductsSection(title = section.key, products = section.value)
                    }
                }
            } else {
                items(searchedProducts) {
                    CardProductItem(
                        product = it,
                        Modifier.padding(horizontal = 16.dp),
                    )

                }
            }


        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenSearchtextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections, searchText = "ham")
        }
    }
}
