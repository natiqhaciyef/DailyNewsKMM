package com.natiqhaciyef.dailynewskmp.android.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.natiqhaciyef.dailynewskmp.android.R
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleModel
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.viewmodel.getViewModelKey


@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleViewModel = koinViewModel(),
    navAction: () -> Unit
) {
    val context = LocalContext.current
    val articleState = viewModel.articleState.collectAsState()

    Column {
        AppBar(title = context.getString(R.string.articles), modifier = modifier, navAction)

        if (articleState.value.isLoading)
            LoadingScreen(modifier = modifier)

        if (articleState.value.error != null)
            ErrorMessage(message = articleState.value.error!!)

        ArticlesMain(modifier = modifier, list = articleState.value.articles)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    title: String,
    modifier: Modifier,
    action: () -> Unit
) {
    TopAppBar(
        title = { Text(title) },
        modifier = modifier,
        actions = {
            IconButton(onClick = action){
                Icon(
                    modifier = modifier,
                    imageVector = Icons.Default.Info,
                    contentDescription = "Info icon"
                )
            }
        }
    )
}

@Composable
private fun LoadingScreen(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
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
        items(list) { item ->
            ArticleItemView(article = item)
        }
    }
}

@Composable
private fun ArticleItemView(article: ArticleModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}