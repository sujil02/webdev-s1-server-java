


function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'http://localhost:8080/api/user';
    var self = this;
    function createUser(user, callback) {
        function createUser(user) {
            return fetch(url, {
                method : 'post',
                body : JSON.stringify(user),
                headers : {
                    'content-type' : 'application/json'
                }

            }).then(function(response) {
                return response.json();
            });
        }
    }
    function findAllUsers() {
        return fetch(url).then(function(response) {
            return response.json();
        });
    }
    // function findUserById(userId, callback) { … }
    // function updateUser(userId, user, callback) { … }
    // function deleteUser(userId, callback) { … }
}
