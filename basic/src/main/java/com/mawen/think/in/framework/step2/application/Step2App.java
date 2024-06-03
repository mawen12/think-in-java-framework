package com.mawen.think.in.framework.step2.application;

import java.lang.reflect.Proxy;

import com.mawen.think.in.framework.step2.application.dao.CompanyDao;
import com.mawen.think.in.framework.step2.application.dao.CompanyDaoImpl;
import com.mawen.think.in.framework.step2.application.model.Company;
import com.mawen.think.in.framework.step2.application.service.CompanyService;
import com.mawen.think.in.framework.step2.application.service.CompanyServiceImpl;
import com.mawen.think.in.framework.step2.framework.ProxyHandler;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class Step2App {

	public static void main(String[] args) {
		final CompanyDao companyDao = new CompanyDaoImpl();

		final CompanyService companyServiceProxy = (CompanyService) Proxy.newProxyInstance(
				Step2App.class.getClassLoader(),
				new Class[]{CompanyService.class},
				new ProxyHandler(new CompanyServiceImpl(companyDao)));

		companyServiceProxy.createCompany(new Company());
	}
}
