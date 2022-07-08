package str;

/**
 * @author Diyang Li
 * @create 2022-07-08 5:36 PM
 */
public class _405_ConvertaNumbertoHexadecimal {
    public String toHex(int num) {
        // each four bits represent one hexadecimal number:
        // 1111->15->f, so there are 8 hex numbers
        // num & 15 means mod, so we could find the corresponding number in the map
        // then num >>> 4 could come to the next gourp of bits/ hex number


        // for -1: -1 is 0000....0001->1111....1110 + 1 = 1111....1111;
        // 8 group of 1111, each 1111 represent one f, so -1 is 7 f

        if(num == 0) return "0";
        String map = "0123456789abcdef";
        String rest = "";

        while(num!=0){
            // num & 15 find the right num in map, for
            rest = map.charAt(num&15) + rest;
            num = num >>> 4;
        }

        return rest.toString();
    }
}
