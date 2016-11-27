'use strict';

angular.module('smartHouseApp.mainRoom', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mainRoom', {
    templateUrl: 'mainRoom/mainRoom.html',
    controller: 'MainRoomCtrl'
  });
}])

.controller('MainRoomCtrl', [function() {

}]);
