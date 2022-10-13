package EmpWage;

public class EmployeeWageUC9 {
    public static final int isPartTime = 1;
    public static final int isFullTime = 2;
    private final String company;
    private final int empRatePerHr;
    private final int numWorkingDays;
    private final int MaxHrsInMonth;
    private int totalEmpWage;

    public EmployeeWageUC9(String company, int empRatePerHr, int MaxHrsInMonth, int numWorkingDays) {
        this.company = company;
        this.empRatePerHr = empRatePerHr;
        this.numWorkingDays = numWorkingDays;
        this.MaxHrsInMonth = MaxHrsInMonth;

    }

    public void EmpWage() {

        int empHrs = 0, totalEmpHrs = 0, empWage, totalEmpWage;
        int totalWorkingDays = 0;
        while (totalEmpHrs <= MaxHrsInMonth && totalWorkingDays < numWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10 % 3);
            if (empCheck == isPartTime) {
                empHrs = 8;
            } else if (empCheck == isFullTime) {
                empHrs = 16;
            } else {
                empHrs = 0;
            }
            totalEmpHrs = totalEmpHrs + empHrs;
            System.out.println("Days:" + totalWorkingDays + "Emp Hrs:" + empHrs);
        }
        totalEmpWage = totalEmpHrs * empRatePerHr;
        System.out.println("Total Employee wage for " + company + " company is " + totalEmpWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage");
        EmployeeWageUC9 Reliance = new EmployeeWageUC9("Reliance", 20, 100, 20);
        EmployeeWageUC9 TCS = new EmployeeWageUC9("TCS", 10, 150, 15);
        EmployeeWageUC9 Infosys = new EmployeeWageUC9("Infosys", 15, 125, 22);
        Reliance.EmpWage();
        System.out.println(Reliance);
        TCS.EmpWage();
        System.out.println(TCS);
        Infosys.EmpWage();
        System.out.println(Infosys);
    }
}
