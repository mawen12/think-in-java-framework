package com.mawen.think.in.framework.step3.application.service;

import com.mawen.think.in.framework.step3.application.dao.CompanyDao;
import com.mawen.think.in.framework.step3.application.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class CompanyService {

	private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);

	private final CompanyDao companyDao;

	public CompanyService(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public void createCompany(Company company) {
		logger.info("SERVICE:   START - create company");
		companyDao.createCompany(company);
		logger.info("SERVICE:   END - create company");
	}

	public void updateCompany(Company company) {
		logger.info("SERVICE:   START - update company");
		companyDao.updateCompany(company);
		logger.info("SERVICE:   END - update company");
	}
}
