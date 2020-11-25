// 318247822 Idan Hur
package HW4;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class MyDate {
	private int year;
	private int month;
	private int day;
	private final static int[] DAYS_MONTHS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private String temp;

	public MyDate() {
		year = 2020;
		month = 1;
		day = 1;
	}

	public MyDate(Scanner scan) {
		day = scan.nextInt();
		temp = scan.next();
		temp = temp.replace(", ", "");
		month = Integer.parseInt(temp);
		temp = scan.next();
		temp = temp.replace(", ", "");
		year = Integer.parseInt(temp);
	}

	public MyDate(int day, int month, int year) {
		if (year >= 2000 && year <= 2020) {
			this.year = year;
		} else {
			this.year = 2020;
		}
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			this.month = 1;
		}
		if (day >= 1 && day <= DAYS_MONTHS[this.month]) {
			this.day = day;
		} else {
			this.day = day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public static int[] getDaysMonths() {
		return DAYS_MONTHS;
	}

	public boolean equals(MyDate d) {
		if (day == d.day && month == d.month && year == d.year) {
			return true;
		} else {
			return false;
		}
	}

	public int daysCount(MyDate d) {
		LocalDate enter = LocalDate.of(year, month, day);
		LocalDate out = LocalDate.of(d.year, d.month, d.day);
		Period period = Period.between(enter, out);
		int diff = period.getDays();
		return diff;
	}

	public void save(PrintWriter writer) {
		writer.println(day + ", " + month + ", " + year);
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}
}
