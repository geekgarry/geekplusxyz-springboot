package com.maike.framework.web;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * @projectname GEEKCJJWeb
 * @author GEEKCJJ
 * @date 2019年10月18日 下午11:52:18
 * @description:
 *
 */
public class MyErrorPageRegister implements ErrorPageRegistrar {
	@Override
	public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
		ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
		ErrorPage page403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403");

		errorPageRegistry.addErrorPages(page404, page403);
	}
}
