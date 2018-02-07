package testExample;

import java.util.*;

public class RC4 {

    /**
     * 默认等级4，默认大写
     * @return
     */
    public static String RC4(){
       String ss =  RC4(4,true);
       return ss;
    }

    /**
     * level = 1 2 3 4 5 6 7 8
     * 100万内安全系数 仅供参考
     * 1    2^16安全
     * 2    230左右误差
     * 3    0误差 【1000万级0误差】
     * 4    0误差
     *
     * @param level     安全等级
     * @param upper     是否大写
     * @return
     */
    public static  String  RC4(int level,boolean upper){
       String uuid = UUID.randomUUID().toString().replace("-","").substring(0,level*4);
       String ss = RC42hex02(HloveyRC4(uuid,"angelSXD"));
       return  upper ? ss.toUpperCase() : ss;
    }


    public static String RC42hex02(String str){
        final String HEX = "0123456789abcdef";
        StringBuffer stringBuffer = new StringBuffer();
        byte [] bytArr = str.getBytes();
        for (byte b : bytArr) {
            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            stringBuffer.append(HEX.charAt((b >> 4) & 0x0f));
            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
            stringBuffer.append(HEX.charAt(b & 0x0f));
        }
        return stringBuffer.toString();
    }


    public static String HloveyRC4(String aInput,String aKey)
    {
        int[] iS = new int[256];
        byte[] iK = new byte[256];

        for (int i=0;i<256;i++)
            iS[i]=i;

        int j = 1;

        for (short i= 0;i<256;i++)
        {
            iK[i]=(byte)aKey.charAt((i % aKey.length()));
        }

        j=0;

        for (int i=0;i<255;i++)
        {
            j=(j+iS[i]+iK[i]) % 256;
            int temp = iS[i];
            iS[i]=iS[j];
            iS[j]=temp;
        }


        int i=0;
        j=0;
        char[] iInputChar = aInput.toCharArray();
        char[] iOutputChar = new char[iInputChar.length];
        for(short x = 0;x<iInputChar.length;x++)
        {
            i = (i+1) % 256;
            j = (j+iS[i]) % 256;
            int temp = iS[i];
            iS[i]=iS[j];
            iS[j]=temp;
            int t = (iS[i]+(iS[j] % 256)) % 256;
            int iY = iS[t];
            char iCY = (char)iY;
            iOutputChar[x] =(char)( iInputChar[x] ^ iCY) ;
        }

        return new String(iOutputChar);

    }
}
