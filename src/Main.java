import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        double amount;

        Scanner sc = new Scanner(System.in);

        Currency currency; // Интерфейс для работы с адаптерами валют

        System.out.println("Options:");  // Выводим доступные опции
        System.out.println("Enter 1: Dollar");
        System.out.println("Enter 2: Yuan");
        System.out.println("Enter 3: Euro");
        System.out.println("Enter 4: Tenge");

        System.out.println("\nChoose your option: "); // Получаем выбор пользователя
        choice = sc.nextInt();

        System.out.println("Your number is: " + choice);

        System.out.println("Enter the amount you want to convert?"); // Получаем сумму для конвертации
        amount = sc.nextFloat();
        System.out.println("Your amount is: " + amount);

        switch (choice) {   // Используем адаптеры в зависимости от выбора пользователя
            case 1:
                currency = new Dollar();
                currency.convert(amount);
                break;
            case 2:
                currency = new Yuan();
                currency.convert(amount);
                break;
            case 3:
                currency = new Euro();
                currency.convert(amount);
                break;
            case 4:
                currency = new Tenge();
                currency.convert(amount);
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}

interface Currency { // Интерфейс, описывающий метод конвертации валюты
    void convert(double amount);
}

class Dollar implements Currency { // Адаптер для долларов
    @Override
    public void convert(double amount) {
        double yuan = amount * 7.32;
        double euro = amount * 1.02;
        double tenge = amount * 478.6;

        System.out.println(amount + " Dollar = " + yuan + " Yuan ");
        System.out.println(amount + " Dollar = " + euro + " Euro ");
        System.out.println(amount + " Dollar = " + tenge + " Tenge ");
    }
}

class Yuan implements Currency { // Адаптер для юаней
    @Override
    public void convert(double amount) {
        double dollar = amount * 0.14;
        double euro = amount * 0.13;
        double tenge = amount * 66.7;

        System.out.println(amount + " Yuan = " + dollar + " Dollar ");
        System.out.println(amount + " Yuan = " + euro + " Euro ");
        System.out.println(amount + " Yuan = " + tenge + " Tenge ");
    }
}

class Euro implements Currency { // Адаптер для евро
    @Override
    public void convert(double amount) {
        double dollar = amount * 0.98;
        double yuan = amount * 6.98;
        double tenge = amount * 507.6;

        System.out.println(amount + " Euro = " + dollar + " Dollar");
        System.out.println(amount + " Euro = " + yuan + " Yuan");
        System.out.println(amount + " Euro = " + tenge + " Tenge ");
    }
}

class Tenge implements Currency { // Адаптер для тенге
    @Override
    public void convert(double amount) {
        double dollar = amount * 0.0021;
        double yuan = amount * 0.015;
        double euro = amount * 0.002;

        System.out.println(amount + " Tenge = " + dollar + " Dollar");
        System.out.println(amount + " Tenge = " + yuan + " Yuan");
        System.out.println(amount + " Tenge = " + euro + " Euro ");
    }
}
