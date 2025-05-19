package src.slidingWindow;

import java.util.HashMap;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {

        int l =0;
        int r =0;
        int maxFruits = 0;
        HashMap<Integer,Integer> fruitCount = new HashMap<>();
        while(r < fruits.length){
            if(fruitCount.containsKey(fruits[r])){
                int currentVal = fruitCount.get(fruits[r]);
                fruitCount.put(fruits[r], currentVal+1);
            }else {
                fruitCount.put(fruits[r],1);
            }


            if(fruitCount.size() > 2 ){


                int currentVal = fruitCount.get(fruits[l])-1;


                if(currentVal==0){

                    fruitCount.remove(fruits[l]);
                }else{
                    fruitCount.put(fruits[l], currentVal);
                }

                l++;

            }

            if (fruitCount.size() <= 2 ){
                maxFruits = Math.max(maxFruits, r-l+1);
            }

            r++;
        }
        return maxFruits;
    }
}
