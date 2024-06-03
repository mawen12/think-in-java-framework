package com.mawen.think.in.framework.step3.application.dao;

import com.mawen.think.in.framework.step3.application.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class CompanyDao {

	private static final Logger logger = LoggerFactory.getLogger(CompanyDao.class);

	public void createCompany(Company company) {
		logger.info("DAO:   START - create company");

		logger.info("DAO:   END - create company");
	}

	public void updateCompany(Company company) {
		logger.info("DAO:   START - update company");

		logger.info("DAO:   END - update company");
	}
}
