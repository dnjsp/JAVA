package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * 10마리의 말들이 경주하는 프로그램을 작성하시오.
 * 
 * 말은 HORSE라는 이름의 쓰레드 클래스로 작성하는데
 * 이 클래스는 말이름(String), 현재위치(int), 등수(int)를 멤버변수로 갖는다.
 * 그리고 이 클래스는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.
 * 
 *  경기 구간은 1~50 구간으로 되어 있다.
 *  경기 중 중간중간에 각 말들의 위치를 나타낸다.
 *  예)
 *  01번말 --->--------------------------------
 */

public class ThreadTest141 {
   public static void main(String[] args) {
      new ThreadTest141().start();
   }
   
   public void start() {
      ArrayList<Horse1> horses = setHorse();
      for (Horse1 horse : horses) {
         horse.start();
      }
      int cnt = 1;
      
      while(true) {         
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
         }
         for (int i = 0; i < horses.size(); i++) {
            System.out.printf("%2d번마 ",i+1);
            System.out.println(horses.get(i));
            if (horses.get(i).getLocation()==49 && horses.get(i).getRank()==0) {
               horses.get(i).setRank(cnt++);
            }
         }
         System.out.println();
         if (cnt == 11) {
            break;
         }
      }
      
      Collections.sort(horses);
      
      for (int i = 0; i < horses.size(); i++) {
         System.out.printf("%2d등마 %s\n",i+1,horses.get(i).getHorseName());
      }
   }
   
   public ArrayList<Horse1> setHorse() {
      ArrayList<Horse1> horses = new ArrayList<Horse1>();
      horses.add(new Horse1("청담도끼"));
      horses.add(new Horse1("파워블레이드"));
      horses.add(new Horse1("트리플나인"));
      horses.add(new Horse1("돌아온포경선"));
      horses.add(new Horse1("실버울프"));
      horses.add(new Horse1("에이스코리아"));
      horses.add(new Horse1("마이티씽"));
      horses.add(new Horse1("천지스톰"));
      horses.add(new Horse1("클린업조이"));
      horses.add(new Horse1("투데이"));
      return horses; 
   }
}

class Horse1 extends Thread implements Comparable<Horse1>{
   String horseName;
   int location;
   int rank;
   
   public Horse1(String horseName) {
      this.horseName = horseName;
   }

   @Override
   public void run() {
      while(location<49) {
         if(RandomUtil.getInstance().nextInt(300000)==0) {
            location++;
         }
      }
   }
   
   @Override
   public int compareTo(Horse1 o) {
      return Integer.compare(this.rank, o.rank);
   }

   public String getHorseName() {
      return horseName;
   }

   public void setHorseName(String horseName) {
      this.horseName = horseName;
   }

   public int getLocation() {
      return location;
   }

   public void setLocation(int location) {
      this.location = location;
   }

   public int getRank() {
      return rank;
   }

   public void setRank(int rank) {
      this.rank = rank;
   }

   @Override
   public String toString() {
      String state = "";
      for (int i = 0; i < 50; i++) {
         if(i==location) {
            state += ">";
         }else {
            state += "-";
         }
      }
      return horseName+"\t"+state;
   }
}

class RandomUtil{
   private static RandomUtil instance = new RandomUtil();
   public static RandomUtil getInstance() {
      return instance;
   }
   private RandomUtil() {}
   
   private Random rand = new Random();
   
   public int nextInt(int a) {
      return rand.nextInt(a);
   }
}