/**
 * 
 */
package indi.jack.model;

/**
 * <p>Title:ResultModel</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月5日 上午8:25:14
 */
public class ResultModel<T> {
	private boolean operation_res;
	private String operation_res_details;
	private T datamodel;
	public boolean isOperation_res() {
		return operation_res;
	}
	public void setOperation_res(boolean operation_res) {
		this.operation_res = operation_res;
	}
	public String getOperation_res_details() {
		return operation_res_details;
	}
	public void setOperation_res_details(String operation_res_details) {
		this.operation_res_details = operation_res_details;
	}
	public T getDatamodel() {
		return datamodel;
	}
	public void setDatamodel(T datamodel) {
		this.datamodel = datamodel;
	}
	
}
