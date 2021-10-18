package effectiveJava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Builder {
    public static void main(String[] args) {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_SUPER_USER");
        roles.add("ROLE_ADMIN");
        var user = new User.Builder("email@gmail.com", "pass")
                .firstName("f")
                .lastName("l")
                .birthDate(new Date())
                .roles(roles)
                .build();

        System.out.println(user);
    }
}

class User {
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final Date birthDate;

    private List<String> roles;

    public static class Builder {
        private final String email;
        private final String password;
        private String firstName;
        private String lastName;
        private Date birthDate;
        private List<String> roles;

        public Builder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public Builder firstName(String val) {
            this.firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            this.lastName = val;
            return this;
        }

        public Builder birthDate(Date val) {
            this.birthDate = val;
            return this;
        }

        public Builder roles(List<String> val) {
            this.roles = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        email = builder.email;
        password = builder.password;
        firstName = builder.firstName;
        lastName = builder.lastName;
        birthDate = builder.birthDate;
        roles = builder.roles;
    }

    @Override
    public String toString() {
        return "User{" +
                email + ", " +
                firstName + ' ' + lastName +
                ", birthDate=" + birthDate +
                ", roles=" + roles +
                '}';
    }
}
