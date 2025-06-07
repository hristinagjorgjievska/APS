package HashTable;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String embg;
    Double prosek;

    public Student(String embg, Double prosek) {
        this.embg = embg;
        this.prosek = prosek;
    }

    public String getEmbg() {
        return embg;
    }

    public Double getProsek() {
        return prosek;
    }
}
public class UpisiNaFakultet {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Double> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            Student s = new Student(cin.next(), cin.nextDouble());

            if (map.search(s.getEmbg()) == null){
                map.insert(s.getEmbg(), s.getProsek());
            }
            else {
                SLLNode<MapEntry<String, Double>> tmp = map.search(s.getEmbg());
                map.insert(tmp.element.key, tmp.element.value);
            }
        }

        int m = cin.nextInt();
        cin.nextLine();
        CBHT<String, Double> map1 = new CBHT<>(m);

        for (int i = 0; i < m; i++) {
            Student s = new Student(cin.next(), cin.nextDouble());

            if (map1.search(s.getEmbg()) == null){
                map1.insert(s.getEmbg(), s.getProsek());
            }
            else {
                SLLNode<MapEntry<String, Double>> tmp = map1.search(s.getEmbg());
                map1.insert(tmp.element.key, tmp.element.value);
            }
        }

        String embg = cin.next();
        SLLNode<MapEntry<String, Double>> result = map.search(embg);
        SLLNode<MapEntry<String, Double>> result1 = map1.search(embg);
        if (result == null || result1 == null){
            System.out.println("Empty");
            return;
        }
        else {
            Student s;
            if (result.element.value.equals(result1.element.value)){
                System.out.println("OK");
            }
            else{
                System.out.println("Error");
            }
        }

    }
}
