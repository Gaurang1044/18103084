package Assignment4;

public class Question4_2 {
    public static void main(String[] args) {
        int val = -1;
        byte byte_val = (byte) val;
        char char_val = (char) byte_val;
        int out = char_val;
        System.out.println(out);
        System.out.println("No the value of the variable doesnt end back as the same as start value.");
        String out1 = "Byte ranging from -128 to 127 is able to accomate -1 and value remains same. "
                + "But char datatype ranges from 0 to 65535. SO it isnt able to accomodate the value -1 when conversion from byte to char. "
                + "So in this situation java allocates the maximum value,i.e, 65535 to the variable. "
                + "Now when conversion from char to int happens , 65535 being in range of int is converted to int as it is "
                + "and that is the final output.";
        System.out.println(out1);
    }
}