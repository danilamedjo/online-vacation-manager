function editFilmCtrl($scope, $routeParams, $location, filmoviService, kategorijeService) {

	$scope.oldFilm = {};
	$scope.kategorije = [];

	var id = $routeParams.aid;

	var getOldFilm = function () {
		filmoviService.getFilm(id, function (res) {
			$scope.oldFilm = res.data;
		});
	};

	var getKompanije = function () {
		kategorijeService.getKompanije(function (res) {
			$scope.kategorije = res.data;
		});
	};

	getOldFilm();
	getKompanije();


	$scope.editFilm = function () {
		filmoviService.editFilm($scope.oldFilm.id, $scope.oldFilm, function (res) {
			$location.path('/filmovi');
		});
	};

}