PROJECT STRUCTURE

Profiles
- default.glbl
Object Repository
- AirPollution.rs
- ForecastWeather.rs
- GeoCoding.rs
Test Cases
- AirPollution.tc
- ForecastWeather.tc
Test Suites
- TS_AirPollution_FcWeather.groovy
- TS_AirPollution_FcWeather.ts
Reports
- TS_AirPollution_FcWeather
	- 20250410_203731
		- 20250410_203731.csv
		- 20250410_203731.html

------------------------------

How to run
1. Run the TestSuite "TS_AirPollution_FcWeather"
2. This will run the TestCases AirPollution and ForecastWeather, both of which have included the GeoCoding request beforehand.
3. Values from AirPollution and ForecastWeather are printed and can be viewed in the console
4. Report is generated automatically in the Reports folder in .csv and .html

------------------------------

Attributes checked

GEOCODING
- NAME : South Jakarta
- LOCAL NAME : Jakarta Selatan
- LATITUDE : -6.28381815
- LONGITUDE : 106.80486324917382

AIR POLLUTION
- AIR QUALITY INDEX : 2
- AIR QUALITY : FAIR
- CARBON MONOXIDE : 308.05
- NITROGEN OXIDE : 0
- NITROGEN DIOXIDE : 1.64
- OZONE : 48.52
- SULPHUR DIOXIDE : 0.32
- PARTICULATES <2.5μm : 10.09
- PARTICULATES <10μm : 11.12
- AMMONIA : 0.58

WEATHER FORECAST
- TIMESTAMP [0] : 2025-04-10 15:00:00
- WEATHER : Rain
- DESCRIPTION : light rain
- TEMPERATURE : 27.79
- HUMIDITY : 76
- WIND SPEED : 2.47
- Note: The test script ForecastWeather retrieves data at 40 timestamps ([0]-[39]) in total

------------------------------




