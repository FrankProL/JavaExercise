package exercise;


/**
 * Created by Frank on 2018/8/1.
 */
public class VersionCompare {
    public static void main(String[] args) {
        String versionA = "1.2.3a";
        String versionB = "1.2.3a";
        String[] aArray = versionA.split("\\D+");
        String[] bArray = versionB.split("\\D+");

        boolean flag=true;
        for (int i = 0; i < aArray.length; i++) {
            if (Integer.valueOf(aArray[i]) > Integer.valueOf(bArray[i])) {
                System.out.println("versionA>versionB");
                flag=false;
                break;
            }
            if (Integer.valueOf(aArray[i]) < Integer.valueOf(bArray[i])) {
                System.out.println("versionA<versionB");
                flag=false;
                break;
            }
        }
        if (flag) {
            aArray = versionA.split("\\d");
            bArray = versionB.split("\\d");
            char aLast = aArray[aArray.length - 1].charAt(0);
            char bLast = bArray[bArray.length - 1].charAt(0);
            int t=aLast - bLast;
            if((aLast-bLast)>0) System.out.println("versionA>versionB");
            else if ((aLast-bLast)<0) System.out.println("versionA<versionB");
            else System.out.println("versionA=versionB");
        }
    }
}
