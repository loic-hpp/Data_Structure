import java.util.*;

public final class Interview {
    /**
     * Expliquez votre complexité temporelle et spatiale à l'aide de commentaire dans le code
     * Indiquez les équivalences telles que O(n + 1) => O(n) et O(2n) => O(n)
     *
     * * TODO Time Complexity  :
     * * TODO Space Complexity :
     *
     * @param boxes The array that contains the weight of each box.
     * @return The weight of the final box if it is applicable.
     */
    static public int lastBox(int[] boxes) {
        if (boxes.length == 0)
            return 0;
        else{
            // create a priority queue sorted in descending order
            PriorityQueue<Integer> boxQueue = new PriorityQueue<>((box1, box2) -> box2 - box1);
            for (int box : boxes) {
                boxQueue.add(box);
            }
            while(boxQueue.size() > 1){
                Integer highestBox1 = boxQueue.remove();
                Integer highestBox2 = boxQueue.remove();
                if(highestBox1.compareTo(highestBox2) > 0)
                    boxQueue.add(highestBox1 - highestBox2);
                else if(highestBox1.compareTo(highestBox2) < 0)
                    boxQueue.add(highestBox2 - highestBox1);
            }
            if (boxQueue.size() == 0)
                return 0;
            else
                return boxQueue.remove();
        }
    }
}
