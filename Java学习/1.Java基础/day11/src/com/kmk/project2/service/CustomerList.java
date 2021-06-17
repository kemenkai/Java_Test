package com.kmk.project2.service;

import com.kmk.project2.bean.Customer;

/**
 * @author kemengkai
 * @create 2021-06-11 9:52
 */
public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList() {
    }

    public CustomerList(int totalCustomer) {
        this.customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (customer != null && total < customers.length) {
            customers[total++] = customer;
            return true;
        }
        return false;
    }

    public boolean replaceCustomer(int index, Customer customer) {
        if (index >= 1 && index <= total) {
            customers[index - 1] = customer;
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(int index) {
        if (index >= 1 && index <= total) {
            for (int i = index - 1; i < total - 1; i++) {
                customers[i] = customers[i + 1];
            }
            customers[--total] = null;
            return true;
        }
        return false;
    }

    public Customer[] getAllCustomers() {
        Customer[] newCustomers = new Customer[total];
        for (int i = 0; i < newCustomers.length; i++) {
            newCustomers[i] = customers[i];
        }
        return newCustomers;
    }

    public Customer getCustomer(int index) {
        if (index >= 1 && index <= total) {
            return customers[index - 1];
        }
        return null;
    }

    public int getTotal() {
        return total;
    }

}
