package sliver.problem10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] people = getPeople(br, N);
        Arrays.sort(people);

        print(people);
    }

    private static Person[] getPeople(BufferedReader br, int N) throws IOException {
        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            people[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        return people;
    }

    private static void print(Person[] people) {
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

    private static class Person implements Comparable<Person>{
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.getAge();
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }
    }
}
