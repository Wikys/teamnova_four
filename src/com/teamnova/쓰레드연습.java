package com.teamnova;

public class 쓰레드연습 {

    public static void main(String[] args) {



    }
}

//    Runnable 실행할코드 = new Runnable() {
//        @Override
//        public void run() {
//            // 실행할코드 작성
//            int i = 0;
//            while (true){
//                System.out.println("빽쓰레드 "+i++);
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//
//            }
//        }
//    };
//
//    Thread 백쓰레드 = new Thread(실행할코드);//백그라운드 쓰레드
//        백쓰레드.setPriority(Thread.MAX_PRIORITY); //우선순위 정해주는 방법
//                백쓰레드.start();
//
//
//                int i = 0;
//                while (true){ // 메인스레드
//                System.out.println(i++);
//
//                try {
//                Thread.sleep(1000);
//                } catch (InterruptedException e){
//                e.printStackTrace();
//                }
//
//                }