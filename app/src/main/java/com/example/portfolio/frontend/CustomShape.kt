package com.example.portfolio.frontend

import android.graphics.Matrix
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.graphics.PathParser

import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*

class CustomShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val offsetX = with(density) { 90.dp.toPx() }
        val offsetY = with(density) { (-100).dp.toPx() }

        return Outline.Generic(
            path = PathParser.createPathFromPathData(

                "M426.755 0.660905C526.01 5.37687 630.416 42.2627 691.019 " +
                        "119.058C747.053 190.064 709.403 290.888 725.408 379.114C738.276 450.044 " +
                        "786.302 512.961 775.404 584.204C763.332 663.132 724.842 738.453 662.532 790" +
                        ".186C597.271 844.368 510.835 889.895 426.755 873.671C345.261 857.947 319.875 " +
                        "754.823 250.249 710.635C174.069 662.287 41.2528 688.785 6.43092 606.913C-27.6816" +
                        " 526.71 83.9568 456.257 106.308 372.209C131.067 279.108 79.6084 166.633 143.094 " +
                        "93.0241C208.865 16.7636 324.689 -4.1886 426.755 0.660905Z"

            ).asComposePath().apply {
                val pathSize = getBounds().size
                val matrix = Matrix()
                matrix.postScale(
                    size.width / pathSize.width,
                    size.height / pathSize.height
                )
                matrix.postTranslate(offsetX, offsetY)
                asAndroidPath().transform(matrix)

                val left = getBounds().left
                val top = getBounds().top
                translate(Offset(-left,-top))
            }
        )
    }
}

