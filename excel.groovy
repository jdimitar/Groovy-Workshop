@Grapes([
    @Grab(group='org.apache.poi',module='poi',version='3.9'),
    @Grab(group='org.apache.poi',module='poi-ooxml',version='3.9'),
    @GrabExclude(group ='xml-apis',module ='xml-apis')
])

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet


class Bank{
    
    String senderBankBranch
    String senderName
    String receiverBankBranch
    String receiverName
    Date processDate
    Double amount
    
}

def excelFile = new File('C:/test/test.xlsx')
excelFile.withInputStream{
    file -> 
    workbook = new XSSWorkbook(file)
    
    (0..<workbook.numberOfSheets).each{
        sheetNumber -> 
        XSSFSheet sheet = workbook.getSheetAt( sheetNumber )
        sheet.rowIterator().each {
            row -> 
            row.cellIterator().each{
                cell -> 
                println cell.toString()
            }
        }
    
    }
}