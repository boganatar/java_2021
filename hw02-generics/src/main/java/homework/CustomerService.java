package homework;


import java.util.*;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final NavigableMap<Customer, String> customersTreeMap = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> smallestCustomer = customersTreeMap.firstEntry();
        if (smallestCustomer == null) {
            return null;
        } else {
            return new AbstractMap.SimpleEntry<>(new Customer(smallestCustomer.getKey()), smallestCustomer.getValue());
        }
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer,String> nextCustomer = customersTreeMap.higherEntry(customer);
        if (nextCustomer == null) { return null; } else {
            return new AbstractMap.SimpleEntry<>(new Customer(nextCustomer.getKey()), nextCustomer.getValue());
        }
    }

    public void add(Customer customer, String data) {
        customersTreeMap.put(customer, data);
    }
}
