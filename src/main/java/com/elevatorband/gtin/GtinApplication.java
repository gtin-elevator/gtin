package com.elevatorband.gtin;

import com.elevatorband.gtin.services.Validator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtinApplication {
	static String tryGtin8 = "12345670";
	static String tryGtin13 = "1234567890123";
	public static void main(String[] args) {
		Validator v = new Validator();
		int[] gArr = v.integerParser(tryGtin13);
		v.isValidNumber(gArr);
		if (v.isValidNumber(gArr)){
			System.out.println("Congratulation! It is a valid GTIN number");
		}

		//System.out.print(v.isValidNumber(tryGtin13));
	}

}
