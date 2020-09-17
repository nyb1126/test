package com.nyb.demo.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Author:nyb
 * @DESC: freemarker实现文件上传
 * @Date: Created in 16:54 2020/9/16
 * @Modified By:
 */
@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    private final ResourceLoader resourceLoader;

    @Autowired
    public TestController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;
    @Value("${addr.file.path}")
    private String filePath;

    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping("test")
    public String toUpload(){
        return "/test";
    }

    /**
     *
     * @param file 要上传的文件
     * @return
     */
    @RequestMapping("fileUpload")
    public String upload(@RequestParam("fileName") MultipartFile file, Map<String, Object> map){
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        // 这需要填写一个本地路径
        File dest = new File(path + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return "forward:/test";
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }

//        // 要上传的目标文件存放路径
//        String localPath = path;
//        // 上传成功或者失败的提示
//        String msg = "";
//
//        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
//            // 上传成功，给出页面提示
//            msg = "上传成功！";
//        }else {
//            msg = "上传失败！";
//
//        }
//
//        // 显示图片
//        map.put("msg", msg);
//        map.put("fileName", file.getOriginalFilename());

        return "hello";
    }

    /**
     * 显示单张图片
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity showPhotos(String fileName){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
