import java.util.Scanner;

public class Quantities
{
    /**
     * @author Ilya Pushkarev PIN-23
     * @version 22.0.1
     */

    // Получение данных от пользователя (Контроллер)
    public static void main(String[] args)
    {
        Scanner values = new Scanner(System.in); // Принимаем ввод

        System.out.print("Введите длину в метрах: ");
        int meters = values.nextInt();
        if (meters >= 0)
        {
            System.out.print("Введите длину в сантиметрах: ");
            int centimeters = values.nextInt();
            if(centimeters >= 0)
                {
                    int fullcentimeters = meters * 100 + centimeters;
                    System.out.println("Длина в сантиметрах: " + fullcentimeters);
                    View(fullcentimeters);
                }
            else
            {
                System.out.println("Неправильно введено значение (Сантиметры)!");
            }

        }
        else
        {
            System.out.println("Неправильно введено значение (Метры)!");
        }
    }

    // Здесь можем поменять способ обработки данных (Model)
    public static void importEnglish(double fullcentimeters)
    {
        System.out.println("Длина в английской СИ: ");
        // 1 фут = 30,48 см; 1 дюйм = 2,54 см;
        double foot = 30.48;
        double foots = fullcentimeters/foot;
        int roundfoots = (int) Math.round(foots);
        System.out.println("В футах: " + roundfoots);

        double inch = 2.54;
        double inchs = fullcentimeters/inch;
        int roundinchs = (int) Math.round(inchs);
        System.out.println("В дюймах: " + roundinchs);
    }
    public static void importOldRussian(double fullcentimeters)
    {
        System.out.println("Длина в старорусской СИ: ");
        // 1 вершок = 4,45 см; 1 аршин = 71,2 см.
        double vershok = 4.45;
        double vershki = fullcentimeters/vershok;
        int roundvershok = (int) Math.round(vershki);
        System.out.println("В вершках: " + roundvershok);

        double arshin = 71.2;
        double arshins = fullcentimeters/arshin;
        int roundarshins = (int) Math.round(arshins);
        System.out.println("В аршинах: " + roundarshins);

    }

    // Отображение всего происходящего (View)
    public static void View(double fullcentimeters)
    {

        int answer = 0;
        while (answer != 3)
        {
            System.out.println("Выберите СИ: ");
            System.out.println("1. Английский");
            System.out.println("2. Старорусский");
            System.out.println("3. Выход");
            Scanner views = new Scanner(System.in);
            if(views.hasNextInt()) // проверка на Int
            {
                answer = views.nextInt();
                switch (answer)
                {
                    case 1:
                        importEnglish(fullcentimeters);
                        break;
                    case 2:
                        importOldRussian(fullcentimeters);
                        break;
                    case 3:
                        System.out.println("..Выход из консоли..");
                        System.out.println("....................");
                        System.out.println("''''''''''''''''''''");
                        System.out.println("Выход.");
                        break;
                    default:
                        System.out.println("Неизвестное значение введите 1(Английские) или 2(Старорусские)! ");
                        break;
                }
            }
            else {
                System.out.println("Введено неккоректное значение (Введите 1, 2 или 3)!");
            }

        }
    }
}
