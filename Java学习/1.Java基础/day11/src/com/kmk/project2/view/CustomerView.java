package com.kmk.project2.view;

import com.kmk.project2.bean.Customer;
import com.kmk.project2.service.CustomerList;
import com.kmk.project2.utility.CMUtillity;

/**
 * @author kemengkai
 * @create 2021-06-11 10:22
 */
public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("柯南", '男', 23, "13012342134", "ken@abc.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu() {

        boolean isFlag = true;
        do {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char menu = CMUtillity.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                default:
                    System.out.print("确认是否退出(Y/N)：");
                    char exit = CMUtillity.readConfirmSelection();
                    if (exit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        } while (isFlag);
    }

    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtillity.readString(5);
        System.out.print("性别：");
        char gender = CMUtillity.readChar();
        System.out.print("年龄：");
        int age = CMUtillity.readInt();
        System.out.print("电话：");
        String phone = CMUtillity.readString(13);
        System.out.print("邮箱：");
        String email = CMUtillity.readString(20);
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isFlag = customerList.addCustomer(customer);
        if (isFlag) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("人数已达上限，添加失败！");
        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        Customer customer;
        int index;
        for (; ; ) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = CMUtillity.readInt();
            if (index == -1) {
                return;
            }
            customer = customerList.getCustomer(index);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        // 修改用户的信息
        System.out.print("姓名(" + customer.getName() + "):");
        String name = CMUtillity.readString(5, customer.getName());
        System.out.print("性别(" + customer.getGender() + "):");
        char gender = CMUtillity.readChar(customer.getGender());
        System.out.print("年龄(" + customer.getAge() + "):");
        int age = CMUtillity.readInt(customer.getAge());
        System.out.print("电话(" + customer.getPhone() + "):");
        String phone = CMUtillity.readString(13, customer.getPhone());
        System.out.print("邮箱(" + customer.getEmail() + "):");
        String email = CMUtillity.readString(15, customer.getEmail());
        customer = new Customer(name, gender, age, phone, email);
        boolean isFlag = customerList.replaceCustomer(index, customer);
        if (isFlag) {
            System.out.println("---------------------修改完成---------------------");
        } else {
            System.out.println("---------------------修改失败---------------------");
        }
    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        Customer customer;
        int index;
        for (; ; ) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            index = CMUtillity.readInt();
            if (-1 == index) {
                return;
            }
            customer = customerList.getCustomer(index);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        System.out.print("确认是否删除(Y/N)：");
        boolean isDeleted = customerList.deleteCustomer(index);
        if (isDeleted) {
            boolean isFlag = customerList.deleteCustomer(index);
            if (isFlag) {
                System.out.println("---------------------删除完成---------------------");
            } else {
                System.out.println("---------------------删除失败---------------------");
            }
        }
    }

    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        // 获取所有的客户
        Customer[] customers = customerList.getAllCustomers();
        if (customers.length == 0) {
            System.out.println("没有任何客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            for (int i = 0; i < customers.length; i++) {
                Customer customer = customers[i];
                System.out.println((i + 1) + "\t" + customer.info());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
