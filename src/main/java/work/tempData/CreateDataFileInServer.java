package work.tempData;

import com.jcraft.jsch.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class CreateDataFileInServer {
    public static void main(String[] args) {
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;

        String ip = "192.168.1.151";
        int port = 22;
        String user = "learnershi";
        String password = "45301542";

        JSch jsch = new JSch();
        try {
            session = jsch.getSession(user, ip, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = session.openChannel("sftp");
            channel.connect();

            channelSftp = (ChannelSftp) channel;

            //위치 이동
            String path = "/home/learnershi/share/";
            String ymd = LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

            channelSftp.cd(path);
//            channelSftp.mkdir(ymd);
            channelSftp.cd(ymd);

            String localPath = "D:/2024/temp/tempJonsData.jsonl";
            
            int cnt = 500;    //file 개수
            for(int i=0; i<cnt; i++) {
                createFile(localPath);
                // 파일 업로드
                String fileName = String.format("user_metric.part%04d.jsonl",i);
                channelSftp.put(new FileInputStream(localPath), fileName);
            }

        } catch (JSchException e) {
            throw new RuntimeException(e);
        } catch (SftpException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(session != null) session.disconnect();
            if(channel != null) channel.disconnect();
            if(channelSftp != null) channelSftp.disconnect();
        }
    }

    static void createFile(String localPath) {
        File sampleFile = new File("D:/2024/temp/user_metric.part0000.jsonl");
        int cnt = 1000;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sampleFile)));
             BufferedWriter bw = new BufferedWriter(new FileWriter(localPath))
        ) {
            String line = br.readLine();
            String newData = line.substring(line.indexOf(", \"metrics"));
            for(int i=0; i<cnt; i++) {
//                String accountName = UUID.randomUUID().toString();
//                bw.write("{\"account_name\": \""+accountName+newData);
//                System.out.println(i+" :: "+accountName);

                bw.write("{\"account_name\": \""+UUID.randomUUID()+newData);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
