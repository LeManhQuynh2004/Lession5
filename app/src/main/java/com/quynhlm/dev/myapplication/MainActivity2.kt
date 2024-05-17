package com.quynhlm.dev.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quynhlm.dev.myapplication.ui.theme.MyApplicationTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    Text(text = "Hello")
                }
            }
        }
    }

    @Composable
    fun PaymentScreen() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.Main)
        ) {
            Column {
                GettingTitle(msg = "Thanh toán")
                Divider(
                    color = Color.Black, // Màu của đường kẻ
                    thickness = 2.dp // Độ dày của đường kẻ
                )
                Spacer(modifier = Modifier.height(15.dp))
                Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                    Text(
                        text = "Địa chỉ nhận hàng",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.map),
                            contentDescription = null
                        )
                        Column(
                            modifier = Modifier
                                .height(130.dp)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.SpaceBetween // Căn cách các composable theo chiều dọc
                        ) {
                            Text(
                                text = "Lê Mạnh Quỳnh | 999999",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "16/15 Kiểu Mai",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Phường Phúc Diễn",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Bắc từ niêm - Hà nội",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Vui lòng chọn một trong những phương thức sau",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    PaymentFunction(
                        painter = painterResource(id = R.drawable.paypal),
                        color = colorResource(id = R.color.Orange),
                        "Paypal"
                    )
                    PaymentFunction(
                        painter = painterResource(id = R.drawable.visa),
                        color = colorResource(id = R.color.purple_200),
                        "Visa"
                    )
                    PaymentFunction(
                        painter = painterResource(id = R.drawable.images),
                        color = colorResource(id = R.color.Red),
                        "Momo"
                    )
                    PaymentFunction(
                        painter = painterResource(id = R.drawable.zalo),
                        color = colorResource(id = R.color.Blue2),
                        "Zalo Pay"
                    )
                    PaymentFunction(
                        painter = painterResource(id = R.drawable.payment),
                        color = colorResource(id = R.color.Blue1),
                        "Thanh toán trức tiếp"
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .width(350.dp)
                                .background(
                                    color = colorResource(id = R.color.Yellow),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.Yellow))
                        ) {
                            Text(text = "Tiếp theo", fontSize = 20.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Divider(
                    color = Color.Black, // Màu của đường kẻ
                    thickness = 3.dp // Độ dày của đường kẻ
                )
            }
        }
    }

    @Composable
    fun GettingTitle(msg: String) {
        Text(
            text = msg,
            modifier = Modifier
                .padding(0.dp, 20.dp)
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun PaymentFunction(painter: Painter, color: Color, msg: String) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color, shape = RoundedCornerShape(12.dp))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter, contentDescription = null)
            Text(text = msg, color = Color.White)
            RadioButton(selected = false, onClick = { /*TODO*/ })
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationTheme {
            PaymentScreen()
        }
    }
}