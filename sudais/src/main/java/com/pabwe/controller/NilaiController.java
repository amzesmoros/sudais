package com.pabwe.controller;

import com.pabwe.model.Jurusan;
import com.pabwe.model.Nilai;
import com.pabwe.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Controller
public class NilaiController {

    private NilaiService nilaiService;
    private SiswaService siswaService;
    private SubjectService subjectService;
    private SemesterService semesterService;
    private JurusanService jurusanService;
    private KelasService kelasService;

    public NilaiController() {
    }

    @Autowired
    public void setNilaiService(NilaiService nilaiService, SiswaService siswaService, KelasService kelasService, SubjectService subjectService, SemesterService semesterService, JurusanService jurusanService){
        this.nilaiService = nilaiService;
        this.siswaService = siswaService;
        this.subjectService = subjectService;
        this.semesterService = semesterService;
        this.jurusanService = jurusanService;
        this.kelasService = kelasService;
    }

    @RequestMapping("/daftarSiswa")
    public String daftarSiswa(Model model){
        model.addAttribute("nilai", nilaiService.listNilai());
        model.addAttribute("siswa", siswaService);
        model.addAttribute("subject", subjectService);
        model.addAttribute("semester", semesterService);
        model.addAttribute("kelas", kelasService);
        model.addAttribute("jurusan", jurusanService);
        return "/daftarSiswa";
    }

    @RequestMapping(value="/nilai/siswa/create", method = RequestMethod.GET)
    public String addNilaiSiswa(Model model) {
        model.addAttribute("nilai", new Nilai());
        model.addAttribute("listSemester", semesterService.listSemester());
        model.addAttribute("listSubject", subjectService.listSubject());
        model.addAttribute("listSiswa", siswaService.listSiswa());
        return "/form/formAddNilai";
    }

    @RequestMapping(value="/nilai/siswa/create", method = RequestMethod.POST)
    public String saveNilaiSiswa(@RequestParam("idSubject") String idSubject, @RequestParam("idSemester") String idSemester,  @RequestParam("idSiswa") String idSiswa, Model model, Nilai nilai) {
        nilai.setSubject(subjectService.getSubjectById(Integer.parseInt(idSubject)));
        nilai.setSemester(semesterService.getSemesterById(Integer.parseInt(idSemester)));
        nilai.setSiswa(siswaService.getSiswaById(Integer.parseInt(idSiswa)));
        model.addAttribute("nilai", nilaiService.saveOrUpdate(nilai));
        return "redirect:/daftarSiswa";
    }

    @RequestMapping(value="/nilai/siswa/edit/{nilaiId}", method = RequestMethod.GET)
    public String editNilaiSiswa(@PathVariable Integer nilaiId, Model model) {
        model.addAttribute("listSemester", semesterService.listSemester());
        model.addAttribute("listSubject", subjectService.listSubject());
        model.addAttribute("listSiswa", siswaService.listSiswa());
        model.addAttribute("nilai", nilaiService.getNilaiById(nilaiId));
        return "form/formAddNilai";
    }

    @RequestMapping(value="/nilai/siswa/delete/{nilaiId}", method = RequestMethod.GET)
    public String deleteNilaiSiswa(@PathVariable Integer nilaiId) {
        nilaiService.deleteNilai(nilaiId);
        return "redirect:/daftarSiswa";
    }

    @RequestMapping(value = "nilai/siswa/view/{nilaiId}")
    public String viewNilaiSiswa(@PathVariable Integer nilaiId, Model model){
        Nilai nilai = nilaiService.getNilaiById(nilaiId);
        model.addAttribute("nilai", nilaiService.getNilaiById(nilaiId));
        model.addAttribute("siswa", siswaService);
        model.addAttribute("subject", subjectService);
        model.addAttribute("semester", semesterService);
        model.addAttribute("kelas", kelasService);
        model.addAttribute("jurusan", jurusanService);
        return "view/viewNilaiSiswa";
    }
}
