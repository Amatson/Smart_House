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
    $scope.roomTemperature = GlobalVariables.temperatureMainroom;
    $scope.roomHumidity = GlobalVariables.humidityMainroom;

    $scope.roomLights = GlobalVariables.lightMainroom;

    $scope.overrideTemp = GlobalVariables.overrideTemp;
    $scope.temperatureHouse = GlobalVariables.temperatureHouse;
    $scope.roomTemperatureSet = GlobalVariables.temperatureMainroomSet;

    $scope.alerts = GlobalVariables.alerts;
    $scope.overrideLight = GlobalVariables.overrideLight;
  }

  $scope.updateScope();

  $scope.toggleRoomLights = function() {
    GlobalVariables.lightMainroom = (GlobalVariables.lightMainroom) ? (false) : (true);
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
