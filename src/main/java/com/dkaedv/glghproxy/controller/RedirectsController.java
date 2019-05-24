package com.dkaedv.glghproxy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.util.AntPathMatcher;

@Controller
public class RedirectsController {

	@Value("${gitlabUrl}")
	private String gitlabUrl;

	@RequestMapping("/{namespace}")
	public String namespace(
			@PathVariable String namespace
			) {
		
		return "redirect:" + gitlabUrl + "/" + namespace;
	}

    @RequestMapping("/{group}/{project}/info/refs")
    public String infoRefs(@PathVariable String group, @PathVariable String project ){

        return "redirect:" + gitlabUrl + "/" +group+"/"+project+"/info/refs?service=git-upload-pack";

    }

	@RequestMapping("/{namespace}/{repo}")
	public String repoHomepage(
			@PathVariable String namespace,
			@PathVariable String repo
			) {
		
		return "redirect:" + gitlabUrl + "/" + namespace + "/" + repo;
	}
	
	@RequestMapping("/{namespace}/{repo}/commit/{sha}")
	public String commit(
			@PathVariable String namespace,
			@PathVariable String repo,
			@PathVariable String sha
			) {
		
		return "redirect:" + gitlabUrl + "/" + namespace + "/" + repo + "/commit/" + sha;
	}

	@RequestMapping("/{namespace}/{repo}/tree/**")
	public String repoTree(
			@PathVariable String namespace,
			@PathVariable String repo,
			HttpServletRequest request
			//@PathVariable String branch
			) {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String bestMatchPattern = (String ) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		AntPathMatcher apm = new AntPathMatcher();
		String branch = apm.extractPathWithinPattern(bestMatchPattern, path);

		return "redirect:" + gitlabUrl + "/" + namespace + "/" + repo + "/tree/" + branch;
	}

	@RequestMapping("/{namespace}/{repo}/compare")
	public String compare(
			@PathVariable String namespace,
			@PathVariable String repo
			) {

		return "redirect:" + gitlabUrl + "/" + namespace + "/" + repo + "/compare";
	}

	@RequestMapping("/{namespace}/{repo}/compare/{spec}")
	public String compare(
			@PathVariable String namespace,
			@PathVariable String repo,
			@PathVariable String spec
			) {

		return "redirect:" + gitlabUrl + "/" + namespace + "/" + repo + "/compare/" + spec;
	}

}
