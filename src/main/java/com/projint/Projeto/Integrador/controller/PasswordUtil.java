/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projint.Projeto.Integrador.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author cirol
 */
public class PasswordUtil {
    public static String gerarMD5(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes());
        byte[] bytes = md.digest();
        
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
}
