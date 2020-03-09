import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);

        System.out.println("服务器准备就绪~~~~");
        System.out.println("服务端信息：" + serverSocket.getInetAddress() + " Port: " + serverSocket.getLocalPort());

        // 等待客户端连接
        for(;;) {
            // 得到客户端
            Socket client = serverSocket.accept();
            // 客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(client);
            // 启动线程
            clientHandler.start();
        }
    }

    /**
     * <h2>客户端消息处理</h2>
     */
    private static class ClientHandler extends Thread {

        private Socket socket;
        private boolean flag = true;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("新客户端连接：" + socket.getInetAddress() + " port: " + socket.getPort());

            try {
                // 得到打印流，用于数据输出；服务器回送数据使用
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());
                // 得到输入流，用于接收数据
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                do {
                    // 客户端得到数据
                    String str = socketInput.readLine();
                    if ("bye".equalsIgnoreCase(str)) {
                        flag = false;
                        socketOutput.println("bye");
                    } else {
                        // 打印到屏幕，并回送数据长度
                        System.out.println(str);
                        socketOutput.println("回送：" + str.length());
                    }
                } while (flag);


                socketInput.close();
                socketOutput.close();

            } catch (Exception e) {
                System.out.printf("连接异常！");
            } finally {
                // 连接关闭
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("客户端已退出：" + socket.getInetAddress() + " port: " + socket.getPort());

        }
    }

}
