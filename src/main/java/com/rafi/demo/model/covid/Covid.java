package com.rafi.demo.model.covid;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Covid {
	private List<CovidCases> cases_time_series = new ArrayList<>();
	private List<CovidStatewise> statewise = new ArrayList<>();
	private List<CovidTested> tested = new ArrayList<>();
}
