package lesson14;

import lesson14.factory.AddressBook;

import java.util.Date;

public class CallerRunner {

    public static void main(String[] args) {
        Date startDate = new Date();
        AddressBook.addressBookAtList(10);
        AddressBook.addressBookAtSet(10);
        AddressBook.addressBookAtMap(10);
        Date endDate = new Date();
        long time = endDate.getTime() - startDate.getTime();
        System.out.println(time + " мс");

    }
}
