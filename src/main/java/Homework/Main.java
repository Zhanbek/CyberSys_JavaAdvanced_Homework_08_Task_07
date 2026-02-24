package Homework;

class DaemonTask implements Runnable{
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Daemon працює...");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println("Daemon перервано");
        }
    }
}

public class Main {

    private static void printInfo(Thread t) {
        System.out.println("ID: " + t.getId());
        System.out.println("Name: " + t.getName());
        System.out.println("стан: " + t.getState());
        System.out.println("Активний?: " + t.isAlive());
        System.out.println("Є Демоном: " + t.isDaemon());
        System.out.println("Thread Group: " + t.getThreadGroup().getName());
    }
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new DaemonTask(), "MyDaemonThread");

        System.out.println();
        System.out.println("Встановлюємо потік daemonThread як daemon до його запуску!");
        daemonThread.setDaemon(true);

        System.out.println();
        System.out.println("<----- Виведення інформації про потік ПЕРЕД СТАРТОМ ----->");
        printInfo(daemonThread);

        daemonThread.start();

        System.out.println();
        System.out.println("<----- Виведення інформації про потік ПІСЛЯ ЗАПУСКУ ----->");
        printInfo(daemonThread);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("<----- Main потік завершується ----->");
        printInfo(daemonThread);
    }
}