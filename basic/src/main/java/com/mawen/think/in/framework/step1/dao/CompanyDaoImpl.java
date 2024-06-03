package com.mawen.think.in.framework.step1.dao;

import com.mawen.think.in.framework.step1.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class CompanyDaoImpl implements CompanyDao {

	private static final Logger logger = LoggerFactory.getLogger(CompanyDaoImpl.class);

	@Override
	public void createCompany(Company company) {
		logger.info("DAO:   START - create company");

		logger.info("DAO:   END - create company");
	}

	@Override
	public void updateCompany(Company company) {
		logger.info("DAO:   START - update company");

		logger.info("DAO:   END - update company");
	}
}
