package com.example.jetnewsapp.presentation.about

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.jetnewsapp.designsystem.ui.theme.JetNewsAppTheme
import com.bangkit.jetnewsapp.designsystem.util.Dimens
import com.example.jetnewsapp.R

@Composable
fun ProfileScreen() {
    val profileName by remember {
        mutableStateOf("Andi")
    }
    val profileEmail by remember {
        mutableStateOf("andipriyono94@gmail.com")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Image(
                painter = painterResource(id = com.bangkit.jetnewsapp.designsystem.R.drawable.bg_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier.offset(y = 225.dp, x = 125.dp)
            ) {
                Image(
                    painter = painterResource(id = com.bangkit.jetnewsapp.designsystem.R.drawable.foto_profil),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .border(
                            BorderStroke(
                                Dimens.BorderWidth,
                                colorResource(id = R.color.peter_river)
                            ),
                            CircleShape
                        )
                        .padding(Dimens.BorderWidth)
                        .clip(CircleShape)
                )
            }
        }
        Spacer(modifier = Modifier.height(130.dp))
        Text(
            text = profileName,
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = profileEmail,
            fontSize = 16.sp,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    JetNewsAppTheme {
        ProfileScreen()
    }
}