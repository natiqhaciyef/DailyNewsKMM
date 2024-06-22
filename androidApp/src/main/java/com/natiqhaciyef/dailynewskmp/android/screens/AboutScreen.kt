package com.natiqhaciyef.dailynewskmp.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.natiqhaciyef.dailynewskmp.Platform
import com.natiqhaciyef.dailynewskmp.android.R


@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Column(modifier = modifier.fillMaxSize()) {
        TopBar(context.getString(R.string.about_device), modifier)
        ContentDescription(modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, modifier: Modifier) {
    TopAppBar(title = {
        Text(
            text = title,
            modifier = modifier.padding(horizontal = 4.dp)
        )
    })
}

@Composable
fun ContentDescription(modifier: Modifier) {
    val items = provideItems()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        items(items) { pair ->
            InformationView(
                modifier = modifier,
                title = pair.first,
                details = pair.second
            )
        }
    }
}

@Composable
fun InformationView(
    modifier: Modifier,
    title: String,
    details: String
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "$title :",
            style = TextStyle(
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        )

        Spacer(modifier = modifier.width(20.dp))

        Text(
            text = details,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
        )
    }
}

fun provideItems(): List<Pair<String, String>> {
    val info = Platform()
    info.logSystemInfo()

    return listOf(
        Pair("Operating System", "${info.osName} ${info.osVersion}"),
        Pair("Device", info.deviceModel),
        Pair("Density", "${info.density}"),
    )
}