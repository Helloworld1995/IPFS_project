package com.cqupt513.doubleliu.controller;
import com.cqupt513.doubleliu.pojo.Addr;
import com.cqupt513.doubleliu.pojo.Key;
import com.cqupt513.doubleliu.pojo.Manager;
import com.cqupt513.doubleliu.services.StoreManagerToDBService;
import com.cqupt513.doubleliu.utils.DES;
import com.cqupt513.doubleliu.utils.IpfsUtil;
import com.cqupt513.doubleliu.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/divided")
public class StorageController {
    @Autowired
    StoreManagerToDBService storeManagerToDBService;
    @Autowired
    IpfsUtil ipfsUtil;
    @Autowired
    MD5Util md5Util;
    @Autowired
    DES des;
    @GetMapping("")
    public String divied(){
        return "/divided";
    }
    @GetMapping("/page1")
    public String directToPage1(){
        return "/EPstore";
    }
    @GetMapping("/page2")
    public String directToPage2(Model model){
        List<Manager> managers = storeManagerToDBService.listManagers();
        Iterator<Manager> it=managers.iterator();
        while(it.hasNext()){
            Manager m=it.next();
            if(m.getCount()==1){
                it.remove();
            }
        }
        model.addAttribute("managers",managers);
        return "/IndexStore";
    }
    @PostMapping("/EPstore")
    public String store(@RequestParam("fileName") MultipartFile file, Manager m, RedirectAttributes attributes, Model model){
        String hash="";
        if(file.isEmpty()){
            attributes.addFlashAttribute("message","文件上传失败");
            return "redirect:/page1";
        }
        File newfile=null;
        String fname=file.getOriginalFilename();
        String[] f=fname.split("\\.");
        try {
            newfile=File.createTempFile(f[0],f[1]);
            file.transferTo(newfile);
            hash=ipfsUtil.uploadFile(newfile);
        } catch (IOException e) {
            return "redirect:/page1";
        }
        m.setHash(hash);
        m.setFname(fname);
        m.setDate(new Date());
        if(storeManagerToDBService.find(m)==0){
            storeManagerToDBService.store(m);
        }
        model.addAttribute("manager",m);
        attributes.addFlashAttribute("check",1);
        return "/success1";
    }
    @PostMapping("/Indexstore")
    public String store2(Key key,RedirectAttributes attributes,Model model){
        String index=key.getHash();
        String sykey=key.getSykey();
        if(index.equals("")||sykey.equals("")){
            attributes.addFlashAttribute("check",0);
            return "redirect:/page2";
        }
        Manager m=new Manager();
        m.setHash(index);
        Manager res=storeManagerToDBService.selectCount(m);
        if(res==null){
            return "redirect:/page2";
        }
        String address=md5Util.inputPassToDBPass(index);
        Addr addr=new Addr();
        index=des.encode(index,sykey);
        addr.setAddress(address);
        addr.setEncode(sykey);
        addr.setIdx(index);
        addr.setMid(res.getId());
        m.setCount(res.getCount()+1);
        Integer res2=storeManagerToDBService.insert(addr);
        if(res2==null){
            return "redirect:/page2";
        }
        if(storeManagerToDBService.updateCount(m)==null){
            return "redirect:/page2";
        }
        key.setAddress(address);
        model.addAttribute("key",key);
        attributes.addFlashAttribute("check",1);
        return "/success2";
    }
    @GetMapping("/listManagers")
    public String listManagers(Model model){
        List<Manager> managers = storeManagerToDBService.listManagers();
        model.addAttribute("managers",managers);
        return "/trace";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        storeManagerToDBService.delete(Integer.parseInt(id));
        return "redirect:/divided/listManagers";
    }
}
