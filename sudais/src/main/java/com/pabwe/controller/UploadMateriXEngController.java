package com.pabwe.controller;

import com.pabwe.model.UploadMateri;
import com.pabwe.services.SemesterService;
import com.pabwe.services.UploadMateriService;
import com.pabwe.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class UploadMateriXEngController {

    private UploadMateriService uploadMateriService;
    private SemesterService semesterService;
    private StorageService storageService;

    @Autowired
    public void setUploadMateriService(UploadMateriService uploadMateriService, SemesterService semesterService, StorageService storageService){
        this.uploadMateriService = uploadMateriService;
        this.semesterService = semesterService;
        this.storageService = storageService;
    }

    @RequestMapping("/x/eng")
    public String listMateriXEng(Model model) {
        model.addAttribute("uploadMateri", uploadMateriService.listUploadMateri());
        return "x/eng";
    }

    @RequestMapping(value="/materi/x/eng/create", method = RequestMethod.GET)
    public String addMateriXEng(Model model) {
        model.addAttribute("uploadMateri", new UploadMateri());
        model.addAttribute("listSemester", semesterService.listSemester());
        return "/form/formAddMateriXEng";
    }

    @RequestMapping(value="/materi/x/eng/create", method = RequestMethod.POST)
    public String saveMateriXEng(@RequestParam("idSemester") String idSemester, Model model, final @ModelAttribute(value = "uploadMateri") @Valid UploadMateri uploadMateri, BindingResult bindingResult, final @RequestParam(value = "file")MultipartFile uploadingFile){
        storageService.store(uploadingFile);
        uploadMateri.setFile(uploadingFile.getOriginalFilename());

        uploadMateri.setSemester(semesterService.getSemesterById(Integer.parseInt(idSemester)));
        model.addAttribute("uploadMateri", uploadMateriService.saveOrUpdate(uploadMateri));
        return "redirect:/x/eng";
    }


    @RequestMapping(value="/materi/x/eng/edit/{materiId}", method = RequestMethod.GET)
    public String editMateriXEng(@PathVariable Integer materiId, Model model) {
        model.addAttribute("listSemester", semesterService.listSemester());
        model.addAttribute("uploadMateri", uploadMateriService.getUploadMateriById(materiId));
        return "form/formAddMateriXEng";
    }

    @RequestMapping(value="/materi/x/eng/delete/{materiId}", method = RequestMethod.GET)
    public String deleteMateriXEng(@PathVariable Integer materiId) {
        uploadMateriService.deleteMateri(materiId);
        return "redirect:/x/eng";
    }

    @RequestMapping(value = "materi/x/eng/view/{materiId}")
    public String viewSiswa(@PathVariable Integer materiId, Model model){
        UploadMateri uploadMateri = uploadMateriService.getUploadMateriById(materiId);
        model.addAttribute("uploadMateri", uploadMateriService.getUploadMateriById(materiId));
        model.addAttribute("semester", semesterService);
        return "view/viewMateriXEng";
    }

    @RequestMapping("/x/neng")
    public String xneng() {
        return "/x/neng";
    }

}
