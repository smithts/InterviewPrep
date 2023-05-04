package leetcode.two_pointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //begin with an impossible area amount
        int maxArea = -1;
        //assign pointers on either side of the height array
        int low = 0, high = height.length - 1, currentArea;

        while (low < high) {
            // calculate current area
            // area is restricted by the smaller of the two walls, hence Math.min
            currentArea = Math.min(height[low], height[high]) * (high - low);

            // Set max area to new value if larger area is discovered
            maxArea = Math.max(currentArea, maxArea);

            // my thought here was that keeping the higher wall made more sense
            // if we're trying to maximize the area
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }

        // return result
        return maxArea;
    }

}
