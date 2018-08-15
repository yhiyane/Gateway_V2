app.controller("UserController", function ($rootScope, $scope, $location, $state, $stateParams, userServices) {
    console.log($rootScope.indexActive);
    console.log($rootScope.mode);

    $scope.user = {};
    var baseUrl = 'http://localhost:8080/';
    var showUserUrl = baseUrl + 'users/user/';
    var addUserUrl = baseUrl + 'users/addUser/';
    var updateUserUrl = baseUrl + 'users/updateUser/';
    $scope.pageUsers = null;
    $scope.motCle = "";
    $scope.pageCourante = 0;
    $scope.size = 5;
    $scope.pages = [];
    $scope.addUser = {};

    userServices.searchU($scope.motCle, $scope.pageCourante, $scope.size)
        .then(function mySuccess(response) {
            $scope.pageUsers = response.data;
            $scope.pages = new Array(response.data.totalPages);

        }, function myError(err) {
            console.log(err);
        });

    $scope.goToShowDetail = function (idUser) {
        $rootScope.mode = false;
        $rootScope.indexActive = 0;
        //console.log($rootScope.mode);
        state = 'app.pages.user';
        $state.go(state, {id: idUser.id});


    }

    $scope.goToAddUser = function () {
        $rootScope.mode = true;
        $rootScope.indexActive = 1;
        console.log($rootScope.indexActive)
        $scope.user = null;
        state = 'app.pages.newUser';
        userServices.goToRouter(state, $state);


    }

    $scope.allStudents = function () {

        userServices.getStudents()
            .then(function mySuccess(response) {
                $scope.pageUsers = response.data;
                console.log($scope.pageUsers)
            }, function myError(err) {
                console.log(err);
            });
    }

    $scope.searchUser = function () {

        userServices.searchU($scope.motCle, $scope.pageCourante, $scope.size)
            .then(function mySuccess(response) {
                $scope.pageUsers = response.data;
                $scope.pages = new Array(response.data.totalPages);

            }, function myError(err) {
                console.log(err);
            });


    }


    $scope.gotoPage = function (p) {
        $scope.pageCourante = p;
        $scope.searchUser();
    }

    if ($stateParams.id !== undefined) {
        userServices.getUser(showUserUrl, $stateParams.id)
            .then(function (data) {
                $scope.user = data;
            });
    }


    $scope.saveUser = function () {
        // console.log($scope.addUser);
        if ($scope.addUser.id == null) {
            userServices.saveObject(addUserUrl, $scope.addUser)
                .then(function mySuccess(response) {
                    $rootScope.mode = false;
                    $rootScope.indexActive = 0;
                    $scope.user.data = response.data;

                }, function myError(err) {
                    console.log(err);
                })
        }
        else {
            alert('accès update ctrl');
            console.log('hada howa khona addUsr');
            console.log($scope.addUser.roles);
            url = updateUserUrl + $scope.addUser.id;
            $rootScope.mode = false;
            $rootScope.indexActive = 0;

            userServices.updateObject(url, $scope.addUser)
                .then(function mySuccess(response) {

                }, function myError(err) {
                    console.log(err);
                })
        }

    }

    $scope.editAccount = function (idUser) {

        $scope.addUser = $scope.user.data;
        $scope.addUser.lastLogin = new Date($scope.user.data.lastLogin);


        $rootScope.indexActive = 1;

        $rootScope.mode = true;
        console.log($rootScope.mode);
        state = 'app.pages.user';
        $state.go(state, {id: idUser.id});
    }
})
;
