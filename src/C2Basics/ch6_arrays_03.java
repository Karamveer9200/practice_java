package C2Basics;

public class ch6_arrays_03 {
    public static void main(String[] args) {
// Multidimensional Array (arrays within an array)
// Suppose there is an array string[]classroom
// each element of array classroom - has its own array of student
// each element of array student   - has its own array of subjects
// like:- string[]classroom [class][stu][sub] (<-3d array, can go up to 'n'd)

//----------------------------------------------------------
        // 2-D array
        //int [] marks; // 1-D array
        String [][] flats; // 2-D array
        flats = new String [2][4]; // a flat has 2 floors, each floor 4 apartments
        flats[0][0] = "|G1 - Mr. Rakesh"; // 1st apartment on the ground is G1
        flats[0][1] = "|G2 - Ms. Seema";
        flats[0][2] = "|G3 - Dr. Bose";
        flats[0][3] = "|G4 - Vacant";
        flats[1][0] = "|11 - Mr. Mohd"; // 1st apartment on the 1st floor is 11
        flats[1][1] = "|12 - Vacant";
        flats[1][2] = "|13 - Mr. Vincent";
        flats[1][3] = "|14 - Ms. Singh";

        // printing a 2-D array using for-loop
        System.out.println("printing a 2-D array");
        for (int i=0; i<flats.length; i++) {
            for (int j=0;j<flats[i].length; j++ ) {
                System.out.print(flats[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
