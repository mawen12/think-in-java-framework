package com.mawen.think.in.framework.step1;

import com.mawen.think.in.framework.step1.dao.CompanyDao;
import com.mawen.think.in.framework.step1.dao.CompanyDaoImpl;
import com.mawen.think.in.framework.step1.model.Company;
import com.mawen.think.in.framework.step1.service.CompanyService;
import com.mawen.think.in.framework.step1.service.CompanyServiceImpl;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class Step1App {

	public static void main(String[] args) {
		final CompanyDao companyDao = new CompanyDaoImpl();
		final CompanyService companyService = new CompanyServiceImpl(companyDao);

		companyService.createCompany(new Company());
	}
}
