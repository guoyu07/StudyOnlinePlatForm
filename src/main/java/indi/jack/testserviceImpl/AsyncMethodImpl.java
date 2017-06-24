/**
 * 
 */
package indi.jack.testserviceImpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import indi.jack.testservice.AsyncMethod;

/**
 * <p>Title:AsyncMethodImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月15日 下午4:43:02
 */
@Service
public class AsyncMethodImpl implements AsyncMethod{

	/* (non-Javadoc)
	 * @see indi.jack.service.AsyncMethod#sayHello5slater()
	 */
	@Override
	@Async
	public void sayHello5slater() {
		try {
			Thread.sleep(15000l);
			System.out.println("过了5秒钟Hello");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
