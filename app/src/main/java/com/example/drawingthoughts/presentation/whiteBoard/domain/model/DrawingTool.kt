package com.example.drawingthoughts.presentation.whiteBoard.domain.model

import com.example.drawingthoughts.R

enum class DrawingTool(
    val resId: Int
) {
    PEN(R.drawable.img_pen),
    ERASER(R.drawable.img_eraser),
    HIGHLIGHTER(R.drawable.img_highlighter),
    LASER_PEN(R.drawable.img_laser_pen),
    LINE_PLANE(R.drawable.ic_line_plain),
    LINE_DOTTED(R.drawable.ic_line_dotted),
    ARROW_ONE_SIDED(R.drawable.ic_arrow_one_sided),
    ARROW_TWO_SIDED(R.drawable.ic_arrow_two_sided),
    CIRCLE_OUTLINED(R.drawable.ic_circle_outline),
    CIRCLE_FILLED(R.drawable.ic_circle_filled),
    RECTANGLE_OUTLINED(R.drawable.ic_rectangle_outline),
    RECTANGLE_FILLED(R.drawable.ic_rectangle_filled),
    TRIANGLE_OUTLINED(R.drawable.ic_triangle_outline),
    TRIANGLE_FILLED(R.drawable.ic_triangle_filled),


}