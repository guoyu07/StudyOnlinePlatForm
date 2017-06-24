/**
 * 
 */
package indi.jack.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Title:FileUtil</p>
 * <p>Description:文件工具</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月2日 下午1:37:38
 */
public interface FileUtil {
	void saveFile(MultipartFile file,String filepath, String filename);
}
