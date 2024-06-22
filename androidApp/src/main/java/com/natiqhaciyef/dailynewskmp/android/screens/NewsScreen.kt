package com.natiqhaciyef.dailynewskmp.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.natiqhaciyef.dailynewskmp.android.R
import com.natiqhaciyef.dailynewskmp.articles.ArticleModel
import com.natiqhaciyef.dailynewskmp.articles.ArticleViewModel


@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleViewModel
) {
    val context = LocalContext.current
    val articleState = viewModel.articleState.collectAsState()

    Column {
        AppBar(title = context.getString(R.string.articles), modifier = modifier)

        if (articleState.value.isLoading)
            LoadingScreen(modifier = modifier)

        if (articleState.value.articleList != null)
            ArticlesMain(modifier = modifier, list = articleState.value.articleList!!)
    }

}

@Composable
private fun AppBar(title: String, modifier: Modifier) {
    TopBar(
        title = title,
        modifier = modifier
    )
}

@Composable
private fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center){
        CircularProgressIndicator(
            modifier = modifier.width(64.dp),
            color = Color.Green,
            trackColor = Color.Blue
        )
    }
}

@Composable
private fun ArticlesMain(modifier: Modifier, list: List<ArticleModel>) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(list){ item ->
            ArticleItemView(article = item)
        }
    }
}

@Composable
private fun ArticleItemView(article: ArticleModel){
    
}