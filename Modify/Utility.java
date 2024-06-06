/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify;

import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author xuandien
 */
public class Utility {
    private String password;

    public Utility(String password) {
        this.password = password;
    }

    public String getSecurityMD5() {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(this.password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPrice(float x) {
//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat vn = NumberFormat.getInstance(localeVN);
        DecimalFormat vn = new DecimalFormat("###,###,###");
        String str = vn.format(x);
        return str;
    }

    public static String getTimeNow(String pattern) {    // Lấy ngày lẫn giờ hiện tại
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(new Date());
    }

    public static LocalDate getDayNow() {
        return java.time.LocalDate.now();
    }

    public static LocalTime getTimeNow() {
        return java.time.LocalTime.now();
    }

    public static String getRelativePath (){
        URL url = Utility.class.getResource("../Poster");
        String selectedImagePath = new File(url.getPath()).toString()+ "/" ;
        
        return selectedImagePath;
    }
    public static void setImageLabel(JLabel imgLabel, String name){
        ImageIcon ii = new ImageIcon(getRelativePath() + name);
        //Resize
        Image image = ii.getImage().getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
        //Display
        imgLabel.setIcon(new ImageIcon(image));
    }
}


