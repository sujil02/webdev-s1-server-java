function AdminUserServiceClient() {
    this.createUser = createUser;
    this.deleteUser = deleteUser;
    this.findAllUsers = findAllUsers;
    url = 'http://localhost:8080/api/users';
    createUrl = 'http://localhost:8080/api/users/create';
    var self = this;
    function createUser(user, callback) {
        function createUser(user) {
            return fetch(createUrl, {
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
    
    function deleteUser(userId, callback) {
        return fetch(url+"/"+userId,{
            method:'delete'
        }).then(response=>
            response.json().then(json=>{
                return json;
            })
        );
    }
    function findAllUsers() {
        return fetch(url).then(function(response) {
            return response.json();
        });
    }
}
