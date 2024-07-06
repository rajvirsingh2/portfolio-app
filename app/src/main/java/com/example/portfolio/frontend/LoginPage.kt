@file:Suppress("DEPRECATION", "UNUSED_EXPRESSION")

package com.example.portfolio.frontend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portfolio.R
import com.example.portfolio.ui.theme.Blue
import com.example.portfolio.ui.theme.dimens
import java.util.regex.Pattern

@Composable
fun LoginPage(navController: NavController){
    Surface{
        LazyColumn(Modifier.fillMaxSize()){
            item{
                Greeting()
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))

                Column(modifier = Modifier
                    .padding(horizontal = 32.dp)) {

                    Email()

                    Spacer(modifier = Modifier.height(MaterialTheme.dimens.extraSmall))
                }

                RememberUser()

                Spacer(modifier = Modifier.height(MaterialTheme.dimens.extraSmall))

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)){

                    ContinueButton()

                    Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))
                    //OR
                    Text(text = "OR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally))


                    Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))

                    GoogleSignIn()

                    Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))

                    FacebookSignIn()

                    Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))

                    CreateAccount(navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(){
    Column(
        modifier =
        Modifier
            .padding(start = 30.dp, top = MaterialTheme.dimens.medium2)
            .fillMaxWidth(0.9f)
    ) {

        Text(
            text = "WELCOME BACK",
            fontSize = 20.sp
        )

        Text(
            text = "Login to your Account",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(){
    val emailText = remember {
        mutableStateOf("")
    }

    val passwordText = remember {
        mutableStateOf("")
    }

    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    val errorMessage = remember {
        mutableStateOf("")
    }
    Column{
        //Email
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = {
                Icon(Icons.Filled.Email, contentDescription = "email")
            },
            value = emailText.value,
            onValueChange = {
                emailText.value = it
            },
            label = {
                Text(
                    text = "Email",
                    fontSize = 18.sp
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White.copy(.2f),
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.DarkGray,
                focusedLabelColor = Color.Black.copy(.9f),
                unfocusedLabelColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        //Password
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = passwordText.value,
            onValueChange = {
                passwordText.value = it
                errorMessage.value = validatePassword(it)
            },
            label = {
                Text(
                    text = "Password",
                    fontSize = 18.sp
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White.copy(.2f),
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.DarkGray,
                focusedLabelColor = Color.Black.copy(.9f),
                unfocusedLabelColor = Color.Gray
            ),
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisibility.value)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(
                        imageVector = image,
                        contentDescription = "show password"
                    )
                }
            })
        if(errorMessage.value.isNotEmpty()){
            Text(
                text = errorMessage.value,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 40.dp)
            )
        }
    }
}

@Composable
fun RememberUser() {
    val checked = remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    ) {
        // Remember Me
        Checkbox(
            checked = checked.value,
            onCheckedChange = {
                checked.value = it
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Transparent,
                checkmarkColor = Color.Green
            )
        )
        Text(
            text = "Remember Me",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 15.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Forgot Password
        Text(
            text = "Forgot Password?",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 14.dp, end = MaterialTheme.dimens.forgotPadding)
        )
    }
}


@Composable
fun ContinueButton(){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        )) {
        Text(text = "Continue")
    }
}

@Composable
fun GoogleSignIn() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight)
            .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable {  }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google), // Replace with your Google icon resource
                contentDescription = "Google",
                modifier = Modifier.size(26.dp)
            )

            Spacer(modifier = Modifier.width(MaterialTheme.dimens.medium2))
        }

        Text(
            text = "Continue with Google",
            color = Color.DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun FacebookSignIn() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight)
            .border(2.dp, color = Blue, RoundedCornerShape(8.dp))
            .background(color = Blue, RoundedCornerShape(8.dp))
            .clickable { /* TODO */ }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook",
                modifier = Modifier.size(26.dp)
            )

            Spacer(modifier = Modifier.width(MaterialTheme.dimens.medium2))
        }

        Text(
            text = "Continue with Facebook",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun CreateAccount(navController: NavController){
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Center){
        Text(text = "Don't have an account?",
            fontSize = 18.sp,
            modifier = Modifier)

        Text(text = "Sign Up",
            textDecoration = TextDecoration.Underline,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable {
                    navController.navigate("SignupPage") {
                        popUpTo("LoginPage") {
                            inclusive = true
                        }
                    }
                })
    }
}

fun validatePassword(password: String): String{
    val uppercasePattern = Pattern.compile(".*[A-Z].*")
    val digitPattern = Pattern.compile(".*\\d.*")
    val specialCharPattern = Pattern.compile(".*[!@#$%^&*()].*")

    return when{
        password.length < 8 -> "Password must be at least 8 characters long."
        !uppercasePattern.matcher(password).matches() -> "Password must contain at least one uppercase letter."
        !digitPattern.matcher(password).matches() -> "Password must contain at least one digit."
        !specialCharPattern.matcher(password).matches() -> "Password must contain at least one special character."
        else -> ""
    }
}

fun validateName(name: String): String {
    return if (name.isEmpty()) "Name is required" else ""
}

fun validateEmail(email: String): String {
    return if (email.isEmpty()) {
        "Email is required"
    } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        "Invalid email address"
    } else {
        ""
    }
}