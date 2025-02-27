package com.natiqhaciyef.dailynewskmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.natiqhaciyef.dailynewskmp.Platform
import com.natiqhaciyef.dailynewskmp.android.screens.NewsScreen
import com.natiqhaciyef.dailynewskmp.android.screens.AboutScreen
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Platform().logSystemInfo()

        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = NavigationTags.HOME.name,
                    ) {
                        composable(NavigationTags.HOME.name) {
                            NewsScreen {
                                navController.navigate(NavigationTags.ABOUT.name)
                            }
                        }

                        composable(NavigationTags.ABOUT.name) {
                            AboutScreen {
                                navController.navigate(NavigationTags.HOME.name)
                            }
                        }
                    }
                }
            }
        }
    }
}

enum class NavigationTags {
    HOME,
    ABOUT
}