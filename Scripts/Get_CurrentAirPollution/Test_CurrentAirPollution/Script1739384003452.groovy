import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ResponseObject
import groovy.json.JsonSlurper
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil
import org.everit.json.schema.Schema
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener

// Send Request
ResponseObject response = WS.sendRequest(findTestObject('Object Repository/Get_CurrentAirPollution'))

// Assert status code
WS.verifyResponseStatusCode(response, 200)
assert response.getStatusCode() == 200

// Parse JSON response
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Assert the 'coord' attributes
assert jsonResponse.coord.lat == -6.3006
assert jsonResponse.coord.lon == 106.8141

// Assert the 'main.aqi' value (should be between 1 and 5)
assert jsonResponse.list[0].main.aqi >= 1 && jsonResponse.list[0].main.aqi <= 5

// Assert key air pollution components
assert jsonResponse.list[0].components.co > 0
assert jsonResponse.list[0].components.no2 > 0
assert jsonResponse.list[0].components.pm2_5 > 0
assert jsonResponse.list[0].components.pm10 > 0

// Log some values for verification
println "AQI: ${jsonResponse.list[0].main.aqi}"
println "CO Level: ${jsonResponse.list[0].components.co}"
println "NO2 Level: ${jsonResponse.list[0].components.no2}"
println "PM2.5 Level: ${jsonResponse.list[0].components.pm2_5}"
println "PM10 Level: ${jsonResponse.list[0].components.pm10}"
