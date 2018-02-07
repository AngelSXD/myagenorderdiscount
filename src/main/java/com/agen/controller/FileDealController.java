package com.agen.controller;


import com.agen.myagen.entity.XxAdmin;
import com.agen.myagen.repository.AdminRepository;
import com.agen.orderdiscount.entity.Promocode;
import com.agen.orderdiscount.repository.PromocodeRepository;
import com.sxd.util.QR_Code;
import com.sxd.util.RC4;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileDealController {

    final Base64.Decoder decoder = Base64.getDecoder();
    final Base64.Encoder encoder = Base64.getEncoder();

    @Resource
    private AdminRepository adminRepository;
    @Resource
    private PromocodeRepository promocodeRepository;


    /**
     * 机构登录  获取 头像
     * @param adminId
     * @return
     */
    @ResponseBody
    @RequestMapping("getAdminLogoData")
    public String getAdminLogoData(Integer adminId){
        if(Objects.nonNull(adminId)){
            Promocode promocode = promocodeRepository.findPromocodeByAdminId(adminId);
            if(Objects.nonNull(promocode)){
                return promocode.getLogoImg();
            }
        }

        return "null";
    }


    /**
     * 上传机构logo图片
     *
     * 不限制windows或者 linux平台
     * 上传logo图片存储与数据库，磁盘上的图片文件会被删除 不会被存储
     * @param partFile
     * @param adminId
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("uploadMaterial")
    @ResponseBody
    public String uploadMaterial(@RequestParam("upfile")MultipartFile partFile, @RequestParam("adminId")Integer adminId,HttpServletRequest request) throws IOException {


        if(Objects.isNull(adminId)){
            return "error";
        }else{
            XxAdmin admin = adminRepository.findXxAdminById(adminId);
            if(Objects.nonNull(admin)){

                String fileName = partFile.getOriginalFilename();
                String perfix = fileName.substring(fileName.lastIndexOf("."));
                String newFileName = admin.getName()+System.currentTimeMillis()+perfix;
                File file = new File("/static/img/"+newFileName);//上传到服务器端的路径
                InputStream is = partFile.getInputStream();
                FileUtils.copyInputStreamToFile(is, file);

                Promocode promocode = null;
                if(Objects.nonNull((promocode = promocodeRepository.findPromocodeByAdminId(adminId)))){
                    promocode.setLogoImg(file2String(file));
                }else{
                    promocode = new Promocode();
                    promocode.setCodeId(UUID.randomUUID().toString());
                    promocode.setAdminId(adminId);
                    promocode.setCodeDate(new Date());
                    promocode.setAdminName(admin.getName());
                    promocode.setLogoImg(file2String(file));
                    promocode.setFileName(newFileName);
                    promocode.setPromocodeStr(RC4.RC4());
                    promocode.setPromoDiscount(1D);
                }
                Promocode promocode1 = promocodeRepository.saveAndFlush(promocode);
                if(file.exists()){
                    file.deleteOnExit();
                }
                return Objects.nonNull(promocode1) ? promocode1.getLogoImg() : "null";
            }

        }
        return  "null";
    }


    /**
     * 为机构下载优惠券二维码
     * @param adminId
     * @param response
     */
    @RequestMapping("downloadQR_Code")
    public void downloadQR_Code(Integer adminId,HttpServletResponse response){
        if(Objects.nonNull(adminId)){
            Promocode promocode = promocodeRepository.findPromocodeByAdminId(adminId);
            if(Objects.nonNull(promocode)){
                File logoFile = file4base64(promocode.getLogoImg(),promocode.getFileName());
                String QR_CodeName = promocode.getAdminName()+".jpg";

                //创建一个本机构的优惠券二维码
                QR_Code code = new QR_Code();
                QR_Code.CodeModel codeModel = code.new CodeModel();
                codeModel.setLogoFile(logoFile);
                codeModel.setDesc(promocode.getAdminName()+"优惠券二维码\r\n"+"优惠券编码："+promocode.getPromocodeStr());
                codeModel.setContents(promocode.getPromocodeStr());
                codeModel.setFontSize(20);
                File QR_CodeFile = new File("/static/img/"+QR_CodeName);
                code.createCodeImage(codeModel,QR_CodeFile);



                FileInputStream inputStream = null;
                response.setContentType("multipart/form-data");
                response.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
                try {
                    if(Objects.nonNull(QR_CodeFile) && QR_CodeFile.exists()){
                        inputStream = new FileInputStream(QR_CodeFile);
                    }
                    response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(QR_CodeName, "utf-8"));//保证下载文件名不会出现乱码
                    OutputStream outputStream = response.getOutputStream();
                    byte[] b = new byte[1024];
                    int length = 0;
                    while ((length = inputStream.read(b)) != -1) {
                        outputStream.write(b, 0, length);
                    }
                    inputStream.close();
                    outputStream.close();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(QR_CodeFile.exists()){
                        QR_CodeFile.deleteOnExit();
                    }
                    if(logoFile.exists()){
                        logoFile.deleteOnExit();
                    }
                }


            }
        }
    }



    /**
     * 编码
     * 文件编码为字符串
     * @param file
     * @return
     */
    public String file2String(File file){

        if(Objects.isNull(file)){
            return  null;
        }else{
            byte [] bytes = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
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
            return base64Str;
        }
    }


    /**
     * 解码
     * 解码base64字符串为文件
     * @param base64Str
     * @param fileName
     * @return
     */
    public File file4base64(String base64Str,String fileName){
        //解码
        byte [] bytes1 = decoder.decode(base64Str);
        File file = new File("/static/img/"+fileName);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(bytes1);

            bufferedOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  file;
    }
}
