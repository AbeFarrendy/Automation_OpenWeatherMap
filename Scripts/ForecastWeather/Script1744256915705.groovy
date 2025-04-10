import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// GEOCODING API -- RETRIEVE LATITUDE LONGITUDE
Resp_GeoCoding = WS.sendRequest(findTestObject('GeoCoding', [('var_cityName') : GlobalVariable.cityName, ('var_limit') : GlobalVariable.limit
            , ('var_apiKey') : GlobalVariable.apiKey]), FailureHandling.STOP_ON_FAILURE)

value_name = WS.getElementPropertyValue(Resp_GeoCoding, '[0].name')

value_name_id = WS.getElementPropertyValue(Resp_GeoCoding, '[0].local_names.id')

value_lat = WS.getElementPropertyValue(Resp_GeoCoding, '[0].lat')

value_lon = WS.getElementPropertyValue(Resp_GeoCoding, '[0].lon')

println('-----------------------------------------------------------')

println(Resp_GeoCoding.getResponseText())

// PRINT NAME + LATITUDE + LONGITUDE

println('NAME : ' + value_name)

println('LOCAL NAME : ' + value_name_id)

println('LATITUDE : ' + value_lat)

println('LONGITUDE : ' + value_lon)

// ASSIGN LATITUDE + LONGITUDE TO GLOBAL VARIABLE
GlobalVariable.latitude = value_lat

GlobalVariable.longitude = value_lon

println('-----------------------------------------------------------')

// FORECAST WEATHER -- RETRIEVE 5-DAY WEATHER FORECAST PER 3 TIMESTAMPS
// 1 DAY 8 TIMESTAMPS, 5 DAYS 40 TIMESTAMPS
int ts = GlobalVariable.days * 8

Resp_FcWeather = WS.sendRequest(findTestObject('ForecastWeather', [('var_lat') : GlobalVariable.latitude, ('var_lon') : GlobalVariable.longitude
            , ('var_apiKey') : GlobalVariable.apiKey]), FailureHandling.STOP_ON_FAILURE)

println('--- WEATHER FORECAST DATA ---')

println(Resp_FcWeather.getResponseText())

// FOR EACH TIMESTAMP, RETRIEVE & PRINT WEATHER FORECAST DATA
for (int i = 0; i < ts; i++) {
    value_dt = WS.getElementPropertyValue(Resp_FcWeather, ('list[' + i) + '].dt_txt')

    value_wt_main = WS.getElementPropertyValue(Resp_FcWeather, ('list[' + i) + '].weather[0].main')

    value_wt_desc = WS.getElementPropertyValue(Resp_FcWeather, ('list[' + i) + '].weather[0].description')

    value_temp = WS.getElementPropertyValue(Resp_FcWeather, ('list[' + i) + '].main.temp')

    value_humidity = WS.getElementPropertyValue(Resp_FcWeather, ('list[' + i) + '].main.humidity')

    value_wind_speed = WS.getElementPropertyValue(Resp_FcWeather, ('list[' + i) + '].wind.speed')

    println((('TIMESTAMP [' + i) + '] : ') + value_dt)

    println('WEATHER : ' + value_wt_main)

    println('DESCRIPTION : ' + value_wt_desc)

    println('TEMPERATURE : ' + value_temp)

    println('HUMIDITY : ' + value_humidity)

    println('WIND SPEED : ' + value_wind_speed)

    println('-----------------------------------------------------------')
}

