/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;


    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        return ' ';
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        return " ";
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        LinkedList MorseList =  new LinkedList<String>(Arrays.asList(
        ".",
        "-",
        "..",
        ".-",
        "-.",
        "--",
        "...",
        "..-",
        ".-.",
        ".--",
        "-..",
        "-.-",
        "--.",
        "---",
        "....",
        "...-",
        "..-.",
        ".-..",
        ".--.",
        ".---",
        "-...",
        "-..-",
        "-.-.",
        "-.--",
        "--..",
        "--.-",
        ".....",
        "....-",
        "...--",
        "..---",
        ".----",
        "-....",
        "--...",
        "---..",
        "----.",
        "-----"));
        return MorseList;
    }
}
