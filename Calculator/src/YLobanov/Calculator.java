package YLobanov;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Calculator {
	private static final String[] ROMAN_NUMBERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARABIC_NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
	public static void  main(String[] args) throws Exception {
		BufferedReader reader = (new BufferedReader(new InputStreamReader(System.in)));
		String input = new String();
		try {
			input = reader.readLine();
		} catch (Exception e) {
			System.out.println("Fatal error, retry!");
		}
		
		resolver(input);
		
	}
	
	public static String resolver(String input) throws Exception {
		String[] line = input.split(" ", -1);
		String roman = new String("IIIVIIIX");
		boolean isRoman = false;
		int a = 0;
		int b = 0;
		
		if(line.length != 3) {
			throw new Exception("Too many operands");
		}
		if((roman.contains(line[0]) ^ roman.contains(line[2]))) {
			throw new Exception("Romans don't work with Arabic");
		}
		
		if((roman.contains(line[0]) && roman.contains(line[2]))) {
			a = fromRoman(line[0]);
			b = fromRoman(line[2]);
			isRoman = true;
		} else {
			a = Integer.parseInt(line[0]);
			b = Integer.parseInt(line[2]);
		}

		int result;
		
		switch(line[1]) {
		case "+":
			result = adding(a, b);
			break;
		case "-":
			result = substraction(a, b);
			break;
		case "/":
			result = division(a, b);
			break;
		case "*":
			result = multiplication(a, b);
			break;
		default:
			throw new Exception("Wrong operator");
		}
		
		if(isRoman) {
			System.out.println(toRoman(result));
			return(toRoman(result));
		} else {
			System.out.println(result);
			return result + "";
		}
		
	}

	private static String toRoman(int result) throws Exception{
		if(result <= 0) throw new Exception("Negative Roman numbers don't exist");
		
		int remainingValue = result;
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < ARABIC_NUMBERS.length; i++) {
            while (remainingValue >= ARABIC_NUMBERS[i]) {
                remainingValue -= ARABIC_NUMBERS[i];
                number.append(ROMAN_NUMBERS[i]);
            }
        }

        return number.toString();
	}

	private static int fromRoman(String romanNumeral) {
		String remainingValue = romanNumeral;
        int result = 0;

        for(int i = 0; i<ROMAN_NUMBERS.length; i++) {
            while(remainingValue.startsWith(ROMAN_NUMBERS[i])) {
                remainingValue = remainingValue.substring(ROMAN_NUMBERS[i].length(), remainingValue.length());
                result += ARABIC_NUMBERS[i];
            }
        }
        return result;
	}

	private static int multiplication(int a, int b) {
		return a * b;
	}

	private static int division(int a, int b){
		if(b == 0) throw new ArithmeticException();
		return a / b;
	}

	private static int substraction(int a, int b) {
		return a - b;
	}

	private static int adding(int a, int b) {
		return a + b;
	}
	
}
