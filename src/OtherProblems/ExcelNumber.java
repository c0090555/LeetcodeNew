package OtherProblems;
public class ExcelNumber {
    //将十进制数转换为excel数
   public String decToExcel(int decNum) {
		if (decNum  > 0){
			return decToExcel((decNum - 1) /26)+String.valueOf((char)((decNum - 1 )%26 + 'A'));
		}
		return new String();
	}
   
   //将excel数转换为十进制数
   public int excelToDec(String excelNum) {
		int sum = 0;
		for (int i = 0; i < excelNum.length(); i++){
			sum *= 26;
			sum += excelNum.charAt(i) - 'A' + 1;
		}
		return sum;
   }
   
   public static void main(String[] args){
	   ExcelNumber o = new ExcelNumber();
	   int decNum = 1353;
	   System.out.println(o.decToExcel(decNum));
   }
}
