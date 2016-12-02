'use strict';

angular.module('smartHouseApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl',['$scope', function($scope){

  $scope.temperatureOut = 16;
  $scope.humidityOut = 70;

  $scope.bulb = "black"
  $scope.light = false;

  $scope.lockFront = true;
  $scope.lockBack = true;
  $scope.lockAll = true;

  $scope.overrideTemp = true;
  $scope.temperatureHouse = 22;

  $scope.turnOutdoorLights = function() {
    $scope.light = ($scope.light) ? (false) : (true);
    $scope.bulb = ($scope.light) ? ("#ffcc00") : ("black");
  //  $scope.bulb = ($scope.light) ? ("#ffcc00") : ("black");
  }

  $scope.lockDoors = function(door) {
    if(door == "allDoors") {
        $scope.lockFront = !$scope.lockAll;
        $scope.lockBack = !$scope.lockAll;
    }
    else if(door == "frontDoor") {
      $scope.lockFront = !$scope.lockFront;
    }
    else if(door == "backDoor") {
      $scope.lockBack = !$scope.lockBack;
      }
    $scope.lockAll = $scope.lockBack && $scope.lockFront;
    }

    $scope.heater = function(up) {
      if(up){
        $scope.temperatureHouse += 1;
      }
      else {
        $scope.temperatureHouse -= 1;
      }
    }

}]);
