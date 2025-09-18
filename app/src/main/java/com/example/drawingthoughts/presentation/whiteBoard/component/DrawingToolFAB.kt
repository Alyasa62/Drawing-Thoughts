package com.example.drawingthoughts.presentation.whiteBoard.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.drawingthoughts.presentation.whiteBoard.domain.model.DrawingTool

@Composable
fun DrawingToolFAB(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selectedTool: DrawingTool,
    isVisible: Boolean,

) {
    val imageIcon = listOf(
        DrawingTool.PEN,
        DrawingTool.ERASER,
        DrawingTool.HIGHLIGHTER,
        DrawingTool.LASER_PEN
    )
    AnimatedVisibility(
        modifier = modifier,
        visible = isVisible,
        enter = slideInVertically(tween(durationMillis = 500) ) { h -> h },
        exit = slideOutVertically(tween(durationMillis = 500) ) { h -> h }

    ) {
        FloatingActionButton(
            onClick = { onClick() },
            modifier = modifier
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                painter = painterResource(id = selectedTool.resId),
                contentDescription = selectedTool.name,
                tint = if(imageIcon.contains(selectedTool)) {
                    Color.Unspecified
                } else {
                    LocalContentColor.current
                }

            )

        }

    }

    
}