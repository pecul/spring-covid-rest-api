package com.rafi.demo.model.covid;

import lombok.Data;

@Data
public class CovidCases {
	private int dailyconfirmed;
	private int dailydeceased;
	private int dailyrecovered;
	private String date;
	private int totalconfirmed;
	private int totaldeceased;
	private int totalrecovered;
}
