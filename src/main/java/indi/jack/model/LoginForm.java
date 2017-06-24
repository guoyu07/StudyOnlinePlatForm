/**
 * 
 */
package indi.jack.model;

/**
 * <p>Title:LoginForm用户登录表单模型</p>
 * <p>Description:需要使用bean验证以减轻服务方法的压力</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月23日 上午9:03:00
 */
public class LoginForm {
	/*@NotBlank(message="{validate.login.form.username.notblank}")
	@Pattern(regexp = "^[0-9]*$",message="{validate.login.form.username.onlydigit}")*/
	private Long username;
	/*@NotBlank(message="{validate.login.form.password.notblank}")*/
    private String password;

    public Long getUsername()
    {
        return username;
    }

    public void setUsername(Long username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
