package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Point;
import model.menu.*;
import model.node.*;
import model.room.*;
/**
 *
 * @author Fahziar
 */
public class PrimaryXMLTagNotFound extends Exception
{
    private String errorMessage;
    public enum bahasa
    {
        indonesia, english
    }
    
    /**
     * Konstruktor
     * @param b Bahasa dari error message
     */
    public PrimaryXMLTagNotFound(bahasa b)
    {
        if (b == bahasa.indonesia)
        {
            errorMessage = "Tag utama pada XML tidak ditemukan";
        } else {
            errorMessage = "Main XML Tag not found";
        }
    }
    
    /**
     * Konstruktor
     * @param message Error message
     */
    public PrimaryXMLTagNotFound(String message)
    {
        errorMessage = message;
    }
    
    @Override
    public String getMessage()
    {
        return errorMessage;
    }
}
