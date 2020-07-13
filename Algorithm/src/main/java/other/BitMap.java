package other;

import java.util.BitSet;

/**
 * Created by Frank on 2019/10/17.
 * 位图算法
 * 32位机器上的自然数一共有4294967296个，如果用一个bit来存放一个整数，1代表存在，0代表不存在，
 * 那么把全部自然数存储在内存只要4294967296 / (8 * 1024 * 1024) = 512MB（8bit = 一个字节），而这些自然数存放在文件中，
 * 一行一个数字，需要16G的容量.
 * 在java中，应该没有bit这种数据结构，最小的是byte，byte占8bit，那么我们可以用byte代表8个连续的数字，
 * 不过因为byte的范围是127 ~ -128，最高位是符号位，所以可以变通一下，前7位代表8n ~ 8n + 7的数字，
 * 8n + 7这个数可以用符号来区分，即>0即含有8n + 7，<0即不含8n + 7（这里其实不一定要用byte来做，
 * 用short，int，long来做都一样的，因为我找到第一篇是用byte，所以就先入为主了）
 *
 * 因为一个byte占8位，所以对于一个给定的value，我们先求出该value应该位于哪个Byte上，这很简单，int byteIndex = value / 8;
 * 找到value在byte数组中的位置后，再就是在该字节中寻找表示value的bit位，我们知道，一个byte其实就是一个长为8的bit数组，
 * 那么value在该bit数组中的位置也就很好算了，int bitIndex = value % 8;
 * 最后我们把该bit位设置为1就可以了：byte[byteIndex] = byte[byteIndex] | 1 << ( 7 - bitIndex)
 * （数组从左到右从0开始计数，不是二进制数从从右向左增大，所以对应字节位7-bitIndex）
 * https://www.jianshu.com/p/bf9dbbc147ed
 * https://www.leiphone.com/news/201903/tYUEYWz1SJR6CQPV.html
 * https://blog.csdn.net/xinzhongtianxia/article/details/81294922
 */

public class BitMap {
    public byte[] bitArr;
    private static final byte mask = 3;
    private static final int maxNum = (1 << mask) - 1;      // 1 x (2的3次方) - 1   = 7
    private long count = 0;

    BitMap() {
        bitArr = new byte[1 << (Integer.SIZE - mask)];
    }   // 32-3=29  2的29次方=536870912

//    public void setBit(int num) {
//        byte val = bitArr[num >> mask];   // num >> mask  相当于num除以8取整 num/8 即第几个byte
//        int bit = num & maxNum;   //maxNUm 7 111 按位与操作，结果相当于num%(maxNum+1) num除以8的余数，num<=maxNum时还是自身
//        if (val >= 0 && bit == maxNum) {
//            bitArr[num >> mask] = (byte) ~val;
//        } else if (val < 0 && bit != maxNum) {
//            bitArr[num >> mask] = (byte) ~(~val | (1 << bit));
//        } else if (val >= 0 && bit != maxNum) {
//            bitArr[num >> mask] |= (1 << bit);
//        }
//    }
    public void setBit(int value) {
        int byteIndex=value/8;
        int bitIndex=value%8;
//        bitArr[byteIndex]=bitArr[byteIndex]|(1<<(7-bitIndex))
        bitArr[byteIndex]|=(1<<(7-bitIndex));
    }
    public byte getBit(int num) {
        byte val = bitArr[num >> mask];
        int bit = num & maxNum;
        if (bit == maxNum) {
            return bitArr[num >> mask] < 0 ? (byte) 1 : (byte) 0;
        } else if (val < 0 && bit != maxNum) {
            return (byte) (~bitArr[num >> mask] & (1 << (bit)));
        } else {
            return (byte) (bitArr[num >> mask] & (1 << (bit)));
        }
    }
    public long countDistinctNum() {
        int length = bitArr.length;
        for (int i = 0; i < length; ++i) {
            if (bitArr[i] >= 0) {
                count += Integer.bitCount(bitArr[i]);
            }else {
                count += Integer.bitCount(~bitArr[i]) + 1;
            }
        }
        return count;
    }

    public void delBit(int num) {
        byte val = bitArr[num >> mask];
        int bit = num & maxNum;
        if (bit == maxNum) {
            bitArr[num >> mask] = (byte) ~val;
        } else if (val < 0 && bit != maxNum) {
            bitArr[num >> mask] = (byte) ~(~bitArr[num >> mask] ^ (1 << (bit)));
        } else {
            bitArr[num >> mask] = (byte) (bitArr[num >> mask] ^ (1 << (bit)));
        }
    }

    public static void main(String[] args) {
//        int num = (1 << 3);
//        System.out.println(Integer.SIZE);
//        System.out.println(num);
//        for (int i = 0; i < 30; i++) {
//            System.out.println(i+"  "+(i&7)+"  "+(i%8)+ "  "+ (1<<(i&7)));
//        }
        BitMap bm = new BitMap();
        bm.setBit(12);
        bm.setBit(3);
        bm.setBit(3);
        bm.setBit(1);
        bm.setBit(7);
        bm.setBit(13);
        System.out.println(bm.getBit(3));
        System.out.println(bm.countDistinctNum());

        byte b=0;
        System.out.println((byte)~b);
        System.out.println(Integer.toBinaryString(bm.bitArr[0]));
        System.out.println(Integer.toBinaryString(bm.bitArr[1]));

        int map[] = new int[1];
        System.out.println(map.length);
        map[0]=2;
        System.out.println(map.toString());

        System.out.println(Integer.toBinaryString(1 << 7));
        System.out.println(0/8);
        System.out.println(0 % 8);

        byte bb=(byte)127;
        System.out.println(Integer.toBinaryString(bb));

        BitSet bs = new BitSet();
        bs.set(0);
        bs.set(10);
        bs.set(32);
        System.out.println(bs.toString());

        System.out.println(1L<<64);
    }

}
