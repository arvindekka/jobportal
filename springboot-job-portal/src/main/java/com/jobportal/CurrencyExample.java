package com.jobportal;

import java.util.Currency;
import java.util.Set;

public class CurrencyExample {

	public static void main(String[] args) {
//		Set<Currency> cset  = Currency.getAvailableCurrencies();
//		cset.forEach(System.out::println);
		
		Currency c = Currency.getInstance("INR");
		System.out.println(c);
	}

}
