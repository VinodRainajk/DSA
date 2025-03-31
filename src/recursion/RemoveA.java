package src.recursion;

public class RemoveA {
    public static void main(String[] args) {
        System.out.println((removeA("ancsaarb", 0)));
    }

    private static String removeA(String input,int idx) {
        if(idx==input.length())
        {
            return input;
        }

        if(input.charAt(idx) == 'a'){
            input = input.substring(0,idx) + input.substring(idx+1,input.length());
        }else{
            ++idx;
        }

        return removeA(input,idx);
    }

}
