/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.cohort.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.api.context.UserContext;
import org.openmrs.module.cohort.CohortRole;
import org.openmrs.module.cohort.CohortType;
import org.openmrs.module.cohort.api.CohortService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * The main controller.
 */
@Controller
public class CohortTypeManageController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/module/cohort/cohorttypemanage", method = RequestMethod.GET)
	public void manage(HttpSession httpSession, HttpServletRequest request, ModelMap model, @RequestParam(required = false, value = "name") String cohort_name, @ModelAttribute("cohorttype") CohortType cohort) {
		CohortService service = Context.getService(CohortService.class);
		if ("search".equals(request.getParameter("search"))) {
			List<CohortType> list1 = service.findCohortType(cohort_name);
			for (int i = 0; i < list1.size(); i++) {
				CohortType c = (CohortType) list1.get(i);
				model.addAttribute("CohortTypeList", list1);
			}
		}
	}
	
	@RequestMapping(value = "/module/cohort/cohortrolemanage", method = RequestMethod.GET)
	public void manage1(HttpSession httpSession, HttpServletRequest request, ModelMap model, @RequestParam(required = false, value = "name") String cohort_name, @ModelAttribute("cohortrole") CohortRole cohort) {
		CohortService service = Context.getService(CohortService.class);
		if ("search".equals(request.getParameter("search"))) {
			List<CohortRole> list1 = service.findCohortRole(cohort_name);
			for (int i = 0; i < list1.size(); i++) {
				CohortRole c = (CohortRole) list1.get(i);
				model.addAttribute("CohortTypeList", list1);
			}
		}
	}
}
	
