/*
1. Take input as words and then do the operations on the corresponding data
*/

package SourceCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input extends Register {

    File code;
    Scanner input;

    Input() throws FileNotFoundException {
        code = new File(
                "D:\\SACHIN\\Sachin_Docs\\sem 4\\CO\\RISC project\\gh\\RISC-V_Simulator\\RISC-V_Simulator-main\\TestCase\\test.txt");
        // code = new File("D:\\Work\\NOTES\\Computer
        // Organisation\\Project\\RISC-V_Simulator\\RISC-V_Simulator-main\\TestCase\\test.txt");
        this.input = new Scanner(code);
    }

    // A function used to take input of the program and call for other functions to
    // do the task
    void TakeFileInputinMain() {

        // For a paticular set of instructions it shall run efficiently
        while (input.hasNextLine()) {
            switch (input.next()) {
                case "add":
                    input_Add();
                    break;
                case "sub":
                    input_Sub();
                    break;
                case "lw":
                    input_lw();
                    break;
                case "li":
                    input_li();
                    break;
                case "addi":
                    input_addi();
                    break;
                case "subi":
                    input_subi();
                    break;
                case "mul":
                    input_mul();
                    break;
                case "mulh":
                    input_mulh();
                    break;
                case "div":
                    input_div();
                    break;
                case "rem":
                    input_rem();
                    break;
                case "bne":
                    input_bne();
                    break;
                case "jal":
                    input_jal();
                    break;
                case "#":
                    input.nextLine();
                    break;
                default:
                    break;

            }
        }
    }

    // A method that converts input string which contains a target register to index
    // of that particualr register
    private int regToIndex(String reg) {
        if ((reg.charAt(0) == 't') || (reg.charAt(0) == 's') || (reg.charAt(0) == 'a')) {
            switch (reg.charAt(0)) {
                case 't':
                    return getIndexOfT(reg.charAt(1));
                case 's':
                    return getIndexOfS(reg);
                case 'a':
                    return getIndexOfA(reg.charAt(0));
                default:
                    return -1;
            }
        } else {
            // Ideally will throw an error but currently let's deal it simple
            return -1;
        }
    }

    private int addressToIndex(String reg) {
        String offset = "";
        // reg will be of format offset(rs1) => I need value inside rs1 and offset
        // Firstly lets catch up on offset
        int i = 0, regIndex;
        while (reg.charAt(i) != '(') {
            offset += reg.charAt(i);
            i++;
        }
        i++;
        // Dealing with rs1 now
        regIndex = regToIndex(reg.substring(i, reg.lastIndexOf(reg)));
        // Now We need to fetch value from this register and add it to offset which will
        // be returned
        // return (Register[regIndex]+(int)offset);
        return 0;
    }

    private void input_Add() {
        int rd, rs1, rs2;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e add rd, rs1, rs2
        rd = regToIndex(input.next());
        rs1 = regToIndex(input.next());
        rs2 = regToIndex(input.next());
        add(rd, rs1, rs2);
        // Calling Add operation of memory class
    }

    private void input_Sub() {
        int rd, rs1, rs2;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e sub rd, rs1, rs2
        rd = regToIndex(input.next());
        rs1 = regToIndex(input.next());
        rs2 = regToIndex(input.next());
        sub(rd, rs1, rs2);
        // Calling Sub operation of memory class
    }

    private void input_lw() {
        int dest, src;
        // Currently only accepts the standard way i.e lw x1, 0(x2)
        dest = regToIndex(input.next());
        src = addressToIndex(input.next());
        loadWord(dest, src);
        // Calling lw operation of memory class
    }

    private void input_li() {
        int dest, addr;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e li x0, 0
        dest = regToIndex(input.next());
        addr = input.nextInt();
        li(dest, addr);
    }

    private void input_addi() {
        // throw new UnsupportedOperationException("Not supported yet.");
        int rd, rs1, imm;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e add rd, rs1, 5
        rd = regToIndex(input.next());
        rs1 = regToIndex(input.next());
        imm = input.nextInt();
        addi(rd, rs1, imm); // Calling Addi operation of memory class
    }

    private void input_bne() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void input_jal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void input_subi() {
        int rd, rs1, immd;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e sub rd, rs1, 8
        rd = regToIndex(input.next());
        rs1 = regToIndex(input.next());
        immd = input.nextInt();
        subi(rd, rs1, immd);
        // Calling Subi operation of memory class
    }

    private void input_mul() {
        int rd, rs1, rs2;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e mul rd, rs1, rs2
        rd = regToIndex(input.next());
        rs1 = regToIndex(input.next());
        rs2 = regToIndex(input.next());
        mul(rd, rs1, rs2);
        // Calling Mul operation of memory class
    }

    private void input_mulh() {
        int rd, rs1, rs2;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e mulh rd, rs1, rs2
        rd = regToIndex(input.next());
        rs1 = regToIndex(input.next());
        rs2 = regToIndex(input.next());
        mulh(rd, rs1, rs2);
        // Calling Mulh operation of memory class
    }

    private void input_div() {
        int rd, rs1, rs2;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e div rd, rs1, rs2
        rd = regToIndex(input.next());
        rs1 = regToIndex(input.next());
        rs2 = regToIndex(input.next());
        div(rd, rs1, rs2);
        // Calling div operation of memory class
    }

    private void input_rem() {
        int rd, rs1, rs2;
        // throw new UnsupportedOperationException("Not supported yet.");
        // Currently only accepts the standard way i.e rem rd, rs1, rs2
        rd = regToIndex(input.next());
        rs1 = regToIndex(input.next());
        rs2 = regToIndex(input.next());
        rem(rd, rs1, rs2);
        // Calling Rem operation of memory class
    }

    private int getIndexOfT(char num) {
        switch (num) {
            case '0':
                return 5;
            case '1':
                return 6;
            case '2':
                return 7;
            case '3':
                return 28;
            case '4':
                return 29;
            case '5':
                return 30;
            case '6':
                return 31;
            default:
                return -1;
        }
    }

    private int getIndexOfS(String reg) {
        switch (reg.charAt(0)) {
            case '0':
                return 8;
            case '1':
                // Register mapping to sppecific one
                return 9;
            case '2':
                return 18;
            case '3':
                return 19;
            case '4':
                return 20;
            case '5':
                return 21;
            case '6':
                return 22;
            case '7':
                return 23;
            case '8':
                return 24;
            case '9':
                return 25;
            default:
                return -1;
        }
    }

    private int getIndexOfA(char num) {
        switch (num) {
            case '0':
                return 10;
            case '1':
                return 11;
            case '2':
                return 12;
            case '3':
                return 13;
            case '4':
                return 14;
            case '5':
                return 15;
            case '6':
                return 16;
            case '7':
                return 17;
            default:
                return -1;
        }
    }
}