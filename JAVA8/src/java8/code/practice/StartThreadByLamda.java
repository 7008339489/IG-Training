package java8.code.practice;

public class StartThreadByLamda {

	public static void main(String[] args) {

		Thread th = new Thread(() -> {
			for (int i = 0; i <= 10; i++) {
				System.out.println("Inside Thread class");
			}
		});
		th.start();

		for (int i = 0; i <= 10; i++) {
			System.out.println("Inside main class");
		}

	}

}
