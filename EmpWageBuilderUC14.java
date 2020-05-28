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
		public ArrayList<Integer> wagePerDayList=new ArrayList<>();
 		public int wagePerHour;
		CompanyEmpWage(String companyName, int wagePerHour, int numWorkingDays, int maxHrsInMonth)
		{
			this.companyName=companyName;
			this.numWorkingDays=numWorkingDays;
			this.maxHrsInMonth=maxHrsInMonth;
			this.wagePerHour=wagePerHour;
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











public class EmpWageBuilderUC14 implements IComputeEmpWage
{	
	



	public final int isFullTime = 1;
	public final int isPartTime = 2;
	private ArrayList<CompanyEmpWage>companyEmpWageList;
	private HashMap<String,CompanyEmpWage>companyToEmpWageMap;
	EmpWageBuilderUC14()
	{
		companyEmpWageList = new ArrayList<>();
		companyToEmpWageMap = new HashMap<>();		
	}
	public void addCompanyEmpWage(String companyName, int wagePerHour, int numWorkingDays, int maxHrsInMonth)
	{	
		CompanyEmpWage companyEmpWage=new CompanyEmpWage(companyName,wagePerHour,numWorkingDays,maxHrsInMonth);
		System.out.println(wagePerHour);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(companyName,companyEmpWage);
		
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
					companyEmpWage.wagePerDayList.add((empHrs * companyEmpWage.wagePerHour));
				}
				
				return companyEmpWage.wagePerHour * totalEmpHrs;
			}

	public int getTotalSalary(String companyName)
		{
			return companyToEmpWageMap.get(companyName).totalSalary;			
		}
	public static void main(String[] args) {		

		EmpWageBuilderUC14 empArray = new EmpWageBuilderUC14();

		empArray.addCompanyEmpWage("ford",20,2,10);

		empArray.addCompanyEmpWage("Reliance",10,45,20);
		empArray.computeEmpWage();

	}


}

