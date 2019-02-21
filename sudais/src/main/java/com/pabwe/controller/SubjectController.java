package com.pabwe.controller;

import com.pabwe.model.Subject;
import com.pabwe.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public void setSubjectService(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @RequestMapping("/subject/indexSubject")
    public String dataSubjectList(Model model){
        model.addAttribute("subject", subjectService.listSubject());
        return "/subject/indexSubject";
    }

    @RequestMapping(value="/subject/create", method = RequestMethod.GET)
    public String addSubject(Model model) {
        model.addAttribute("subject", new Subject());
        return "/subject/addSubject";
    }

    @RequestMapping(value="/subject/create", method = RequestMethod.POST)
    public String saveSubject(Model model, Subject subject) {
        model.addAttribute("subject", subjectService.saveOrUpdate(subject));
        return "redirect:/subject/indexSubject";
    }

    @RequestMapping(value="/subject/edit/{subjectId}", method = RequestMethod.GET)
    public String editSubject(@PathVariable Integer subjectId, Model model) {
        model.addAttribute("subject", subjectService.getSubjectById(subjectId));
        return "subject/addSubject";
    }

    @RequestMapping(value="/subject/delete/{subjectId}", method = RequestMethod.GET)
    public String deleteSubject(@PathVariable Integer subjectId) {
        subjectService.deleteSubject(subjectId);
        return "redirect:/subject/indexSubject";
    }
}
