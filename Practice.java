public class Practice{
    public static void main(String args[]){
        String str = "This is a test sting";
        String ptrn = "tist";
        char[] pattern = ptrn.toCharArray();
        int n = str.length();
        int ptrnLen = ptrn.length();
        int left = 0;
        int right = ptrnLen-1;
        int minLength = Integer.MAX_VALUE;
        String res = "";
        while(right < n){
            String temp = new String(str.substring(left, right));
            int count = 0;
            for(char ch : pattern){
                for(int i = 0; i < temp.length(); i++){
                    if(temp.charAt(i) == ch){
                        count++;
                    }
                }
                if(count == ptrnLen && temp.length() < minLength){
                    minLength = temp.length();
                    res = new String(temp);
                    left++;
                    right++;
                }
                else{
                    right++;
                }
            }


            }
        for(int i = 0; i < res.length(); i++){
            System.out.print(res.charAt(i));
        }

        }
    }
