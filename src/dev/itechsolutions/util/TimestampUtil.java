package dev.itechsolutions.util;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Optional;

/**
 * 
 * @author Argenis Rodríguez
 *
 */
public class TimestampUtil {
	
	/**
	 * @author Argenis Rodríguez
	 * @param date
	 * @param seconds
	 * @return
	 */
	public static Timestamp minusSecond(Timestamp date, int seconds) {
		return add(date, -seconds, ChronoUnit.SECONDS);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param date
	 * @param days
	 * @return
	 */
	public static Timestamp minusDay(Timestamp date, int days) {
		return add(date, -days, ChronoUnit.DAYS);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param date
	 * @return
	 */
	public static Timestamp truncDay(Timestamp date) {
		return trunc(date, ChronoUnit.DAYS);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param date
	 * @param unit
	 * @return
	 */
	public static Timestamp trunc(Timestamp date, TemporalUnit unit) {
		LocalDateTime dateTime = date.toLocalDateTime();
		dateTime = dateTime.truncatedTo(unit);
		
		return Timestamp.valueOf(dateTime);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param date
	 * @param units
	 * @param unit
	 * @return
	 */
	public static Timestamp add(Timestamp date, double units, TemporalUnit unit) {
		LocalDateTime dateTime = date.toLocalDateTime();
		dateTime = dateTime.plus((long) units, unit);
		
		return Timestamp.valueOf(dateTime);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Timestamp min(Timestamp date1, Timestamp date2) {
		if (date1 == null && date2 == null)
			return null;
		
		if (date1 == null || date2 == null)
			return Optional.ofNullable(date1)
					.orElse(date2);
		
		if (date1.before(date2))
			return date1;
		
		return date2;
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param dates
	 * @return
	 */
	public static Timestamp min(Timestamp ...dates) {
		
		return Arrays.stream(dates)
				.filter(date -> date != null)
				.sorted()
				.findFirst()
				.get();
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param dates
	 * @return
	 */
	public static Timestamp max(Timestamp ...dates) {
		
		return Arrays.stream(dates)
				.filter(date -> date != null)
				.sorted((date1, date2) -> date2.compareTo(date1))
				.findFirst()
				.get();
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param dateFrom
	 * @param dateTo
	 * @param dayOfWeek
	 * @return
	 */
	public static int getDays(Timestamp dateFrom, Timestamp dateTo
			, DayOfWeek dayOfWeek) {
		if (dateFrom == null || dateTo == null)
			return 0;
		
		int days = 0;
		
		LocalDate localDateFrom = dateFrom.toLocalDateTime().toLocalDate();
		LocalDate localDateTo = dateTo.toLocalDateTime().toLocalDate();
		
		for (LocalDate ld = localDateFrom; ld.compareTo(localDateTo) <= 0; ld = ld.plusDays(1))
			days += ld.getDayOfWeek().equals(dayOfWeek) ? 1 : 0;
		
		return days;
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static double getDaysBetween(Timestamp date1, Timestamp date2) {
		return getBetween(date1, date2, ChronoUnit.DAYS);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param date1
	 * @param date2
	 * @param unit
	 * @return
	 */
	public static long getBetween(Timestamp date1, Timestamp date2
			, ChronoUnit unit) {
		return unit.between(min(date1, date2).toLocalDateTime()
				, max(date1, date2).toLocalDateTime());
	}
}
