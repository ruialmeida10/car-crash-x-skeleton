class ClosestNeighbours {

    public static void main(String[] args) {

        int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};

        // Initialize variables
        int difference = Math.abs((myArray[0] - myArray[1]));
        int minDifference = difference;
        int[] neighbours = {myArray[0], myArray[1]};

        for (int i = 1; i < myArray.length - 1; i++) {

            difference = Math.abs((myArray[i] - myArray[i + 1]));

            if (difference <= minDifference) {
                minDifference = difference;
                neighbours[0] = myArray[i];
                neighbours[1] = myArray[i + 1];
            }
        }

        // Print the elements of the resulting array
        System.out.println("The closest neighbours are: " + neighbours[0] + "," + neighbours[1]);

    }
}
