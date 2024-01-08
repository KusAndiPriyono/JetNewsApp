package com.bangkit.jetnewsapp.home.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bangkit.jetnewsapp.database.model.Article
import com.bangkit.jetnewsapp.database.model.Source
import com.bangkit.jetnewsapp.designsystem.ui.theme.JetNewsAppTheme
import com.bangkit.jetnewsapp.designsystem.util.DateFormatter

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier, article: Article, onClick: (() -> Unit)? = null
) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .clickable { onClick?.invoke() }
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context).data(article.urlToImage).build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = com.bangkit.jetnewsapp.designsystem.R.drawable.ic_time),
                    contentDescription = null,
                    tint = colorResource(id = com.bangkit.jetnewsapp.designsystem.R.color.text_medium),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    Text(
                        text = DateFormatter.formatDate(
                            currentDateString = article.publishedAt,
                            targetTimeZone = "Asia/Jakarta"
                        ),
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(id = com.bangkit.jetnewsapp.designsystem.R.color.text_medium),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    JetNewsAppTheme(dynamicColor = false) {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2021-09-12T09:00:00Z",
                source = Source(id = "", name = "BBC"),
                title = "broken heart",
                url = "",
                urlToImage = ""
            )
        )
    }
}