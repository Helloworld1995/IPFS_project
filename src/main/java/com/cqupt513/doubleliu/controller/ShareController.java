package com.cqupt513.doubleliu.controller;

import com.cqupt513.doubleliu.pojo.Addr;
import com.cqupt513.doubleliu.pojo.Manager;
import com.cqupt513.doubleliu.services.ShareService;
import com.cqupt513.doubleliu.utils.DES;
import com.cqupt513.doubleliu.utils.IpfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/share")
public class ShareController {
    @Autowired(required = false)
    ShareService shareService;
    @Autowired
    IpfsUtil ipfsUtil;
    @Autowired
    DES des;
    @GetMapping("")
    public String share(Model model){
        List<Addr> addrs = shareService.listAddr();
        model.addAttribute("addrs",addrs);
        return "/share";
    }
    @PostMapping("/decode")
    public String decode(Addr addr, Model model){
        Addr addr1 = shareService.findAddr(addr);
        String index=addr1.getIdx();
        String key=addr1.getEncode();
        index = des.decode(index, key);
        model.addAttribute("ipfs",index);
        model.addAttribute("encode",key);
        return "/share :: table_refresh";
    }
    @PostMapping("/findimg")
    public String findimg(Addr addr, Model model){
        Manager m=new Manager();
        m.setHash(addr.getIdx());
        String fileName = shareService.findFileName(m);
        String path="";
        try {
            path = ipfsUtil.download(fileName, addr.getIdx());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path);
        model.addAttribute("path",path);
        return "/share :: img_refresh";
    }
}
