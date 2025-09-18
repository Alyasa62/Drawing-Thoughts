package com.example.drawingthoughts.presentation.whiteBoard.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drawingthoughts.presentation.theme.DrawingThoughtsTheme

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onStrokeWidthClick: () -> Unit,
    onHomeIconClick: () -> Unit,
    onUndoIconClick: () -> Unit,
    onRedoIconClick: () -> Unit,
    onDrawingColorClick: () -> Unit,
    onBackgroundClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    var isMoreOptionMenuOpened by rememberSaveable {
        mutableStateOf(false)
    }

    Row(modifier = modifier) {
        FilledIconButton(onClick = { onHomeIconClick() }) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home",
//                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(25.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        FilledIconButton(onClick = { onUndoIconClick() }) {
            Icon(
                painter = painterResource(id = com.example.drawingthoughts.R.drawable.ic_undo),
                contentDescription = "Undo",
//                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(25.dp)
            )
        }
        FilledIconButton(onClick = { onRedoIconClick() }) {
            Icon(
                painter = painterResource(id = com.example.drawingthoughts.R.drawable.ic_redo),
                contentDescription = "Redo",
//                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(25.dp)
            )
        }
        Box { // No need to apply the parent modifier here.
            FilledIconButton(onClick = { isMoreOptionMenuOpened = true }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More options",
//                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(25.dp)
                )
            }
            MoreOptionsMenu(
                isExpended = isMoreOptionMenuOpened,
                onMenuDismiss = { isMoreOptionMenuOpened = false },
                onStrokeWidthClick = { onStrokeWidthClick() },
                onDrawingColorClick = { onDrawingColorClick() },
                onBackgroundClick = { onBackgroundClick() },
                onSettingsClick = { onSettingsClick() }
            )
        }
    }
}

@Composable
private fun MoreOptionsMenu (
    modifier: Modifier = Modifier,
    isExpended: Boolean,
    onMenuDismiss: () -> Unit,
    onStrokeWidthClick: () -> Unit,
    onDrawingColorClick: () -> Unit,
    onBackgroundClick: () -> Unit,
    onSettingsClick: () -> Unit


) {
    DropdownMenu(
        expanded = isExpended,
        onDismissRequest = { onMenuDismiss() },
        modifier = modifier
    ) {
        DropdownMenuItem(
            text = { Text(text = "Stroke Width") },
            onClick = { onStrokeWidthClick()
                      onMenuDismiss()
                      },
            leadingIcon = {
                Icon(imageVector= Icons.Default.Edit, contentDescription = "Stroke Width")

            }
        )
        DropdownMenuItem(
            text = { Text(text = "Drawing Colors") },
            onClick = { onDrawingColorClick()
                onMenuDismiss()
            },
            leadingIcon = {
                Icon(imageVector= Icons.Default.PlayArrow, contentDescription = "Stroke Width")

            }
        )
        DropdownMenuItem(
            text = { Text(text = "Background Color") },
            onClick = { onBackgroundClick()
                onMenuDismiss()
            },
            leadingIcon = {
                Icon(imageVector= Icons.Default.PlayArrow, contentDescription = "Stroke Width")

            }
        )
        DropdownMenuItem(
            text = { Text(text = "Setting") },
            onClick = { onSettingsClick()
                onMenuDismiss()
            },
            leadingIcon = {
                Icon(imageVector= Icons.Default.Settings, contentDescription = "Stroke Width")

            }
        )

    }
}

@Preview
@Composable
private fun TopBarPreview() {
    DrawingThoughtsTheme {
        TopBar(
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

@Preview
@Composable
private fun MoreOptionMenuPreview() {
    DrawingThoughtsTheme {
        MoreOptionsMenu(isExpended = true, onMenuDismiss = {  }
        , onStrokeWidthClick = {  }
            , onDrawingColorClick = {  }
            , onBackgroundClick = {  }
            , onSettingsClick = {  })
    }
    
}