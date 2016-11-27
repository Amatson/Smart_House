'use strict';

angular.module('smartHouseApp.livingRoom', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/livingRoom', {
    templateUrl: 'livingRoom/livingRoom.html',
    controller: 'LivingRoomCtrl'
  });
}])

.controller('LivingRoomCtrl', [function() {

}]);
