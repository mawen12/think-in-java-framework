package com.mawen.think.in.framework.step1.service;

import com.mawen.think.in.framework.step1.dao.CompanyDao;
import com.mawen.think.in.framework.step1.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class CompanyServiceImpl implements CompanyService {

	private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	private final CompanyDao companyDao;

	public CompanyServiceImpl(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public void createCompany(Company company) {
		try {
			beginTransaction();

			logger.info("SERVICE:   START - create company");
			companyDao.createCompany(company);
			logger.info("SERVICE:   END - create company");

			commitTransaction();
		}
		catch (Exception e) {
			rollbackTransaction();
			throw e;
		}
	}

	@Override
	public void updateCompany(Company company) {
		try {
			beginTransaction();

			logger.info("SERVICE:   START - update company");
			companyDao.updateCompany(company);
			logger.info("SERVICE:   END - update company");

			commitTransaction();
		}
		catch (Exception e) {
			rollbackTransaction();
			throw e;
		}
	}

	private void beginTransaction() {
		logger.debug("BEGIN TRANSACTION");
	}

	private void commitTransaction() {
		logger.debug("COMMIT TRANSACTION");
	}

	private void rollbackTransaction() {
		logger.debug("ROLLBACK TRANSACTION");
	}
}
