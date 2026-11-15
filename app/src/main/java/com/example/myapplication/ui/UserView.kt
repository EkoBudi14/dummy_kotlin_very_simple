package com.example.myapplication.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserView(
    modifier: Modifier = Modifier,
    userViewModel : UserViewModel = viewModel()
) {

    val state by userViewModel.state.collectAsStateWithLifecycle()

    Column(modifier.fillMaxSize()) {
        when(val s = state) {
            is UiState.OnLoading -> Box(modifier.fillMaxSize(), Alignment.Center) {
                CircularProgressIndicator()
            }

            is UiState.OnError -> Text(s.message)


            is UiState.OnSuccess -> LazyColumn() {
                items(s.data.products, key = { it.id }) { product ->
                   Text(product.id.toString())
                    Text(product.title)
                    Text(product.category)
                    Text(product.dimension.width.toString())
                    product.review.forEach { review ->
                        Text(review.reviewerName)
                        Text(review.reviewerEmail)
                    }
                    HorizontalDivider()
                }

            }

        }
    }

}