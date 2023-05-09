package com.cuit9622.common.controller;

import com.cuit9622.common.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Author: lsh
 * Date: 2023/5/9 19:41
 * Version: 1.0
 * @Description: 文件上传和加载的控制器
 */
@RestController
@Slf4j(topic = "FileController")
public class FileController {

    @Value("${filePath}")
    private String basePath;


    /**
     * @Description 文件上传
     * @param file
     * @return UUID生成的文件名字
     * @Date 19:55 2023/5/9
     */
    @PostMapping("/img/upload")
    public R<String> upload(MultipartFile file){
        log.info(file.toString());

        // 原始文件名字
        String originalFilename = file.getOriginalFilename();

        // 获取文件后缀
        String suffix = null;
        if (originalFilename != null) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        // 使用UUID来生成文件名，防止文件名重复
        String fileName = UUID.randomUUID().toString() + suffix;

        // 判断当前目录是否存在，如果不存在就创建
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            // 将临时文件转存到指定位置
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return R.ok(fileName);
    }

    /**
     * @Description 文件下载
     * @return
     * @Date 19:56 2023/5/9
     */
    @GetMapping("/img/download")
    public void download(String name, HttpServletResponse response) {
        try {
            // 从输入流中读取文件
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(basePath + name));

            response.setContentType("image/jpeg");

            // 向浏览器中输出数据,用于展示图片
            int len = -1;
            byte[] bytes = new byte[1024];
            ServletOutputStream os = response.getOutputStream();
            while ((len = bis.read(bytes)) != -1) {
                os.write(bytes,0,len);
                os.flush();
            }
            // 关闭资源
            os.close();
            bis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
