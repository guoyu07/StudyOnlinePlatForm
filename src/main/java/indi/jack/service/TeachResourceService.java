/**
 * 
 */
package indi.jack.service;

import indi.jack.entity.TeachResource;

/**
 * <p>Title:TeachResourceService</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月9日 下午3:52:40
 */
public interface TeachResourceService {
	TeachResource saveResource(TeachResource entity);
	void deleteResource(Long id);
	TeachResource getOneRes(Long id);
}
