package src;

import java.util.List;

public class Main {
    public static void main(String[] args){
        for(String arg : args){
            switch (arg){
                case "--version":
                    System.out.println("v1.0");
            }
        }
    }
}
