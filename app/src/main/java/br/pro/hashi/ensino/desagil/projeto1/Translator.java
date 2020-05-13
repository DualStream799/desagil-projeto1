/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Translator {
    private HashMap<Character, Node> map;
    private LinkedList<Character> queue_chars;
    private static Node root, node_l, node_r, node_ll, node_lr, node_rr, node_rl, node_lll,
            node_llr, node_lrl, node_lrr, node_rll, node_rlr, node_rrl, node_rrr,
            node_llll, node_lllr, node_llrl, node_llrr, node_lrll, node_lrlr, node_lrrl,
            node_lrrr, node_rlll, node_rllr, node_rlrl, node_rlrr, node_rrll, node_rrlr,
            node_rrrl, node_rrrr, node_lllll, node_llllr, node_lllrr, node_llrrr,
            node_lrrrr, node_rllll, node_rrlll, node_rrrll, node_rrrrl, node_rrrrr;


    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Translator() {
        root = new Node('|');
        node_l = new Node('e');
        node_r = new Node('t');
        node_ll = new Node('i');
        node_lr = new Node('a');
        node_rl = new Node('n');
        node_rr = new Node('m');
        node_lll = new Node('s');
        node_llr = new Node('u');
        node_lrl = new Node('r');
        node_lrr = new Node('w');
        node_rll = new Node('d');
        node_rlr = new Node('k');
        node_rrl = new Node('g');
        node_rrr = new Node('o');
        node_llll = new Node('h');
        node_lllr = new Node('v');
        node_llrl = new Node('f');
        node_llrr = new Node(' '); // No value
        node_lrll = new Node('l');
        node_lrlr = new Node(' '); // No value
        node_lrrl = new Node('p');
        node_lrrr = new Node('j');
        node_rlll = new Node('b');
        node_rllr = new Node('x');
        node_rlrl = new Node('c');
        node_rlrr = new Node('y');
        node_rrll = new Node('z');
        node_rrlr = new Node('q');
        node_rrrl = new Node(' '); // No value
        node_rrrr = new Node(' '); // No value
        node_lllll = new Node('5');
        node_llllr = new Node('4');
        node_lllrr = new Node('3');
        node_llrrr = new Node('2');
        node_lrrrr = new Node('1');
        node_rllll = new Node('6');
        node_rrlll = new Node('7');
        node_rrrll = new Node('8');
        node_rrrrl = new Node('9');
        node_rrrrr = new Node('0');

        Queue<Node> queue = new LinkedList<>();
        queue_chars = new LinkedList<>();
        map = new HashMap<>();
        setRoot();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.element();
            Node right = node.getRight();
            Node left = node.getLeft();
            if (node.getValue() != '|' && node.getValue() != ' ') {
                queue_chars.add(node.getValue());
            }

            if (left != null) {
                left.setParent(node);
                queue.add(left);

            }
            if (right != null) {
                right.setParent(node);
                queue.add(right);
            }
            map.put(node.getValue(), node);
            queue.remove();
        }
    }


    private void setRoot() {
        // Relation : Root => E / T
        root.setLeft(node_l);
        root.setRight(node_r);
        node_l.setParent(root);
        node_r.setParent(root);
        // Relation : E => I / A
        node_l.setLeft(node_ll);
        node_l.setRight(node_lr);
        node_lr.setParent(node_l);
        node_ll.setParent(node_l);
        // Relation : T => N / M
        node_r.setLeft(node_rl);
        node_r.setRight(node_rr);
        node_rl.setParent(node_r);
        node_rr.setParent(node_r);
        // Relation : I => S / U
        node_ll.setLeft(node_lll);
        node_ll.setRight(node_llr);
        node_lll.setParent(node_ll);
        node_llr.setParent(node_ll);
        // Relation : A => R / W
        node_lr.setLeft(node_lrl);
        node_lr.setRight(node_lrr);
        node_lrl.setParent(node_lr);
        node_lrr.setParent(node_lr);
        // Relation : N => D / K
        node_rl.setLeft(node_rll);
        node_rl.setRight(node_rlr);
        node_rll.setParent(node_rl);
        node_rlr.setParent(node_rl);
        // Relation : M => G / O
        node_rr.setLeft(node_rrl);
        node_rr.setRight(node_rrr);
        node_rrl.setParent(node_rr);
        node_rrr.setParent(node_rr);
        // Relation : S => H / V
        node_lll.setLeft(node_llll);
        node_lll.setRight(node_lllr);
        node_llll.setParent(node_lll);
        node_lllr.setParent(node_lll);
        // Relation : U => F / None
        node_llr.setLeft(node_llrl);
        node_llr.setRight(node_llrr);
        node_llrl.setParent(node_llr);
        node_llrr.setParent(node_llr);
        // Relation : R => L / None
        node_lrl.setLeft(node_lrll);
        node_lrl.setRight(node_lrlr);
        node_lrll.setParent(node_lrl);
        node_lrlr.setParent(node_lrl);
        // Relation : W => P / J
        node_lrr.setLeft(node_lrrl);
        node_lrr.setRight(node_lrrr);
        node_lrrl.setParent(node_lrr);
        node_lrrr.setParent(node_lrr);
        // Relation : D => B / X
        node_rll.setLeft(node_rlll);
        node_rll.setRight(node_rllr);
        node_rlll.setParent(node_rll);
        node_rllr.setParent(node_rll);
        // Relation : K => C / Y
        node_rlr.setLeft(node_rlrl);
        node_rlr.setRight(node_rlrr);
        node_rlrl.setParent(node_rlr);
        node_rlrr.setParent(node_rlr);
        // Relation : G => Z / Q
        node_rrl.setLeft(node_rrll);
        node_rrl.setRight(node_rrlr);
        node_rrll.setParent(node_rrl);
        node_rrlr.setParent(node_rrl);
        // Relation : O => None / None
        node_rrr.setLeft(node_rrrl);
        node_rrr.setRight(node_rrrr);
        node_rrrl.setParent(node_rrr);
        node_rrrr.setParent(node_rrr);
        // Relation : H => 5 / 4
        node_llll.setLeft(node_lllll);
        node_llll.setRight(node_llllr);
        node_lllll.setParent(node_llll);
        node_llllr.setParent(node_llll);
        // Relation : V => null / 3
        node_lllr.setRight(node_lllrr);
        node_lllrr.setParent(node_lllr);
        // Relation : None => null / 2
        node_llrr.setRight(node_llrrr);
        node_llrrr.setParent(node_llrr);
        // Relation : J => => null / 1
        node_lrrr.setRight(node_lrrrr);
        node_lrrrr.setParent(node_lrrr);
        // Relation : B => 6 / null
        node_rlll.setLeft(node_rllll);
        node_rllll.setParent(node_rlll);
        // Relation : Z => 7 / null
        node_rrll.setLeft(node_rrlll);
        node_rrlll.setParent(node_rrll);
        // Relation : None => 8 / null
        node_rrrl.setLeft(node_rrrll);
        node_rrrll.setParent(node_rrrl);
        // Relation : None => 9 / 0
        node_rrrr.setLeft(node_rrrrl);
        node_rrrr.setRight(node_rrrrr);
        node_rrrrl.setParent(node_rrrr);
        node_rrrrr.setParent(node_rrrr);
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        Node node = root;
        for (int i = 0; i <=code.length()-1; i++) {
            if (code.charAt(i) == '.') {
                node = node.getLeft();
            } else if (code.charAt(i) == '-') {
                node = node.getRight();
            }
        }
        return node.getValue();
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        //while parent is not null => add string, then invert
        StringBuilder code = new StringBuilder();

        while (node.getParent() != null) {
            Node parent = node.getParent();
            if (parent.getLeft() == node) {
                code.append(".");
            } else if (parent.getRight() == node){
                code.append("-");
            }
            node = parent;
        }
        return code.reverse().toString();
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        LinkedList<String> codes = new LinkedList<>();
        for (char val : queue_chars){
            codes.add(charToMorse(val));
        }
        return codes;
    }
}
