
(function () {
    var $idFld, $usernameFld, $passwordFld;
    var $updateBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);

    function main() {

        $createBtn = $(".wbdv-create");
        $updateBtn=$(".wbdv-update");
        $userRowTemplate = $(".wbdv-template");
        $tbody=$(".wbdv-tbody");
        $idFld = $(".wbdv-user-id");
        $usernameFld = $("#usernameFld");
        $passwordFld = $("#passwordFld");
        $firstNameFld = $("#firstNameFld");
        $lastNameFld = $("#lastNameFld");
        $roleFld = $("#roleFld");
        $createBtn.click(function(){
            var data = createUser();
            window.location.replace("https://webdev-s1-server-java.herokuapp.com/admin/user-admin.template.client.html");
        });



        $(document).on('click','.wbdv-edit',function () {
            var userId = $(this).closest('tr').children('td.wbdv-user-id').text();
            var username = $(this).closest('tr').children('td.wbdv-username').text();
            var password = "***"
            var firstName = $(this).closest('tr').children('td.wbdv-first-name').text();
            var lastName = $(this).closest('tr').children('td.wbdv-last-name').text();
            var role = $(this).closest('tr').children('td.wbdv-role').text();
            var user = new User(userId,username,password,firstName,lastName,role);
            $updateBtn.click(function(){
                var data = updateUser();
                window.location.replace("https://webdev-s1-server-java.herokuapp.com/admin/user-admin.template.client.html");
            });
            renderUser(user);
        })
        $(document).on('click','.wbdv-remove', function () {
            var userId = $(this).closest('tr').children('td.wbdv-user-id').text();
            deleteUser(userId);
        })
        findAllUsers();
    }
    function createUser() {
        // $usernameFld = $("#usernameFld").val();
        // $passwordFld = $("#passwordFld").val();
        // $firstNameFld = $("#firstNameFld").val();
        // $lastNameFld = $("#lastNameFld").val();
        // $roleFld = $("#roleFld").val();
        // console.log($passwordFld);
        var user = {
            "id" : (new Date()).getTime(),
            "username" : $usernameFld.val(),
            "password" : $passwordFld.val(),
            "firstName" : $firstNameFld.val(),
            "lastName" : $lastNameFld.val(),
            "role" : $roleFld.val(),
        }
        return userService.createUser(user);
    }
     function findAllUsers() {
         userService
             .findAllUsers()
             .then(renderUsers);
     }
    // function findUserById() { … }
     function deleteUser(userId) {
            userService.deleteUser(userId);
            window.location.replace("https://webdev-s1-server-java.herokuapp.com/admin/user-admin.template.client.html");
     }
    // function selectUser() { … }
     function updateUser() {
         var user = {
             "id" : $idFld.val(),
             "username" : $usernameFld.val(),
             "password" : $passwordFld.val(),
             "firstName" : $firstNameFld.val(),
             "lastName" : $lastNameFld.val(),
             "role" : $roleFld.val(),
         }
         return userService.updateUser(user);
     }
     function renderUser(user) {
        $idFld.val(user.getId());
        $usernameFld.val(user.getUsername());
        $passwordFld.val(user.getPassword());
        $firstNameFld.val(user.getFirstName());
        $lastNameFld.val(user.getLastName());
        $roleFld.val(user.getRole());
     }
     function renderUsers(users) {
        $('table tbody').empty();
            for(var u=0; u<users.length; u++){
                var clone = $userRowTemplate.clone();
                $idFld.val(users[u].id);
                clone.find(".wbdv-user-id").html(users[u].id);
                clone.find(".wbdv-username").html(users[u].username);
                clone.find(".wbdv-first-name").html(users[u].firstName);
                clone.find(".wbdv-last-name").html(users[u].lastName);
                clone.find(".wbdv-role").html(users[u].role);
                console.log(users[u].role);
                $tbody.append(clone);
            }
     }
})();