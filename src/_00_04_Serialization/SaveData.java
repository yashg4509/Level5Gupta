package _00_04_Serialization;

import java.io.Serializable;

/*
 * Complete this class so that it can be serialized.
 */
public class SaveData implements Serializable {
	public String name;
	public int age;
	private int column;
	private int height;
	private int width;
	private int row;

	public SaveData(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public SaveData(int width, int height, int row, int column) {
		this.width = width;
		this.height = height;
		this.row = row;
		this.column = column;
	}
}
