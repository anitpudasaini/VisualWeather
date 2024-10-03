package com.weather.weatherapplication.screens

import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.weatherapplication.MainActivity
import com.weather.weatherapplication.R
import com.weather.weatherapplication.WeatherConstants
import com.weather.weatherapplication.data.Repository
import com.weather.weatherapplication.models.WeatherDay
import com.weather.weatherapplication.ui.theme.WeatherApplicationTheme

class OneDay(private var caller: MainActivity) {

    fun homeDisplay(vm: WeatherDay): Unit {
        caller.setContent {
            WeatherApplicationTheme {
                Summary(vm, Modifier.padding(10.dp))
            }
        }
    }

    @Composable
    fun Summary(weatherDay: WeatherDay, modifier: Modifier = Modifier) {
        val rowModifier = Modifier.padding(5.dp)
        Box(
            modifier.paint(
                painterResource(id = R.drawable.sky),
                contentScale = ContentScale.FillBounds
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
            ) {
                var searchText by rememberSaveable { mutableStateOf("") }
                WeatherTopAppBar()
                Log.e(WeatherConstants.TAG, "here is : $weatherDay")
                Row(rowModifier.fillMaxHeight(0.1F)) {
                    TextField(
                        value = searchText, onValueChange = { searchText = it }, modifier = Modifier
                            .wrapContentHeight()
                            .padding(0.dp), placeholder = { Text("Search") }
                    )
                    Button(
                        onClick = { caller.getWeatherReport(searchText) },
                        shape = RoundedCornerShape(2.dp)
                    ) { Text("Search", modifier = Modifier.requiredHeight(30.dp)) }
                }

                if (weatherDay.days.size == 0) return
                Row(rowModifier) { Text("${weatherDay.days[0].datetime}") }
                Row(rowModifier) { Text("${weatherDay.resolvedAddress}") }
                Row(rowModifier) { Text("") }
                Text("**Weather Now**", fontSize = 30.sp)
                Row(rowModifier) { Text("Temperature: ${weatherDay.currentConditions?.temp}") }
                Row(rowModifier) { Text("Temperature(Feels Like): ${weatherDay.currentConditions?.feelslike}") }
                Row(rowModifier) { Text("Precipitation: ${weatherDay.currentConditions?.precip}") }
                Row(rowModifier) { Text("Precipitation Type: ${weatherDay.currentConditions?.preciptype}") }
                Row(rowModifier) { Text("Precipitation: ${weatherDay.currentConditions?.precip}") }
                Row(rowModifier) { Text("Wind Speed: ${weatherDay.currentConditions?.windspeed}") }
                Row(rowModifier) { Text("sunrise ${weatherDay.days[0].sunrise}") }
                Row(rowModifier) { Text("runset ${weatherDay.days[0].sunset}") }
                Row(rowModifier) { Text("today's max ${weatherDay.days[0].tempmax}") }
                Row(rowModifier) { Text("today's min ${weatherDay.days[0].tempmin}") }
                Row(rowModifier) { Text("precipitation ${weatherDay.days[0].precip}") }
                Text("precipitation type ${weatherDay.days[0].preciptype}")
                Row { Text("") }
                Row(rowModifier) { Text("Current Conditions") }
                Row(rowModifier) {
                    Text(
                        "Conditions ${weatherDay.currentConditions?.conditions}",
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopAppBar() {
    TopAppBar(
        title = { Text("Visual Weather") },
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewWeather() {
    val repo = Repository(LocalContext.current)
    val weatherDay = repo.weatherReport()
//    Summary(weatherDay)
}
