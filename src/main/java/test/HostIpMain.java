package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class HostIpMain {
    public static void main(String[] args) {
        printIp();
    }

    private static void printIp() {
        try {
            InetAddress host = InetAddress.getLocalHost();
            System.out.println(host.getHostName());

            String ip = host.getHostAddress();
            System.out.println(ip);
            System.out.println(Arrays.toString(host.getAddress()));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}