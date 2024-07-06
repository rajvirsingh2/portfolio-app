package com.example.portfolio.frontend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.R
import com.example.portfolio.ui.theme.dimens


val comfortaFamily = FontFamily(
    Font(R.font.comforta_bold, FontWeight.Bold),
    Font(R.font.comforta_light, FontWeight.Light),
    Font(R.font.comforta_regular, FontWeight.Normal),
)

@Composable
fun MainPage(){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        ProfileText()
        ProfilePicture()
    }
}

@Composable
fun ProfilePicture() {

    Row(
        Modifier
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.dimens.medium3,
                end = MaterialTheme.dimens.small3
            )
    ){

        Box{

            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",
                Modifier
                    .size(250.dp)
                    .offset(x = 150.dp, y = (-90).dp)
            )

            Image(painter = painterResource(id = R.drawable.luffy),
                contentDescription = "Luffy",
                Modifier
                    .size(250.dp)
                    .offset(x = 150.dp, y = (-86).dp)
                    .clip(CustomShape())
                    .clickable { }
            )

        }

    }

}

@Composable
fun ProfileText(){

    Row(Modifier.padding(start = MaterialTheme.dimens.small2)){
        Text(
            text = "Rajvir Singh",
            fontFamily = comfortaFamily,
            fontSize = 28.sp,
        )

    }

}

@Preview("DefaultPreview","null")
@Composable
fun DefaultPreview() {
    MainPage()
}