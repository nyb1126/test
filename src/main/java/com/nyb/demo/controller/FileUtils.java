package com.nyb.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 15:35 2020/6/8
 * @Modified By:
 */
@Controller
public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    @Value("${file.upload.path}")
    private String uploadFilePth;

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file,String filePath) {
        logger.info("下载文件开始");
        filePath=uploadFilePth;
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        // 这需要填写一个本地路径
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return "index";
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
