
function User(id, username, password, firstName, lastName, role) {
    this.id=id;
    this.username = username;
    this.password = password;
    this.firstName=firstName;
    this.lastName =lastName;
    this.role = role;

    this.setUsername = setUsername;
    this.getUsername = getUsername;
    this.setPassword = setPassword;
    this.getPassword = getPassword;
    this.setFirstName = setFirstName;
    this.getFirstName = getFirstName;
    this.setPassword = setPassword;
    this.getPassword = getPassword;
    this.setLastName = setLastName;
    this.getLastName = getLastName;
    this.setRole = setRole;
    this.getRole = getRole;
    this.setId = setId;
    this.getId = getId;

    function setUsername(username) {
        this.username = username;
    }
    function getUsername() {
        return this.username;
    }
    function setPassword(password) {
        this.password = password;
    }
    function getPassword() {
        return this.password;
    }

    function setId(id) {
        this.id = id;
    }
    function getId() {
        return this.id;
    }
    function setFirstName(firstName) {
        this.firstName = firstName;
    }
    function getFirstName() {
        return this.firstName;
    }

    function setLastName(lastName) {
        this.lastName = lastName;
    }
    function getLastName() {
        return this.lastName;
    }
    function setRole(role) {
        this.role = role;
    }
    function getRole() {
        return this.role;
    }
}
