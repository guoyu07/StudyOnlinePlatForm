/**
 * 
 */
package indi.jack.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import indi.jack.entity.AccountInfo;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.BatchRegisterModel;

/**
 * <p>Title:ReadExcel</p>
 * <p>Description:读取Excel表格</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月6日 上午10:01:35
 */
public class ReadFile {
	/*private InputStream inputStream;
	public ReadFile(InputStream inputStream) {
		super();
		this.inputStream = inputStream;
	}*/
	public static List<UserPrincipal> readExcel(InputStream inputStream ,BatchRegisterModel batchRegisterModel){
		Integer roleid=batchRegisterModel.getRoleid();
		List<UserPrincipal> userPrincipals=new ArrayList<>();
		int UsernameCol=0;
		int GenderCol=0;
		int PhoneNumCol=0;
		int EmailCol=0;
		int SchoolNameCol=0;
		int BirthDayCol=0;
		int AddressCol=0;
		int UserIdCol = 0;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Workbook workbook=WorkbookFactory.create(inputStream);
			int sheetCount = workbook.getNumberOfSheets();
			//遍历sheet
			for(int s = 0; s < sheetCount; s++){
				Sheet sheet=workbook.getSheetAt(s);
				int rowConut=sheet.getPhysicalNumberOfRows();
				//遍历row
				for(int r=0; r<rowConut; r++){
					Row row=sheet.getRow(r);
					int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
					if(r==0){
						//表头部分
						for(int c=0; c<cellCount; c++){
							Cell cell=row.getCell(c);
							String getHeader=cell.getStringCellValue();
							if(getHeader.equals(batchRegisterModel.getAddressCol())){
								System.out.println(getHeader+"列"+"在第"+cell.getColumnIndex()+"列");
								AddressCol=cell.getColumnIndex();
							}
							if(getHeader.equals(batchRegisterModel.getBirthDayCol())){
								System.out.println(getHeader+"列"+"在第"+cell.getColumnIndex()+"列");
								BirthDayCol=cell.getColumnIndex();
							}
							if(getHeader.equals(batchRegisterModel.getEmailCol())){
								System.out.println(getHeader+"列"+"在第"+cell.getColumnIndex()+"列");
								EmailCol=cell.getColumnIndex();
							}
							if(getHeader.equals(batchRegisterModel.getPhoneNumCol())){
								System.out.println(getHeader+"列"+"在第"+cell.getColumnIndex()+"列");
								PhoneNumCol=cell.getColumnIndex();
							}
							if(getHeader.equals(batchRegisterModel.getSchoolNameCol())){
								System.out.println(getHeader+"列"+"在第"+cell.getColumnIndex()+"列");
								SchoolNameCol=cell.getColumnIndex();
							}
							if(getHeader.equals(batchRegisterModel.getUsernameCol())){
								System.out.println(getHeader+"列"+"在第"+cell.getColumnIndex()+"列");
								UsernameCol=cell.getColumnIndex();
							}
							if(getHeader.equals(batchRegisterModel.getUserIdCol())){
								System.out.println(getHeader+"列"+"在第"+cell.getColumnIndex()+"列");
								UserIdCol=cell.getColumnIndex();
							}
							
						}
					}else{
						//遍历列,
						UserPrincipal userPrincipal=new UserPrincipal();
						userPrincipal.setRoleid(roleid);
						AccountInfo accountInfo=new AccountInfo();
						//userId列必须在第0列,而且值不为空
						if(row.getCell(UserIdCol)!=null&&UserIdCol==0){
							if(row.getCell(UserIdCol).getCellType()==Cell.CELL_TYPE_STRING){
								 String userid=row.getCell(UserIdCol).getStringCellValue();
								 userPrincipal.setUserid(Long.parseUnsignedLong(userid));
								 userPrincipal.setRoleid(roleid);
								 System.out.println("从表中获取的用户信息"+userPrincipal.getUserid());
							}else if(row.getCell(UserIdCol).getCellType()==Cell.CELL_TYPE_NUMERIC){
								 Double userid=(Double)row.getCell(UserIdCol).getNumericCellValue();
								 userPrincipal.setUserid(userid.longValue());
								 userPrincipal.setRoleid(roleid);
								 System.out.println("从表中获取的用户信息=="+userPrincipal.getUserid());
							}else {
								 //读取错误
								 break;
							}
							//System.out.println("测试getcellvalue="+getCellValue(row.getCell(0)).toString());
							//userPrincipal.setUserid(Long.valueOf(getCellValue(row.getCell(0)).toString()).longValue());
							if(AddressCol!=0){
								Object address=getCellValue(row.getCell(AddressCol));
								if(address!=null){
									accountInfo.setAddress(address.toString());
								}
							}
							try {
								if(BirthDayCol!=0){
									Object birthDay=getCellValue(row.getCell(BirthDayCol));
									if(birthDay!=null){
										accountInfo.setBirthDay(sdf.parse(birthDay.toString()));
									}
								}
							} catch (ParseException e) {
								e.printStackTrace();
							}
							if(EmailCol!=0){
								Object email=getCellValue(row.getCell(EmailCol));
								if(email!=null){
									accountInfo.setEmail(email.toString());
								}
							}
							if(GenderCol!=0){
								Object gender=getCellValue(row.getCell(GenderCol));
								if(gender!=null){
									accountInfo.setGender(gender.toString());
								}
							}
							if(PhoneNumCol!=0){
								Object phoneNum=getCellValue(row.getCell(PhoneNumCol));
								if(phoneNum!=null)
								accountInfo.setPhoneNum(getCellValue(row.getCell(PhoneNumCol)).toString());
							}
							if(SchoolNameCol!=0){
								Object schoolName=getCellValue(row.getCell(SchoolNameCol));
								if(schoolName!=null){
									accountInfo.setSchoolName(schoolName.toString());
								}
							}
							if(UsernameCol!=0){
								Object username=getCellValue(row.getCell(UsernameCol));
								if(username!=null){
								accountInfo.setUser_Name(username.toString());
								System.out.println("开始读取第"+UsernameCol+"列"+"值=="+row.getCell(UsernameCol).getStringCellValue());
								//accountInfo.setUser_Name(row.getCell(UsernameCol).getStringCellValue());
								}
							}
							
						}
						
						userPrincipal.setAccountInfo(accountInfo);
						userPrincipals.add(userPrincipal);
					}
					
				}
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		return userPrincipals;
		
	}
	public static <T> Object getCellValue(Cell cell){
		
		if(cell!=null&&cell.getCellType()==Cell.CELL_TYPE_STRING){
			return cell.getStringCellValue();
		}
		if(cell!=null&&cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
			return cell.getNumericCellValue();
		}
		return null;
		
	}
	
}
