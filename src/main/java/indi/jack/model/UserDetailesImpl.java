/**
 * 
 */
package indi.jack.model;

import java.nio.charset.StandardCharsets;
import java.util.Collection;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * Title:UserDetailesImpl用户细节模型
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author jackhoo
 * @date 2017年3月22日 上午11:25:31
 */
public class UserDetailesImpl implements UserDetails, CredentialsContainer, Cloneable {
	private static final long serialVersionUID = 1L;
	private String username;
	private byte[] password;
	private Collection<? extends GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return new String(password, StandardCharsets.UTF_8);
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	@Override
	public void eraseCredentials() {
		this.password = null;
	}

	@Override
	public int hashCode() {
		return this.username.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof UserDetailesImpl && ((UserDetailesImpl) other).username == this.username;
	}

	@Override
	public String toString() {
		return "UserDetailesImpl [username=" + username + ", password=" + password + ", authorities=" + authorities
				+ ", accountNonExpired=" + enabled + ", accountNonLocked=" + enabled + ", credentialsNonExpired="
				+ enabled + ", enabled=" + enabled + "]";
	}

}
