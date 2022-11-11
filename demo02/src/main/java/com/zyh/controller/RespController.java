package com.zyh.controller;

import com.zyh.pojo.Resp;
import com.zyh.service.RespService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RespController {

    @Autowired
    private RespService respService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    private Resp<String> upload(@RequestParam("file")MultipartFile file){
        return respService.upload(file);
    }
}
