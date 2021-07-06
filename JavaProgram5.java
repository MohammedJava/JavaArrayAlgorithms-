import java.util.Random;

public class JavaProgram5 {
    public static void main(String[] args) {
        //random number between 1 and 15
        int a = random(1, 15);
        System.out.println("Random number between 1 and 15:" + a + "\n");

        //array of 10 elements between 0 and 20
        System.out.println("Array of 10 random elements between 0 and 20");
        int[] arr = randomArr(10, 0, 20);
        //print the array
        printArr(arr);
        System.out.println();

        //1,2,3,4,5 array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("\nArr2 before rightShift() : ");
        printArr(arr2);

        //Shift array to the right
        System.out.println("\nArr2 after rightShift(): ");
        arr2 = shiftRight(arr2);
        printArr(arr2);

        //Before shift
        System.out.println("\n\nArr3 before leftShift(): ");
        int[] arr3 = {10, 11, 12, 13, 14};
        printArr(arr3);
        System.out.println("\nArr3 sorted: " + sorted(arr3));

        //After shift
        arr3 = shiftLeft(arr3);
        System.out.println("\nArr3 after leftShift(): ");
        printArr(arr3);
        System.out.println("\nArr3 sorted: " + sorted(arr3));

        //Print array and whether it has duplicates
        int[] arr4 = {0,1,2,4,5,4,7,6};
        System.out.println("\nArr4: ");
        printArr(arr4);
        System.out.println("\nArr4 is a set: " + isASet(arr4));

        //Print array and whether it has duplicates
        int[] arr5 = {0,2,4,7,8,3,1};
        System.out.println("\nArr5: ");
        printArr(arr5);
        System.out.println("\nArr5 is a set: " + isASet(arr5));



    }

    //random integer between [a,b] generator
    public static int random(int a, int b) {
        Random rand = new Random();
        //rand.nextInt(b) results in a random int [0,b[
        //a + [0,b-a[ = [a,b[
        //[a,b[ + 1 = [a,b+1[ = [a,b]
        return a + rand.nextInt(b - a + 1);
    }


    //array of size n of random integers between a and b
    public static int[] randomArr(int n, int a, int b) {
        //if size is 0, return null
        if (n == 0) {
            return null;
        }

        else {
            //create array and counter
            int[] arr = new int[n];
            int counter = 0;

            //random number [a,b] for each element of the array
            while (counter < n) {
                arr[counter] = random(a, b);
                counter++;
            }
            return arr;
        }
    }

    //print 5 elements of an int array in each line
    public static void printArr(int[] arr) {
        int counter = 0;
        int size = arr.length;

        //while counter < array size
        while (counter < size) {
            //if counter is not divisible by 5 or equal to 0
            if (counter % 5 != 0 || counter == 0) {
                //print element and increment
                System.out.print(arr[counter] + " ");
                counter++;
            }
            //else counter is divisible by 5
            else {
                //for each 5th index, println and then print element and increment
                System.out.println();
                System.out.print(arr[counter] + " ");
                counter++;
            }
        }
    }

    //Since Java is always pass by value, one needs to do arr1 = shiftLeft(arr1)
    //right shift an int array
    public static int[] shiftRight(int[] arr) {
        int size = arr.length;
        int counter = 0;
        int lastValue = arr[size - 1];
        int temp1 = arr[1];
        int temp2 = arr[0];

        //while counter < size - 1, store info of the index in temp1 before replacing it with temp2's content
        //Store the info of the next index in temp2, and replace the info in the index with temp1's content
        //Exchange the process now with temp2 used to replace the info and temp1 storing again the info
        //Repeat for all the array
        while (counter < size - 1) {
            if (counter % 2 == 0) {
                temp1 = arr[counter + 1];
                arr[counter + 1] = temp2;
                counter++;
            }
            else {
                temp2 = arr[counter + 1];
                arr[counter + 1] = temp1;
                counter++;
            }
        }
        arr[0] = lastValue;

        return arr;
    }

    //Since Java is always pass by value, one needs to do arr1 = shiftLeft(arr1)
    //left shift an int array
    public static int[] shiftLeft(int[] arr) {
        int size = arr.length;
        int counter = size - 1;
        int firstValue = arr[0];
        int temp1;
        int temp2;

        //checks whether size is even or not to decide what is the last index and which
        //must be chosen correctly shift the first values
        if (size % 2 == 0) {
            temp1 = arr[size - 1];
            temp2 = arr[size - 2];
        }
        else {
            temp1 = arr[size - 2];
            temp2 = arr[size - 1];
        }

        //while counter > 0, store info of the index in temp1 before replacing it with temp2's content
        //Store the info of the next index in temp2, and replace the info in the index with temp1's content
        //Exchange the process now with temp2 used to replace the info and temp1 storing again the info
        //Repeat for all the array
        while (counter > 0) {
            if (counter % 2 == 0) {
                temp1 = arr[counter - 1];
                arr[counter - 1] = temp2;
                counter--;
            }
            else {
                temp2 = arr[counter - 1];
                arr[counter - 1] = temp1;
                counter--;
            }
        }
        arr[size - 1] = firstValue;

        return arr;
    }

    //Check if the array is sorted
    public static boolean sorted(int[] arr) {
        int counter = 0;
        boolean sorted = true;

        while (counter < arr.length - 1) {
            //if one value is greater than the next, return false
            if (arr[counter] > arr[counter + 1]) {
                sorted = false;
                break;
            }
            counter++;
        }
        return sorted;
    }

    //Check if the array has duplicates
    public static boolean isASet(int[] arr) {
        int counter = 0;
        boolean set = true;

        //loop to check if all values following each i are not equal to i
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                //if duplicate found, break inner lop[
                if(arr[i] == arr[j]){
                    set = false;
                    break;
                }
            }
            //break outer loop if duplicate found
            if(!set){
                break;
            }
        }

        return set;
    }
}
