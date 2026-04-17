package CodeEveryday;

public class 一比特与2比特字符 {

    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i]==1){
                i++;
                if (i==bits.length-1){return false;}
            }
        }
        return true;
    }
}
