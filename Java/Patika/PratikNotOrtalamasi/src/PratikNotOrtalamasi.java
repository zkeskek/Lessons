import java.util.InputMismatchException;
import java.util.Scanner;

public class PratikNotOrtalamasi {

    // https://app.patika.dev/moduller/java101/pratik-not-ortalamasi
    public static void main(String[] args) {
        int math,physics,chemistry,history,music,turkish;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Matemaik Ders Notunuz : ");
            math = scanner.nextInt();

            System.out.print("Fizik Ders Notunuz : ");
            physics = scanner.nextInt();

            System.out.print("Kimya Ders Notunuz : ");
            chemistry = scanner.nextInt();

            System.out.print("Tarih Ders Notunuz : ");
            history = scanner.nextInt();

            System.out.print("Müzik Ders Notunuz : ");
            music = scanner.nextInt();

            System.out.print("Türkçe Ders Notunuz : ");
            turkish = scanner.nextInt();

            notHesapla(math, physics, chemistry, history, music, turkish);
        }catch (InputMismatchException e){
            System.out.println("Lütfen sadece Integer veri tipinde değerler giriniz.");
        }
    }

    public static void notHesapla(int math, int physics, int chemistry, int history, int music, int turkish){
        double result;
        double total = math + physics + chemistry + history + music + turkish;
        String textResult;
        result = total / 6;
        textResult = result > 60 ? "Sınıfı Geçti" : "Sınıfta Kaldı";
        System.out.println("Not Ortalamanız : " + result);
        System.out.println("Durum : " + textResult);


    }
}
