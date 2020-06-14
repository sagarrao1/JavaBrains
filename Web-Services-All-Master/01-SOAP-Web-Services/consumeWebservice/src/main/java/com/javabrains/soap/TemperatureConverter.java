package com.javabrains.soap;

import https.www_w3schools_com.xml.TempConvert;
import https.www_w3schools_com.xml.TempConvertSoap;

public class TemperatureConverter {

	public static void main(String[] args) {
		if (args.length !=1) {
			System.out.println("you need to pass temperature value");
		}else {
			String fahrenheitValue =args[0];
			TempConvert convert= new TempConvert();
			TempConvertSoap tempConvertSoap = convert.getTempConvertSoap();	
			String celsiusValue = tempConvertSoap.fahrenheitToCelsius(fahrenheitValue);
			System.out.println(fahrenheitValue+" fahrenheit conversion is "+celsiusValue+ " celsius.");
		}

	}

}
