package utilities;

public class DataFile {

	Xls_Reader d = new Xls_Reader("C:\\QA\\Selanium_Workspace\\RestAssuredProject\\src\\test\\java\\dataDrivenTest\\empdata.xlsx");
	
	public  String empname = d.getCellData("Sheet1", "EmpName", 2);
	public  String empsal = d.getCellData("Sheet1","EmpSalary", 2);
	public  String empage = d.getCellData("Sheet1", "EmpAge", 2);

	
	
}
