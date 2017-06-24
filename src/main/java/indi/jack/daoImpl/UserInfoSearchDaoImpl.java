/**
 * 
 */
package indi.jack.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import indi.jack.dao.SearchableDao;
import indi.jack.dao.UserInfoSearchDao;
import indi.jack.entity.UserInfoEntitySearchable;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.SearchResult;

/**
 * <p>Title:UserInfoSearchDaoImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月13日 下午9:41:03
 */
@Repository
public class UserInfoSearchDaoImpl implements SearchableDao<UserInfoEntitySearchable>{

	@PersistenceContext EntityManager entityManager;
	
	@Override
	@Transactional
	public Page<UserInfoEntitySearchable> search(String query, Pageable pageable) {
		FullTextEntityManager manager=Search.getFullTextEntityManager(entityManager);
    	try {
			manager.createIndexer().startAndWait();
			
			QueryBuilder builder=manager.getSearchFactory().buildQueryBuilder().forEntity(UserInfoEntitySearchable.class).get();
			Query lucene=builder.keyword().onFields("userid","accountInfo.address","accountInfo.email","accountInfo.phoneNum"
					,"accountInfo.profile","accountInfo.schoolName","accountInfo.user_Name")
					.matching(query)
					.createQuery();
			
			FullTextQuery q=manager.createFullTextQuery(lucene, UserInfoEntitySearchable.class);
			q.setProjection(FullTextQuery.THIS, FullTextQuery.SCORE);
			long tatal=q.getResultSize();
			System.out.println("查询参数="+lucene);
			q.setFirstResult(pageable.getOffset())
				.setMaxResults(pageable.getPageSize());
			
			@SuppressWarnings("unchecked")
			List<Object[]> results = q.getResultList();
	        List<UserInfoEntitySearchable> list = new ArrayList<>();
	        //results.forEach(o ->list.add(new SearchResult<UserInfoEntitySearchable>((UserInfoEntitySearchable)o[0], (float)o[1])));
	        results.forEach(o ->list.add((UserInfoEntitySearchable)o[0]));
	        return new PageImpl<>(list, pageable, tatal);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
//要搜索的关键词
		/*String keyword = QueryParser.escape(query);
		
		//解析器，中文分词工具
		QueryParser titleParser = new QueryParser("User_Principal_Id", new IKAnalyzer());
		titleParser.setDefaultOperator(QueryParser.AND_OPERATOR);
		try {
			Query titleQuery = titleParser.parse(keyword);
			//模糊搜索标题
			FuzzyQuery titleFuzzyQuery = new FuzzyQuery(new Term("User_Principal_Id", keyword));
			
			//按词条搜索内容
			//Query contentQuery = new TermQuery(new Term("accountInfo.address", keyword));
			
			//按词条搜索发布状态
			//Query isPublicationQuery = new TermQuery(new Term("isPublication", "true"));
			
			//全文检索（标题搜索+内容搜索）
			BooleanQuery textQuery = new BooleanQuery();
			textQuery.add(titleQuery, Occur.SHOULD);
			textQuery.add(titleFuzzyQuery, Occur.SHOULD);
			//textQuery.add(contentQuery, Occur.SHOULD);
			FullTextQuery q=manager.createFullTextQuery(textQuery, UserPrincipal.class);
			q.setProjection(FullTextQuery.THIS, FullTextQuery.SCORE);
			long tatal=q.getResultSize(); 
			System.out.println("textQuery"+textQuery);
			System.out.println("结果大小="+tatal);
			q.setFirstResult(pageable.getOffset())
				.setMaxResults(pageable.getPageSize());
			@SuppressWarnings("unchecked")
			List<Object[]> results = q.getResultList();
	        List<SearchResult<UserPrincipal>> list = new ArrayList<>();
	        results.forEach(o ->list.add(new SearchResult<UserPrincipal>((UserPrincipal)o[0], (float)o[1])));
			return new PageImpl<>(list, pageable, tatal);
		
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
			}
		
		}*/
	/*private FullTextEntityManager getFullTextEntityManager()
  {
      return Search.getFullTextEntityManager(
          this.entityManagerProxy.getTargetEntityManager()
      );
  }*/

 /* @PostConstruct
  public void initialize()
  {
  	System.out.println("初始化！");
      if(!(this.entityManager instanceof EntityManagerProxy))
          throw new FatalBeanException("当前实体管理器 " + this.entityManager +
                  " 不是代理管理器");
      	this.entityManagerProxy = (EntityManagerProxy)this.entityManager;
  }
*/
