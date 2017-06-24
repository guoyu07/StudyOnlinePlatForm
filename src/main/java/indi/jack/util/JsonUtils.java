/**
 * 
 */
package indi.jack.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.ObjectMapper;

import indi.jack.entity.ClassCourseTree;
import indi.jack.model.TreeModel;

/**
 * <p>
 * Title:ObjectToJsonArray
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author jackhoo
 * @date 2017年5月10日 上午11:08:47
 */
public class JsonUtils {
	public  List<TreeModel> treeMenuList(List<ClassCourseTree> treelist, Long parentId) {

		//System.out.println("树大小"+treelist.size()+"父节点="+parentId);
		List<TreeModel> children=new ArrayList<>();
		//算法待优化，可边遍历边去除以使用过的数据
		for (ClassCourseTree node : treelist) {
			Long meId = node.getId();
			Long pid = node.getpId();
			TreeModel tem=new TreeModel();
			// 有儿子啦
			if (parentId == pid) {
				tem.setChildren(treeMenuList(treelist, meId));
				tem.setNode(node);
				children.add(tem);
				//System.out.println("当前children=="+children);
			}

		}
		return children;

	}

}
