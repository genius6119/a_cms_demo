package cn.qimu.common;


import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import cn.qimu.common.Constants;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


/**
 * Create By Zhang on 2018/3/26
 */
public class QiniuFileUploadUtil {

    public static String upload(MultipartFile file,int type) throws IOException {
        /**获取全局唯一标识*/
        String uuid=UUID.randomUUID().toString().replaceAll("\\-", "");
        /**文件前缀*/
        String prefix=null;
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(Constants.QINIU_ACCESS_KEY, Constants.QINIU_SECRET_KEY);
        String upToken = auth.uploadToken(Constants.QINIU_BUCKET_NAME);
        Response response=null;
        /**根据类型选择不同前缀*/
        switch (type){
            case 1:
                prefix=Constants.QINIU_PREFIX_IMAGE;
                response= uploadManager.put(file.getBytes(),prefix+uuid, upToken);
                break;
            case 2:
                prefix=Constants.QINIU_PREFIX_VEDIO;
                response= uploadManager.put(file.getBytes(),prefix+uuid, upToken);
                break;
            case 3:
                prefix=Constants.QINIU_PREFIX_FILE;
                response= uploadManager.put(file.getBytes(),prefix+uuid+".zip", upToken);
                break;
        }
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        return putRet.key; /**返回文件名*/

    }
}
