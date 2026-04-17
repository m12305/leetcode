package CodeEveryday;

public class 字符串匹配模式 {



    //cccccccccccccccccccccccccccccccccccccccccc
    public static boolean hasMatch(String s, String p) {
        StringBuilder stringBuffer1 = new StringBuilder();
        StringBuilder stringBuffer2 = new StringBuilder();

        int i = 0;
        for (; i < p.toCharArray().length; i++) {
            if (p.charAt(i)=='*'){
                i++;
                break;
            }
            stringBuffer1.append(p.charAt(i));
        }

        for (; i < p.toCharArray().length; i++) {
            stringBuffer2.append(p.charAt(i));
        }

        System.out.println(stringBuffer1.toString());
        System.out.println(stringBuffer2.toString());


        int j = 0;
        for (; j < s.toCharArray().length-stringBuffer1.length()+1; j++) {
            System.out.println(s.substring(j,j+stringBuffer1.length()));
            if (s.substring(j,j+stringBuffer1.length()).equals(stringBuffer1.toString())){

                if (stringBuffer2.length()==0){return true;}
                break;
            }
        }
        if (j==s.toCharArray().length-stringBuffer1.length()+1){return false;}
        j+=stringBuffer1.length();
        System.out.println(j);
        if (j==s.toCharArray().length-stringBuffer2.length()+1){return false;}
        for (; j < s.toCharArray().length-stringBuffer2.length()+1; j++) {
            System.out.println(s.substring(j,j+stringBuffer2.length()));
            if (s.substring(j,j+stringBuffer2.length()).equals(stringBuffer2.toString())){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        hasMatch("giiiigiiii","iigi*i");
    }
}
