package br.fonseca.ED.algoritmos;

import java.util.Scanner;

public class EqualStacks {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr1 = new int[sc.nextInt()];
		int[] arr2 = new int[sc.nextInt()];
		int[] arr3 = new int[sc.nextInt()];

		int total1 = 0;
		int total2 = 0;
		int total3 = 0;

		for (int i = 0; i < arr1.length; i++) {
			int next = sc.nextInt();
			arr1[i] = next;
			total1 += next;
		}
		for (int i = 0; i < arr2.length; i++) {
			int next = sc.nextInt();
			arr2[i] = next;
			total2 += next;
		}
		for (int i = 0; i < arr3.length; i++) {
			int next = sc.nextInt();
			arr3[i] = next;
			total3 += next;
		}

		System.out.println((total1 + total2 + total3) / 3);

	}
}
