# PJATK-Programowanie-aplikacji-PRA-zad.-4

   <b>Zad. 1. BIGDECCALC (max. punktów 5)</b>
   
   Napisać prosty kalkulator dla liczb typu BigDecimal.
Obliczenia mają być podawane jako argumenty wiersza poleceń w postaci:

liczba1 op liczba2

gdzie op jeden ze znaków +,- (minus), * (mnożenie), / (dzielenie), a  pomiędzy liczba1, op i liczba2 występuje jeden lub więcej białych znaków.

Obliczenia zrealizować w klasie Calc jako metodę String doCalc(String cmd), zwracająca  napisową reprezentację wyniku (uzyskanej liczby) lub napis "Invalid command to calc", jeśli wystąpią jakiekolwiek błędy.

Następująca  klasa Main::

public class Main {
  
  public static void main(String[] args) {
    Calc c = new Calc();
    String wynik = c.doCalc(args[0]);
    System.out.println(wynik);
  }

}
po uruchomieniu winna wyprowadzić na konsolę wynik obliczenia (np. jesli podano jako argument wiersza poleceń
 "1 / 2" , to wynikiem powinine być napis 0.5.

Jeśli liczba wynikowa nie ma dokładnej reprezentacji (jak np. wynik dzielenia 1/3), to wynik powinien być pokazany z dokładnością co najmniej 7 miejsc dziesiętnych.

Uwaga 1: klasy Main nie wolno modyfikować i musi ona prawidłowo działać.

Uwaga 2: w  zadnej z klas programu nie wolno używać instrukcji if,  ani switch, ani operatora warunkowego, ani instrukcji for, ani isntrukcji while.  

   
<b>Zad. 2. JAVABEAN (max. punktów 5)</b>

Zdefiniować klasę JavaBean o nazwie  Purchase z trzema właściwościami: prod (String), data (typu String) i price (typu Double).
Własciwość prod jest prosta, właściwości data i price są związane (bounded), włąsciwośc price jest dodatkowo ograniczane (constrained).
Za pomoca mechanizmu nasłuchu  i wetowania zmian właściwości umożliwić:
wypisywanie na konsoli wszystkich zmian dat i cen,
kontrolę poprawności zmian: nie można zmienić ceny na liczbę mniejszą od 1000.
Przykładowy program (klasa Main utworzona przez generatir projektów):

public class Main {
  public static void main(String[] args) {
    
    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);
    
    // --- tu należy dodać odpowiedni kod    
    // ...     
    // ----------------------------------
    
    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);
     
      purch.setPrice(500.00);
      
    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);
  }
}
winien wypisać na konsoli:
Purchase [prod=komputer, data=nie ma promocji, price=3000.0]
Change value of: data from: nie ma promocji to: w promocji
Change value of: price from: 3000.0 to: 2000.0
Purchase [prod=komputer, data=w promocji, price=2000.0]
Price change to: 500.0 not allowed
Purchase [prod=komputer, data=w promocji, price=2000.0]
   
   
