package br.com.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.aluvery.R
import br.com.aluvery.extensions.toBrazilianCurrency
import br.com.aluvery.model.Product
import br.com.aluvery.ui.sampledata.sampleProducts
import br.com.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage


@Composable
fun CardProductItem(
    product: Product,
    elevation: Dp = 4.dp
) {
    Card(
        Modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        ),
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
            // TODO: adicionar descrição do produto
            // Text(
            //     text = product.description,
            //     Modifier
            //         .padding(16.dp)
            // )
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
            )
        }
    }
}