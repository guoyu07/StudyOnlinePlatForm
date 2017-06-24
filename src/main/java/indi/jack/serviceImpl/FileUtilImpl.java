/**
 * 
 */
package indi.jack.serviceImpl;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import indi.jack.service.FileUtil;

/**
 * <p>Title:FileUtilImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月2日 下午1:39:53
 */
@Service
public class FileUtilImpl implements FileUtil{
	private static final Logger log =LogManager.getLogger();
	@Override
	/*@Async*/
	public void saveFile(MultipartFile multipartFile, String filepath, String filename) {
		File filedir=new File(filepath);
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
			}
		}
		try {
			//System.out.println("正在读取内容");
			multipartFile.transferTo(file);
			//System.out.println("文件保存成功");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("不允许在响应结束后传输数据！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("multipart文件转化本地文件异常");
		}
		/*return true;*/
	}
}
