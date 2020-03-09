import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // ��ʱʱ��
        socket.setSoTimeout(3000);

        // ���ӱ��ء��˿ں�2000����ʱʱ��3000
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 3000);

        //
        System.out.println("�ѷ�����������ӣ��������������~~~~");
        System.out.println("�ͻ�����Ϣ��" + socket.getLocalAddress() + " Port: " + socket.getLocalPort());
        System.out.println("�������Ϣ��" + socket.getInetAddress() + " Port: " + socket.getPort());

        try {
            // ���ͽ�������
            todo(socket);
        } catch (Exception e) {
            System.out.println("�쳣�ر�");
        }

        // �ͷ���Դ
        socket.close();
        System.out.println("�ͻ������˳�!");
    }

    public static void todo(Socket client) throws IOException {
        // ����������
        InputStream input = System.in;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));

        // �õ�socket�����������ת��Ϊ��ӡ�����
        OutputStream outputStream = client.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(outputStream);

        // �õ�socket������������ת��ΪBufferedReader
        InputStream inputStream = client.getInputStream();
        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        boolean flag = true;
        do {
            // ���̶�ȡһ��
            String str = inputReader.readLine();
            // ���͵�������
            socketPrintStream.println(str);

            // �ӷ�������ȡһ��
            String echo = socketBufferedReader.readLine();
            if ("bye".equalsIgnoreCase(echo)) {
                flag = false;
            } else {
                System.out.println(echo);
            }
        } while (flag);

        // ��Դ�ͷ�
        socketPrintStream.close();
        socketBufferedReader.close();


    }

}
