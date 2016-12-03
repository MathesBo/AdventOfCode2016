package de.aoc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Day2 {

	private int key;

	private Map<Character, Map<Character, Character>> keypad = new HashMap<>();

	private char currentKey;

	public static void main(String[] args) {
		Day2 day2 = new Day2();
		day2.run();
		System.out.println("\n");
		day2.run2();
	}

	public void run() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("day2/input.txt")
				.getFile());

		try {

			key = 5;

			FileInputStream fis = new FileInputStream(file);

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {
				for (char c : line.toCharArray()) {
					switch (c) {
					case 'U':
						moveUp();
						break;
					case 'D':
						moveDown();
						break;
					case 'L':
						moveLeft();
						break;
					case 'R':
						moveRight();
						break;

					default:
						break;
					}
				}
				System.out.println(key);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void run2() {

		// 1
		Map<Character, Character> keyMap = new HashMap<>();
		keyMap.put('D', '3');
		keypad.put('1', keyMap);

		// 2
		keyMap = new HashMap<>();
		keyMap.put('R', '3');
		keyMap.put('D', '6');
		keypad.put('2', keyMap);

		// 3
		keyMap = new HashMap<>();
		keyMap.put('U', '1');
		keyMap.put('R', '4');
		keyMap.put('D', '2');
		keyMap.put('L', '7');
		keypad.put('3', keyMap);

		// 4
		keyMap = new HashMap<>();
		keyMap.put('D', '8');
		keyMap.put('L', '3');
		keypad.put('4', keyMap);

		// 5
		keyMap = new HashMap<>();
		keyMap.put('R', '6');
		keypad.put('5', keyMap);

		// 6
		keyMap = new HashMap<>();
		keyMap.put('U', '2');
		keyMap.put('R', '7');
		keyMap.put('D', 'A');
		keyMap.put('L', '5');
		keypad.put('6', keyMap);

		// 7
		keyMap = new HashMap<>();
		keyMap.put('U', '3');
		keyMap.put('R', '8');
		keyMap.put('D', 'B');
		keyMap.put('L', '6');
		keypad.put('7', keyMap);

		// 8
		keyMap = new HashMap<>();
		keyMap.put('U', '4');
		keyMap.put('R', '9');
		keyMap.put('D', 'C');
		keyMap.put('L', '7');
		keypad.put('8', keyMap);

		// 9
		keyMap = new HashMap<>();
		keyMap.put('L', '8');
		keypad.put('9', keyMap);

		// A
		keyMap = new HashMap<>();
		keyMap.put('U', '6');
		keyMap.put('R', 'B');
		keypad.put('A', keyMap);

		// B
		keyMap = new HashMap<>();
		keyMap.put('U', '7');
		keyMap.put('R', 'C');
		keyMap.put('D', 'D');
		keyMap.put('L', 'A');
		keypad.put('B', keyMap);

		// C
		keyMap = new HashMap<>();
		keyMap.put('U', '8');
		keyMap.put('L', 'B');
		keypad.put('C', keyMap);

		// D
		keyMap = new HashMap<>();
		keyMap.put('U', 'B');
		keypad.put('D', keyMap);

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("day2/input.txt")
				.getFile());

		try {

			currentKey = '5';

			FileInputStream fis = new FileInputStream(file);

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {
				for (char c : line.toCharArray()) {
					move(c);
				}
				System.out.println(currentKey);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void move(char dir) {
		if (keypad.get(currentKey).containsKey(dir)) {
			currentKey = keypad.get(currentKey).get(dir);
		}
	}
	
	private void moveRight() {
		if ((key % 3) == 0) {
			return;
		}
		key++;
	}

	private void moveLeft() {
		if (key == 1 || key == 4 || key == 7) {
			return;
		}
		key--;
	}

	private void moveDown() {
		if (key > 6) {
			return;
		}
		key += 3;
	}

	private void moveUp() {
		if (key < 4) {
			return;
		}
		key -= 3;

	}

}
