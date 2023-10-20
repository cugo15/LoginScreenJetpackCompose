package com.cugocumhurgunay.loginscreenjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants.IterateForever
import com.airbnb.lottie.compose.rememberLottieComposition
import com.cugocumhurgunay.loginscreenjetpackcompose.ui.theme.LoginScreenJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenJetpackComposeTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginPage()
                }
            }
        }
    }
}

@Composable
fun LoginPage() {
    Surface(color = MaterialTheme.colorScheme.background){
        val tfUserName = remember { mutableStateOf("") }
        val tfPassword = remember { mutableStateOf("") }
        val email = "cumhur@gmail.com"
        val password = "123456"
        val context = LocalContext.current
        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally){
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.girisfood))
            Box(
                modifier = Modifier
                    .size(350.dp)
                    .background(Color.Transparent)
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = IterateForever,
                    modifier = Modifier.fillMaxSize()
                )

                Text(
                    text = "YEMEK KAPIMDA",
                    color = colorResource(id = R.color.orange),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(0.dp, 55.dp)
                )
            }

            OutlinedTextField(
                value = tfUserName.value,
                onValueChange = {tfUserName.value = it},
                label = { Text(text = "E-mail")},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp)

            )
            OutlinedTextField(
                value = tfPassword.value,
                onValueChange = {tfPassword.value = it},
                label = { Text(text = "Şifre")},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            Button(

                onClick = {
                    if (tfUserName.value == email && tfPassword.value == password) {
                        Toast.makeText(context,"Giriş Başarılı",Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(context,"E-mail ve Şifre birbirleriyle uyuşmuyor",Toast.LENGTH_SHORT).show()
                    }
                          },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.orange),
                    contentColor = Color.White,

                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp)
                    .background(
                        shape = RoundedCornerShape(10.dp),
                        color = colorResource(id = R.color.orange)
                    )

            ) {
                Text(
                    text = "Giriş Yap",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold

                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreenJetpackComposeTheme {
        LoginPage()
    }
}