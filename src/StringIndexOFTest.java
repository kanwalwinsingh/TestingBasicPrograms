import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class StringIndexOFTest {

	public static void main(String[] args) {

		LocalTime localTime = LocalTime.now(ZoneId.of("GMT+02:30"));
		System.out.println(localTime);
	}

}
