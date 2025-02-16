package com.regex.advancedproblems.validateipaddress;

import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String[] testIPs = {
                "192.168.1.1",   // Valid
                "255.255.255.255", // Valid
                "256.100.50.25",  // Invalid (256 out of range)
                "192.168.1",      // Invalid (missing octet)
                "192.168.1.999",  // Invalid (999 out of range)
                "1.1.1.01"        // Invalid (leading zero)
        };

        for (String ip : testIPs) {
            System.out.println(ip + " -> " + isValidIPv4(ip));
        }
    }

    public static boolean isValidIPv4(String ip) {
        String regex = "^(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

        return ip.matches(regex);
    }
}

