package com.mawen.think.in.framework.step3.application;

import com.mawen.think.in.framework.step3.application.dao.CompanyDao;
import com.mawen.think.in.framework.step3.application.model.Company;
import com.mawen.think.in.framework.step3.application.service.CompanyService;
import com.mawen.think.in.framework.step3.framework.ProxyMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;

/**
 *
 * <p>VM options:
 * <pre>{@code
 *  --add-opens=java.base/java.lang=ALL-UNNAMED
 * }</pre>
 *
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class Step3App {

	public static void main(String[] args) {
		final Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CompanyService.class);
		enhancer.setCallback(new ProxyMethodInterceptor());

		final CompanyService companyServiceProxy = (CompanyService) enhancer.create(new Class[]{CompanyDao.class}, new Object[]{new CompanyDao()});
		companyServiceProxy.createCompany(new Company());
	}
}
