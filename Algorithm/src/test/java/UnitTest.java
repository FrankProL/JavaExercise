/**
 * Created by Frank on 2019/10/18.
 * learn junit
 */
//import org.junit.Test;
public class UnitTest {
    @org.junit.Test
    public void testBitMap() {
        int N = 64;//位图存储的最大数字
        int map[] = new int[(int)Math.ceil(N / 32.0)];
        System.out.println(checkBit(map, 1));
        setBit(map, 1);
        setBit(map, 10);
        setBit(map, 4);
        setBit(map, 31);
        setBit(map, 0);
        setBit(map,35);
        setBit(map,63);
        System.out.println(checkBit(map, 1));
        sortBitArray(map);
    }

    private boolean checkBit(int[] arr, int val) {
        return (arr[val / 32] & (1 << val % 32)) != 0;
    }

    private void setBit(int[] arr, int val) {
        arr[val / 32] |= 1 << val % 32;
    }

    public void sortBitArray(int[] bitArray) {
        int count = 0;
        for (int i = 0; i < 64; i++) {
            if (checkBit(bitArray, i)) {
                System.out.print(count + "\t");
            }
            count++;
        }
        System.out.println("");
        System.out.println(Integer.toBinaryString(bitArray[0]));
        System.out.println(Integer.toBinaryString(bitArray[1]));
    }
}
