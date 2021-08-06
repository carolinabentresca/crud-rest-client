/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author EXO
 */
public class usuarioClient {
    
    String uri = "http://localhost:8080/CrudRest/webresources/usuario";
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(uri);
    
    //Test GetList
    public void testGetAll(){
        String response = target.request().accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(response);
    }
    
    //Test GetById
    public void testGetById(){
        try{
        String id = "3";
        String response = target.path(id).request().accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(response);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //Test Post
    public void testPost(){
        usuario us = new usuario(4,"char","char@email.com");
        String response = target.request()
                .post(Entity.entity(us,MediaType.APPLICATION_JSON),String.class);
        System.out.println(response);
        
    }
    
    //Test Put
    public void testPut(){
        try{
        usuario us = new usuario("ely","charY@email.com");
        String id = "4";
        Response response = target.path(id).request()
                .put(Entity.entity(us, MediaType.APPLICATION_JSON),Response.class);
        System.out.println(response);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //Test Delete
    public void testDelete(){
        try{
        String id = "4";
        usuario us = target.path(id).request().delete(usuario.class);
        System.out.println(us);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
