package com.luv2code.springdemo.dao;

import java.time.LocalDate;

import javassist.expr.NewArray;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate[] dat  = new test().getPreviousMonth();
		System.out.println(dat[0]);
		LocalDate todayDate = LocalDate.now();
		LocalDate periousMonth = todayDate.minusMonths(1);
		System.out.println(periousMonth);
		

	}
	public static LocalDate[] getPreviousMonth() {
		LocalDate date = LocalDate.now();
	    final LocalDate from = date.minusDays(date.getDayOfMonth() - 1).minusMonths(1);
	    final LocalDate to = from.plusMonths(1).minusDays(1);

	    return new LocalDate[] {from};
	}
}
