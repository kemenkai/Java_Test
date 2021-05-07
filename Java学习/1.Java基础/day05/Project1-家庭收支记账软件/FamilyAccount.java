/**
 * @author 柯孟凯
 * @date ：Created in 2021/5/7 10:15
 * @description：家庭收支记账软件
 * @modified By：
 * @version: 1$
 */
public class FamilyAccount {
    public static void main(String[] args) {
        String details = "收支\t账户金额\t收支金额\t\t说  明\n";
        int balance = 10000;

        exitWhile:while (true) {
            System.out.println("-----------------家庭收支记账软件-----------------");
            System.out.println("                1 收支明细");
            System.out.println("                2 登记收入");
            System.out.println("                3 登记支出");
            System.out.println("                4 退    出");
            System.out.print("                请选择（1-4）: ");
            char selection = Utility.readMenuSelection();

            switch (selection) {
                case '1':
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(details);
                    System.out.println("--------------------------------------------------\n");
                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    int addMoney = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String addInfo = Utility.readString();
                    balance += addMoney;
                    details += "收入\t" + balance + "\t" + addMoney + "  \t\t" + addInfo + "\n";
                    System.out.println("---------------------登记完成---------------------\n");
                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    int delMoney = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    String delInfo = Utility.readString();
                    balance -= delMoney;
                    details += "支出\t" + balance + "\t" + delMoney + "  \t\t" + delInfo + "\n";
                    System.out.println("---------------------登记完成---------------------\n");
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char isExit = Utility.readConfirmSelection();
                    if (isExit == 'Y') {
                        break exitWhile;
                    }
                    break;
                default:
            }
        }
    }
}
