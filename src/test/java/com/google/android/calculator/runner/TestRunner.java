package com.google.android.calculator.runner;

import com.google.android.calculator.page.CalculatorScreen;
import com.google.android.calculator.setup.Setup;
import com.google.android.calculator.utils.MyUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 2025, January 21, Tuesday, 2:03 PM
 */

public class TestRunner extends Setup {

    @Test(priority = 1, description = "Pass the series as a parameter")
    public void testMathExpression_inputAsParameter_success() {
        CalculatorScreen calculatorScreen = new CalculatorScreen(androidDriver);
        Assert.assertEquals(calculatorScreen.calculation("100/10*5-10+60"), "100");
    }

    @Test(priority = 2, description = "Pass the series from CSV file",dataProviderClass = MyUtils.class, dataProvider = "getData")
    public void testMathExpression_inputAsCSV_success(String input, String output) {
        CalculatorScreen calculatorScreen = new CalculatorScreen(androidDriver);
        Assert.assertEquals(calculatorScreen.calculation(input), output);
    }
}
