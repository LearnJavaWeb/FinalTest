package thinhluffy.com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thinhluffy.com.test.model.NhanVien;
import thinhluffy.com.test.model.NhomNhanVien;
import thinhluffy.com.test.service.NhanVienService;
import thinhluffy.com.test.service.NhomNhanVienService;

import java.util.Optional;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private NhomNhanVienService nhomNhanVienService;

    @ModelAttribute("nhomnvs")
    public Iterable<NhomNhanVien> nhomNhanViens(){
        return nhomNhanVienService.findAll();
    }

    //tao nhan vien
    @GetMapping("/create-nhanvien")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("nhanvien",new NhanVien());
        return modelAndView;
    }
    //luu nhan vien
    @PostMapping("/create-nhanvien")
    public ModelAndView saveNhanVien(@ModelAttribute("nhanvien") NhanVien nhanVien){
        nhanVienService.save(nhanVien);

        ModelAndView modelAndView = new ModelAndView("/nhanvien/create");
        modelAndView.addObject("nhanvien", new NhanVien());
        modelAndView.addObject("message", "New employee created successfully");
        return modelAndView;
    }
    @GetMapping("/nhanviens")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<NhanVien> nhanviens;
        if(s.isPresent()){
            nhanviens = nhanVienService.findAllByTenContaining(s.get(), pageable);
        } else {
            nhanviens = nhanVienService.findAll(pageable);
        }


        ModelAndView modelAndView = new ModelAndView("/nhanvien/list");
        modelAndView.addObject("nhanviens", nhanviens);
        return modelAndView;
    }
    @GetMapping("/edit-nhanvien/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        NhanVien nhanvien = nhanVienService.findById(id);
        if(nhanvien != null) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
            modelAndView.addObject("nhanvien", nhanvien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-nhanvien")
    public ModelAndView updateEmployee(@ModelAttribute("nhanvien") NhanVien nhanvien){
        nhanVienService.save(nhanvien);
        ModelAndView modelAndView = new ModelAndView("/nhanvien/edit");
        modelAndView.addObject("nhanvien", nhanvien);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-nhanvien/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id){
        NhanVien nhanvien = nhanVienService.findById(id);
        if(nhanvien != null) {
            ModelAndView modelAndView = new ModelAndView("/nhanvien/delete");
            modelAndView.addObject("nhanvien", nhanvien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-nhanvien")
    public String deleteCustomer(@ModelAttribute("nhanvien") NhanVien nhanvien){
        nhanVienService.remove(nhanvien.getId());
        return "redirect:/nhanviens";
    }

}
