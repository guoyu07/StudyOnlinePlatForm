/**
 * 
 */
package indi.jack.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

/**
 * <p>Title:PDFConvertor</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月14日 下午5:48:13
 */
public class PDFConvertor {
	public static int office2PDF(String sourceFile, String destFile) throws FileNotFoundException {    
        try {    
            File inputFile = new File(sourceFile);    
            if (!inputFile.exists()) {    
                return -1;// 找不到源文件, 则返回-1    
            }    
    
            // 如果目标路径不存在, 则新建该路径    
            File outputFile = new File(destFile);    
            if (!outputFile.getParentFile().exists()) {    
                outputFile.getParentFile().mkdirs();    
            }    
                
            // connect to an OpenOffice.org instance running on port 8100    
            OpenOfficeConnection connection = new SocketOpenOfficeConnection(    
                    "127.0.0.1", 8100);    
            connection.connect();    
            //DocumentConverter converter=new StreamOpenOfficeDocumentConverter(connection);
    
            // convert    
            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
            converter.convert(inputFile, outputFile);    
    
            // close the connection    
            connection.disconnect();    
    
            return 0;    
        } catch (ConnectException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
    
        return 1;    
    }    
}
