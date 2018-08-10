app.controller("UserController", function ($rootScope,$scope, $location, $state, $stateParams,userServices) {


    $scope.user = {};
    var baseUrl = 'http://localhost:8080/';
    var showUserUrl = baseUrl + 'users/user/';
    var addUserUrl = baseUrl + 'users/addUser/';
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

    $scope.goToShowDetail = function(idUser){
        console.log(idUser);
        $rootScope.mode = false;
        state = 'app.pages.user';
        $state.go(state,{id:idUser.id});




    }

    $scope.goToAddUser = function (mode_newUser) {
        console.log("Add user ctrl");
        console.log(mode_newUser);
        $rootScope.mode = true;

        $scope.user = null;
        state = 'app.pages.newUser';
        userServices.goToRouter(state,$state);




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

        userServices.saveObject(addUserUrl, $scope.addUser)
            .then(function mySuccess(response) {


            }, function myError(err) {
                console.log(err);
            })
     }
})
;
