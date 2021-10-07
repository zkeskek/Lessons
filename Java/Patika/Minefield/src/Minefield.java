import java.util.Scanner;

public class Minefield {

    // https://app.patika.dev/moduller/java101/bitirme-mayin-tarlasi
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rowCount = 0, columnCount = 0;

        try {
            System.out.print("Satır Sayısı : ");
            rowCount = scanner.nextInt();

            System.out.print("Sütün Sayısı : ");
            columnCount = scanner.nextInt();

            if(rowCount <= 0 || columnCount <= 0){
                System.out.println("Sadece pozitif sayı giriniz");
                System.exit(0);
            }
        }catch (Exception e){
            System.out.println("Sadece sayı giriniz!");
            System.exit(0);
        }

        // Create Instance
        MineSweeper mineSweeper = new MineSweeper(rowCount, columnCount);

        mineSweeper.create();

        int row = 0, column = 0;

        while (true){
            if(mineSweeper.isWin()){
                System.out.println("Tebrikler Oyunu tamamladınız.");
                break;
            }

            mineSweeper.print();

            try {
                System.out.print("Satır seçiniz : ");
                row = scanner.nextInt();

                System.out.print("Sütun seçiniz : ");
                column = scanner.nextInt();

                if(row < 0 || column < 0){
                    System.out.println("Lütfen negatif sayı girmeyiniz");
                    continue;
                }

            }catch (Exception e){
                System.out.println("Lütfen sadece sayı giriniz");
                continue;
            }

            mineSweeper.selectIndex(row,column);
        }

        scanner.close();

    }
}
