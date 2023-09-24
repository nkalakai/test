package lession_6;

public class instrukcjaIf {
    public static void main(String[] args) {
        boolean deszczowapogoda;
        boolean slonce;
        deszczowapogoda = false;
        slonce = true;

        //jezeli pogoda jest deszczowa to wez parasol, a jesli swieci slonce to wez okulary

        if (deszczowapogoda == true) {
            System.out.println("biore parasol");
        } else if (slonce) {
            System.out.println("biore okulary UV");
            
        } else {
            System.out.println("nie biore parasol");
        }
    }
}
