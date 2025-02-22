package cn.tedu.baking.controller;

import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@Api(tags = "上传管理模块")
@RestController
@RequestMapping("/v1/")
public class UploadController {
    // 确保路径分隔符统一使用File.separator
    String dirpath = "D:" + File.separator + "university" + File.separator + "java" + File.separator + "Tedu" + File.separator + "review" + File.separator + "stage2" + File.separator + "baking" + File.separator + "img";
    @PostMapping("upload")
    //先创建文件夹再创建文件
    public JsonResult upload(MultipartFile file) throws IOException {
        //创建新的独一无二的名字
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename=UUID.randomUUID()+substring;
        //创建日期文件夹
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yyyy/MM/dd/");
        String datepath = simpleDateFormat.format(new Date());
        File file1 = new File(dirpath + datepath);
        if (!file1.exists()){
            file1.mkdirs();//递归创建
        }
        //传送文件
        file.transferTo(new File(dirpath+datepath+filename));
        System.out.println(datepath+filename);
        return JsonResult.ok(datepath+filename);


    }
    @PostMapping("remove")
    public JsonResult remove(String url){
        boolean delete = new File(dirpath + url).delete();
        return delete?JsonResult.ok():new JsonResult(StatusCode.OPERATION_FAILED);
    }
}


