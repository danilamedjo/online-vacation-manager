function filmoviCtrl($scope, $location, $log, filmoviService, kategorijeService) {

	$log.log("Instantiating filmoviCtrl");

	$selectedFilm = {};

	$scope.kategorije = [];
	$scope.filmovi = [];

	$scope.pageNum = 0;
	$scope.totalPages = 0;

	$scope.newFilm = {};
	$scope.newFilm.naziv = "";
	$scope.newFilm.trajanje = "";
	$scope.newFilm.kategorijaId = "";

	$scope.searchParams = {};
	$scope.searchParams.naziv = "";
	$scope.searchParams.trajanje = "";

	$scope.pageSizeOptions = [ '5', '10', '20' ];
	
	$scope.karta = {};
	$scope.karta.poruka = "";

	var getFilmovi = function() {

		var config = {
			params : {}
		};

		config.params.pageNum = $scope.pageNum;

		filmoviService.getFilmovi(config, function(res) {
			$scope.filmovi = res.data;
			$scope.totalPages = res.headers('totalPages');
		});

	};

	var getKategorije = function() {
		kategorijeService.getKategorije(function(res) {
			$scope.kategorije = res.data;
		});
	};

	getFilmovi();
	getKategorije();

	$scope.addFilm = function() {
		filmoviService.addFilm($scope.newFilm, function(res) {

			getFilmovi();

			document.getElementById("addForm").reset();

			$scope.addForm.$setPristine();
			$scope.addForm.$setUntouched();

			$scope.newFilm.naziv = "";
			$scope.newFilm.trajanje = "";
			$scope.newFilm.kategorijaId = "";

		});
	};

	$scope.deleteFilm= function(id) {
		filmoviService.deleteFilm(id, function(res) {
			getFilmovi();
		});
	};

	$scope.editFilm = function(aid) {
		$location.path('/filmovi/edit/' + aid);
	};

	$scope.selectFilm = function(id) {
		$scope.selectedId = id;
		
		filmoviService.getFilm(id, function(res){
			$scope.selectedFilm = res.data;
		});
	};

	$scope.searchFilmovi = function() {
		var config = {
			params : {}
		};
		
		if($scope.searchParams.naziv != ""){
			config.params.naziv = $scope.searchParams.naziv;
		}
		
		if($scope.searchParams.trajanje != ""){
			config.params.minDuration = $scope.searchParams.trajanje;
		}

		$scope.pageNum = 0;

		filmoviService.getFilmovi(config, function(res) {
			$scope.filmovi = res.data;
			$scope.totalPages = res.headers('totalPages');
		});

		document.getElementById("searchForm").reset();

		$scope.searchForm.$setPristine();
		$scope.searchForm.$setUntouched();

		$scope.trazeniFilm.model = "";
		$scope.trazeniFilm.godiste = "";
		$scope.trazeniFilm.potrosnja = "";

	};

	$scope.previous = function(){
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getFilmovi();
        }
    };

    $scope.next = function(){
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getFilmovi();
        }
    };
    
    
    $scope.funkcija = function(){
    	$scope.karta.filmId = $scope.selectedFilm.id;
    	kartaService.add($scope.karta, function(res){
    		
    	});
    }

}