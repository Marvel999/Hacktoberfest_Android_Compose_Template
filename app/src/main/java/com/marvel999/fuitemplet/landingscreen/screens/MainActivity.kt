package com.marvel999.fuitemplet.landingscreen.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.marvel999.fuitemplet.DemoScreen.DemoScreen
import com.marvel999.fuitemplet.R
import com.marvel999.fuitemplet.landingscreen.componets.LandingPageListItemCard
import com.marvel999.fuitemplet.landingscreen.componets.LandingPageListItemCardData
import com.marvel999.fuitemplet.landingscreen.data.landingPageListItemCardDataList
import com.marvel999.fuitemplet.ui.theme.FUITempletTheme
import com.marvel999.fuitemplet.ui.theme.LiteGray0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FUITempletTheme {
                val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
                HomeCompose(scaffoldState = scaffoldState)
            }
        }
    }

    fun StartDemoActivity(){
        startActivity(Intent(this, DemoScreen::class.java))
    }

    @Composable
    fun HomeCompose(scaffoldState: ScaffoldState) {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { MyTopAppBar() },
            content = { BodyComposable() },
            contentColor = LiteGray0
        )
    }


    @Composable
    fun MyTopAppBar() {
        TopAppBar(
            title = {
                Text(
                    text = "Educator Profile",
                    color = Color.White,

                    modifier = Modifier.padding(start = Dp(15f))
                )
            },
        )
    }


    @Composable
    fun BodyComposable() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(LiteGray0)
        ) {

            Column(
                modifier = Modifier
                    .background(Color(android.graphics.Color.parseColor("#" + "3C4852")))
                    .fillMaxSize(),
            ) {

                // Top lazyList Section
                landingPageListItemCardDataList = landingPageListItemCardDataList + LandingPageListItemCardData(
                        R.drawable.img_landingscreen_default_icon,
                        appTemplateName = "Demo App",
                        onItemClick = {
                            StartDemoActivity()
                        })

                TopListSection(landingPageListItemCardDataList)

            }
        }
    }

    @Composable
    fun TopListSection(itemList: List<LandingPageListItemCardData>) {
        Column{
            LazyColumn(modifier = Modifier.padding(top = Dp(8f), bottom = Dp(20f))) {
                itemsIndexed(itemList) { _, item ->
                    LandingPageListItemCard(landingPageListItemCardData = item)
                }
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
    }
}