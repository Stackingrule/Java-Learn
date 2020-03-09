import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // 超时时间
        socket.setSoTimeout(3000);

        // 连接本地。端口号2000，超时时间3000
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);

        //
        System.out.println("已发起服务器连接，并进入后续流程~~~~");
        System.out.println("客户端信息：" + socket.getLocalAddress() + " Port: " + socket.getLocalPort());
        System.out.println("服务端信息：" + socket.getInetAddress() + " Port: " + socket.getPort());

        try {
            // 发送接收数据
            todo(socket);
        } catch (Exception e) {
            System.out.println("异常关闭");
        }

        // 释放资源
        socket.close();
        System.out.println("客户端已退出!");
    }

    public static void todo(Socket client) throws IOException {
        // 键盘输入流
        InputStream input = System.in;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));

        // 得到socket输出流，并且转换为打印输出流
        OutputStream outputStream = client.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(outputStream);

        // 得到socket输入流，并且转换为BufferedReader
        InputStream inputStream = client.getInputStream();
        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        boolean flag = true;
        do {
            // 键盘读取一行
            String str = inputReader.readLine();
            // 发送到服务器
            socketPrintStream.println(str);

            // 从服务器读取一行
            String echo = socketBufferedReader.readLine();
            if ("bye".equalsIgnoreCase(echo)) {
                flag = false;
            } else {
                System.out.println(echo);
            }
        } while (flag);

        // 资源释放
        socketPrintStream.close();
        socketBufferedReader.close();


    }

}
