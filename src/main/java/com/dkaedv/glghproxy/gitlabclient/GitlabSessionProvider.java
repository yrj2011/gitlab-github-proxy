package com.dkaedv.glghproxy.gitlabclient;

import javax.annotation.PostConstruct;

import com.dkaedv.glghproxy.Constant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gitlab.api.AuthMethod;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.TokenType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GitlabSessionProvider {
	private final static Log LOG = LogFactory.getLog(GitlabSessionProvider.class);

	@Value("${gitlabUrl}")
	private String gitlabUrl;

	public GitlabAPI connect(String authorizationHeader) {
		//String token = authorizationHeader.replaceAll("token ", "");
		String token = Constant.GIT_TOKEN.replaceAll("token ", "");
		GitlabAPI api = GitlabAPI.connect(gitlabUrl, token, TokenType.PRIVATE_TOKEN);
		api.ignoreCertificateErrors(true);
		return api;
	}
	
	@PostConstruct
	public void logUrl() {
		LOG.info("Using Gitlab Base URL: " + gitlabUrl);
	}
}
