/**
 * 
 */
package indi.jack.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <p>Title:RoleAuthority角色权限表</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月20日 下午8:45:57
 */
@Entity
@Table(name="Role_Permission")
public class RoleAuthority implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rolePermissionId;
	private Integer roleId;
	private Integer permissionId;
	private AuthorityEntity authorityEntity;
	@Id
	@Column(name="Role_Permission_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getRolePermissionId() {
		return rolePermissionId;
	}
	public void setRolePermissionId(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}
	@Column(name="Role_Id")
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Column(name="Permission_Id")
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	
	//不使用实体间关联技术，分散实体
	@OneToOne(fetch=FetchType.EAGER,cascade= CascadeType.PERSIST)
	@JoinColumn(name="Permission_Id",insertable=false,updatable=false)
	public AuthorityEntity getAuthorityEntity() {
		return authorityEntity;
	}
	public void setAuthorityEntity(AuthorityEntity authorityEntity) {
		this.authorityEntity = authorityEntity;
	}
	
}
