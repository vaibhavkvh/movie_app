package com.example.movieapp.presentation.customWidget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R


@Composable
fun RatingWidget(modifier: Modifier, rating: Double,scaleFactor: Float = 3f) {

    val starStringPath = stringResource(R.string.star)

    val starPath = remember {
        PathParser().parsePathString(pathData = starStringPath).toPath()
    }

    val starPathBounds = remember {
        starPath.getBounds()
    }

    FilledStar(starPath = starPath, starPathBound = starPathBounds,scaleFactor)
}



@Composable
fun FilledStar(starPath: Path, starPathBound: Rect, scaleFactor: Float ) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBound.width
            val pathHeight = starPathBound.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left, top) {
                drawPath(starPath, Color.Yellow)
            }
        }
    }
}

@Composable
fun EmptyStar(starPath: Path, starPathBound: Rect, scaleFactor: Float ) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBound.width
            val pathHeight = starPathBound.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left, top) {
                drawPath(starPath, Color.LightGray.copy(alpha=0.5f))
            }
        }
    }
}

@Composable
fun HalfFilledStar(starPath: Path, starPathBound: Rect, scaleFactor: Float) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size
        scale(scale = scaleFactor) {
            val pathWidth = starPathBound.width
            val pathHeight = starPathBound.height
            val left = (canvasSize.width / 2f) - (pathWidth / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(left, top) {
                drawPath(starPath, Color.LightGray.copy(alpha = 0.5f))
                clipPath(path = starPath) {
                    drawRect(
                        color = Color.Yellow,
                        size = Size(
                            width = starPathBound.maxDimension /1.7f,
                            height = starPathBound.maxDimension * scaleFactor
                        )
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true,)
fun FilledStarPreview(modifier: Modifier = Modifier) {
    val starStringPath = stringResource(R.string.star)

    val starPath = remember {
        PathParser().parsePathString(pathData = starStringPath).toPath()
    }

    val starPathBounds = remember {
        starPath.getBounds()
    }

    FilledStar(starPath = starPath, starPathBound = starPathBounds,2f)
}