public class RectangleIntersectionCalc {

    // Method to check if two rectangles intersect
    public static boolean intersects(int[] A1, int[] A2, int[] B1, int[] B2) {
        int x1 = A1[0], y1 = A1[1];
        int x2 = A2[0], y2 = A2[1];
        int x3 = B1[0], y3 = B1[1];
        int x4 = B2[0], y4 = B2[1];

        // Check if there is no overlap
        return !(x2 < x3 || x1 > x4 || y2 < y3 || y1 > y4);
    }

    // Method to compute the area of intersection between two rectangles
    public static int areaOfIntersection(int[] A1, int[] A2, int[] B1, int[] B2) {
        if (!intersects(A1, A2, B1, B2)) {
            return 0; // No intersection
        }

        int x1 = A1[0], y1 = A1[1];
        int x2 = A2[0], y2 = A2[1];
        int x3 = B1[0], y3 = B1[1];
        int x4 = B2[0], y4 = B2[1];

        // Calculate the intersection coordinates
        int ix1 = Math.max(x1, x3);
        int iy1 = Math.max(y1, y3);
        int ix2 = Math.min(x2, x4);
        int iy2 = Math.min(y2, y4);

        // Calculate the width and height of the intersection
        int width = ix2 - ix1 + 1; // +1 because the points are included
        int height = iy2 - iy1 + 1; // +1 because the points are included

        // If width or height is negative, there is no intersection
        if (width <= 0 || height <= 0) {
            return 0;
        }

        // Return the area of the intersection
        return width * height;
    }

    public static void main(String[] args) {
        int[] A1 = {3, 5};
        int[] A2 = {11, 11};
        int[] B1 = {7, 2};
        int[] B2 = {13, 7};
        int[] C1 = {11, 11};
        int[] C2 = {15, 13};

        System.out.println("areaOfIntersection (A, B) = " + areaOfIntersection(A1, A2, B1, B2));  // Output: 15
        System.out.println("areaOfIntersection (A, B) = " + areaOfIntersection(A1, A2, C1, C2));  // Output: 1
    }
}
