package com.example.monte.proyectov2;

public class ListaEjercicios {

    private String head;
    private String desc;

    public ListaEjercicios(String head, String desc){
        this.head = head;
        this.desc = desc;
    }

    public String getHead(){
        return head;
    }

    public String getDesc(){
        return desc;
    }
}
