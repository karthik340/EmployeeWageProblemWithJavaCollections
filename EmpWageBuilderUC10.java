import java.util.*; 
class CompanyEmpWage{
		
	
		private String companyName="";
		public final int numWorkingDays;
		public  final int maxHrsInMonth;		
		public int totalSalary=0;
		public int wagePerHour;
		CompanyEmpWage(String companyName, int wagePerHour, int numWorkingDays, int maxHrsInMonth)
		{
			this.companyName=companyName;	
			this.wagePerHour=wagePerHour;
			this.numWorkingDays=numWorkingDays;
			this.maxHrsInMonth=maxHrsInMonth;
		}
		public void setTotalSalary(int totalSalary)
		{
			this.totalSalary=totalSalary;		
		}
		public String toString()
		{	
			return 	"total emp wage for company: "+companyName +"is : "+totalSalary; 	
		}
		}

public class EmpWageBuilderUC10
{	
	public final int isFullTime = 1;
	public final int isPartTime = 2;
	private CompanyEmpWage[] comp = new CompanyEmpWage[5]; 
	private int index=0;
	public void addCompanyEmpWage(String companyName, int wagePerHour, int numWorkingDays, int maxHrsInMonth)
	{
		comp[index]=new CompanyEmpWage(companyName,wagePerHour,numWorkingDays,maxHrsInMonth);
		index++;
	}
	private void computeEmpWage()
	{
		for(int i=0;i<index;i++)
		{
			comp[i].totalSalary=this.findSalary(comp[i]);
			System.out.println(comp[i]);
		}	
	}
	private int findSalary(CompanyEmpWage companyEmpWage)
			{
				int totalEmpHrs=0;
				int empHrs;
				int totalWorkingDays=0;
				int empCheck;
				while(totalWorkingDays<=companyEmpWage.numWorkingDays && totalEmpHrs<=companyEmpWage.maxHrsInMonth)
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
				return companyEmpWage.wagePerHour * totalEmpHrs;
			}
	public static void main(String[] args) {		

		EmpWageBuilderUC10 empArray = new EmpWageBuilderUC10();

		empArray.addCompanyEmpWage("ford ",20,2,10);

		empArray.addCompanyEmpWage("Reliance ",10,45,20);
		empArray.computeEmpWage();

	}


}



