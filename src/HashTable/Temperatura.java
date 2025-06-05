package HashTable;

import java.util.Scanner;

class Record{
    String odCas;
    String doCas;
    float temperatura;

    public Record(String odCas, String doCas, float temperatura) {
        this.odCas = odCas;
        this.doCas = doCas;
        this.temperatura = temperatura;
    }

    public String getOdCas() {
        return odCas;
    }

    public String getDoCas() {
        return doCas;
    }

    public float getTemperatura() {
        return temperatura;
    }
}
public class Temperatura {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        CBHT<String, Record> map = new CBHT<>(n);

        for (int i = 0; i < n; i++) {
            String grad = cin.next();
            Record r = new Record(cin.next(), cin.next(), cin.nextFloat());

            if (map.search(grad) == null){
                map.insert(grad, r);
            }
            else {
                SLLNode<MapEntry<String, Record>> tmp = map.search(grad);
                if (tmp.element.value.getTemperatura() < r.getTemperatura()){
                    map.insert(grad, r);
                }
            }
        }

        String grad = cin.next();
        SLLNode<MapEntry<String, Record>> result = map.search(grad);

        if (result == null){
            System.out.println("No records");
        }
        else {
            Record r = result.element.value;
            System.out.println(grad + ": " + r.getOdCas() + " - " + r.doCas + " " + r.getTemperatura());
        }
    }
}
