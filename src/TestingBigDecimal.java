import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class TestingBigDecimal {

	public static void main(String[] args) {
String num =	new TestingBigDecimal().countSerialNumber("20","GS1");
	System.out.println(num);
	System.out.println(new BigInteger(num));

	}
	
	public String countSerialNumber(final String snlength, final String charset) {
		int i = 0;
		switch (charset) {
			case "NUMERIC":
				i = 10;
				break;
			case "EFPIA":
				i = 30;
				break;
			case "GS1":
				i = 36;
				break;
			default:


		}
		final BigDecimal big = new BigDecimal(i);
        final BigDecimal totalCount = big.pow(Integer.parseInt(snlength) - 4);
		final DecimalFormat decimalFormat = new DecimalFormat("0");
		return decimalFormat.format(totalCount);



	}

}
