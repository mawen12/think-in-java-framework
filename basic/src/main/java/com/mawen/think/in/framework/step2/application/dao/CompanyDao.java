package com.mawen.think.in.framework.step2.application.dao;


import com.mawen.think.in.framework.step2.application.model.Company;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public interface CompanyDao {

	void createCompany(Company company);

	void updateCompany(Company company);
}
