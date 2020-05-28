import java.util.*;
interface IComputeEmpWage
{
public void addCompanyEmpWage(String companyName, int wagePerHour, int numWorkingDays, int maxHrsInMonth);
public void computeEmpWage();
}

 
class CompanyEmpWage{
		
	
		public String companyName="";
		public final int numWorkingDays;
		public final int maxHrsInMonth;		
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

public class EmpWageBuilderUC12 implements IComputeEmpWage
{	
	



	public final int isFullTime = 1;
	public final int isPartTime = 2;
	private ArrayList<CompanyEmpWage>companyEmpWageList;
	EmpWageBuilderUC12()
	{
		companyEmpWageList = new ArrayList<>();		
	}
	public void addCompanyEmpWage(String companyName, int wagePerHour, int numWorkingDays, int maxHrsInMonth)
	{
		companyEmpWageList.add(new CompanyEmpWage(companyName,wagePerHour,numWorkingDays,maxHrsInMonth));
	
	}
	public void computeEmpWage()
	{	
	
		for(int i=0;i<companyEmpWageList.size();i++)
		{
			CompanyEmpWage comp=companyEmpWageList.get(i);
			comp.totalSalary=this.findSalary(comp);
			System.out.println(comp);
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

		EmpWageBuilderUC12 empArray = new EmpWageBuilderUC12();

		empArray.addCompanyEmpWage("ford",20,2,10);

		empArray.addCompanyEmpWage("Reliance",10,45,20);
		empArray.computeEmpWage();

	}


}
