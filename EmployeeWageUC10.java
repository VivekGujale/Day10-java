package EmpWage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EmployeeWageUC10 {
    public static final int is_PartTime = 1;
    public static final int is_FullTime = 2;
    int numOfCompanies, index;
    CompanyEmpWage[] companies;

    public EmployeeWageUC10(int numOfCompanies) {
        this.numOfCompanies = numOfCompanies;
        companies = new CompanyEmpWage[numOfCompanies];
        index = 0;
    }

    public void addCompanyEmpWage(String company_Name, int emp_Rate_Per_Hr, int num_Working_Days, int maxHrsMax_Hrs_In_Month) {
        companies[index++] = new CompanyEmpWage(company_Name, emp_Rate_Per_Hr, num_Working_Days, maxHrsMax_Hrs_In_Month);
    }

    public void calTotalEmpWage() {
        for (CompanyEmpWage company : companies) {
            int totalWage = calTotalEmpWage(company);
            company.setTotalEmpWage(totalWage);
        }
    }

    public int calTotalEmpWage(CompanyEmpWage companyEmpWage) {
        System.out.println("Total Employee wage for " + companyEmpWage.company_Name + " company is as follows : ");
        int empHrs = 0, totalEmpHrs = 0, empWage, totalEmpWage;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= companyEmpWage.maxHrsMax_Hrs_In_Month && totalWorkingDays < companyEmpWage.num_Working_Days) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10 % 3);
            if (empCheck == is_PartTime) {
                empHrs = 8;
            } else if (empCheck == is_FullTime) {
                empHrs = 16;
            } else {
                empHrs = 0;
            }
            totalEmpHrs = totalEmpHrs + empHrs;
            System.out.println("Days:" + totalWorkingDays + "Emp Hrs:" + empHrs);
        }
        totalEmpWage = totalEmpHrs * companyEmpWage.emp_Rate_Per_Hr;
        System.out.println("Total Employee wage for " + companyEmpWage.company_Name + " company is " + totalEmpWage);
        System.out.println();
        return empHrs;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage");
        EmployeeWageUC10 employeeWageUC10 = new EmployeeWageUC10(3);
        employeeWageUC10.addCompanyEmpWage("Reliance", 20, 20, 100);
        employeeWageUC10.addCompanyEmpWage("TCS", 10, 15, 150);
        employeeWageUC10.addCompanyEmpWage("Infosys", 15, 22, 125);
        employeeWageUC10.calTotalEmpWage();
    }
}