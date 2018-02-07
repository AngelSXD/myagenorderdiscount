package testExample;




import com.sxd.util.RC4;
import org.junit.Test;

import java.io.*;
import java.util.Base64;


public class UUIDTest {

    @Test
    public void getUUid(){
        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();

        File file = new File("G:/ACODE/123.jpg");
        System.out.println(file.getName());
        byte [] bytes = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream  bos = new ByteArrayOutputStream();
            byte [] b = new byte[1024];
            int n = 0;
            while((n = fileInputStream.read(b)) != -1){
                bos.write(b,0,n);
            }
            fileInputStream.close();
            bos.close();

            bytes = bos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //编码
        final String base64Str = encoder.encodeToString(bytes);
        System.out.println("base64Str:"+base64Str);
        System.out.println("base64Str长度:"+base64Str.length());


        String classPath = this.getClass().getResource("/").getPath();
        System.out.println(classPath);
        //解码
        byte [] bytes1 = decoder.decode(base64Str);
        File file1 = new File(classPath+file.getName());
        try {
            OutputStream outputStream = new FileOutputStream(file1);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(bytes1);

            bufferedOutputStream.close();
            outputStream.close();
            System.out.println(file1.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }







}
