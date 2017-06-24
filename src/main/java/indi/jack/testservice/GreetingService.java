/**
 * 
 */
package indi.jack.testservice;


import org.springframework.security.access.prepost.PreAuthorize;

/**
 * <p>Title:GreetingService</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月9日 上午9:09:46
 */

public interface GreetingService
{	
	@PreAuthorize(value="#name=='jack' and(" + "hasAuthority('DELETE_PPT'))")
    public String getGreeting(String name);
}
