/**
 * 
 */
package indi.jack.testserviceImpl;

/**
 * <p>Title:GreetingServiceImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月9日 上午9:10:49
 */
import org.springframework.stereotype.Service;

import indi.jack.testservice.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService
{
    @Override
    public String getGreeting(String name)
    {
        return "Hello, " + name + "!";
    }
}
