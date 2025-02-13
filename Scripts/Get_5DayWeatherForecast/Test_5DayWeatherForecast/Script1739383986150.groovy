import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.util.KeywordUtil
import org.everit.json.schema.Schema
import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener


// Step 1: Send API Request
def response = WS.sendRequest(findTestObject('Object Repository/Get_5DayWeatherForecastsets'))

// Step 2: Convert response body to JSON
def responseBody = response.getResponseBodyContent()
JSONObject jsonResponse = new JSONObject(responseBody)

// Step 3: Define JSON Schema as String (Expanded Schema)
String jsonSchema = ''' 
{
  "type": "object",
  "properties": {
    "cod": { "type": "string" },
    "message": { "type": "number" },
    "cnt": { "type": "number" },
    "list": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "dt": { "type": "number" },
          "main": {
            "type": "object",
            "properties": {
              "temp": { "type": "number" },
              "feels_like": { "type": "number" },
              "temp_min": { "type": "number" },
              "temp_max": { "type": "number" },
              "pressure": { "type": "number" },
              "humidity": { "type": "number" }
            },
            "required": ["temp", "humidity"]
          },
          "weather": {
            "type": "array",
            "items": {
              "type": "object",
              "properties": {
                "id": { "type": "number" },
                "main": { "type": "string" },
                "description": { "type": "string" },
                "icon": { "type": "string" }
              },
              "required": ["id", "main", "description"]
            }
          },
          "wind": {
            "type": "object",
            "properties": {
              "speed": { "type": "number" },
              "deg": { "type": "number" }
            },
            "required": ["speed"]
          },
          "dt_txt": { "type": "string", "pattern": "\\\\d{4}-\\\\d{2}-\\\\d{2} \\\\d{2}:\\\\d{2}:\\\\d{2}" }
        },
        "required": ["dt", "main", "weather", "dt_txt"]
      }
    }
  },
  "required": ["cod", "list"]
}
'''

// Step 4: Validate JSON Schema
Schema schema = SchemaLoader.load(new JSONObject(new JSONTokener(jsonSchema)))
try {
    schema.validate(jsonResponse)  // Throws an exception if invalid
    KeywordUtil.logInfo("JSON Schema validation passed!")
} catch (Exception e) {
    KeywordUtil.markFailed("JSON Schema validation failed: " + e.getMessage())
}
