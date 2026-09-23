public class task_5 {
    public static void main(String[] args){
        Table table = new Table(3,4);

        table.setValue(0, 0, 10);
        table.setValue(1, 2, 20);
        table.setValue(2, 3, 30);

        System.out.println("Строк: " + table.rows());
        System.out.println("Столбцов: " + table.cols());

        System.out.println("Значение в (1, 2): " + table.getValue(1, 2)); // Выведет: 20

        System.out.println("\nМатрица:");
        System.out.print(table.toString());

        System.out.println("Среднее арифметическое: " + table.average());
    }
}

class Table{
    private final int[][] matrix;
    private final int rowCount;
    private final int colCount;

    public Table(int rows, int cols){
        this.rowCount = rows;
        this.colCount = cols;
        this.matrix = new int[rows][cols];
    }

    public int getValue(int row, int col){
        return matrix[row][col];
    }

    public void setValue(int row, int col, int value) {
        matrix[row][col] = value;
    }

    public int rows(){
        return rowCount;
    }
    public int cols(){
        return colCount;
    }

    public double average(){
        double sum = 0;
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < colCount; j++){
                sum += matrix[i][j];
            }
        }
        return sum /(rowCount * colCount);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                sb.append(matrix[i][j]);

                if(j < colCount - 1){
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
