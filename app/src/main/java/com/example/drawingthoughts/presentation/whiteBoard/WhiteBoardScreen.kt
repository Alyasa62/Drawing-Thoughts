package com.example.drawingthoughts.presentation.whiteBoard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.drawingthoughts.presentation.whiteBoard.component.TopBar

@Composable
fun WhiteBoardScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
    ) {
        TopBar(
            modifier = Modifier.align(Alignment.TopCenter)
                .padding(20.dp),
            onStrokeWidthClick = { },
            onHomeIconClick = { },
            onUndoIconClick = { },
            onRedoIconClick = { },
            onDrawingColorClick = { },
            onBackgroundClick = { },
            onSettingsClick = { }
        )
    }
    
}