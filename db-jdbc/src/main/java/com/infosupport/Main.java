package com.infosupport;

public class Main {
    public static void main(String[] args) {
        Jdbc jdbc = Jdbc.getInstance();
        jdbc.executeQuery(
                """
                select *
                from titles
                where type = 'mod_cook'
                """
        );
    }
}