package com.pabwe.controller;

import com.pabwe.model.Guru;
import com.pabwe.model.Siswa;
import com.pabwe.model.User;
import com.pabwe.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    private SiswaService siswaService;
    private GuruService guruService;
    private SubjectService subjectService;
    private KelasService kelasService;
    private JurusanService jurusanService;

    @Autowired
    void injectDependency(UserService userService, GuruService guruService, SiswaService siswaService, SubjectService subjectService, KelasService kelasService, JurusanService jurusanService) {
        this.userService = userService;
        this.guruService = guruService;
        this.siswaService = siswaService;
        this.subjectService = subjectService;
        this.kelasService = kelasService;
        this.jurusanService = jurusanService;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value="/akademik/guru/create", method = RequestMethod.GET)
    public ModelAndView signUpGuru() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        Guru guru = new Guru();
        model.addObject("user", user);
        model.addObject("guru", guru);
        model.addObject("listSubject", subjectService.listSubject());
        model.addObject("listKelas", kelasService.listKelas());
        model.setViewName("/form/formAddDataAkademikGuru");

        return model;
    }

    @RequestMapping(value="/akademik/siswa/create", method = RequestMethod.GET)
    public ModelAndView signUpSiswa() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        Siswa siswa = new Siswa();
        model.addObject("user", user);
        model.addObject("siswa", siswa);
        model.addObject("listJurusan", jurusanService.listJurusan());
        model.addObject("listKelas", kelasService.listKelas());
        model.setViewName("/form/formAddDataAkademikSiswa");

        return model;
    }

    @RequestMapping(value="/akademik/guru/create", method = RequestMethod.POST)
    public ModelAndView createUserGuru(@RequestParam("idSubject") String idSubject, @RequestParam("idKelas") String idKelas, @Valid User user, @Valid Guru guru, @Valid Siswa siswa, BindingResult bindingResult, @RequestParam(value="jenis_role") int jenis_role) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findByUsername(user.getUsername());

        logger.error("Nilai role: " + jenis_role);
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user", "This username already exists!");
        }
        if (bindingResult.hasErrors()) {
            model.setViewName("/form/formAddDataAkademikGuru");
        } else {

            if (jenis_role == 2) {
                user.setGuru(guru);
                guru.setUser(user);
                guru.setSubject(subjectService.getSubjectById(Integer.parseInt(idSubject)));
                guru.setKelas(kelasService.getKelasById(Integer.parseInt(idKelas)));
                userService.save(user);
                guruService.saveOrUpdate(guru);
            } else if (jenis_role == 3) {
                user.setSiswa(siswa);
                siswa.setUser(user);
                userService.save(user);
                siswaService.saveOrUpdate(siswa);
            }
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("redirect:/dataAkademikGuru");
        }
        return model;
    }

    @RequestMapping(value="/akademik/siswa/create", method = RequestMethod.POST)
    public ModelAndView createUserSiswa(@RequestParam("idKelas") String idKelas, @RequestParam("idJurusan") String idJurusan, @Valid User user, @Valid Guru guru, @Valid Siswa siswa, BindingResult bindingResult, @RequestParam(value="jenis_role") int jenis_role) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findByUsername(user.getUsername());

        logger.error("Nilai role: " + jenis_role);
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user", "This username already exists!");
        }
        if (bindingResult.hasErrors()) {
            model.setViewName("/form/formAddDataAkademikSiswa");
        } else {

            if (jenis_role == 2) {
                user.setGuru(guru);
                guru.setUser(user);
                userService.save(user);
                guruService.saveOrUpdate(guru);
            } else if (jenis_role == 3) {
                user.setSiswa(siswa);
                siswa.setUser(user);
                siswa.setKelas(kelasService.getKelasById(Integer.parseInt(idKelas)));
                siswa.setJurusan(jurusanService.getJurusanById(Integer.parseInt(idJurusan)));
                userService.save(user);
                siswaService.saveOrUpdate(siswa);
            }
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new User());
            model.setViewName("redirect:/dataAkademikSiswa");
        }
        return model;
    }
}
