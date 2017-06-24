/**
 * 
 */
package indi.jack.serviceImpl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import indi.jack.dao.AccountInfoDao;
import indi.jack.dao.UserInfoSearchDao;
import indi.jack.dao.UserPrincipalDao;
import indi.jack.entity.AccountInfo;
import indi.jack.entity.UserInfoEntitySearchable;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.SearchResult;
import indi.jack.service.AccountInfoService;

/**
 * <p>Title:AccountInfoServiceImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月10日 下午7:35:43
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService{
	@Inject AccountInfoDao accountInfoDao;
	@Inject UserPrincipalDao userPrincipalDao;
	@Inject UserInfoSearchDao userInfoSearchDao;
	@Override
	@Transactional
	public AccountInfo save(AccountInfo entity) {
		return accountInfoDao.save(entity);
	}
	@Override
	@Transactional
	
	public AccountInfo update(AccountInfo entity) {
		return accountInfoDao.save(entity);
	}
	@Override
	@Transactional
	public Page<UserInfoEntitySearchable> search(String query, Pageable pageable) {
		System.out.println("查询参数="+query+"分页信息="+pageable);
		return userInfoSearchDao.search(query, pageable);
	}
	@Override
	public UserPrincipal updatePrivacy(UserPrincipal entity) {
		return userPrincipalDao.save(entity);
	}
	@Override
	public UserInfoEntitySearchable getInfoByUserId(Long userId) {
		return userInfoSearchDao.findOne(userId);
	}
	@Override
	public Page<UserInfoEntitySearchable> getAllUserInfo(Pageable pageable) {
		return userInfoSearchDao.findAll(pageable);
	}
	@Override
	public Page<UserPrincipal> getAllUserInfoPrivacy(Pageable pageable) {
		return userPrincipalDao.findAll(pageable);
	}
	@Override
	public Page<AccountInfo> batchSave(Iterable<AccountInfo> entities, Pageable pageable) {
		//return accountInfoDao.save(entities);
		List<AccountInfo> accountInfos=(List<AccountInfo>) accountInfoDao.save(entities);
		PageImpl<AccountInfo> pageImpl=new PageImpl<>(accountInfos, pageable, accountInfos.size());
		return pageImpl;
	}
	@Override
	public Iterable<UserInfoEntitySearchable> getAllUserInfoNoPages() {
		return userInfoSearchDao.findAll();
	}
	@Override
	public void deleteByUser_Info_Id(Long userinfoId) {
		accountInfoDao.delete(userinfoId);
	}
	
	

}
