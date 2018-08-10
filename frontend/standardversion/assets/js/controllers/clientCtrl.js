
app.controller("SearchClientController",function ($stateParams,$scope, $http,searchUsers) {

    $scope.pageUsers = null;
    $scope.motCle = "";
    $scope.pageCourante = 0;
    $scope.size = 5;
    $scope.pages = [];

    $scope.user = null;

    searchUsers.searchU($scope.motCle, $scope.pageCourante, $scope.size)
        .then(function mySuccess(response) {
            $scope.pageUsers = response.data;
            //  console.log($scope.motCle);
            $scope.pages = new Array(response.data.totalPages);

        }, function myError(err) {
            console.log(err);
        });
    /*getAllStudents.getStudents()
        .then(function mySuccess(response){
            $scope.pageStudents = response.data;
            console.log($scope.pageStudents)
        }, function myError(err) {
            console.log(err);
        });*/
    $scope.allStudents = function(){
        //alert("student ctrl");
        getAllStudents.getStudents()
            .then(function mySuccess(response){
                $scope.pageUsers = response.data;
                console.log($scope.pageUsers)
            }, function myError(err) {
                console.log(err);
            });
    }

    $scope.searchUser = function () {

        searchUsers.searchU($scope.motCle, $scope.pageCourante, $scope.size)
            .then(function mySuccess(response) {
                $scope.pageUsers = response.data;
                //  console.log($scope.motCle);
                $scope.pages = new Array(response.data.totalPages);

            }, function myError(err) {
                console.log(err);
            });


    }


    $scope.gotoPage = function (p) {
        $scope.pageCourante = p;
        $scope.chercherStudent();
    }
});

app.controller("showUserDetailController",function ($scope,$stateParams,getUserById) {

    $scope.user = null;



    $scope.init = function () {
        //console.log($stateParams.id);
        url='http://localhost:8080/users/user/';
        getUserById.getUser(url,$stateParams.id)
            .then(function (data) {
                $scope.user = data;
        console.log($scope.user.data);
            });

    }
});
