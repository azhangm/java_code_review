package nuc.zm.MoreThreadAndIo;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 转载
 * @description  多线程下载器
 * @author zm
 * @date 2022/11/06
 */
public class DownLoad {

    private Integer threadNum = 10;
    public void download(String source,String target) {
        InputStream ios = null;
        OutputStream oos = null;

        String filename = null;
        try {
            URL url = new URL(source);
            URLConnection urlConnection = url.openConnection();
            ios = urlConnection.getInputStream();
            filename = source.substring(source.lastIndexOf("/") + 1);
            oos = new FileOutputStream(target + File.separator +  filename) ;
            int len;
            byte[] bs = new byte[1024];
            while ((len = ios.read(bs)) != -1) {
                oos.write(bs,0,len);
            }
        }catch (IOException e)  {
            e.printStackTrace();
        }finally {
            try {
                if (oos != null) oos.close();
                if (ios != null) ios.close();
              } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("[INFO] 文件下载完毕 + 文件地址为[" + target + File.separator + filename + "]");

        }
}
//      指定 properties 的路径
        public void start(String proDir) {
            Reader reader = null;
            File proFile = new File(proDir + File.separator +"config.properties");
            Properties properties = new Properties();
            try {
                reader = new FileReader(proFile);
                properties.load(reader);
                String property = properties.getProperty("thread-num");
                threadNum = Integer.valueOf(property);
                String targetDir = properties.getProperty("targetDir");
                this.multiDownloadFromFiles(targetDir,proDir + File.separator + "download.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

//    读取 下载列表
     public void multiDownloadFromFiles(String targetDir , String downloadTxt) {
         File file = new File(targetDir);
         if (!file.exists()) {
             file.mkdirs();
             System.out.println("[INFO]发现下载目录[" + targetDir + "] 不存在" + "已经自动创建");
         }
         ArrayList<String > fileList = new ArrayList<>();
         BufferedReader reader = null;
         ExecutorService executorService = null;
         try {
             reader = new BufferedReader(new FileReader(downloadTxt));
             String line = null;
             while ((line = reader.readLine()) != null ) {
                 fileList.add(line);
                 System.out.println(line);
             }
             executorService = Executors.newFixedThreadPool(threadNum);
             for (String s : fileList) {
                 executorService.execute(() -> DownLoad.this.download(s,targetDir));
             }
         }catch (IOException e) {
                     e.printStackTrace();
             }finally {
             if (reader != null) {
                 try {
                     reader.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             if (executorService != null) {
                 executorService.shutdown();
             }
         }
     }




    public static void main(String[] args) {
        DownLoad downLoad = new DownLoad();
        downLoad.start("e:/code_review/JAVASE");
        //          Reader reader = null;
//        new DownLoad().download("https://lf-cdn-tos.bytescm.com/obj/static/xitu_extension/static/gold.981a5510.svg","");
//        File proFile = new File("JAVASE/config.properties");
//        Properties properties = new Properties();
//        try {
//            reader = new FileReader(proFile);
//            properties.load(reader);
//            String property = properties.getProperty("thread-num");
//            String targetDir = properties.getProperty("targetDir");
//            System.out.println(property);
//            System.out.println(targetDir);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

