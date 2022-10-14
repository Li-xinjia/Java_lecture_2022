public class PersonTest {
    public static void main(String[] args) {
        Person one_guy = new Person();

        one_guy.setFirstName("Taro");
        one_guy.setLastName("Yamada");
        one_guy.setAddress("Goshokaidocho, Matsugasaki, Sakyoku, Kyoto");

        System.out.println("getName(): " + one_guy.getName());
        System.out.println("getAddress(): " + one_guy.getAddress());
        System.out.println();

        one_guy.print();
    }
}
