package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object apiKey
     
    /**
     * <p></p>
     */
    public static Object cityName
     
    /**
     * <p></p>
     */
    public static Object days
     
    /**
     * <p></p>
     */
    public static Object latitude
     
    /**
     * <p></p>
     */
    public static Object longitude
     
    /**
     * <p></p>
     */
    public static Object limit
     
    /**
     * <p></p>
     */
    public static Object units
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            apiKey = selectedVariables['apiKey']
            cityName = selectedVariables['cityName']
            days = selectedVariables['days']
            latitude = selectedVariables['latitude']
            longitude = selectedVariables['longitude']
            limit = selectedVariables['limit']
            units = selectedVariables['units']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
