package com.elevatorband.gtin;

import com.elevatorband.gtin.services.Generator;
import com.elevatorband.gtin.services.Validator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtinApplication {
	static String tryGtin8 = "12345670";
	static String tryGtin13 = "1234567890123";
	public static void main(String[] args) {
		Generator g = new Generator();

		try {
			System.out.println(g.generate(14));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
