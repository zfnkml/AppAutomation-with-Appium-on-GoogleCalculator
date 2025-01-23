package com.google.android.calculator.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;

/**
 * 2025, January 21, Tuesday, 1:49 PM
 */

public class CalculatorScreen {
    AndroidDriver androidDriver;

    boolean isClicked_clickOperation;

    public CalculatorScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public String calculation(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                clickDigit(input.charAt(i));
            } else if (input.charAt(i) == '+') {
                clickOperation("add");
            } else if (input.charAt(i) == '-') {
                clickOperation("sub");
            } else if (input.charAt(i) == '*') {
                clickOperation("mul");
            } else if (input.charAt(i) == '/') {
                clickOperation("div");
            } else if (input.charAt(i) == '^') {
                clickOperation("pow");
            } else if (input.charAt(i) == 'p' && input.charAt(i + 1) == 'i') {
                i++;
                androidDriver.findElement(By.id("com.google.android.calculator:id/const_pi")).click();
            }
        }

        return getResult();
    }

    private void clickDigit(char num) {
        androidDriver.findElement(By.id("com.google.android.calculator:id/digit_" + num)).click();
    }

    private void clickOperation(String symbol) {
        isClicked_clickOperation = true;
        androidDriver.findElement(By.id("com.google.android.calculator:id/op_" + symbol)).click();
    }

    private String getResult() {
        androidDriver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        String result;
        if (!isClicked_clickOperation) {
            result = androidDriver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
            for (int i = 0; i < result.length(); i++)
                androidDriver.findElement(By.id("com.google.android.calculator:id/del")).click();
        } else {
            result = androidDriver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
            androidDriver.findElement(By.id("com.google.android.calculator:id/clr")).click();
        }

        double parseDouble = Double.parseDouble(result);
        int parseInt = (int) parseDouble;
        if(parseInt == parseDouble)
            return parseInt + "";

        return new DecimalFormat(".00").format(parseDouble);
    }
}
