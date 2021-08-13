package kr.or.ddit.basic;

import java.util.Random;
import javax.swing.JOptionPane;

/*
 * 사용자의 입력은 showInputDialog()메서드를 이용해서 입력 받는다.
 * 
 * 입력시간은 5초로 제한하고 카운트 다운을 한다.
 * 5초안에 입력이 없으면 게임에 진것으로 처리한다.
 * 
 * 5초안에 입력이 완료되면 승패를 구해서 출력한다.
 */

public class ThreadTest091 {
   private Count count = new Count();
   private Rock rock = new Rock();
   private Random rand = new Random();
   
   public static void main(String[] args) {
      new ThreadTest091().home();
   }
   
   public void home() {
      threadControl();
      
      if (rock.getRockstr()==null) {
         System.out.println("입력값이 없습니다.");
         System.out.println("당신은 패배하였습니다.");
         return;
      }else if(!(rock.getRockstr().equals("가위")||
            rock.getRockstr().equals("바위")||
            rock.getRockstr().equals("보"))) {
         System.out.println("잘못된 입력입니다.");
         System.out.println("당신은 패배하였습니다.");   
         return;
      }
         
      String randRock = randRock();
      System.out.printf("당신은 '%s' 컴퓨터는 '%s' 입니다.\n",rock.getRockstr(),randRock);
      if(rock.getRockstr().equals(randRock)) {
         System.out.println("무승부");
      }else if((rock.getRockstr().equals("가위")&&randRock.equals("보")) ||
            (rock.getRockstr().equals("바위")&&randRock.equals("가위")) ||
            (rock.getRockstr().equals("보")&&randRock.equals("바위")) ) {
         System.out.println("당신의 승리");
      }else {
         System.out.println("당신의 패배");
      }
   }
   
   public void threadControl() {
      count.process();
      rock.process();
      while(true) {
         if(!(count.thread.isAlive()&&rock.thread.isAlive())) {                  
            count.thread.interrupt();   
            rock.thread.interrupt();
            break;
         }
      }
   }
   
   public String randRock() {
      switch(rand.nextInt(3)) {
         case 0 : return "가위"; 
         case 1 : return "바위";
         case 2 : return "보";
         default : return "";
      }
   }
}

class Count implements Runnable{
   public Thread thread;
   
   @Override
   public void run() {
      int i = 5;
      while(!Thread.currentThread().isInterrupted() && i !=0) {
         System.out.println(i--);
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
         }
      }
   }
   
   public void process() {
      thread = new Thread(this);
      thread.start();
   }
}

class Rock implements Runnable{
   public Thread thread;
   private String rockstr;
   
   @Override
   public void run() {
      rockstr = JOptionPane.showInputDialog("가위 바위 보");
   }

   public String getRockstr() {
      return rockstr;
   }

   public void process() {
      thread = new Thread(this);
      thread.start();
   }
}