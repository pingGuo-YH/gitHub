package com.zyh.service.impl;

import com.zyh.pojo.Resp;
import com.zyh.service.RespService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class RespServiceImpl implements RespService {

    @Override
    public Resp<String> upload(MultipartFile file) {
        if (file.isEmpty()) { // 判断 file 文件是否为空
            return Resp.fail("400", "文件为空");
        }
        String originalFilename = file.getOriginalFilename(); // 文件名称
        String fileName = System.currentTimeMillis() + "." + originalFilename.substring(originalFilename.lastIndexOf(".") + 1); //文件名 . 后的后缀名
        String filePath = "D:\\Git\\"; // 文件夹存储目录
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) { // 判断 filePath 的目录是否存在，不存在便创建 filePath 的目录
            dest.getParentFile().mkdirs(); // 新建目录
        }
        try {
            file.transferTo(dest); //文件输出
        } catch (Exception e) {
            e.printStackTrace();
            Resp.fail("500", originalFilename + "上传失败！");
        }
        return Resp.success(fileName);
    }

}
