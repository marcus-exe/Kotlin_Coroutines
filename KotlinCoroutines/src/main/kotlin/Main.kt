import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


suspend fun getForecast() : String{
    delay(1000)
    return "Sunny"
}

//basically JS async
suspend fun getTemperature() : String{
    delay(1000)
    return "30\u00b0C"
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }

    "${forecast.await()} ${temperature.await()}"
}



fun main() {

    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            getWeatherReport()
            println("Have a good Day")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")

}
