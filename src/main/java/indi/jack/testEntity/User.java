/**
 * 
 */
package indi.jack.testEntity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Title:User</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月12日 下午10:48:01
 */
@XmlRootElement
public class User
{
    private long userId;
    private String username;
    private String name;

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
