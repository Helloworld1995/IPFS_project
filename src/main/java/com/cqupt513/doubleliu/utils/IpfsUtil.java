package com.cqupt513.doubleliu.utils;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class IpfsUtil {
    private IPFS ipfs=new IPFS("/ip4/127.0.0.1/tcp/5001");
    private String filepath="D:\\doubleliu\\src\\main\\resources\\static\\medicPhotos\\";
    public String uploadFile(File file){
        NamedStreamable.FileWrapper savefile = new NamedStreamable.FileWrapper(file);
        MerkleNode result = null;
        try {
            result = ipfs.add(savefile).get(0);
        } catch (IOException e) {
            return "上传文件到IPFS失败";
        }
        return result.hash.toString();//返回结果里面获取保存文件的唯一hash，基于文件内容的 hash
    }
    public String download(String filename,String hash) throws IOException {
        Multihash filePointer = Multihash.fromBase58(hash);
        byte[] data = ipfs.cat(filePointer);
        String filePathName=filepath+filename;
        if(data != null){
            File file = new File(filePathName);
            if(file.exists()){
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data,0,data.length);
            fos.flush();
            fos.close();
        }
        return filename;
    }
}
