package com.dkaedv.glghproxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingFilter implements Filter {
	private final static Log LOG = LogFactory.getLog(LoggingFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		String query = (request.getQueryString() == null) ? "" : "?" + request.getQueryString();
		if(StringUtils.isEmpty(query)){
			query += Constant.GIT_TOKEN_ADD;
		}else{
			query += Constant.GIT_TOKEN_APPEND;
		}


	/*	MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);
		mutableRequest.putHeader("Authorization", Constant.GIT_TOKEN);*/


		//String body = getBody(request);
		LOG.info("method:"+request.getMethod()+"Request to " + request.getRequestURI() + query);
		//LOG.info("body:"+body);




		chain.doFilter(req, res);

		request.getPathInfo();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}


	// 字符串读取
	public  String getBody(HttpServletRequest request)
	{

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try
		{
			br = request.getReader();
			String str;
			while ((str = br.readLine()) != null)
			{
				sb.append(str);
			}
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (null != br)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}



	class MutableHttpServletRequest extends HttpServletRequestWrapper {
		// holds custom header and value mapping
		private final Map<String, String> customHeaders;

		public MutableHttpServletRequest(HttpServletRequest request){
			super(request);
			this.customHeaders = new HashMap<String, String>();
		}

		public void putHeader(String name, String value){
			this.customHeaders.put(name, value);
		}

		public String getHeader(String name) {
			// check the custom headers first
			String headerValue = customHeaders.get(name);

			if (headerValue != null){
				return headerValue;
			}
			// else return from into the original wrapped object
			return ((HttpServletRequest) getRequest()).getHeader(name);
		}

		public Enumeration<String> getHeaderNames() {
			// create a set of the custom header names
			Set<String> set = new HashSet<String>(customHeaders.keySet());

			// now add the headers from the wrapped request object
			@SuppressWarnings("unchecked")
			Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
			while (e.hasMoreElements()) {
				// add the names of the request headers into the list
				String n = e.nextElement();
				set.add(n);
			}

			// create an enumeration from the set and return
			return Collections.enumeration(set);
		}
	}



}
