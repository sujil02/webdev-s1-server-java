function AdminUserServiceClient() {
    this.createUser = createUser;
    this.updateUser = updateUser;
    this.deleteUser = deleteUser;
    this.findAllUsers = findAllUsers;
    url = 'http://localhost:8080/api/users';
    createUrl = 'http://localhost:8080/api/users/create';
    var self = this;
    function createUser(user) {{
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
    
    function deleteUser(userId) {
        return fetch(url+"/"+userId,{
            method:'delete'
        }).then(response=>
            response.json().then(json=>{
                return json;
            })
        );
    }

    function updateUser(user) {{
        return fetch(url, {
            method : 'put',
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
}
