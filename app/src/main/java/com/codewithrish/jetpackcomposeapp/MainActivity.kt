package com.codewithrish.jetpackcomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithrish.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

data class User(
    val id: Int
)

@Composable
fun MainContent() {

    val user = User(1)

    val users = remember {
        mutableStateListOf(user)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        UserList(users = users)
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),

            onClick = {
                users.add(User(1))
            }) {
            Text(text = "Add More")
        }
    }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) {
            UserCard()
        }
    }
}

@Composable
fun UserCard() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "User Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.dummy_text),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(12.dp)
                )
                Button(onClick = {

                }) {
                    Text(text = "View Profile")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
        MainContent()
    }
}