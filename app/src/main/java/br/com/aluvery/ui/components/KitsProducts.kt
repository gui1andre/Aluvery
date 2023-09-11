import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.aluvery.R
import br.com.aluvery.ui.theme.Purple500
import br.com.aluvery.ui.theme.Teal200

@Composable
fun KitsProducts() {
    Surface(
        shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp
    ) {
        Row(
            Modifier
                .height(200.dp)
                .width(350.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Descrição do produto",
                    Modifier
                        .offset(x = 50.dp, y = (-50).dp)
                        .size(100.dp)
                        .border(
                            BorderStroke(2.dp, Purple500), CircleShape
                        )
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)

                )
            }
            Text(
                text = LoremIpsum(50).values.first(),
                Modifier
                    .padding(32.dp)
                    .padding(start = 32.dp),
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 6
            )
        }
    }
}