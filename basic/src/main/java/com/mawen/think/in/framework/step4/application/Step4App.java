package com.mawen.think.in.framework.step4.application;

import com.mawen.think.in.framework.step4.application.model.Company;
import com.mawen.think.in.framework.step4.application.service.CompanyService;
import com.mawen.think.in.framework.step4.framework.ApplicationContext;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class Step4App {

	public static void main(String[] args) {
		final ApplicationContext applicationContext = new ApplicationContext(Step4App.class);
		final CompanyService companyService = applicationContext.getBean(CompanyService.class);

		companyService.createCompany(new Company());
	}
}
