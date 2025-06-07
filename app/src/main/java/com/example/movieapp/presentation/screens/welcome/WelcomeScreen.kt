package com.example.movieapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movieapp.domain.model.OnBoardingPage
import com.example.movieapp.navigation.Screen
import com.example.movieapp.presentation.viewmodels.WelcomeViewModel
import com.example.movieapp.ui.theme.EXTRA_LARGE_PADDING
import com.example.movieapp.ui.theme.LARGE_PADDING


@Composable
fun WelcomeScreen(navHostController: NavHostController,
                  welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {

    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third)

    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) {
            PagerScreen(pages[it])
        }

        GetPagerIndicator(modifier = Modifier.weight(1f), pagerState)

        GetFinishButton(modifier = Modifier.weight(2f), pagerState) {
            navHostController.popBackStack()
            navHostController.navigate(Screen.Home.route)
            welcomeViewModel.saveOnBoardingState(isCompleted = true)
        }
    }
}

@Composable
fun GetFinishButton(modifier: Modifier, pagerState: PagerState, onClick: () -> Unit) {
    Row(modifier = modifier) {
        AnimatedVisibility(
            modifier = modifier
                .fillMaxWidth()
                .padding(EXTRA_LARGE_PADDING),
            visible = pagerState.currentPage == pagerState.pageCount-1
        ) {
            ElevatedButton(
                onClick = onClick,
                colors = ButtonDefaults.elevatedButtonColors(

                    containerColor = Color.Blue,
                    contentColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text("Finish", style = MaterialTheme.typography.labelLarge)
            }
        }

    }
}

@Composable
fun GetPagerIndicator(modifier: Modifier, pagerState: PagerState) {
    return Row(
        modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(onBoardingPage.image),
            contentDescription = onBoardingPage.title
        )
        Spacer(Modifier.height(LARGE_PADDING))
        Text(onBoardingPage.title, style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(LARGE_PADDING))
        Text(
            modifier = Modifier.padding(LARGE_PADDING),
            text = onBoardingPage.description,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}