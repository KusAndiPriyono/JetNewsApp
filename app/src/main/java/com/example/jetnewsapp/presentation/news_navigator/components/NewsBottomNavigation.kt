package com.example.jetnewsapp.presentation.news_navigator.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.jetnewsapp.designsystem.ui.theme.JetNewsAppTheme
import com.example.jetnewsapp.R
import com.bangkit.jetnewsapp.designsystem.util.Dimens

@Composable
fun NewsBottomNavigation(
    items: List<BottomNavigationItem>, selectedItem: Int, onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = colorResource(id = R.color.peter_river),
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = { onItemClick(index) },
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(Dimens.IconSize)
                        )
                        Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))
                        Text(text = item.text, style = MaterialTheme.typography.labelSmall)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = colorResource(id = R.color.white),
                    unselectedTextColor = colorResource(id = R.color.white),
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    }
}

data class BottomNavigationItem(
    @DrawableRes val icon: Int, val text: String
)

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NewsBottomNavigation() {
    JetNewsAppTheme(dynamicColor = false) {
        NewsBottomNavigation(
            items = listOf(
                BottomNavigationItem(
                    icon = com.bangkit.jetnewsapp.designsystem.R.drawable.ic_home,
                    text = "Home"
                ),
                BottomNavigationItem(
                    icon = com.bangkit.jetnewsapp.designsystem.R.drawable.ic_search,
                    text = "Search"
                ),
                BottomNavigationItem(
                    icon = com.bangkit.jetnewsapp.designsystem.R.drawable.ic_bookmark,
                    text = "Bookmark"
                ),
                BottomNavigationItem(
                    icon = com.bangkit.jetnewsapp.designsystem.R.drawable.ic_person_24,
                    text = "About"
                )
            ), selectedItem = 0, onItemClick = {})
    }
}