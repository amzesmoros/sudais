package com.pabwe.controller;

import com.pabwe.model.Semester;
import com.pabwe.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SemesterController {

    private SemesterService semesterService;

    @Autowired
    public void setSemesterService(SemesterService semesterService){
        this.semesterService = semesterService;
    }

    @RequestMapping("/semester/indexSemester")
    public String dataSemesterList(Model model){
        model.addAttribute("semester", semesterService.listSemester());
        return "/semester/indexSemester";
    }

    @RequestMapping(value="/semester/create", method = RequestMethod.GET)
    public String addSemester(Model model) {
        model.addAttribute("semester", new Semester());
        return "/semester/addSemester";
    }

    @RequestMapping(value="/semester/create", method = RequestMethod.POST)
    public String saveSemester(Model model, Semester semester) {
        model.addAttribute("semester", semesterService.saveOrUpdate(semester));
        return "redirect:/semester/indexSemester";
    }

    @RequestMapping(value="/semester/edit/{semesterId}", method = RequestMethod.GET)
    public String editSemester(@PathVariable Integer semesterId, Model model) {
        model.addAttribute("semester", semesterService.getSemesterById(semesterId));
        return "semester/addSemester";
    }

    @RequestMapping(value="/semester/delete/{semesterId}", method = RequestMethod.GET)
    public String deleteSemester(@PathVariable Integer semesterId) {
        semesterService.deleteSemester(semesterId);
        return "redirect:/semester/indexSemester";
    }
}
