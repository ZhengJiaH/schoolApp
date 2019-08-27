package com.app.utils;

import org.springframework.stereotype.Component;
import java.util.Random;
import java.util.Random;

@Component
public class AccreditURL {
    public static String accreditURL (){
        //验证码位数  是否含有字母  是否含有数字
        String REDIRECTURI="https://tellhowedu.haixiong.io/index.html";
        String nonce=randomUtil.nextInt();
        String privat = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCLtw1n6gCF9+gYpXdFU7RBWm0T0rnHTdjaPyEhDKJnuphLd4y8UyqGKJbobd4ykrCHsOrzb9antHtlvk+oHLjTMVcWuPUV7DVqa+v/FQOB9HSlNefStlynGv092C4vjwlDWHGz51+98UvPDL5lCLCLnuHMSY7aMrW36qyQnHSEOMnHHdCO2ECc4Zs4eTvojkF+TG/wauioLbiA20RXPlRW7wllkXljuUyrGk8gFBE7pfqbTHsKF4MwO51PSvb1Q566LWh5Cl/VvHc7ycxgdwQDvn3x86QMdDbumJgq/EJikye4Jza2VzXZEKMMft+BdTUm9id7gkKCZk0YX71u3aRhAgMBAAECggEAXmyEfupDGEeHcMDDbvM3K8P1XCRasjwGhtmLhk6HpBsTuk09rDl4z9q2wrceKIfDDrGe2I+JPyZXD1gjdbaTowgBl7XAzeQp5ZaylF6bVETmYJGh72KYE8fFxvpHnJTK6dzoW3HP3wso9PHj61yIFJR4fhxok0caUQYlQka66HCGA+zjEyUajtTOZQX0IIAfFKV9TxmAomQfnbjBwf9LsOXfy0GJzWlNKJer2GDFHMaZqj2XfRT9r/pMi8/HAICp/3nYl/ozEaSPcnHfSAw6W52GhmTzBpLEr8njEoWoIu5RGoVAkCfWbikAhP8mHt0XKYA2lh4Xd5GCs4Pao60kAQKBgQDdRaARMg7tgILa/EWuAh2cYPJi1HBCpwL+j2Xp1IZbZNXs7avhkr0tAPhfU+McLx3r+PKk9VZ+OdgCEVUz3rPwS/NANPamNvgXmxqet4WP7XdpI/Dr7zD5DX06WNBgqPG3RMXE7u6GLS5Bc5qeXw9U9F1cDG1SGAG1gREkVjQzcQKBgQChpJe3XOySXZflDbrFvgC//3p0AogYB5EKbxYmuwf6hEW6Olh3eoAwfAcjj7sQNIeOu71+WdrT3+Ti8iZjiNGaaJBYe3RqXj5Gesi9Avj5+McyMJgndakWJUVVqFI+kZ677i0/Efdi/ww2MNVk0aWUsrpFWgQlNeIj06ggapMn8QKBgQCcuVsFsvIV0Mdeef6UoFT+1T/5NkUJQKgDS+hAddJwW3yWY0Ux8bBiduR1CMK8zLah0+NxaYBIyYmw9TvnEF9c3T6/BISK+DZC6g4xywUkC2tfoiBbzEBgtugy8oMtY5xJVcHKmf2CNfAkVdB3Shde8fJKZ1brJavYNkHA/fndUQKBgGQhRk4yxOVCDva304vs0CAfTSaR7uYbwdAZ0jn5v86Co4Lh461XeBMQsYdo4LMAJzzWtWKQnMqEtg+Tew5LUbP5s/jruMivSpp0MudK8Ro/7nz7tzUyYKS0P8f49cGGiTLXLrYUFg//9/uVsoq6h3yeXl7ZjRnT0BrrYQl7m16xAoGAUvkt1gmayxi3Ip3pV2tludQ5sNvX6RkAEhcxdRVqSPuI4QhdAqTPFM1ccE6hJ18kBYVL+o5o2rBTMFpDMMGJrfxCaf72zeaJ+xdepC2WbEJ//eXJQPhh8KOtkywSMrmqJuno0GHszSHf9f6w6cu2JrXkETp2jZKhHGs9otiYxyk=";
        String APPID="3fc4198f-bfca-42c1-a497-600a070fb336";
        String raw = "appId="+APPID+"&nonce="+nonce+"&privateKey="+privat;
        String sign=MD5Utils.encode1(raw);
        String SIGN=sign.toUpperCase();
        String url="https://i.yunban.com/wlxy/api/open/oauth2/v2?appId="+APPID+"&sign="+SIGN+"&nonce="+nonce+"&redirectUri="+REDIRECTURI;
        System.out.println(url);
        return url;
    }
}

/**
 * ClassName: randomUtil
 * @Description: 随机数工具类
 * @author chisj chisj@foxmail.com
 * @date 2017年5月7日
 */
class randomUtil {
    public static String nextInt() {
        Random random = new Random();
        String result="";
        for(int i=0;i<6;i++){
            result+=random.nextInt(10);
        }
        return result;
    }
}