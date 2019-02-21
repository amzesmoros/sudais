package com.pabwe.controller;

import com.pabwe.model.Kelas;
import com.pabwe.services.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KelasController {

    private KelasService kelasService;

    @Autowired
    public void setKelasService(KelasService kelasService){
        this.kelasService = kelasService;
    }

    @RequestMapping("/kelas/indexKelas")
    public String dataKelasList(Model model){
        model.addAttribute("kelas", kelasService.listKelas());
        return "/kelas/indexKelas";
    }

    @RequestMapping(value="/kelas/create", method = RequestMethod.GET)
    public String addKelas(Model model) {
        model.addAttribute("kelas", new Kelas());
        return "/kelas/addKelas";
    }

    @RequestMapping(value="/kelas/create", method = RequestMethod.POST)
    public String saveKelas(Model model, Kelas kelas) {
        model.addAttribute("kelas", kelasService.saveOrUpdate(kelas));
        return "redirect:/kelas/indexKelas";
    }

    @RequestMapping(value="/kelas/edit/{kelasId}", method = RequestMethod.GET)
    public String editKelas(@PathVariable Integer kelasId, Model model) {
        model.addAttribute("kelas", kelasService.getKelasById(kelasId));
        return "kelas/addKelas";
    }

    @RequestMapping(value="/kelas/delete/{kelasId}", method = RequestMethod.GET)
    public String deleteKelas(@PathVariable Integer kelasId) {
        kelasService.deleteKelas(kelasId);
        return "redirect:/kelas/indexKelas";
    }

}
