package de.aoc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Day3 {

	public static void main(String[] args) {
		Day3 day3 = new Day3();
		day3.run();
		day3.run2();
	}

	public void run() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("day3/input.txt")
				.getFile());

		try {

			FileInputStream fis = new FileInputStream(file);

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			int result = 0;
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] split = line.trim().split("\\s+");
				if (isValid(split[0],split[1],split[2])) {
					result++;
				}
			}
			System.out.println(result);
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void run2() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("day3/input.txt")
				.getFile());

		try {

			FileInputStream fis = new FileInputStream(file);

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			int result = 0;
			String line = null;
			while ((line = br.readLine()) != null) {
				String line2 = br.readLine();
				String line3 = br.readLine();
				String[] split = line.trim().split("\\s+");
				String[] split2 = line2.trim().split("\\s+");
				String[] split3 = line3.trim().split("\\s+");
				if (isValid(split[0],split2[0],split3[0])) {
					result++;
				}
				if (isValid(split[1],split2[1],split3[1])) {
					result++;
				}
				if (isValid(split[2],split2[2],split3[2])) {
					result++;
				}
			}
			System.out.println(result);
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean isValid(String string, String string2, String string3) {
		Integer value1 = Integer.valueOf(string);
		Integer value2 = Integer.valueOf(string2);
		Integer value3 = Integer.valueOf(string3);
		return value1+value2>value3 && value1+value3>value2 && value2+value3>value1;
	}

}
