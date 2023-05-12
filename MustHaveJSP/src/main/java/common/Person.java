package common;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		this.name = "";
		this.age = 0;
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "name = " + this.name + ", age = " + this.age;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		return (this.name.equals(p.name) && (this.age == p.age));
	}
}
