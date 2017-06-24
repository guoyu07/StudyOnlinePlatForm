/**
 * 
 */
package indi.jack.util;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Title:Fileupload</p>
 * <p>Description:文件上传工具</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月2日 上午11:23:08
 */
@Component
@Async
public class FileUtil1{
	private static final Logger log =LogManager.getLogger();
	private MultipartFile multipartFile;
	private String filepath;
	private String filename;
	/*public FileUtil(MultipartFile multipartFile, String filepath, String filename) {
		this.multipartFile = multipartFile;
		this.filepath = filepath;
		this.filename = filename;
	}*/
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	//异步处理
	@Async
	public void Save(){
		/*File filedir=new File(filepath);
		if(!filedir.exists()){
			filedir.mkdirs();
		}
		File file=new File(filepath,filename);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				log.warn("文件创建失败！");
				e.printStackTrace();
				return false;
			}
		}
		try {
			System.out.println("正在读取内容");
			multipartFile.transferTo(file);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("不允许在响应结束后传输数据！");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("multipart文件转化本地文件异常");
			return false;
		}*/
		try {
			Thread.sleep(5000l);
			System.out.println("过了5秒钟Hello");
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*return true;*/
	}
	
	
}
