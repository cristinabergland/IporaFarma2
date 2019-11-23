/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

/**
 *
 * @author Alcídia Cristina
 */
public class Autenticacao {

    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

}
