package com.natiqhaciyef.dailynewskmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.natiqhaciyef.dailynewskmp.Platform
import com.natiqhaciyef.dailynewskmp.android.screens.AboutScreen
import com.natiqhaciyef.dailynewskmp.android.screens.NewsScreen
import com.natiqhaciyef.dailynewskmp.articles.ArticleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Platform().logSystemInfo()
        val viewModel: ArticleViewModel by viewModels()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsScreen(viewModel = viewModel)
                }
            }
        }
    }
}