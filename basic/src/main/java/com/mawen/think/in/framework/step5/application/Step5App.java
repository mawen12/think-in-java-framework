package com.mawen.think.in.framework.step5.application;


import com.mawen.think.in.framework.step5.application.model.Company;
import com.mawen.think.in.framework.step5.application.service.CompanyService;
import com.mawen.think.in.framework.step5.framework.ApplicationContext;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/4
 */
public class Step5App {

	public static void main(String[] args) {
		final ApplicationContext applicationContext = new ApplicationContext(Step5App.class);

		final CompanyService companyService = applicationContext.getBean(CompanyService.class);

		companyService.createCompany(new Company());

		System.out.println();

		companyService.updateCompany(new Company());
	}
}
