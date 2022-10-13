package EmpWage;

interface IEmployeeWage {

    public void addCompany(String company_Name, int emp_Rate_Per_Hr, int num_Working_Days, int maxHrsMax_Hrs_In_Month);

    public void calculateTotalWage();

}
public class CompanyEmpWage {
    public final String company_Name;
    public final int emp_Rate_Per_Hr;
    public final int num_Working_Days;
    public final int maxHrsMax_Hrs_In_Month;
    int totalEmpWage;



    public CompanyEmpWage(String company_Name, int emp_Rate_Per_Hr,
                          int num_Working_Days, int maxHrsMax_Hrs_In_Month) {
        this.company_Name = company_Name;
        this.emp_Rate_Per_Hr = emp_Rate_Per_Hr;
        this.num_Working_Days = num_Working_Days;
        this.maxHrsMax_Hrs_In_Month = maxHrsMax_Hrs_In_Month;
        totalEmpWage=0;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    public String toString() {
        System.out.println("Company Name: " + company_Name + "  ");
        System.out.println("Employee rate per hour : " + emp_Rate_Per_Hr + "  ");
        System.out.println("Number of Working days : " + num_Working_Days + "  ");
        System.out.println("Maximum hurs in month : " + maxHrsMax_Hrs_In_Month + "  ");
        return "Total wage for a month of " + company_Name + " employee is " + totalEmpWage;

    }
}

