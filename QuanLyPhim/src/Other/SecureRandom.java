/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Other;
import java.util.Random;

/**
 *
 * @author This PC
 */
public class SecureRandom {
    public static String generateRandomID(int length) {
         if (length <= 7) {
            throw new IllegalArgumentException("Your input must be greater than or equal 8");
        }

        // Dùng chuỗi ký tự để tạo ID ngẫu nhiên
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@!~#$%^&**?<>*+-/+_";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        while(!Pass(sb.toString()))
        {
            for (int i = 0; i < length; i++) 
            {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
            }
        }

        return sb.toString();
    }
    public static boolean Pass(String password)
    {
        int so=0,chu=0,kitu=0;
        for(int i=0;i<password.length();i++)
        {
           if(Character.isLetter(password.charAt(i))) chu++;
           if(Character.isDigit(password.charAt(i))) so++;
           if(!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i)) ) kitu++;
        }
        if(password.length()>=8 && so>0 && chu>0 && kitu>0)
        {
           return true;
        }
        return false;
    }
}

