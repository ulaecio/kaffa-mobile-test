public class RectangleIntersection {

    public static boolean intersects(int[] A1, int[] A2, int[] B1, int[] B2) {
        int x1 = A1[0], y1 = A1[1];
        int x2 = A2[0], y2 = A2[1];
        int x3 = B1[0], y3 = B1[1];
        int x4 = B2[0], y4 = B2[1];

        // Check if any of the non-intersection scenarios are true
        if (x2 < x3 || x1 > x4 || y2 < y3 || y1 > y4) {
            return false;
        }
        return true;
    }
    //Test the intersects method with three different sets of rectangles (A, B and C).
    public static void main(String[] args) {
        int[] A1 = {3, 5};
        int[] A2 = {11, 11};
        int[] B1 = {7, 2};
        int[] B2 = {13, 7};
        int[] C1 = {11, 11};
        int[] C2 = {15, 13};

        System.out.println(intersects(A1, A2, B1, B2));  // true
        System.out.println(intersects(A1, A2, C1, C2));  // true
        System.out.println(intersects(B1, B2, C1, C2));  // false
    }
}
