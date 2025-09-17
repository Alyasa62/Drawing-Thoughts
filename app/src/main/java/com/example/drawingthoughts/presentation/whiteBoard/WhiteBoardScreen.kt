package com.example.drawingthoughts.presentation.whiteBoard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.drawingthoughts.presentation.whiteBoard.component.DrawingToolCard
import com.example.drawingthoughts.presentation.whiteBoard.component.TopBar
import com.example.drawingthoughts.presentation.whiteBoard.domain.model.DrawingTool

@Composable
fun WhiteBoardScreen(
    modifier: Modifier = Modifier
) {

    var isDrawingToolCardVisible by rememberSaveable {
        mutableStateOf(false)
    }
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
        DrawingToolCard(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(20.dp),
            selectedTool = DrawingTool.PEN,
            onToolSelected = { },
            onClosedIconClick = { isDrawingToolCardVisible = false },
            isVisible = isDrawingToolCardVisible
        )
    }
    
}