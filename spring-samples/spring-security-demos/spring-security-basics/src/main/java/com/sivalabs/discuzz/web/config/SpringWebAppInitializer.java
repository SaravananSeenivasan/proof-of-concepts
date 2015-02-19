package com.sivalabs.discuzz.web.config;

import javax.servlet.Filter;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
//import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import com.sivalabs.discuzz.core.config.AppConfig;

/**
 * @author Siva
 * 
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class<?>[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings()
	{
		
		return new String[] { "/" };
	}
	
	//Instead we used SecurityWebApplicationInitializer
	
	@Override
    protected Filter[] getServletFilters() {
		
       return new Filter[]{
	    		   new DelegatingFilterProxy("springSecurityFilterChain"),
	    		   new OpenEntityManagerInViewFilter(),
	    		   new SiteMeshFilter()
    		   };
    } 
	
	

}
