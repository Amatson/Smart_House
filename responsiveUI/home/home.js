'use strict';

angular.module('smartHouseApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl',['$scope', 'GlobalVariables', function($scope, GlobalVariables){

  $scope.updateScope = function() {
    $scope.temperatureOut = GlobalVariables.temperatureOut;
    $scope.humidityOut = GlobalVariables.humidityOut;

    $scope.bulb = GlobalVariables.bulb;
    $scope.light = GlobalVariables.light;

    $scope.lockFront = GlobalVariables.lockFront;
    $scope.lockBack = GlobalVariables.lockBack;
    $scope.lockAll = GlobalVariables.lockAll;

    $scope.overrideTemp = GlobalVariables.overrideTemp;
    $scope.temperatureHouse = GlobalVariables.temperatureHouse;

    $scope.overrideLight = GlobalVariables.overrideLight;
  }

  $scope.updateScope();

  $scope.turnOutdoorLights = function() {
    GlobalVariables.light = (GlobalVariables.light) ? (false) : (true);
    GlobalVariables.bulb = (GlobalVariables.light) ? ("#ffcc00") : ("black");
  //  $scope.bulb = ($scope.light) ? ("#ffcc00") : ("black");
    $scope.updateScope();
  }

  $scope.lockDoors = function(door) {
    if(door == "allDoors") {
        GlobalVariables.lockFront = !GlobalVariables.lockAll;
        GlobalVariables.lockBack = !GlobalVariables.lockAll;
    }
    else if(door == "frontDoor") {
      GlobalVariables.lockFront = !GlobalVariables.lockFront;
    }
    else if(door == "backDoor") {
      GlobalVariables.lockBack = !GlobalVariables.lockBack;
      }
    GlobalVariables.lockAll = GlobalVariables.lockBack && GlobalVariables.lockFront;
    $scope.updateScope();
    }

    $scope.heater = function(up) {
      if(up){
        GlobalVariables.temperatureHouse += 1;
      }
      else {
        GlobalVariables.temperatureHouse -= 1;
      }
      $scope.updateScope();
    }

    $scope.toggleOverrideTemp = function() {
      GlobalVariables.overrideTemp = !GlobalVariables.overrideTemp;
      $scope.updateScope();
    }

    $scope.toggleOverrideLight = function() {
      GlobalVariables.overrideLight = !GlobalVariables.overrideLight;
      $scope.updateScope();
    }

}]);
