package cn.qimu.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
/**
 * 文件上传类
 * 返回绝对路径
 * */
public class UploadPath {
    /**根目录下的下一级目录*/
    public static final String FOLDER="/resource-files/";

    public static String getUploadPath(MultipartFile file) throws IOException {
        String idisk=new File("/").getAbsolutePath();   					/**获取项目所在磁盘*/
        String disk=idisk.replaceAll("\\\\","");					/**反斜杠改为空*/
        String name= file.getOriginalFilename();									/**文件名称*/
        File uploadF=new File(FOLDER+name);
        String fullPath=disk+FOLDER+name;											/**拼接字符串*/
        file.transferTo(uploadF);
        return fullPath;
    }
}
