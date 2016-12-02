'use strict';

angular.module('smartHouseApp.mainRoom', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mainRoom', {
    templateUrl: 'mainRoom/mainRoom.html',
    controller: 'MainRoomCtrl'
  });
}])

.controller('MainRoomCtrl',['$scope', 'GlobalVariables', function($scope, GlobalVariables){
  $scope.updateScope = function() {
    $scope.temperatureMainroom = GlobalVariables.temperatureMainroom;
    $scope.humidityMainroom = GlobalVariables.humidityMainroom;

    $scope.lightMainroom = GlobalVariables.lightMainroom;

    $scope.overrideTemp = GlobalVariables.overrideTemp;
    $scope.temperatureHouse = GlobalVariables.temperatureHouse;
    $scope.temperatureMainroomSet = GlobalVariables.temperatureMainroomSet;

    $scope.alerts = GlobalVariables.alerts;
    $scope.overrideLight = GlobalVariables.overrideLight;
  }

  $scope.updateScope();

  $scope.turnMainroomLights = function() {
    GlobalVariables.lightMainroom = (GlobalVariables.lightMainroom) ? (false) : (true);
    GlobalVariables.bulbMainroom = (GlobalVariables.lightMainroom) ? ("#ffcc00") : ("white");
    $scope.updateScope();
  }

    $scope.heater = function(up) {
      if(up){
        GlobalVariables.temperatureMainroomSet += 1;
      }
      else {
        GlobalVariables.temperatureMainroomSet -= 1;
      }
      $scope.updateScope();
    }

}]);
