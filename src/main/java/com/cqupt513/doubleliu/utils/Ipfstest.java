package com.cqupt513.doubleliu.utils;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Ipfstest {
    static IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");//ipfs的服务器地址和端口
        public static String upload(String filePathName) throws IOException {
            //filePathName指的是文件的上传路径+文件名，如D:/1.png  
        NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File(filePathName));
        MerkleNode addResult = ipfs.add(file).get(0);
        return addResult.hash.toString();
        }
    public static void download(String filePathName,String hash) throws IOException {
        Multihash filePointer = Multihash.fromBase58(hash);
        filePathName="D:\\test\\"+filePathName;
        byte[] data = ipfs.cat(filePointer);
        if(data != null) {
            File file = new File(filePathName);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data, 0, data.length);
            fos.flush();
            fos.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String hash=upload("C:\\Users\\Administrator\\Desktop\\logo.png");
        System.out.println(hash);
        download("newLogo.png",hash);
    }

}
