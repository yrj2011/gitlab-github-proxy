package com.dkaedv.glghproxy.controller;

import com.dkaedv.glghproxy.Constant;
import com.dkaedv.glghproxy.converter.GitlabToGithubConverter;
import com.dkaedv.glghproxy.gitlabclient.GitlabSessionProvider;
import org.eclipse.egit.github.core.Repository;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class UserReposController {

	@Autowired
	private GitlabSessionProvider gitlab;

	@RequestMapping("/user/repos")
	@ResponseBody
	public Repository createUserRepos(@RequestBody Map<String,String> param,	@RequestHeader("Authorization") String authorization) throws IOException {

		System.out.println(param);
		GitlabAPI api = gitlab.connect(Constant.GIT_TOKEN);
		GitlabProject gitlabProject = api.createProject(param.get("name"));
		return GitlabToGithubConverter.convertRepository(gitlabProject);
	}

}
