/**
 * 
 */
package indi.jack.testservice;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>Title:AsyncMethod</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月15日 下午4:41:36
 */
@Async
public interface AsyncMethod {
	@Async
	void sayHello5slater();
}
