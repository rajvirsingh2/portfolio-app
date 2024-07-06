package com.example.portfolio.frontend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.R

@Composable
fun HomePage(){

    val profileImage = remember {
        mutableIntStateOf(R.drawable.pfp)
    }

    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Box(modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth()
        ){
            Image(painter = painterResource(id = profileImage.intValue),
                contentDescription = "Profile Image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(7.dp))
                    .fillMaxSize()
            )
            Card(modifier = Modifier
                .fillMaxHeight(),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.black)
                )) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage()
}