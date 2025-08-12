import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> uniqueCandies = new HashSet<>();
        
        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }
        
        int maxCandiesSisterCanGet = candyType.length / 2;
        
        return Math.min(uniqueCandies.size(), maxCandiesSisterCanGet);
    }
}
