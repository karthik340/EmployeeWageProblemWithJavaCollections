import java.util.*; 
public class calculateEmployeeWageUC8{
		public final int isFullTime = 1;
		public final int isPartTime = 2;
		public int totalEmpHrs=0;
		private String companyName="";
		private final int numWorkingDays;
		private final int maxHrsInMonth;		
		private int totalSalary=0;
		private int wagePerHour;
		calculateEmployeeWageUC8(String companyName, int wagePerHour, int numWorkingDays, int maxHrsInMonth)
		{
		this.companyName=companyName;	
		this.wagePerHour=wagePerHour;
		this.numWorkingDays=numWorkingDays;
		this.maxHrsInMonth=maxHrsInMonth;
		}
		public int findSalary()
		{
		System.out.println("company name is"+companyName+"\n");
		int empHrs;
	        int totalWorkingDays=0;
		int empCheck;
		while(totalWorkingDays<=numWorkingDays && totalEmpHrs<=maxHrsInMonth)
		{
			totalWorkingDays++;
			empCheck = (int)Math.floor(Math.random() * 10)%3;         
			switch(empCheck)
		        {
		        	case isFullTime:
					empHrs=8;
					break;
				case isPartTime:
					empHrs=4;
					break;
				default:
					empHrs=0;
					break;
		        }
		        totalEmpHrs+=empHrs;
			System.out.println("Day# " + totalWorkingDays + " Emp Hrs: "+empHrs);
		}
		totalSalary=wagePerHour * totalEmpHrs;
		return totalSalary;
		}
		public String toString()
		{
		return "total emp wage for company: "+companyName +"is : "+totalSalary; 	
		}
	public static void main(String[] args) {
		
		calculateEmployeeWageUC8 john = new calculateEmployeeWageUC8("ford",40,25,110);
		System.out.println("total salary"+john.findSalary());
		}
}

