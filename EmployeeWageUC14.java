package EmpWage;

import java.util.ArrayList;
import java.util.HashMap;

class EmployeeWageUC14 implements IEmployeeWage {
    public static final int is_PartTime = 1;
    public static final int is_FullTime = 2;

    //references of companyempwage objects are stored in arraylist
    ArrayList<CompanyEmpWage> companies;
    HashMap<String, Integer> totalEmpWages;
    private String company_Name;
    //companyname is mapped with total employee wage

    //defalut constructor
    public EmployeeWageUC14() {
        companies = new ArrayList<>();
        totalEmpWages = new HashMap<>();
    }

    //It creats companyempwage objects and add to the arraylist
    public void addCompany(String company_Name, int emp_Rate_Per_Hr, int num_Working_Days, int maxHrsMax_Hrs_In_Month) {
        CompanyEmpWage Company = new CompanyEmpWage(company_Name, emp_Rate_Per_Hr, num_Working_Days, maxHrsMax_Hrs_In_Month);
        companies.add(Company);
        totalEmpWages.put(company_Name, 0);
    }

    int getWorkingHrs() {
        int empType = (int) (Math.random() * 100) % 3;
        switch (empType) {
            case is_PartTime:
                return 8;
            case is_FullTime:
                return 4;
            default:
                return 0;
        }
    }

    public void calculateTotalWage() {
        for (CompanyEmpWage company : companies) {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmpWage(totalWage);
        }
    }

    int calculateTotalWage(CompanyEmpWage companyEmpWage) {
        System.out.println("Total Employee wage for " + companyEmpWage.company_Name + " company is as follows : ");
        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.maxHrsMax_Hrs_In_Month
                && totalWorkingHrs <= companyEmpWage.maxHrsMax_Hrs_In_Month; day++, totalWorkingHrs += workingHrs) {
            workingHrs = getWorkingHrs();
            int wage = workingHrs * companyEmpWage.emp_Rate_Per_Hr;
            totalWage = totalWage + wage;
            System.out.println();
            System.out.printf("%d   %d  %d   %d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }
        totalEmpWages.put(companyEmpWage.company_Name, totalWage);
        return totalWage;
    }

    public int getTotalEmpWage(String companyName) {
        return totalEmpWages.get(companyName);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage");
        EmployeeWageUC14 employeeWageUC14 = new EmployeeWageUC14();
        employeeWageUC14.addCompany("Reliance", 20, 20, 100);
        employeeWageUC14.addCompany("TCS", 10, 15, 150);
        employeeWageUC14.addCompany("Infosys", 15, 22, 125);
        employeeWageUC14.calculateTotalWage();
        String query = "Infosys";
        int totalWage = employeeWageUC14.getTotalEmpWage(query);
        System.out.println("Total Employee Wage for " + query + " company is " + totalWage);
    }
}
