package com.valhasoft.mynewcompose

import android.nfc.cardemulation.CardEmulation
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valhasoft.mynewcompose.ui.theme.MyNewComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //STATE HOSTING
                    /* var myText by remember{
                         mutableStateOf("")
                     }
                     MyTextField(myText){
                         myText = it
                     }*/

                    // CUSTOM CHECKBOX
                    /*val myOptions =  getOptions(titles = listOf("Option 1", "Option 2" , "Option 3"))
                    Column {
                        MyTriStatusCheckBox()
                        myOptions.forEach {
                            MyCheckBoxCustom(checkInfo = it)
                        }
                    }
                    */
                    //STATE HOSTING RADIO BUTTON
                    /*var selected by remember {
                        mutableStateOf("Aris")
                    }
                    MyRadioButtonList(name = selected, onClick = {
                        selected = it
                    })*/
                    //STATE HOSTING DIALOG
                    /*var show by remember {
                        mutableStateOf(false)
                    }
                    Box (Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Button(onClick = { show = true }) {
                            
                        }
                        /*MyDialog(show = show, onDismiss = {
                            show = false
                        }, onConfirm = {
                            Log.e("LOG SHOW", "confirm")
                        })*/
                        MyConfirmationDialog(show = show) {
                            
                        }
                    }*/
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNewComposeTheme {
        //MyDialog()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySpinner() {
    var selectedText by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }

    val desserts = listOf("Helado", "Chocolate", "Caramelo", "Fruta")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable {
                    expanded = true
                }
                .fillMaxWidth()
        )
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded, onDismissRequest = {
            expanded =  false
        }) {
            desserts.forEach { item ->
                DropdownMenuItem(text = { Text(text = item) }, onClick = {
                    expanded = false
                    selectedText = item
                })
            }
        }
    }
}

@Composable
fun MyDivider(){
    Divider(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp), color = Color.Red)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(modifier = Modifier.padding(10.dp), badge = { Badge(containerColor = Color.Blue, contentColor = Color.White) { Text("800") } }) {
        Icon(
            Icons.Filled.Star,
            contentDescription = "Favorite"
        )
    }
}


@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Texto 1")
            Text(text = "Texto 2")
            Text(text = "Texto 3")
        }
    }
}


@Composable
fun MyRadioButtonList(name: String, onClick: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row {
            RadioButton(
                selected = name == "Aris1", onClick = {
                    onClick("Aris1")
                }
            )
            Text(text = "Aris1")
        }
        Row {
            RadioButton(
                selected = name == "Aris2", onClick = {
                    onClick("Aris2")
                }
            )
            Text(text = "Aris2")
        }
        Row {
            RadioButton(
                selected = name == "Aris3", onClick = {
                    onClick("Aris3")
                }
            )
            Text(text = "Aris3")
        }
        Row {
            RadioButton(
                selected = name == "Aris4", onClick = {
                    onClick("Aris4")
                }
            )
            Text(text = "Aris4")
        }
    }
}

@Composable
fun MyRaddioButton() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        RadioButton(
            selected = false, enabled = false, onClick = {

            }, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green
            )
        )
        Text(text = "Prueba de radio")
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            }

            ToggleableState.Off -> {
                ToggleableState.Indeterminate
            }

            ToggleableState.Indeterminate -> {
                ToggleableState.On
            }
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            isSelected = status,
            onSelected = { newStatus ->
                status = newStatus
            }
        )
    }
}

@Composable
fun MyCheckBoxCustom(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.isSelected,
            onCheckedChange = { checkInfo.onSelected(!checkInfo.isSelected) },
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.Red,
                checkedColor = Color.Yellow,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxAdvanceWithText() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.Red,
                checkedColor = Color.Yellow,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Prueba")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        colors = CheckboxDefaults.colors(
            uncheckedColor = Color.Red,
            checkedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}


@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }
    Switch(
        checked = state, onCheckedChange = {
            state = !state
        }, enabled = true, colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedBorderColor = Color.Green,
            uncheckedTrackColor = Color.Blue,
            checkedTrackColor = Color.Magenta,
        )
    )
}

@Composable
fun MyProgressBarAdvanced() {
    var increment by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp, progress = increment)
        LinearProgressIndicator(progress = increment)

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                increment += 0.1f
            }) {
                Text(text = "Incrementar")
            }
            Button(onClick = {
                increment -= 0.1f
            }) {
                Text(text = "Decrementar")
            }
        }
    }
}

@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }
        Button(onClick = {
            showLoading = !showLoading
        }) {
            Text(text = "Click")
        }

    }
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Outlined.Add,
        contentDescription = "Icono",
        tint = Color.Blue
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, shape = CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}


@Composable
fun MyButton() {
    var enable by rememberSaveable {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            enabled = enable,
            border = BorderStroke(5.dp, Color.Green),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            ), onClick = {
                enable = false
            }) {
            Text(text = "Click")
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.Green
            )
        ) {
            Text(text = "Click")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Click")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(name: String, onValueChange: (String) -> Unit) {
    Column {
        TextField(value = name, onValueChange = {
            onValueChange(it)
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutline() {
    var myText by remember {
        mutableStateOf("")
    }
    Column {
        OutlinedTextField(value = myText, onValueChange = {
            myText = it
        }, modifier = Modifier.padding(24.dp), label = {
            Text(text = "Prueba")
        }, colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("")
    }
    Column {
        TextField(value = myText, onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        }, label = {
            Text(text = "Introduce un nombre")
        })
    }
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 45.sp)
    }
}


@Composable
fun MyStateExample() {

    var counter by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            counter += 1
        }) {
            Text(text = "PULSAR")
        }
        Text(text = "He sido fulsado ${counter} veces")
    }
}

@Composable
fun MultipleLayouts() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Prueba de texto 1")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Prueba de texto 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Prueba de texto 3")
            }
        }
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Prueba de texto 4")
        }
    }
}


@Composable
fun MyRow() {
    Row(Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .background(Color.Blue)
                .weight(1f),
            text = "Prueba de mi texto para poder ver un scroll",
            color = Color.White
        )
        Text(
            modifier = Modifier
                .background(Color.Red)
                .weight(1f),
            text = "Prueba de mi texto para poder ver un scroll",
            color = Color.White
        )
        Text(
            modifier = Modifier
                .background(Color.Yellow)
                .weight(1f),
            text = "Prueba de mi texto para poder ver un scroll",
            color = Color.Blue
        )
    }
}


@Composable
fun MyColumn() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            modifier = Modifier.background(Color.Blue),
            text = "Prueba de mi texto para poder ver un scroll",
            color = Color.Blue
        )
        Text(
            modifier = Modifier.background(Color.Red),
            text = "Prueba de mi texto para poder ver un scroll",
            color = Color.Blue
        )
        Text(
            modifier = Modifier.background(Color.Green),
            text = "Prueba de mi texto para poder ver un scroll",
            color = Color.Blue
        )
    }
}

@Composable
fun MyBox(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .verticalScroll(rememberScrollState())
                .background(Color.Cyan)
        ) {
            Text(text = "Prueba de mi texto para poder ver un scroll", color = Color.White)
        }
    }
}
