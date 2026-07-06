package CodeEveryday;

import java.util.Scanner;

public class day_1_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(func(str));
    }

    public static String func(String str){
        StringBuffer s = new StringBuffer();
        char[] temp = str.toCharArray();
        int l = 0,r = 1;
        while(r<temp.length){
            if(temp[l]!=temp[r]){
                l++;
                r++;
            }else{
                while(temp[l]==temp[r]){
                    temp[l] = '0';
                    temp[r] = '0';
                    if(l==0 || r==temp.length-1){break;}
                    while(temp[l]=='0' && l>0){
                        l--;
                    }
                    r++;
                }
                l = r;
                r+=1;
            }
        }
        for(char x: temp){
            if(x!='0'){s.append(x);}
        }
        if(s.length()==0){return "0";}
        return s.toString();
    }
}
