package com.lams1989.rest.webservices.parkingcar.util;

import java.time.Duration;
import java.time.LocalDateTime;

import com.lams1989.rest.webservices.parkingcar.beans.Ticket;

public class Util {

	public static String calculate(Ticket ticket, LocalDateTime entryDate) {

		LocalDateTime actualTime = LocalDateTime.now();
		ticket.setOutDate(actualTime);
		Duration duration = Duration.between(entryDate, actualTime);

		long days = duration.toDays();
		long hours = duration.toHours() - (days * 24);
		long minutes = duration.toMinutes() - (days * 1440) - (hours * 60);
		String timeElapsed = String.format("%s days %s hours %s minutes", days, hours, minutes);

		long pagosHP = calculatePay(duration);

		ticket.setPayment(pagosHP);

		return timeElapsed;
	}

	public static long calculatePay(Duration duration) {

		long fractionHour = 4000;
		long fractionMinutes = 1000;
		long fractionDay = 50000;
		long fractionMidday = 30000;
		long middayTotal = 0;
		long totalPay = 0;
		long daysTotal = duration.toDays();
		long hoursTotal = duration.toHours() - (daysTotal * 24);
		long minutesTotal = duration.toMinutes() - (daysTotal * 1440) - (hoursTotal * 60);

		totalPay += fractionDay * daysTotal;
		
		//cobra por midday y dobuble midday y sin superar fraction day cuando midday x2 
		if (hoursTotal >= 12) {
			middayTotal++;
			hoursTotal -= 12;
			if (hoursTotal > 0 && hoursTotal >= 6 && middayTotal > 0) {
				fractionMidday = 50000;
				hoursTotal = 0;
				minutesTotal = 0;
			}
			totalPay += fractionMidday * middayTotal;
		}
		// cobra fracciones sin pasar del pay midday
		if (hoursTotal >= 7) {
			if (minutesTotal > 30 || hoursTotal > 8) {
				totalPay += middayTotal == 1 ? fractionDay : fractionMidday;
				minutesTotal = 0;

			} else {
				totalPay += hoursTotal * fractionHour;
			}
			//cobra fraciones hora de 1 a 6 hrss
		} else {
			totalPay += hoursTotal * fractionHour;
		}
		// solo cobra la fraccion por min
		if (minutesTotal > 0 && hoursTotal == 0) {
			totalPay += fractionHour;
		}
		// cobra fracciones adicionales despues de una hora o dia
		if (minutesTotal >= 1 && hoursTotal >= 1 || minutesTotal >= 1 && daysTotal >= 1)
			if (minutesTotal <= 15 && minutesTotal > 0 && hoursTotal != 0) {
				totalPay += fractionMinutes;
			} else if (minutesTotal > 15 && minutesTotal <= 30) {
				totalPay += fractionMinutes * 2;
			} else if (minutesTotal > 30 && minutesTotal <= 45) {
				totalPay += fractionMinutes * 3;
			} else if (minutesTotal > 45 && minutesTotal <= 59) {
				totalPay += fractionMinutes * 4;
			}

		return totalPay;
	}
}
