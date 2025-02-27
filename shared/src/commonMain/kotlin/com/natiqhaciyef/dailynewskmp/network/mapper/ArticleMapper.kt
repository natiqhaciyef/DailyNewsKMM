package com.natiqhaciyef.dailynewskmp.network.mapper

import com.natiqhaciyef.dailynewskmp.network.reponse.ArticleResponse
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleModel
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

fun ArticleResponse.toArticleModel(): ArticleModel {
    return ArticleModel(
        title = this.title ?: "",
        desc = this.description ?: "Click to more info",
        date = getDaysAsName(this.publishDate),
        imageUrl = this.imageUrl ?: "https://mathiasfrohlich.gallerycdn.vsassets.io/extensions/mathiasfrohlich/kotlin/1.7.1/1581441165235/Microsoft.VisualStudio.Services.Icons.Default"
    )
}

private fun getDaysAsName(date: String?): String {
    date ?: return "Today"
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    val days = today.daysUntil(
        Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
    )

    return when {
        abs(days) > 1 -> "${abs(days)} days ago "
        abs(days) == 1 -> "Yesterday"
        else -> "Today"
    }
}
