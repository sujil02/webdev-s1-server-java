
(function () {
    var $idFld, $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);

    function main() {

        $createBtn = $(".wbdv-create");
        $removeBtn = $(".wbdv-remove")
        //$createBtn.hide();
        $createBtn.click(function(){
            var data = createUser();
        });

        $(document).on('click','.wbdv-remove', function () {
            var userId = $(this).closest('tr').children('td.wbdv-user-id').text();
            deleteUser(userId);
        })
        $userRowTemplate = $(".wbdv-template");
        $tbody=$(".wbdv-tbody");
        findAllUsers();
    }
    function createUser() {
        $usernameFld = $("#usernameFld").val();
        $passwordFld = $("#passwordFld").val();
        $firstNameFld = $("#firstNameFld").val();
        $lastNameFld = $("#lastNameFld").val();
        console.log($passwordFld);
        var user = {
            "username" : $usernameFld,
            "password" : $passwordFld,
            "firstName" : $firstNameFld,
            "lastName" : $lastNameFld,
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
            window.location.replace("http://localhost:8080/admin/user-admin.template.client.html");
     }
    // function selectUser() { … }
    // function updateUser() { … }
    // function renderUser(user) { … }
     function renderUsers(users) {
        $('table tbody').empty();
            for(var u=0; u<users.length; u++){
                var clone = $userRowTemplate.clone();
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