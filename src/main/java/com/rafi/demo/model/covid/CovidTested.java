package com.rafi.demo.model.covid;

import lombok.Data;

@Data
public class CovidTested {
	private String individualstestedperconfirmedcase;
	private String positivecasesfromsamplesreported;
	private String samplereportedtoday;
	private String source;
	private String testpositivityrate;
	private String testsconductedbyprivatelabs;
	private String testsperconfirmedcase;
	private String testspermillion;
	private String totalindividualstested;
	private String totalpositivecases;
	private String totalsamplestested;
	private String updatetimestamp;
}
