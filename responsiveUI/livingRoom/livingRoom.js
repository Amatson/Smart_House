'use strict';

angular.module('smartHouseApp.livingRoom', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/livingRoom', {
    templateUrl: 'livingRoom/livingRoom.html',
    controller: 'LivingRoomCtrl'
  });
}])

.controller('LivingRoomCtrl',['$scope', 'GlobalVariables', function($scope, GlobalVariables){
  $scope.updateScope = function() {
    $scope.roomTemperature = GlobalVariables.temperatureLivingroom;
    $scope.roomHumidity = GlobalVariables.humidityLivingroom;

    $scope.roomLights = GlobalVariables.lightLivingroom;

    $scope.overrideTemp = GlobalVariables.overrideTemp;
    $scope.temperatureHouse = GlobalVariables.temperatureHouse;
    $scope.roomTemperatureSet = GlobalVariables.temperatureLivingroomSet;

    $scope.alerts = GlobalVariables.alerts;
    $scope.overrideLight = GlobalVariables.overrideLight;
  }

  $scope.updateScope();

  $scope.toggleRoomLights = function() {
    GlobalVariables.lightLivingroom = (GlobalVariables.lightLivingroom) ? (false) : (true);
    $scope.updateScope();
  }

    $scope.heater = function(up) {
      if(up){
        GlobalVariables.temperatureLivingroomSet += 1;
      }
      else {
        GlobalVariables.temperatureLivingroomSet -= 1;
      }
      $scope.updateScope();
    }

}]);
