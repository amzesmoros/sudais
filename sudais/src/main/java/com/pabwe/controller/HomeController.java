package com.pabwe.controller;

import com.pabwe.services.SiswaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	 
	 @RequestMapping("/")
	 public String home() {
		return "dashboard";
	 }
	 
	 @RequestMapping("/dashboard")
	 public String dashboard() {
		 return "dashboard";
	 }
	 
	 @RequestMapping("/login")
	 public String login() {
		return "login";
	 }
	 
	 @RequestMapping("/datadiri")
	 public String datadiri() {
		 return "datadiri";
	 }
	 
	 @RequestMapping("/form/formAddDataAkademik")
	 public String editDataAkademik() {
		 return "/form/formAddDataAkademik";
	 }
	 
	 @RequestMapping("/list/listDataAkademik")
	 public String addMember() {
		 return "/list/listDataAkademik";
	 }
	 
	 @RequestMapping("/logout")
	 public String logout() {
		 return "login";
	 }


	 //Mappping yg tidak jelas
	 @RequestMapping("/datadiri/edit")
	 public String editdata() {
		 return "/form/formEditDataDiri";
	 }

	 @RequestMapping("/view/viewPengumuman")
	 public String viewPengumuman(){
	 	return "/view/viewPengumuman";
	 }


	@RequestMapping("/view/viewSiswa")
	public String viewSiswa(){
		return "/view/viewSiswa";
	}

	@RequestMapping("/view/viewGuru")
	public String viewGuru(){
		return "/view/viewGuru";
	}

	@RequestMapping("/form/formAddNilai")
	public String addNilai(){
	 	return "/form/formAddNilai";
	}

	@RequestMapping("/access-denied")
	public String ditolak(){
		return "/error/access-denied";
	}

}
