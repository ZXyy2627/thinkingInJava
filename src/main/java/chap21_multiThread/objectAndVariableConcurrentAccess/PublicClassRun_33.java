package chap21_multiThread.objectAndVariableConcurrentAccess;

/**
 * 普通内部类的用法
 */
public class PublicClassRun_33 {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.setUsername("usernameValue");
        outerClass.setPassword("passwordValue");
        System.out.println(outerClass.getUsername()+" " +outerClass.getPassword());
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.setAge("ageValue");
        innerClass.setAddress("addressValue");
        System.out.println(innerClass.getAge() + " " +innerClass.getAddress());
        innerClass.printPublicProperty();
    }
}

class OuterClass{
    private String username;
    private String password;

    class InnerClass{
        private String age;
        private String address;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void printPublicProperty() {
            System.out.println(username + " " +password);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
