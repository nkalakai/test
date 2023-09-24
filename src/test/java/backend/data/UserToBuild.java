package backend.data;

public class UserToBuild {
    private int id;
    private String name;
    private String gender;
    private String email;
    private String status;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    private UserToBuild() {
    }

    public static class UserToBuildBuilder {
        private int id;
        private String name;
        private String gender;
        private String email;
        private String status;

        public UserToBuildBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserToBuildBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserToBuildBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserToBuildBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserToBuildBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public UserToBuild build() {
            UserToBuild result = new UserToBuild();
            result.id = this.id;
            result.name = this.name;
            result.gender = this.gender;
            result.email = this.email;
            result.status = this.status;
            return result;
        }
    }
}
