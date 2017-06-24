/**
 * 
 */
package indi.jack.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import indi.jack.entity.AccountInfo;
import indi.jack.entity.UserInfoEntitySearchable;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.SearchResult;

/**
 * <p>Title:AccountInfoService</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月10日 下午7:33:42
 */
public interface AccountInfoService {
	/*管理员权限对用于信息的操作*/
	//获取所有用户信息（不包含隐私信息)
	Page<UserInfoEntitySearchable> getAllUserInfo(Pageable pageable);
	Iterable<UserInfoEntitySearchable> getAllUserInfoNoPages();
	//获取用户所有信息(包含隐私信息)
	Page<UserPrincipal> getAllUserInfoPrivacy(Pageable pageable);
	//搜索所有用户信息(不包含隐私信息)
	Page<UserInfoEntitySearchable> search(String query, Pageable pageable);
	//批量保存用户信息(不包含隐私)
	Page<AccountInfo> batchSave(Iterable<AccountInfo> entities,Pageable pageable);
	//更新用户信息(包含隐私)
	UserPrincipal updatePrivacy(UserPrincipal entity);
	//删除用户信息(不包含隐私)
	void deleteByUser_Info_Id(Long userinfoId);
	/*普通用户对用户信息的操作*/
	
	
	/*所有用户都可以进行的操作*/
	UserInfoEntitySearchable getInfoByUserId(Long userId);
	//保存用户信息
	AccountInfo save(AccountInfo entity);
	//更新用户信息
	AccountInfo update(AccountInfo entity);
}
