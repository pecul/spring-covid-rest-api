package com.rafi.demo.model.covid;

import lombok.Data;

@Data
public class CovidStatewise {
	private int active;
	private int confirmed;
	private int deaths;
	private int deltaconfirmed;
	private int deltadeaths;
	private int deltarecovered;
	private String lastupdatedtime;
	private int migratedother;
	private int recovered;
	private String state;
	private String statecode;
	private String statenotes;
}
