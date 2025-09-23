public class Main {
    public static void main(String[] args) {
        int[] num = {25, -3, 5, 10, 38, 62, 20, -8, 173, 65};

        System.out.println("    Normal Sort:    ");
        printNum(num);
        System.out.println("\n");

        // bubble - ascending
        System.out.println("\n    Bubble Sort (Ascending):    ");
        bubbleAsc(num);
        printNum(num);

        // bubble - descending
        System.out.println("\n\n    Bubble Sort (Descending):   ");
        bubbleDesc(num);
        printNum(num);
        System.out.println("\n");

        // selection - ascending
        System.out.println("\n    Selection Sort (Ascending):     ");
        selectionAsc(num);
        printNum(num);

        // selection - descending
        System.out.println("\n\n    Selection Sort (Descending):    ");
        selectionDesc(num);
        printNum(num);
    }

    private static void bubbleAsc(int[] arr){
        for (int last = arr.length - 1; last  > 0; last-- ) {
            for(int i = 0; i < last; i++){
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
    private static void bubbleDesc(int[] arr){
        for (int last = arr.length - 1; last  > 0; last-- ) {
            for(int i = 0; i < last; i++){
                if(arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
    private static void selectionAsc(int[] arr) {
        for (int last = arr.length - 1; last > 0; last--){

            int largest = 0;

            for(int i = 1; i <= last; i++) {

                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }

            if (largest != last) {
                int temp = arr[largest];
                arr[largest] = arr[last];
                arr[last] = temp;
            }
        }
    }
    private static void selectionDesc(int[] arr) {
        for (int last = arr.length - 1; last > 0; last--){

            int smallest = 0;

            for(int i = 1; i <= last; i++) {

                if (arr[i] < arr[smallest]) {
                    smallest = i;
                }
            }

            if (smallest != last) {
                int temp = arr[smallest];
                arr[smallest] = arr[last];
                arr[last] = temp;
            }
        }
    }
    private static void printNum(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}