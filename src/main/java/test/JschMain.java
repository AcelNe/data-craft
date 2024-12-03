package test;

import com.jcraft.jsch.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class JschMain {
    public static void main(String[] args) {
        printFileName();
    }

    static void printFileName() {
        JSch jsch = new JSch();
        Session session = null;
        try {
//            session = jsch.getSession("student","4.218.19.171",22);
//            session.setPassword("1234");
            jsch.addIdentity("C:\\Users\\MONINGSUN\\Downloads\\mall-vm3-5654_key.pem");
            session = jsch.getSession("azureuser","4.218.19.171",22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();

            //print fileName
//            List<ChannelSftp.LsEntry> list = channel.ls("/home/student");
            List<ChannelSftp.LsEntry> list = channel.ls("/home/azureuser");

            System.out.print(list.size());
            for (ChannelSftp.LsEntry entry : list) {
                System.out.println(entry.getFilename());
                System.out.println(entry.getLongname());
                SftpATTRS attrs = entry.getAttrs();
                System.out.println(attrs);
                System.out.println(attrs.getMTime() * 1000L);
                System.out.println(new Date(attrs.getMTime() * 1000L));

                if(entry.getFilename().equals("test.txt")) {
                    channel.setMtime("/home/azureuser/test.txt", (int) Instant.now().getEpochSecond());
                    System.out.println(entry.getLongname());
                }
            }

            channel.disconnect();
        } catch (JSchException | SftpException e) {
            throw new RuntimeException(e);
        }
    }
}