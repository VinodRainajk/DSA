package src.LinearSearch;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] accountDetails =  {{1, 2, 3, 4}, {99, 3}};
        System.out.println(maximumWealth(accountDetails));

    }

    public static int maximumWealth(int[][] accounts){
        int maxWealth=  0;

        for(int row =0; row < accounts.length; row++){
            int currentwealth = 0;
            for(int col =0; col< accounts[row].length; col++){
                currentwealth =  currentwealth+ accounts[row][col];
            }
            maxWealth = Math.max(maxWealth,currentwealth) ;
        }


        return maxWealth;
    }
}
