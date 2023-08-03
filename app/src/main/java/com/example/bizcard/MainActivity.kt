package com.example.bizcard


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 50.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        ) {
            Column(
                modifier = Modifier

                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // User Image
                createImageProfile()

                // Horizontal line
                Divider(modifier = Modifier.padding(0.dp, 5.dp))

                // user Details
                userDetails()

                // Portfolio Button
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    },
                    modifier = Modifier.padding(0.dp, 30.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp)
                ) {
                    Text(text = "Portfolio", fontSize = 16.sp)
                }
                if(buttonClickedState.value) {
                    Content()
                }else{
                    Box() {
                        
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp),) {
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width=1.dp, color = Color.LightGray)
            ) {
                Portfolio(data = listOf("Project 1","Project 2","Project 3","Project 1","Project 2","Project 3"))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun listItem(){
    Row {
        createImageProfile()
        Column() {
            Text(text = "Item")
            Text(text = "Desc")
        }
        
    }
}


@Composable
fun Portfolio(data: List<String>) {
    val colors = arrayOf(
        Color.Red,
        Color.Black,
        Color.Green,
        Color.Yellow,
        Color.Cyan,
        Color.Magenta,
        //...more
    )
   LazyColumn{
       items(data){ item ->
//            Text(text = item)
//           listItem()
           Card(modifier = Modifier
               .padding(8.dp, 8.dp, 8.dp, 0.dp)
               .fillMaxWidth(),
               shape = RoundedCornerShape(12.dp),
               border = BorderStroke(width = 1.dp, color = Color.LightGray),
               colors = CardDefaults.cardColors(Color.Red)
           ) {
               Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
                   Row(modifier = Modifier

                       .background(MaterialTheme.colorScheme.surface)
                       .fillMaxWidth()
                       .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically)
                   {

                       createImageProfile(modifier = Modifier
                           .size(75.dp)
                           .padding(4.dp))
                       Column(modifier = Modifier
                           .padding(8.dp, 0.dp)
                           .fillMaxHeight(), horizontalAlignment = Alignment.Start,
                           verticalArrangement = Arrangement.Center) {
                           Text(text = item)
                           Text(text = "This is a pretty cool project")
                       }


                   }
                   Row(modifier = Modifier.size(30.dp),Arrangement.End,Alignment.Top) {
                       Surface(modifier = Modifier
                           .height(20.dp)
                           .width(25.dp), color = colors.random(),
                       shape = RoundedCornerShape(0.dp,0.dp,0.dp,5.dp),
                       ) {
                           Text(text = "")
                       }
                   }
               }
           }
       }
   }
}


@Composable
private fun userDetails() {
    Column(
        modifier = Modifier
            .padding(5.dp)
        /*.fillMaxWidth()
                    .height(200.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally*/
    ) {
        Text(
            text = "Yash Dadhich",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(text = "Android Compose programmer")
        Text(text = "yash@gmail.com")
    }
}

@Composable
private fun createImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = Color.LightGray),
        shadowElevation = 4.dp,
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = R.drawable.person), contentDescription = "Person",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardTheme {
        Greeting("Android")
    }
}