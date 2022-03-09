import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch oBinarySearch = new BinarySearch();
        oBinarySearch.runRecursiveTest();
    }

    private void runRecursiveTest(){

        SecureRandom oRand = new SecureRandom();
        int[] aNumbers = new int[1000];
        int iTargetNumber;
        int iTargetNumberIndex;
        int iIndexFound;

        //Fills array with random numbers.
        for (int x = 0; x < aNumbers.length; x++) {
            aNumbers[x] = oRand.nextInt(20000000);
        }

        // Need to have ordered data for binary search.
        Arrays.sort(aNumbers);

        iTargetNumberIndex = oRand.nextInt(aNumbers.length);
        iTargetNumber = aNumbers[iTargetNumberIndex];

        iIndexFound = findNumberBinarySearch(aNumbers, iTargetNumber, 0, aNumbers.length - 1);

        System.out.println("Correct answer: " + iTargetNumberIndex);
        System.out.println("Returned answer: " + iIndexFound);

        // *********************************
        // Test timing of both algorithms.

        long startTime;
        long elapsedTime;

        // **********************************
        // *** BEGIN TEST Binary Search ***
        startTime = System.nanoTime();
        iIndexFound = findNumberBinarySearch(aNumbers, iTargetNumber, 0, aNumbers.length - 1);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Binary search time is: " + elapsedTime);
        // *** END TEST Binary Search ***
        // **********************************


        // **********************************
        // *** BEGIN TEST Linear Search ***
        startTime = System.nanoTime();
        iIndexFound = findNumberLinearSearch(aNumbers, iTargetNumber);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Linear search time is: " + elapsedTime);
        // *** END TEST Linear Search ***
        // **********************************


    }

    // Binary Search: Find index of number using recursive implementation
    // NOTE: Method expects number to be in array.
    private int findNumberBinarySearch(int[] aNumbers, int iTarget,int iLowIndex,int iHighIndex){

        // Figure out the middle index.
        int iMiddleIndex = (iLowIndex + iHighIndex)/2;

        // Check if target at middle index.
        if(aNumbers[iMiddleIndex] == iTarget){
            return iMiddleIndex;
        }

        // Check if target is lower than number at middle index.

        else if (iTarget < aNumbers[iMiddleIndex]){
            return findNumberBinarySearch(aNumbers,iTarget,iLowIndex,iMiddleIndex - 1);
        }

        // Target is higher than middle index number.
        else {
            return findNumberBinarySearch(aNumbers,iTarget,iMiddleIndex + 1,iHighIndex);
        }

    }

    // Linear search: Find Index of number using linear search.
    private int findNumberLinearSearch(int[] aNumbers, int iTarget){
        for(int x = 0; x < aNumbers.length; x++) {
            if (aNumbers[x] == iTarget) {
                return x;
            }
        }
        return -1;
    }

}
