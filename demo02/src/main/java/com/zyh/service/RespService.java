package com.zyh.service;

import com.zyh.pojo.Resp;
import org.springframework.web.multipart.MultipartFile;

public interface RespService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    Resp<String> upload(MultipartFile file);
}
