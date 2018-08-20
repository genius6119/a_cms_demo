package cn.qimu.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class QiniuInvoke {
    public static String callQiniu(MultipartFile file,int type){
        String url;
        String imgUrlName = null;
        try {
            imgUrlName = QiniuFileUploadUtil.upload(file,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url="http://"+Constants.QINIU_BUCKET_URL+"/"+imgUrlName;
        return url;
    }
}
