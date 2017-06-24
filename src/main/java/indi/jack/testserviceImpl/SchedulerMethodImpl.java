/**
 * 
 */
package indi.jack.testserviceImpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import indi.jack.testservice.SchedulerMethod;

/**
 * <p>Title:SchedulerMethodImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月15日 下午5:01:00
 */
@Service
public class SchedulerMethodImpl implements SchedulerMethod{

	@Override
	@Scheduled(initialDelay=5000l,fixedRate=15000l)
	public void testScheduler() {
		/*System.out.println("正在测试计划任务，每15s执行一次！");*/
	}
	
}
