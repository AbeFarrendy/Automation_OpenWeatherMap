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

// AIR POLLUTION -- RETRIEVE AIR POLLUTION DATA FROM COORDINATES
Resp_FcPollution = WS.sendRequest(findTestObject('AirPollution', [('var_lat') : GlobalVariable.latitude, ('var_lon') : GlobalVariable.longitude
            , ('var_apiKey') : GlobalVariable.apiKey]), FailureHandling.STOP_ON_FAILURE)

value_aqi = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].main.aqi')

value_co = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].components.co')

value_no = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].components.no')

value_no2 = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].components.no2')

value_o3 = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].components.o3')

value_so2 = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].components.so2')

value_pm2_5 = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].components.pm2_5')

value_pm10 = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].components.pm10')

value_nh3 = WS.getElementPropertyValue(Resp_FcPollution, 'list[0].components.nh3')

println('-----------------------------------------------------------')

println('--- AIR POLLUTION DATA ---')

println(Resp_FcPollution.getResponseText())

// PRINT AIR QUALITY FROM AQI VALUES
println('AIR QUALITY INDEX : ' + value_aqi)

if (value_aqi == 1) {
    println('AIR QUALITY : GOOD')
} else if (value_aqi == 2) {
    println('AIR QUALITY : FAIR')
} else if (value_aqi == 3) {
    println('AIR QUALITY : MODERATE')
} else if (value_aqi == 4) {
    println('AIR QUALITY : POOR')
} else if (value_aqi == 5) {
    println('AIR QUALITY : VERY POOR')
} else {
    println('')
}

// PRINT AIR POLLUTION METRICS
println('CARBON MONOXIDE : ' + value_co)

println('NITROGEN OXIDE : ' + value_no)

println('NITROGEN DIOXIDE : ' + value_no2)

println('OZONE : ' + value_o3)

println('SULPHUR DIOXIDE : ' + value_so2)

println('PARTICULATES <2.5μm : ' + value_pm2_5)

println('PARTICULATES <10μm : ' + value_pm10)

println('AMMONIA : ' + value_nh3)

println('-----------------------------------------------------------')

