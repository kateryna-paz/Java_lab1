package group;

public class StringSort {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введіть рядок: ");
        String inputString = scanner.nextLine();

        // Виклик методу сортування літер
        String result = sortString(inputString);

        System.out.println("Результат сортування: " + result);
    }

    private static String sortString(String inputString) {
        // Видалення пробілів і перетворення рядка в масив символів
        char[] charArray = inputString.replace(" ", "").toCharArray();

        // Сортування
        customSort(charArray);

        // Перетворення масиву символів у рядок
        return new String(charArray);
    }

    private static void customSort(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Character.toLowerCase(array[i]) > Character.toLowerCase(array[j])) {
                    // Обмін елементів місцями
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
