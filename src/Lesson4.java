public class Lesson4 {
    public static void main(String[] args) {
        Lesson4 main = new Lesson4();
        String[][] correct = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect2 = {
                {"1", "2", "3", "4"},
                {"1", "2", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            main.stringExceptionTest(correct);
//            main.stringExceptionTest(incorrect);
            main.stringExceptionTest(incorrect2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public int stringExceptionTest(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException(String.format("Неверное количество столбцов в %d-й" +
                    " строке", i));
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
            System.out.println();
        }
        return count;
    }

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public int i;
    public int j;
    MyArrayDataException(int i, int j) {
        super(String.format("Неверные данные находятся в ячейке [%d, %d]\n", i, j));
        this.i = i;
        this.j = j;
    }

}
}


