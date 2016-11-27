'use strict';

angular.module('smartHouseApp.bedRoom', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/bedRoom', {
    templateUrl: 'bedRoom/bedRoom.html',
    controller: 'BedRoomCtrl'
  });
}])

.controller('BedRoomCtrl', [function() {

}]);
