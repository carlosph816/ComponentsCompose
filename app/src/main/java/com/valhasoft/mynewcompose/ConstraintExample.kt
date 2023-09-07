package com.valhasoft.mynewcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxBlue,
            boxRed,
            boxYellow,
            boxMagenta,
            boxGreen) = createRefs()

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Red)
                .constrainAs(boxRed) {
                    bottom.linkTo(boxBlue.top)
                    end.linkTo(boxBlue.start)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Magenta)
                .constrainAs(boxMagenta) {
                    top.linkTo(boxBlue.bottom)
                    end.linkTo(boxBlue.start)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(boxBlue.top)
                    start.linkTo(boxBlue.end)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxBlue.bottom)
                    start.linkTo(boxBlue.end)
                }
        )
    }
}

@Composable
fun ConstraintGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)


        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })

    }
}

@Composable
fun ConstraintBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxBlue,
            boxRed, boxYellow) = createRefs()

        val barrier = createEndBarrier(boxRed, boxBlue)

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(color = Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(205.dp)
                .background(color = Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxBlue.bottom)
                    start.linkTo(parent.start, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(65.dp)
                .background(color = Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(barrier)
                }
        )
    }
}

@Preview
@Composable
fun ConstraintChainExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxGreen,
            boxRed, boxYellow) = createRefs()

        Box(
            modifier = Modifier
                .size(75.dp)
                .background(color = Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(parent.start)
                    end.linkTo(boxRed.start)
                }
        )
        Box(
            modifier = Modifier
                .size(75.dp)
                .background(color = Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(boxGreen.end)
                    end.linkTo(boxYellow.start)
                }
        )

        Box(
            modifier = Modifier
                .size(75.dp)
                .background(color = Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(boxRed.end)
                    end.linkTo(parent.end)
                }
        )

        createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)
    }
}