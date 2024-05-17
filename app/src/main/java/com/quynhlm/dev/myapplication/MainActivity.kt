package com.quynhlm.dev.myapplication

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.TextButton
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quynhlm.dev.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.TextField
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.input.KeyboardType
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     //Content
                    HomeScreen()
//                    ExampleSlide3()
                }
            }
        }
    }
}

@Composable
fun BannerCompose(contentScale: ContentScale){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        modifier = Modifier
            .size(100.dp)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(5.dp)),
        contentScale = ContentScale.FillBounds, // contentScale is used to scale the content inside Image
        contentDescription = "Banner"
    )
    Spacer(modifier = Modifier.height(12.dp))
//    VectorImageComponent()
    CircleAvatar()
}

@Composable
fun VectorImageComponent(){
//    Image(imageVector = Icons.Filled.Person, contentDescription = "Person")
    AsyncImage(
        model = "https://example.com/image.jpg",
        contentDescription = null,
    )
}


@Composable
fun GettingTitle(msg : String){
    Text(text = "Hello " + msg,
        modifier = Modifier
            .padding(0.dp, 16.dp)
            .fillMaxWidth(),
        color = Color.Magenta,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .padding(0.dp, 16.dp)
            .fillMaxWidth(),
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Cursive
    )
}

@Composable
fun HomeScreen() {

    val checkedState = remember { mutableStateOf(false) }

    Column (modifier = Modifier.padding(24.dp)) {
//        GettingText()
//        Spacer(modifier = Modifier.height(13.dp))
//        MultipleStylesText()
        BannerCompose(ContentScale.Fit)

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Click me", color = Color.White)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = "Work 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = "Work 2")
        }
        Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically){
                RadioButton(selected = false, onClick = { /*TODO*/ })
                Text(text = "Male")
            }
            Row(verticalAlignment = Alignment.CenterVertically){
                RadioButton(selected = false, onClick = { /*TODO*/ })
                Text(text = "FeMale")
            }
        }
        TextField(value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(
            text = "Input your name"
        )},singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text))
        Image(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ){
            Text(text = "Item 1")
            Text(text = "Item 2")
            Text(text = "Item 3")
        }
    }
}
@Composable
fun ExampleSlide3(){
    Column(modifier = Modifier.fillMaxSize()) {
        Greeting("Lê Mạnh Quỳnh - Ph32353")
        GettingCart(msg = "Hello")
        CounterCard()
        GettingTitle("Lê Mạnh Quỳnh")
    }
}
@Composable
fun CircleAvatar(){
    Box(
        modifier = Modifier
            .size(100.dp) // Đặt kích thước cho ảnh đại diện
            .clip(CircleShape)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(8.dp))// Cắt ảnh thành hình tròn
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Cắt ảnh để lấp đầy hình tròn
            modifier = Modifier.clip(CircleShape) // Cắt ảnh thành hình tròn lại lần nữa
        )
    }
}
@Composable
fun GettingCart(msg : String){
    var text by remember { mutableStateOf(msg)}
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageCart(msg = text)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {text = "Hi!"}) {
            Text(text = "Say Hi!")
        }
    }
}

@Composable
fun MessageCart(msg : String){
    Text(
        text = msg,
        style = customText,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

val customText : TextStyle
    get() = TextStyle(
        color = Color.Red,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Cursive,
    )

@Composable
fun GettingText() {
    Text(text = "Kotlin is a modern but already mature programming language designed to make developers happier.",
        color = Color.Red,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Cursive,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun CounterCard() {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageCard("You have clicked the button $count times.")
        Button(onClick = { count++ },colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
            Text("Click me", color = Color.Blue)
        }
    }
}

@Composable
fun MessageCard(mess : String){
    Text(text = mess, style = customText)
}



@Composable
fun MultipleStylesText(){
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue)){
            append("H")
        }
        append("ello")
        withStyle(style = SpanStyle(color = Color.Red)){
            append("W")
        }
        append("orld")
    })
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}
