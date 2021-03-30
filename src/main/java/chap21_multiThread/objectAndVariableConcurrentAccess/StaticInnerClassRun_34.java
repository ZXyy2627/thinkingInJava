package chap21_multiThread.objectAndVariableConcurrentAccess;

public class StaticInnerClassRun_34 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.setUsername("usernameValue");
        outer.setPassword("passwordValue");
        System.out.println(outer.getUsername()+" "+outer.getPassword());
        Outer.Inner34 inner = new Outer.Inner34();
    }
}

class Outer {
    static private String username;
    static private String password;

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

    static class Inner34{
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
            System.out.println(username+ " "+password);
        }
    }
}
