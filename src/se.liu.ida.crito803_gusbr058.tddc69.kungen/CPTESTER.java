package se.liu.ida.crito803_gusbr058.tddc69.kungen;

import java.util.ArrayList;
import java.util.List;

public class CPTESTER {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) list1.add(i);

        List<Integer> sub =  list1.subList(3, 5);

        list2.addAll(sub);

        System.out.print("list 1: ");
        print(list1);
        System.out.print("subl  : ");
        print(sub);
        System.out.print("list 2: ");
        print(list2);

        sub.clear();
        System.out.println("CLEARED");

        System.out.print("list 1: ");
        print(list1);
        System.out.print("subl  : ");
        print(sub);
        System.out.print("list 2: ");
        print(list2);


    }

    public static void print(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
