package chapter07;

public class AnimalExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Tiger tiger = new Tiger();
		dog.sound();
		cat.sound();
		tiger.sound();
		System.out.println("-----");
		
		Animal animal;
		animal = new Dog();
		animal.sound();
		animal = new Cat();
		animal.sound();
		animal = new Tiger();
		animal.sound();
		System.out.println("-----");
		
		animalSound(new Dog());
		animalSound(new Cat());		
		animalSound(new Tiger());
	}
		public static void animalSound(Animal animal) {
			animal.sound();
		}
}
