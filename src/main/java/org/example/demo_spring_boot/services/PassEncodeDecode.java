

//file only for temp use
package org.example.demo_spring_boot.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncodeDecode {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }
}
