/**
 * 
 */
package indi.jack.testservice;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * <p>Title:SchedulerMethod</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月15日 下午5:00:05
 */

public interface SchedulerMethod {
	@Async
	@PreAuthorize(value="hasAuthority('DELETE_PPT')")
	void testScheduler();
}
