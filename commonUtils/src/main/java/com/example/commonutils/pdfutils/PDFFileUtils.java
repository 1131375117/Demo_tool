/*
package com.example.commonutils.pdfutils;
 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PDFFileUtils {
	
	*/
/**
	 * 方法名:          PDFToBase64
	 * 方法功能描述:     将pdf文件转换为Base64编码
	 * @param:        String sourceFile:源文件路径
	 * @return:       String  base64字符串     
	 * @Author:       zhouhu
	 * @Create Date:   2019年07月03日 
	 *//*

    public static String PDFToBase64(String sourceFile) {
        BASE64Encoder encoder = new BASE64Encoder();
        FileInputStream fin =null;
        BufferedInputStream bin =null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout =null;
        File file = new File(sourceFile);
        try {
            fin = new FileInputStream(file);
            bin = new BufferedInputStream(fin);
            baos = new ByteArrayOutputStream();
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = bin.read(buffer);
            while(len != -1){
                bout.write(buffer, 0, len);
                len = bin.read(buffer);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节
            bout.flush();
            byte[] bytes = baos.toByteArray();
            return encoder.encodeBuffer(bytes).trim();  
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fin.close();
                bin.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	
    */
/**
	 * 方法名:          base64StringToPDF
	 * 方法功能描述:     将base64编码内容转换为Pdf
	 * @param:        String base64Str:图片的base64字符串;
	 *                String businessType:图片数据类型
	 * @return:       void 
	 * @Author:       zhouhu
	 * @Create Date:  2019年07月03日 
	 *//*

    public static void base64StringToPDF(String base64Content,String businessId,String businessType){
        BASE64Decoder decoder = new BASE64Decoder();
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
        	//1.base64编码内容转换为字节数组
            byte[] bytes = decoder.decodeBuffer(base64Content);
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            bis = new BufferedInputStream(byteInputStream);
            
            //2.生成jpg图片，把图片保存到健康乐服务器
            String fileName = "aaa";
			String realPath=ConstantUtil.IMAGE_UPLOAD_URL + "temp" + System.getProperty("file.separator");
		  	String trueFileName=fileName+".pdf";
		  	String imageSavePath = realPath + trueFileName;
            File file = new File(imageSavePath);
            File path = file.getParentFile();
            
            if(!path.exists()){
                path.mkdirs();
            }
            
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
 
            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while(length != -1){
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            bos.flush();
            
            //3.将保存到服务器的图片上传到hadoop上，并把服务器上的图片删除
			File[] fileArray = new File[1];
			fileArray[0] = new File(imageSavePath);
			
			String[] fileNameArray = new String[1]; 
			fileNameArray[0] = fileName + ".pdf";
			
			// 调用接口保存到hdfs
			String res = HttpClientUtil.uploadFile(fileArray, fileNameArray, businessType,businessId);
			System.out.println("============PDFFileUtils:" + res + "==");
			
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	try {
        		bis.close();
        		fos.close();
        		bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    */
/**
	 * 方法名:          uploadPdfFile
	 * 方法功能描述:     将base64编码内容转换为Pdf
	 * @param:        String physicalId:体检报告ID;
	 *                String businessType:图片数据类型
	 * @return:       String  UUID 
	 * @Author:       zhouhu
	 * @Create Date:  2019年07月03日 
	 *//*

    @SuppressWarnings("unchecked")
	public static void uploadPdfFile(String pdfUrl,String physicalId,String businessId,String businessType) {
    	String url = pdfUrl + physicalId;
    	String result = HttpGetUtil.get(url);
    	Map<String, String> map = JsonUtils.toObject(result, Map.class);
    	if(map!=null) {
    		String pdfBase64 = map.get("resultData");
    		if(StringUtils.isNotEmpty(pdfBase64)) {
    			base64StringToPDF(pdfBase64,businessId, businessType);
    		}
    	}
    }
    
    @SuppressWarnings("unchecked")
	public static String getBase64(String pdfUrl,String physicalId) {
    	String url = pdfUrl + physicalId;
    	String result = HttpGetUtil.get(url);
    	Map<String, String> map = JsonUtils.toObject(result, Map.class);
    	if(map!=null) {
    		String pdfBase64 = map.get("resultData");
    		return pdfBase64;
    	}
    	
    	return null;
    }
	public static void main(String[] args) {
		base64StringToPDF(PDFToBase64("D:\\ocrImage\\2.pdf"),UUIDUtil.generateUUID(),"TJ");
	}
}*/
