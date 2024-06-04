package com.mawen.think.in.framework.step5.application.service;

import com.mawen.think.in.framework.step5.application.dao.CompanyDao;
import com.mawen.think.in.framework.step5.application.model.Company;
import com.mawen.think.in.framework.step5.framework.annotation.Autowired;
import com.mawen.think.in.framework.step5.framework.annotation.Component;
import com.mawen.think.in.framework.step5.framework.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/4
 */
@Component
public class CompanyServiceImpl implements CompanyService {

	private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	private final CompanyDao companyDao;

	@Autowired
	public CompanyServiceImpl(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public void createCompany(Company company) {
		logger.info("SERVICE:   START - create company");
		createWithTransaction(company);
		logger.info("SERVICE:   END - create company");
	}

	@Transactional
	public void createWithTransaction(Company company) {
		logger.info("SERVICE:   START - create with transaction");
		companyDao.createCompany(company);
		logger.info("SERVICE:   END - create with transaction");
	}

	@Override
	@Transactional
	public void updateCompany(Company company) {
		logger.info("SERVICE:   START - update company");
		companyDao.updateCompany(company);
		logger.info("SERVICE:   END - update company");
	}
}
