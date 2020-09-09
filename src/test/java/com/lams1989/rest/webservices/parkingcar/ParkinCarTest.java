package com.lams1989.rest.webservices.parkingcar;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

import com.lams1989.rest.webservices.parkingcar.util.Util;

public class ParkinCarTest {
	@Test
	public void testUtil() {
		// dia completo
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 7, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);
		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 50000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil2() {
		// dia y medio dia
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 7, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 20, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);
		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 80000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil3() {
		// fracciones donde hour = 0 y dias = 0
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 30, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);
		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 4000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil4() {
		// fracciones por hora donde dias y minutes =0
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 10, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 8000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil5() {
		// fracciones por hora donde horas = 11 y deberia cobrar 1/2 dia
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 19, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 30000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil6() {
		// cobra un dia solo
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 15, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 28000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil7() {
		// fracciones por dia = 4 y 2hr con 30 min
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 20, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 30000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil8() {
		// fracciones por dia = 4 y 2hr con 30 min
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 4, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 10, 29, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 210000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil9() {
		// fracciones por dia = 4 y 2hr con 30 min
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 4, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 10, 30, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 210000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil10() {
		// fracciones por 12hr y 47 min
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 20, 47, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 34000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil11() {
		// 7 hours 46 minutes
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 15, 46, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 30000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil12() {
		// 19 hours 46 minutes
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 9, 3, 46, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 50000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil13() {
		// 20 hours pero supera fraccion dia -> cobra fraccion dia = 50000
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 9, 4, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 50000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil14() {
		// 19 hours pero supera fraccion dia -> cobra fraccion dia = 50000
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 8, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 9, 3, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 50000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil15() {
		// 16 hours
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 12, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 9, 4, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 46000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil16() {
		// 17 hours
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 12, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 9, 5, 00, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 50000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}

	@Test
	public void testUtil17() {
		// 16 hours 30 min
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 12, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 9, 5, 30, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 52000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}
	@Test
	public void testUtil18() {
		//1 hr 46 min
		LocalDateTime entryDate = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 12, 00, 00);

		LocalDateTime actualTime = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 13, 46, 00);

		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);

		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);
		System.out.println(timeElapsed);
		long actual = 8000;

		long expected = Util.calculatePay(duration);

		System.out.println(expected);

		assertEquals(actual, expected);

	}
}
