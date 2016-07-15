package com.boot;

import static org.junit.Assert.*;

import org.junit.Test;

import com.boot.controller.HomeController;


public class AppTest 
{
    @Test
    public void testApp(){
    	
    	HomeController controller=new HomeController();
    	String result = controller.home();
    	assertEquals("Successful Spring boot Home page", result);
    	
    }
}
