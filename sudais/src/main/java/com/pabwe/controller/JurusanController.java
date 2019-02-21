package com.pabwe.controller;

import com.pabwe.model.Jurusan;
import com.pabwe.services.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JurusanController {

    private JurusanService jurusanService;

    @Autowired
    public void setJurusanService(JurusanService jurusanService){
        this.jurusanService = jurusanService;
    }

    @RequestMapping("/jurusan/indexJurusan")
    public String dataJurusanList(Model model){
        model.addAttribute("jurusan", jurusanService.listJurusan());
        return "/jurusan/indexJurusan";
    }

    @RequestMapping(value="/jurusan/create", method = RequestMethod.GET)
    public String addJurusan(Model model) {
        model.addAttribute("jurusan", new Jurusan());
        return "/jurusan/addJurusan";
    }

    @RequestMapping(value="/jurusan/create", method = RequestMethod.POST)
    public String saveJurusan(Model model, Jurusan jurusan) {
        model.addAttribute("jurusan", jurusanService.saveOrUpdate(jurusan));
        return "redirect:/jurusan/indexJurusan";
    }

    @RequestMapping(value="/jurusan/edit/{jurusanId}", method = RequestMethod.GET)
    public String editJurusan(@PathVariable Integer jurusanId, Model model) {
        model.addAttribute("jurusan", jurusanService.getJurusanById(jurusanId));
        return "jurusan/addJurusan";
    }

    @RequestMapping(value="/jurusan/delete/{jurusanId}", method = RequestMethod.GET)
    public String deleteJurusan(@PathVariable Integer jurusanId) {
        jurusanService.deleteJurusan(jurusanId);
        return "redirect:/jurusan/indexJurusan";
    }

}
