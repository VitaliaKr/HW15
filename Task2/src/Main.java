import java.util.Scanner;

public class Main {
    public static String TEXT_VALID = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя- ";
    public static void main(String[] args) {
        //todo код писать тут. По желанию(рекомендуется) вынести код в методы.
        String input = inputString();
        if(isValidStringLength(input) && isValidStringChars(input)){
            System.out.println("Фамилия: " + lastName(input));
            System.out.println("Имя: " + name(input));
            System.out.println("Отчество: " + middleName(input));
        }else {
            System.out.println("Данные введены с ошибкой!");
        }
    }

    public static String inputString() {
        System.out.print("Введите ФИО: ");
        String inputData = new Scanner(System.in).nextLine().trim();
        return inputData;
    }

    public static boolean isValidStringLength(String validate) {
        int countSpace = 0;
        boolean isValid = true;
        for (int i = 0; i < validate.length(); i++) {
            if (validate.charAt(i) == ' ') {
                countSpace++;
            }
        }
        if (!(countSpace ==2)){
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidStringChars(String validate){
        boolean isValid = true;
        for (int i = 0; i < validate.length(); i++) {
            if(!TEXT_VALID.contains(String.valueOf(validate.charAt(i)))){
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static String lastName(String validate){
        String lastName = validate.substring(0,validate.indexOf(' ')).trim();
        return lastName;
    }

    public static String middleName(String validate){
        String middleName = validate.substring(validate.lastIndexOf(' ')).trim();
        return middleName;
    }

    public static String name (String validate){
        String name = validate.substring(validate.indexOf(' '),validate.lastIndexOf(' ')).trim();
        return name;
    }
}